package com.wpsnetwork.patrones.observer;

import java.util.ArrayList;
import java.util.List;

public class EmisorEvento {
	
	// crear una lista de "oyentes" u "observers"
	private List<Observer> oyentes = new ArrayList<>();
	
	// metodo para añadir un observer
	public void addObserver(Observer o){
		oyentes.add(o) ;
	}
	
	// metodos update con y sin parametro (podrian ser incluso private y luego hacer)
	public void update(){
		for (Observer o : oyentes)
			o.update();// esta llamando al metodo de la interfaz
	}
	
	public void update(String mensaje){
		for (Observer o : oyentes)
			o.update(mensaje); // esta llamando al metodo de la interfaz
	}
	
	// los update con y sin podria haberlos creado privado si quiero y luego 
	// utilizarlos en otro etodo publico
	public void doSomething(){
		this.update();
	}
	
	public void eliminar(){
		this.update("Estoy eliminando algo");
	}
	
}
