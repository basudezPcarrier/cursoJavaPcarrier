package com.wpsnetwork.entidades;

public class Cliente {
	
	private int codigo ;
	private String nombre ;
	
	public Cliente(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Cliente() {
		super();
	}
	protected int getCodigo() {
		return codigo;
	}
	protected void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", " + (nombre != null ? "nombre=" + nombre : "") + "]";
	}
	
}
