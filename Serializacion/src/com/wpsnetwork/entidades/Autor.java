package com.wpsnetwork.entidades;

import java.io.Serializable;

public class Autor implements Serializable {

	/* Serializable va a permitir poder leer y escribir en ficheros p.e.
	 * 
	 * OJO!! La serializacion guarda todos los atributos de los objetos
	 *       pero NO guarda los atributos estaticos
	 *       
	 *       para que no devuelva alguna de las propiedades no estaticas, hay que ponerle
	 *       a la propiedad transient
	 * */
	
	
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	// este serialVersionUID lo va a utlizar para saber qué objeto esta escribiendo
	private static final long serialVersionUID = 1L;

	private int codigo ;
	private String nombre ;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Autor(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Autor() {
		super();
	}
	
	
	
}
