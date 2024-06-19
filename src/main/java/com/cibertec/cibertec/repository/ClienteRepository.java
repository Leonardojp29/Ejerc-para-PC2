package com.cibertec.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.cibertec.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    //Aplicando Query methods
    public abstract List<Cliente> findByDni(String dni);
    public abstract List<Cliente> findByNombresLike(String nombres);
    
    //Aplicadon JPQL (Java Persistence Query Language)
    @Query("SELECT x FROM Cliente x WHERE x.dni = ?1 AND x.nombres = ?2")
    public abstract List<Cliente> findByDniAndNombres(String dni, String nombres);
    

}
