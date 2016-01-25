package com.wpsnetwork.entidades.personal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.consola.Main;

public class Cliente {

	private static final Logger log = LogManager.getLogger(Cliente.class.getName()) ;

	private int codigo ;
	private String nombre ;
	private int edad ;
	public Cliente(int codigo, String nombre, int edad) {
		super();

		// puedo ver que nivel tengo inicializado y que segun eso haga cosas o no P.e. si el trace esta activado
		if (log.isTraceEnabled())
			log.trace("Intentando crear el cliente " + this.nombre );

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
			log.trace("Cliente creado: " + this.nombre );
	}
	public Cliente() {
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
