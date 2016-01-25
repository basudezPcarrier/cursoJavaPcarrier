package com.wpsnetwork.colecciones;

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

public class ColeccionArray <T> {

	
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
