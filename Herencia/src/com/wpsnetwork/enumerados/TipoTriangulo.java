package com.wpsnetwork.enumerados;

public enum TipoTriangulo {
	// EQUILATER, ISOSCELES, RECTANGULO
	// podemos ponerle un valor a cada tipo...
	// 
	// esos valores van a llamar al contructor del enum
	EQUILATER("Equilatero"), ISOSCELES("Isosceles"), RECTANGULO("Rectangulo") ;
	
	private String cadena ;
	
	// cuando vamos a poner metodos, en la def de los valores hay que poner el ;
	
	private TipoTriangulo(String cadena){
		this.cadena = cadena ;
	}
	
	@Override
	public String toString(){
		return cadena ;
	}

}

