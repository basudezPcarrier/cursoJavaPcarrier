package com.wpsnetwork.consola;

import com.wpsnetwork.entidades.LibroJson;
import com.wpsnetwork.entidades.LibroXML;

public class Main {

	public static void main(String[] args) {
		
		LibroXML l1 = new LibroXML(1, "tit 1", 2010, "Un autor") ;
		
		l1.guardarLibros();
		System.out.println(l1.leerLibros());
		
		LibroJson l2 = new LibroJson(1, "tit 1", 2010, "Un autor") ;
		
		l2.guardarLibros();
		System.out.println(l2.leerLibros());
		
	}

}
