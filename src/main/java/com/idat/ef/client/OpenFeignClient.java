package com.idat.ef.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.ef.dto.Cliente;


@FeignClient(name="ef-cliente", url="localhost:3000")
public interface OpenFeignClient {
	
	@GetMapping("/api/cliente/ef/listar")
	public List<Cliente> listarClientesSeleccionados();

}
