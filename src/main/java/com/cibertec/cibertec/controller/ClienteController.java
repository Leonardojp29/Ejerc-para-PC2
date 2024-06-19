package com.cibertec.cibertec.controller;

import com.cibertec.cibertec.entity.Cliente;
import com.cibertec.cibertec.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/url/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    //Las consultas o busquedas
    @GetMapping("/listaTodos")
    public List<Cliente> getAllClientes() {
        return clienteService.listaCliente();
    }

    @GetMapping("/buscarPorNombre")
    public List<Cliente> getClienteByNombre(@RequestParam("nombres") String nombres) {
        return clienteService.listaClientePorNombre(nombres + "%");
    }

    @GetMapping("/buscarPorDni/{dni}")
    public List<Cliente> getClienteByDni(@PathVariable("dni") String dni) {
        return clienteService.listaClientePorDni(dni);
    }
    
    //Para el crud

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
               HashMap<String, Object> salida = new HashMap<>();
            try {
                cliente.setIdcliente(0);
                Cliente objSalida = clienteService.insertaActualizaCliente(cliente);
            salida.put("mensaje", "Cliente registrado de ID >>> " + objSalida.getIdcliente());
        } catch (Exception e) {
            salida.put("mensaje", "Error al registrar");
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaCliente(@RequestBody Cliente cliente) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida = clienteService.insertaActualizaCliente(cliente);
            salida.put("mensaje", "Cliente actualizado de ID >>> " + objSalida.getIdcliente());
        } catch (Exception e) {
            salida.put("mensaje", "Error al actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminaCliente(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            clienteService.eliminaCliente(id);
            salida.put("mensaje", "Cliente eliminado de ID >>> " + id);
        } catch (Exception e) {
            salida.put("mensaje", "Error al eliminar");
        }
        return ResponseEntity.ok(salida);
    }

    @GetMapping("/buscarPorId/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") int id) {
        HashMap<String, Object> salida = new HashMap<>();
        try {
            Cliente cliente = clienteService.obtienePorId(id).get();
            salida.put("cliente", cliente);
        } catch (Exception e) {
            salida.put("mensaje", "Error al buscar");
        }
        return ResponseEntity.ok(salida);
    }

}