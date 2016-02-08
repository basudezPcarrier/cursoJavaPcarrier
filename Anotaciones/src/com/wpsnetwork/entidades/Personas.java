package com.wpsnetwork.entidades;

import com.wpsnetwork.anotaciones.Descripcion;
import com.wpsnetwork.anotaciones.ValidarPersona;

@Descripcion("Representa una persona") // nuestra anotacion solo tiene un atributo
@ValidarPersona(minCodigo = 1, maxCodigo = 100 , patronNombre = ".") // patron \\A(([A-ZÑ])(\\p[lower]+))

// para poner la anotacion mas de una vez, en la anotacion hay que marcarla como Repeteable

@ValidarPersona(minCodigo = 7, maxCodigo = 100 , patronNombre = ".")

public class Personas {
	
	@Descripcion("Codigo de la persona")
	private int codigo ;
	@Descripcion("Nombre de la persona")
	private String nombre ;
	
	public Personas(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Personas() {
		super();
	}

	@Descripcion("Obtener el codigo de la persona")
	public int getCodigo() {
		return codigo;
	}
	@Descripcion("Rellenar el codigo de la persona")
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
