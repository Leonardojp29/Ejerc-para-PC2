package com.cibertec.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.cibertec.entity.Cliente;

public interface ClienteService {
    
    //Para el CRUD
    public abstract List<Cliente> listaCliente();
    public abstract Cliente insertaActualizaCliente(Cliente obj);
    public abstract void eliminaCliente(int id);
    public abstract Optional<Cliente> obtienePorId(int id);
    
    //Para consultas
    public abstract List<Cliente> listaClientePorNombre(String nombres);
    public abstract List<Cliente> listaClientePorDni(String dni);
    public abstract List<Cliente> listaClientePorDniNombre(String dni, String nombres);

   

}
