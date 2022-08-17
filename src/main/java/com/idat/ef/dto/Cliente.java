package com.idat.ef.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {
	
	
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private Integer nroCelular;
	private String direccion;

}
