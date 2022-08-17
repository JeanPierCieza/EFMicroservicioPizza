package com.idat.ef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ef.model.Pizza;
import com.idat.ef.service.PizzaService;

@RestController
@RequestMapping("/api/pizza/ef")
public class PizzaController {
	
	@Autowired
	private PizzaService service;
	
	@GetMapping("/listar")
	public @ResponseBody List<Pizza> listar(){
		return service.listar();
	}

	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody Pizza pizza) {
		service.guardar(pizza);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody Pizza pizza) {
		service.actualizar(pizza);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
	
	@GetMapping("/asignar")
	public @ResponseBody void asignarPizzaAClientes() {
		service.asignarPizzaCliente();
	}

}
