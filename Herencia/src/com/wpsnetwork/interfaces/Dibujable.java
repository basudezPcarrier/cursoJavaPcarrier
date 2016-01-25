package com.wpsnetwork.interfaces;

public interface Dibujable {
	
	// todos los metodos son implicitamente public y abstractos
	// todas las propiedades son public static y final
	//
	// eso significa que si no lo ponemos, esos son los modificadores que tomara
	//
	// en vez de poner public final static double PI = 3.15 ;
	// podemos poner double PI = 3.15 ;
	//
	// igual con los metodos, en vez de public abstract void dibujar() ;
	// podemos poner void dibujar ;
	
	double PI = 3.15 ;
	
	void dibujar();
	
	// desde Java 8 se puede tener el modificador default
	// las clases que implementen la interfaz tienen que tener definido 
	// el metodo hola, pero podria utilizar la implementacion de la interfaz
	//
	// esto hace que desde la interfaz podamos llamar al metodo tambien
	// igual que podemos llamar a las propiedades (en este caso PI)
	
	default String hola(){
		return "Hola" ;
	}
	
	
}
