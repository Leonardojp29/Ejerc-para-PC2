package com.cibertec.cibertec.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.cibertec.entity.Producto;
import com.cibertec.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository repository;
    
    @Override
    public List<Producto> listaProducto() {
        return repository.findAll();
    }

    @Override
    public Producto insertaActualizaProducto(Producto obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaProducto(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Producto> obtienePorId(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Producto> listaProductoPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Producto> listaProductoPorNombreLike(String nombre) {
        return repository.findByNombreLike(nombre);
    }

    @Override
    public List<Producto> listaProductoPorPrecioMenorIgual(BigDecimal precio) {
        return repository.findByPrecioLessThanEqual(precio);
    }

    @Override
    public List<Producto> listaProductoPorNombreYPrecio(String nombre, BigDecimal precio) {
        return repository.findByNombreAndPrecio(nombre, precio);
    }

    @Override
    public List<Producto> listaProductosVencidos() {
        return repository.findExpiredProducts();
    }
}
