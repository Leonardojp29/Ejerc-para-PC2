package com.cibertec.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.cibertec.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Aplicando Query methods
    public abstract List<Producto> findByNombre(String nombre);
    public abstract List<Producto> findByNombreLike(String nombre);
    public abstract List<Producto> findByPrecioLessThanEqual(java.math.BigDecimal precio);
    
    // Aplicando JPQL (Java Persistence Query Language)
    @Query("SELECT p FROM Producto p WHERE p.nombre = ?1 AND p.precio = ?2")
    public abstract List<Producto> findByNombreAndPrecio(String nombre, java.math.BigDecimal precio);
    
    @Query("SELECT p FROM Producto p WHERE p.fechaVencimiento < CURRENT_DATE")
    public abstract List<Producto> findExpiredProducts();
}
