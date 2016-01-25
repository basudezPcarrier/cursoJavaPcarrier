package com.wpsnetwork.entidades.empresa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.entidades.personal.Cliente;

public class Empresa {

	private static final Logger log = LogManager.getLogger(Empresa.class.getName()) ;

	private int codigo ;
	private String nombre ;
	private int edad ;
	public Empresa(int codigo, String nombre, int edad) {
		super();

		if (log.isTraceEnabled())
			log.trace("Intentando crear la empresa " + this.nombre );

		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;

		// puedo ver que nivel tengo inicializado y que segun eso haga cosas o no P.e. si el debug esta activado
		if (log.isDebugEnabled()){
			log.debug("Parametro Codigo: " + codigo);
			log.debug("Parametro Nombre: " + nombre);
			log.debug("Parametro Edad: " + edad);
		}

		if (log.isTraceEnabled())
			log.trace("Empresa creada: " + this.nombre );

	}
	public Empresa() {
		super();
	}
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

}
