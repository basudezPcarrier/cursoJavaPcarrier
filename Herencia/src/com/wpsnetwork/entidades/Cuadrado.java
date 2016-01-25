package com.wpsnetwork.entidades;
public class Cuadrado extends Rectangulo {
	/*
	 * como cuadrado herada de rectangulo y esa clase ya tiene el metodo dibujar
	 * hace que aqui no haya que implementarlo
	 * si quisieramos implementarlo, hariamos el Override 
	 * 
	 * */
	public Cuadrado(int x, int y, int lado) {
		super(x, y, lado , lado);
	}
	
	/*
	 * no voy a utilizar los getter y setters de la superclase
	 * sino sobre escribirlos, pero tengo que sobre escribir los dos
	 * para asegurarme de que siempre toquen las dos dimensiones del objeto
	 * incluso aunque solo llamen a uno de los dos metodos
	 * 
	 * */
	
	@Override
	public void setBase(int base){
		super.setBase(base);
		super.setAltura(base) ;
	}
	
	// sobre escribo los dos porque no quiero que por error se llame a uno 
	// de ellos solo y no el otro 
	@Override
	public void setAltura(int base){
		super.setBase(base);
		super.setAltura(base) ;
	}
	
	
	
}
