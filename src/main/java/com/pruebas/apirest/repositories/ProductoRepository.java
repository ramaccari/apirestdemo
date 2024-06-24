package com.pruebas.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.apirest.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
