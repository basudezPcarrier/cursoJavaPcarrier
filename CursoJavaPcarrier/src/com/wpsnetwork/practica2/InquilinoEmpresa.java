package com.wpsnetwork.practica2;

public class InquilinoEmpresa implements IInquilino {

	String nombre ;
	String id;
	double descuento ;
	
	
	public InquilinoEmpresa ( String nombre , String id ){
		this.nombre = nombre ;
		this.id = id ;
		this.descuento = 0.01;
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
