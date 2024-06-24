package com.pruebas.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.apirest.entities.Producto;
import com.pruebas.apirest.repositories.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping
	public List<Producto> obtenerProductos() {
		return productoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Producto obtenerProductoPorId(@PathVariable Long id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontró el Producto con id = " + id));
	}

	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoRepository.save(producto);
	}

	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoNuevo) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontró el Producto con id = " + id));
		producto.setNombre(productoNuevo.getNombre());
		producto.setPrecio(productoNuevo.getPrecio());
		return productoRepository.save(producto);
	}
	
	@DeleteMapping("/{id}")
	public String borrarProducto(@PathVariable Long id) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No se encontró el Producto con id = " + id));
		productoRepository.delete(producto);
		return "El producto con Id = " + id + " fué eliminado correctamente";
	}
	

}
