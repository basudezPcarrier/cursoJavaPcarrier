package com.wpsnetwork.patrones.abstractfactory;

public class FormaFactory extends AbstractFactory {
	
	@Override
	public Forma getForma ( String tipoForma ){
		
		Forma forma = null ;
		
		if (tipoForma.equalsIgnoreCase("CIRCULO")) 
			forma = new Circulo() ;
		else if (tipoForma.equalsIgnoreCase("CUADRADO")) 
			forma = new Cuadrado() ;
		else if (tipoForma.equalsIgnoreCase("RECTANGULO")) 
			forma = new Rectangulo() ;
		
		return forma ;		
	}

	@Override
	public Color getColor (String tipoColor) {
		return null ;
	}
}
