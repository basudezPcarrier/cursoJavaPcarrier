package com.wpsnetwork.entidades;

public class Rectangulo extends Figura{
	
	private int altura ;
	private int base ;
	
	public Rectangulo(int x, int y, int altura, int base) {
		super(x, y);
		this.altura = altura;
		this.base = base;
	}
	
	@Override
	public double getArea(){
		return base * altura ;
	}

	@Override
	public String toString(){
		return "Soy un rectangulo" ;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
