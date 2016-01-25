package com.wpsnetwork.entidades;

import com.wpsnetwork.enumerados.TipoTriangulo;

public final class Triangulo extends Figura {
	
	private int base ;
	private int altura ;
	
	private TipoTriangulo tipo ;

	public Triangulo(int x, int y, int base, int altura , TipoTriangulo tipo ) {
		super(x, y);
		this.base = base;
		this.altura = altura;
		this.tipo = tipo;
	}

	@Override
	public double getArea() {
		return base * altura / 2;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	@Override
	public String toString (){
		return("Soy un triangulo") ;
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
