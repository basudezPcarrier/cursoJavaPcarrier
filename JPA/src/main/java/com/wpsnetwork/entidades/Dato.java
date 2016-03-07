package com.wpsnetwork.entidades;

public class Dato {
	
	private String nombre ;
	private String info ;
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getInfo() {
		return info;
	}
	protected void setInfo(String info) {
		this.info = info;
	}
	public Dato(String nombre, String info) {
		super();
		this.nombre = nombre;
		this.info = info;
	}
	public Dato() {
		super();
	}
	@Override
	public String toString() {
		return "Dato [" + (nombre != null ? "nombre=" + nombre + ", " : "") + (info != null ? "info=" + info : "")
				+ "]";
	}
	
	
	
}
