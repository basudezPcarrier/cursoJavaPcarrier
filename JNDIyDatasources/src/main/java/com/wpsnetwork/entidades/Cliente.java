package com.wpsnetwork.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	private String nombre ;

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [" + (nombre != null ? "nombre=" + nombre : "") + "]";
	}
	
	
	
	
}
