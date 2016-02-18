package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.List;

import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

import com.wpsnetwork.entidades.CuentaCorriente;

public class Main {

	public static void main(String[] args) {
		
		
		// crear un log
		
		LogCuenta log = new LogCuenta() ;
		
		// crear una cuenta
		
		CuentaCorriente ccc = new CuentaCorriente(100.0, "Cuenta 1") ;
		
		// en la cuenta corriente -que actua como emisor- tenemos que añadir nuestro observer
		
		ccc.addObserver(log); // el observer que añadirmos es el el objeto log de la clase LogCuenta que implementa la internfaz Observer
		
		ccc.addPropertyChangeSupportListener(log); // el observer hecho con el propertyChangeSupport 
		
		ccc.addCantidad(-50);
		ccc.addCantidad(0);
		ccc.addCantidad(10);
		ccc.addCantidad(-70); // aqui la cuenta pasa a numeros rojos...asi que aqui es donde debe saltar el observer
		
		
		// Collecciones observables 
		
		System.out.println("***** Ejemplo de listas observables");
		
		// hemos importado la libreria beansdinding de jdeveloper -> ya implementa el PropertySupportChange
		
		List<CuentaCorriente> cuentas = new ArrayList<>() ;
		
		cuentas.add( new CuentaCorriente(100.0 , "Cuenta 1")) ;
		cuentas.add( new CuentaCorriente(200.0 , "Cuenta 2")) ;
		
		// cogemos nuestra lista de cuentas y la pasamos a observable creando un objeto lista con el metodo ObservableCollections.observableList
		
		List<CuentaCorriente> listaObservable = ObservableCollections.observableList( cuentas ) ; // creamos una lista de observables con la lista de cuentas
		
		ObservableList<CuentaCorriente> lista = (ObservableList) listaObservable ;
		
		lista.addObservableListListener(log);
		
		listaObservable.add( new CuentaCorriente(300 , "Cuenta 3")) ;
		
	}

}
