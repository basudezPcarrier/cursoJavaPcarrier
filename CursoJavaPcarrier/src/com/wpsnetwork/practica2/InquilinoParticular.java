package com.wpsnetwork.practica2;

public class InquilinoParticular implements IInquilino {

	String nombre ;
	String id;
	double descuento ;
	
	
	public InquilinoParticular ( String nombre , String id ){
		this.nombre = nombre ;
		this.id = id ;
		this.descuento = 0.0;
		
	}


	public String getNombre() {
		return nombre;
	}


	public String getId() {
		return id;
	}


	public double getDescuento() {
		return descuento;
	}


}
