package com.wpsnetwork.dao.entidades;

public class Cliente {
	
	private int id ;
	private String nombre ;
	
	public Cliente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Cliente() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", " + (nombre != null ? "nombre=" + nombre : "") + "]";
	}
	
	
}
