package com.wpsnetwork.practica2;

public class Pisos {
	
	private int planta ;
	private float precioBaseMensual  ;
	private int numeroPuerta ;
	
	public Pisos (int planta , int numeroPuerta , float precioBaseMensual ){
		this.planta = planta ;
		this.numeroPuerta = numeroPuerta ;
		this.precioBaseMensual = precioBaseMensual ;
	}
	
	
	public int getPlanta() {
		return planta;
	}
	public float getPrecioBaseMensual() {
		return precioBaseMensual;
	}
	public int getNumeroPuerta() {
		return numeroPuerta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public void setPrecioBaseMensual(float precioBaseMensual) {
		this.precioBaseMensual = precioBaseMensual;
	}
	public void setNumeroPuerta(int numeroPuerta) {
		this.numeroPuerta = numeroPuerta;
	}
	

	
	
}
