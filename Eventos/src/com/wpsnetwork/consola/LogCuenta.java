package com.wpsnetwork.consola;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.jdesktop.observablecollections.ObservableList;
import org.jdesktop.observablecollections.ObservableListListener;

public class LogCuenta implements Observer , PropertyChangeListener , ObservableListListener {

	@Override
	public void update(Observable emisor, Object saldo) {
		
		
		double s = 0.0 ;
		
		if ( saldo != null )
			s = (double) saldo ;
		
		
		System.out.println("La cuenta no tiene dinero o esta en nº rojos.");
		System.out.println("El salda actual es : " + saldo);
	}
	
	
	@Override
	public void propertyChange ( PropertyChangeEvent evt ) {
		System.out.println("Cambiando propiedad => " +
				" ** Propiedad: " + evt.getPropertyName() + 
				" ** Valor antiguo: " + evt.getOldValue() + 
				" ** Valor nuevo: " + evt.getNewValue() + 
				" ** Fuente: " + evt.getSource().getClass().getName()
				);
	}


	
	
	
	@Override
	public void listElementPropertyChanged(ObservableList arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listElementReplaced(ObservableList arg0, int arg1, Object arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listElementsAdded(ObservableList arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listElementsRemoved(ObservableList arg0, int arg1, List arg2) {
		// TODO Auto-generated method stub
		
	}
}
