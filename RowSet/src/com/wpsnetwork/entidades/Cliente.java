package com.wpsnetwork.entidades;

public class Cliente {
	
	private int id ;
	private String nombre ;
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Cliente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Cliente() {
		super();
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", " + (nombre != null ? "nombre=" + nombre : "") + "]";
	}
	
	
}
