package com.wpsnetwork.patrones.dao;

public class Clientes {
	
	private int id ;
	private String nombre ;
	private int edad ;

	public Clientes() {
		super();
	}

	public Clientes(int id, String nombre, int edad) {
		super();
		setId(id) ;
		setNombre(nombre) ;
		setEdad(edad) ;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
}
