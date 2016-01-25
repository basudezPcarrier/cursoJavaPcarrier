package com.wpsnetwork.patrones.builder;

public class ComensalBuilder {
	
	public Comensal prepareMenu1(){
		Comensal c = new Comensal();
		
		c.setPlato(0, "Sopa");
		c.setPlato(1, "Carne");
		
		return c ;
	}
	
	public Comensal prepareMenu2(){
		Comensal c = new Comensal();
		
		c.setPlato(0, "Ensalada");
		c.setPlato(1, "Pescado");
		
		return c ;
	}
	
}
