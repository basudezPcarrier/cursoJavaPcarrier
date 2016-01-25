package com.wpsnetwork.patrones.wrapper;

public class CaseWrapper {

	
	// tiene un has-a de la clase que quiere envolver
	// debe tener la misma funcionalidad que la original (los mismos metodos)
	
	private ClaseBase original = new ClaseBase ();
	private int nuevoValor ;
	private boolean modificado = false ;
	
	// estoy dando una funcionalidad a la claseBase que no tenia antes como es tocar 
	// el valor de la variable
	
	public int getValor(){
		
		if (modificado) 
			return nuevoValor ;
		else
			return original.getValor() ;
	}
	
	public void setValor( int valor ) {
		nuevoValor = valor ;
		modificado = true ;
	}

}
