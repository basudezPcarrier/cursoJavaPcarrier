package com.wpsnetwork.patrones.abstractfactory;

public class colorFactory extends AbstractFactory {

	@Override
	public Color getColor ( String tipoColor ){
		
		Color color = null ;
		
		if (tipoColor.equalsIgnoreCase("ROJO")) 
			color = new Rojo() ;
		else if (tipoColor.equalsIgnoreCase("VERDE")) 
			color = new Verde() ;
		return color ;		
	}
	
	@Override
	public Forma getForma (String tipoForma) {
		return null ;
	}
	
}
