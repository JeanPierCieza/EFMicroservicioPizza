package com.idat.ef.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cliente_pizza")
public class Detalle {
	@Id
	private ClientePizzaFK fk =new ClientePizzaFK();

	public ClientePizzaFK getFk() {
		return fk;
	}

	public void setFk(ClientePizzaFK fk) {
		this.fk = fk;
	}

}
