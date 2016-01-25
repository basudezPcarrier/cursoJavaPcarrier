package com.wpsnetwork.practica1;

import java.util.Iterator;

public class Baraja {
	
	java.util.Vector<Carta> baraja ;
	
	public void iniciarJuego(){
		
		 baraja = new java.util.Vector<Carta>() ;

		 // rellenar la baraja 
		 for(int x = 1 ; x <= 10 ; x++ ){
			 for (PalosCartas p : PalosCartas.values()){
				 baraja.add( new Carta(p , x) );
			 }
		 }
	}
	
	public void baraja (){
		iniciarJuego();
	}
	
	public void barajar(){
		java.util.Collections.shuffle(baraja);
	}
	
	// devuelve la primera carta y la quita de la baraja (no hace una sola comprobacion)
	public Carta reparte() {
		Carta r = baraja.firstElement() ;
		baraja.remove(0) ;
		return r ;		
	}
	
	public Mano mano(int x) {
		Mano r = new Mano (x) ;
		Carta[] listaCartas = new Carta[x] ; 
		
		// obtener la lista de las x primeras cartas
		for ( int i = 0 ; i < x ; i++) {
			listaCartas[i] = reparte(); 
		}
		
		// asignar esa lista de cartas a la mano
		r.repartir(listaCartas) ;
		
		return r ; 
	}
	
//	public void main (String[] args){
//
//		System.out.println("Empezamos (baraja)...");
//
//		baraja() ;
//
//		System.out.println("Terminamos (baraja)...");
//
//	}
}
