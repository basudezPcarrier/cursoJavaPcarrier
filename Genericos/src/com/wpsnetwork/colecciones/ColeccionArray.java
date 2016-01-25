package com.wpsnetwork.colecciones;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import com.wpsnetwork.interfaces.Evaluable;
import com.wpsnetwork.interfaces.Transformable;

/* Para hacer genericos, a la definicion de la clase le añadimos el tipo que queremos
 * , por convenio
 * 
 * T -> tipos
 * E -> elementos
 * N -> numero
 * K -> claves
 * V -> valores
 * 
 *  
 * ese va a ser una especie de tipo generico que servira para pasarle cualquier cosa
 * 
 * Cuando luego lo utilicemos, solo permiten clases no tipos primitivos
 * 
 * 		ColeccionArray<Integer> lista = new ColeccionArray<Integer>(); // por eso se le pone Intenger en vez de int

 * 
 * */

public class ColeccionArray <T,V> implements Iterable <T> {

	
	private static final int TAMAÑO_INICIAL = 10 ;
	private T[] elementos ;
	public ColeccionArray() {
		super();
		elementos = (T[])new Object[TAMAÑO_INICIAL] ;
	}
	
	
	public void add (int posicion , T valor) {
		
		if ( posicion >= elementos.length ) throw new ArrayIndexOutOfBoundsException(); 
		
		elementos[posicion] = valor ;
		
	}
	
	public T get( int posicion ) {
		return elementos[posicion] ;
	}

	/* al decirle arriba que iterator me va a dar un T, al crear el metodo
	 * ya me lo crea como que va a devolver un iteratos tipo T
	 * 
	 * En este caso, hay un metodo que pasa los array a lista y sobre la lista ya puedo iterar
	 * 
	 * 
	 * */
	@Override
	public Iterator<T> iterator() {
		return Arrays.asList(elementos).iterator() ; // me crea una lista con el array y sobre la lista llamamos al iterator
		
	}

	public void remove ( Evaluable<T> criterioEliminacion){
		for( int i=0 ; i<elementos.length;i++ ) {
			if( elementos[i] != null && (criterioEliminacion.cumple(elementos[i]) ) ){
				elementos[i]=null ;
			}
		}
	}
	
	public V[] transforma ( Class<V> tipoRetorno , Transformable<T,V> transformadora ) {
		
		// al Array.newInsdtance hay que hacerle el cast a V[]
		V[] resultado = (V[]) Array.newInstance( tipoRetorno , elementos.length) ;
		
		
		for ( int i = 0 ; i<elementos.length ; i++ ) {
			// resultado = si elemento != null then transdorforma else null ;
			resultado[i] = elementos[i] != null ? transformadora.transforma(elementos[i]): null ;
			
			/* Ejemplo
			 * 
			 * 	int i = 3 ;
			 * 	i + "" --> transforma el i a String
			 * 
			 *  double x = i * 1.0 ; --> transforma el i a double 
			 * 
			 * 
			 * */
			
		}
		
		return resultado ;
	}
	
	
	//
	
	// "Integer ... " signigica que son parametrosd vairables que internamente se comporta como array
	// 
	// de esta forma solo permite sumar enteros... 
	// 
	// vamos a cambiarlo para que permita cualquier cosa
//	public static double suma( Integer ... valores ){
//		double resultado = 0.0 ;
//		
//		for ( Integer x : valores ) {
//			resultado += x ;
//		}
//		
//		return resultado ;
//	}
	
	// con M extends Number, ya estoy diciendo que los M que reciba tienen que ser extensores 
	// de la clase Number
	
	public static <M extends Number > double sumaM( M ... valores ){
		double resultado = 0.0 ;
		
		for ( M x : valores ) {
			resultado += x.doubleValue() ;
		}
		
		return resultado ;
	}

	
/*
 * 
 * 	private static final int TAMAÑO_INICIAL = 10 ;
	private int[] elementos ;
	public ColeccionArray() {
		super();
		elementos = new int [TAMAÑO_INICIAL] ;
	}
	
	
	public void add (int posicion , int valor) {
		
		if ( posicion >= elementos.length ) throw new ArrayIndexOutOfBoundsException(); 
		
		elementos[posicion] = valor ;
		
	}
	
	public int get( int posicion ) {
		return elementos[posicion] ;
	}

 * 
 * 
 * */	
	
}
