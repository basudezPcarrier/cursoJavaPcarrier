package com.wpsnetwork.consola;

public class Contador {
	
	private int resultado ;
	
	public Contador(){
		resultado = 0 ;
	}
	
	public int getResultado(){
		return resultado ;
	}
	
	public void contar(){
		
		for(int i = 0; i < 200 ; i++ ){
			resultado +=i ;
		}
	}
}
