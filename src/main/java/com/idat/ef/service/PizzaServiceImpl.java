package com.idat.ef.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ef.client.OpenFeignClient;
import com.idat.ef.dto.Cliente;
import com.idat.ef.entity.ClientePizzaFK;
import com.idat.ef.entity.Detalle;
import com.idat.ef.model.Pizza;
import com.idat.ef.repository.ClientePizza;
import com.idat.ef.repository.PizzaRepository;


@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private ClientePizza repositoryPizza;
	
	@Autowired
	private PizzaRepository repository;
	
	@Autowired
	private OpenFeignClient feign;
	
	@Override
	public List<Pizza> listar() {
		return repository.findAll();
	}

	@Override
	public Pizza obtenerId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Pizza pizza) {
		repository.save(pizza);
		
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void actualizar(Pizza pizza) {
		repository.saveAndFlush(pizza);

	}

	@Override
	public void asignarPizzaCliente() {
		
		List<Cliente> listado = feign.listarClientesSeleccionados();;
		ClientePizzaFK fk = null;
		Detalle deta = null;

		
		for (Cliente cliente : listado) {
			
			fk = new ClientePizzaFK();
			fk.setIdCliente(cliente.getIdCliente());
			fk.setIdPizza(1);
			
			deta = new Detalle();
			deta.setFk(fk);	
			
			repositoryPizza.save(repositoryPizza);
		}
		
		
	}

}
