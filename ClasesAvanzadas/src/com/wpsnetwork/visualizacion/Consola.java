package com.wpsnetwork.visualizacion;

import com.wpsnetwork.entidades.*;

public class Consola {

	public static void main(String[] args) {
		
		/* Para acceder al objeto Coordenada2D debo importar el paquete entidades
		 * 
		 * Tambien puedo poner la direccion completa del paquete
		 * donde este la clase  
		 * 
		 * com.wpsnetwork.entidades.Figura fig1 = new com.wpsnetwork.entidades.Figura( new com.wpsnetwork.entidades.Figura.Coordenada2D(1 , 2) ) ;
		 * 
		 * */
		
		// para no almacenar el objeto coordenada, lo creo directamente en el parametro 
		Figura fig1 = new Figura( new Figura.Coordenada2D(1 , 2) ) ; 
		
	}

}
