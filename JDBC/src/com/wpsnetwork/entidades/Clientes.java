package com.wpsnetwork.entidades;

public class Clientes {
	
	private int id ;
	private String nombre ;
	
	public Clientes(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		return "Clientes [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
