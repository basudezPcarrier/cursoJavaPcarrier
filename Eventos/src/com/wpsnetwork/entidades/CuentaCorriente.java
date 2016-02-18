package com.wpsnetwork.entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class CuentaCorriente extends Observable {
	
	
	private double saldo ;
	private String nombre ;
	public CuentaCorriente(double saldo, String nombre) {
		super();
		this.saldo = saldo;
		this.nombre = nombre;
	}
	public CuentaCorriente() {
		super();
	}
	public double getSaldo() {
		return saldo;
	}
	
	// lo  hemos tocado para hacerlo privado y asi no podemos tocar mas el saldo externamente
	// a cambio, vamos a crear un addCantidad
	private void setSaldo(double saldo) {
		
		double old = this.saldo ;
		
		this.saldo = saldo;
		
		// ara el ejemplo del propertyChangeSupport 
		propertyChangeSupport.firePropertyChange(PROP_SALDO, old, saldo); // solo lanza el evento si el valor cambia (quicir, si old y new son iguales, no hace nada)
		
	}
	
	public void addCantidad ( double dinero ){
		setSaldo(getSaldo() + dinero) ;
		
		if (getSaldo() <= 0 ) {
			setChanged(); 					// avisa al Observable que hemos cambiado
			notifyObservers(getSaldo()); 	// notifica a lo oyentes enviandoles el valor getSaldo
		}
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// para el ejemplo del PropertyChangeSupport
	
	private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this) ; // el this indica que propiedad queremos monitorizar. El this indica "todas las propiedades"
	private static final String PROP_SALDO = "Saldo" ;
	
	// vamos a tocar tb el set saldo (arriba)
	
	// escribimos metodos para añadir observers al propertyChangeSupport
	public void addPropertyChangeSupportListener( PropertyChangeListener oyente ){
		propertyChangeSupport.addPropertyChangeListener( oyente);
	}
	
	public void removePropertyChangeSupportListener( PropertyChangeListener oyente ){
		propertyChangeSupport.removePropertyChangeListener( oyente);
	}
	
}
