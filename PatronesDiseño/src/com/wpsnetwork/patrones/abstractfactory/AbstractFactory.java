package com.wpsnetwork.patrones.abstractfactory;

// debe contener los metodos getter de todo lo que puede
// proporcionar como factoria

public abstract class AbstractFactory {
	
	
	// metodos abstractos (no tienen codigo) para obtener el color y la forma
	public abstract Forma getForma (String tipoForma) ;
	public abstract Color getColor (String tipoColor) ;
	
	
}
