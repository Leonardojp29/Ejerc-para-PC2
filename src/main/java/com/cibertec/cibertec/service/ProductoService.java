package com.cibertec.cibertec.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.cibertec.cibertec.entity.Producto;

public interface ProductoService {
    
    public abstract List<Producto> listaProducto();
    public abstract Producto insertaActualizaProducto(Producto obj);
    public abstract void eliminaProducto(int id);
    public abstract Optional<Producto> obtienePorId(int id);
    
    public abstract List<Producto> listaProductoPorNombre(String nombre);
    public abstract List<Producto> listaProductoPorNombreLike(String nombre);
    public abstract List<Producto> listaProductoPorPrecioMenorIgual(BigDecimal precio);
    public abstract List<Producto> listaProductoPorNombreYPrecio(String nombre, BigDecimal precio);
    public abstract List<Producto> listaProductosVencidos();
}
