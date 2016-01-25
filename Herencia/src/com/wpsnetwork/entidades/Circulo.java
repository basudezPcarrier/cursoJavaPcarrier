package com.wpsnetwork.entidades;


// la clase que extiende debe estar en el mismo paquete o en c.c. hacer el import
// el final hace que no pueda tener hijos
public final class Circulo extends Figura {
	
	private int radio ;
	
	public Circulo() {
		// TODO Auto-generated constructor stub
	}

	// constructor que hereda el radio del padre
	public Circulo(int x, int y, int radio) {
		super(x, y); 		// esta creando el objeto de la clase padre (figura)
		this.radio = radio; // con el this acceso a los propiedades de esta clase
	}
	
	// sobre escribimos el toString (que viene por defecto) para que utilice el nuestro
	// OJO!! si no lo sobreescribimos, exite un toString por defecto en 
	// cada clase..! no va a utilizar el toString del padre! 
	// 
	
	@Override
	public String toString() {
		// si hacermos override heredando del padre se puede llamar así return super.toString();
		return "Soy un círculo"; 
	}

	//	@Override
	public double getArea(){
		return Math.PI * radio ;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	/*
	 * akl hacer en el main 		
	 * 		Figura[] figuras = new Figura[2] ;
	 * 		figuras[0] = c1 ;
	 * resulta que el metodo A no es visible por el figuras[0]
	 * pero si por el c1 
	 * 
	 * */
	public void A() {
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

	
}
