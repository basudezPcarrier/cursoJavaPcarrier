package com.wpsnetwork.consola;

import java.util.ArrayList;

import com.wpsnetwork.entidades.Circulo;
import com.wpsnetwork.entidades.Figura;
import com.wpsnetwork.entidades.Triangulo;
import com.wpsnetwork.enumerados.TipoTriangulo;
import com.wpsnetwork.interfaces.OperacionBinaria;

public class Main {
	
	// para poder llamarla...debo tener un metodo statico que no devuelva nada y reciba un array de caracteres
	public static void main(String[] args) {
		
		// si hago lo siguiente, me da error porque Figura es una clase
		// abstract y las clases abstractas no pueden crear objetos
		// figura fig1 = new Figura();
		
		Circulo c1 = new Circulo ( 1 , 2, 3) ;
		
		// System.out.println(c1);, excribe com.wpsnetwork.entidades.Circulo@139a55
		// porque el toString que esta utilizando es el que viene por defecto
		// en la calse Circulo slvo que lo sobreescriba
		//
		// para arreglarlo, vamos a hacer un override del toString en la clase circulo
		System.out.println(c1); 
		System.out.println(c1.getArea());
		
		Triangulo t1 = new Triangulo ( 10, 11 , 12 , 3 , TipoTriangulo.ISOSCELES) ;
		System.out.println(t1); 
		System.out.println(t1.getArea());
		
		// moldeo implicito
		
		Figura[] figuras = new Figura[2] ;
		figuras[0] = c1 ;
		figuras[1] = t1 ;
		
		// estoy moldeando el c1 a Figura
		// esto hace que "pierdo" (dejo de ver) metodos del circulo, solo veo las del padre
		// 
		//
		
		System.out.println(figuras[0].toString()) ;
		
		// casting explicito ()
		
		// si hiciera c1 = (Circulo) figuras[1] ; --> eso da una excepcion porque figuras[1] no es un circulo sino un triangulo 
		c1 = (Circulo) figuras[0] ;
		
		// EXPRESIONES LAMBDA
		//
		// (parentesis con los parametros) + el literal "->" + el código de la accion
		// 		si el codigo tiene mas de una linea, habra que poner las llaves y añadir un return
		// 		si no hay parametros, solo se ponen los parametros; si solo hay uno, se puede poner sin los parentesis
		// por ejemplo (x,y) -> x+y: 
		
		System.out.println( "Sumo = " + operar((x,y) -> x+y, 2, 3) );
		System.out.println( "Resto = " + operar((x,y) -> x-y, 2, 3) );
		System.out.println( "Multiplico = " + operar((x,y) -> x*y, 2, 3) );
		
		// EL <figura> indica el tipo de objeto que guardo
		
		ArrayList<Figura> lista = new ArrayList<Figura>(); 
		lista.add(c1) ;
		lista.add(t1) ;
		
		
		/*
		 * 
		 * lista.stream().allMatch(predicate) 
		 * ese predicate (es el nombre del parametro) debe ser un metodo funcional
		 * y por tanto se le puede poner una expresion lambda
		 * 
		 */
		
		// en teoria esta llamada "elimina" de esa lista los elementos
		// cuya area sea > 10
		//
		// podemos llamar al getArea porque habiamos definido el arrayList 
		// como de objetos Figura.
		// si no hubiera puesto nada, solo hubieramos podido accedera los del
		// objeto por defecto que es el objeto object
		//
		// OJO! ¿¿¿se supone que está modificando el objeto lista??? Dice que no
		//      que esta devolviendo una lista que no guardamos en ningun sitio
		
		lista.stream()
			.filter( e -> e.getArea() > 10) ;

		// el parallelStream saca mucho hilos apara hacer el stream en paralelo 
		lista.parallelStream()
		.filter( e -> e.getArea() > 10) ;

	}
	
	// utilizamos un metodo private para usar el metodo de la
	// interfaz ego 
	private static int operar(OperacionBinaria op, int a , int b){
		return op.operacion(a,b);
	}

}
