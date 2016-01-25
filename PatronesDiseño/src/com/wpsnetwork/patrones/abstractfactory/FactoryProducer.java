package com.wpsnetwork.patrones.abstractfactory;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String eleccion) {
		AbstractFactory factoria= null ;
		
		if (eleccion.equalsIgnoreCase("FORMA"))
			factoria = new FormaFactory();
		else if (eleccion.equalsIgnoreCase("COLOR"))
			factoria = new colorFactory();
		
		return factoria ;
	}
	
}
