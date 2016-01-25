package com.wpsnetwork.patrones.builder;

/* PATRON BUILDER
 * 
 * 
 * 
 * */

public class Comensal {
	
	// supòngamos 
	private String[] platos = new String[2];
	
	public void setPlato( int posicion , String plato) {
		
		/* operadores logicos
		 * 	
		 * 	Y
		 * 
		 * 		& 	--> obliga a evaluar las dos condiciones y luego evalua el resultado del operador 
		 *  	&& 	--> van evaluando de izq a derecha. Para en cuanto puede (similar al coalesce)
		 * 
		 * 	O 
		 * 		| 	--> mismo comportamiento que &
		 * 		|| 	--> mismo comportamiento que &&
		 * 
		 * 
		 * los && permiten expresiones
		 * 		
		 * 		i ( objeto != null && objeto.getPropiedad < 3 ) 
		 * porque si usamos solo el &, al acceder a objeto.getPropiedad petaria si el objeto fuera null
		 * 
		 * */
		
		if(posicion >= 0 & posicion < 2) 
			platos[posicion] = plato;
	}
}
