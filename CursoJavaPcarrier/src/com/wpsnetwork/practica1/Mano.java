package com.wpsnetwork.practica1;

public class Mano {
	
	private final int numCartas ;
	private Carta[] cartas ;
	
	public Mano ( int numCartas ) {
		this.numCartas = numCartas ;
		this.cartas = new Carta[ this.numCartas ] ;
	}
	
	public void repartir ( Carta[] cartas ) {
		this.cartas = cartas ;
	}
	
	// devuelve la puntuacion de las cartas de una mano
	public int puntuacion ( Mano mano ) {
		int r = 0 ;
		for ( int x = 0 ; x < mano.cartas.length ; x++ ) {
			r = r + mano.cartas[x].getPuntuacion() ;
		}
		return r ;
	}

	@Override
	public String toString() {
		String r = "" ;
		for ( int x = 0 ; x < this.cartas.length ; x++ ) {
			r = r + 
				", " + 
				this.cartas[x].getDspNumero() ;
		}
		return r ;	
	}
	
}
