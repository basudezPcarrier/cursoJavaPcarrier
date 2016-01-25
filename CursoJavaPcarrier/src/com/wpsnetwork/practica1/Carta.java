package com.wpsnetwork.practica1;

public class Carta {
	
	/* Cada carta se identifica por su palo de la baraja, por un 
	 * número (de 1 a 10, donde el 1 es el as, el 8 es la sota, el 
	 * 9 el caballo y el 10 el rey)y por una puntuación diferente
	 * 
	 * 
	 * */
	
	private final PalosCartas palo ; // palo de la carga
	private final int numero ; // num de la carta
	private final String dspNumero ; // wording del umero de la carta
	private final int puntuacion ; // valor de la carta (segun el numero de carga)
	
	// Constructor de la clase recibiendo el palo y el numero de la carga
	public Carta ( PalosCartas palo , int numero ) {
		
		// deberia controlar que numeros solo tome del 1 al 10 
		
		this.palo = palo ;
		this.numero = numero ;

		// asgnar el valor de la carta segun el numero de la carga
		if (this.numero == 1) {
			this.puntuacion = 11 ;
			this.dspNumero = "AS" ;
		}
		else if (this.numero == 8) {
			this.puntuacion = 10 ;
			this.dspNumero = "Sota" ;
		}
		else if (this.numero == 9) {
			this.puntuacion = 10 ;
			this.dspNumero = "Caballo" ;
		}
		else if (this.numero == 10) {
			this.puntuacion = 10 ;
			this.dspNumero = "Rey" ;
		}
		else {
			this.puntuacion = this.numero ;
			this.dspNumero = "" + this.puntuacion ; 
		}
	}

	// metodos getters
	public PalosCartas getPalo(){
		return this.palo ;
	}
	public int getNumero(){
		return this.numero ;
	}
	public String getDspNumero(){
		return this.dspNumero ;
	}
	public int getPuntuacion(){
		return this.puntuacion ;
	}
	
	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", numero=" + numero + ", puntuacion=" + puntuacion + "]";
	}
	
}
