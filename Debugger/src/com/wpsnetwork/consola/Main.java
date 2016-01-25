package com.wpsnetwork.consola;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contador c = new Contador() ;
		c.contar();
		
		System.out.println("Hemos contado " + c.getResultado());
		
	}

}
