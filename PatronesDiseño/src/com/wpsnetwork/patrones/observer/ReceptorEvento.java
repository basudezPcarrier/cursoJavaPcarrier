package com.wpsnetwork.patrones.observer;

// el receptor si implementa el 
public class ReceptorEvento implements Observer {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Evento sin param recibido");
	}

	@Override
	public void update(String mensaje) {
		System.out.println("Evento com param recibido: " + mensaje);

	}

}
