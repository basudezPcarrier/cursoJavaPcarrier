package com.wpsnetwork.patrones.singleton;

/* 
 * 
 * se utiliza para cuando queremos devolver siempre el mismo tipo deobjeto
 * 
 * 	- hay que definir una propiedad privada static instance del tipo de la clase
 * 	- un constructor privado
 * 	- un metodo static getInstance que devuelve un objeto cliente
 *  
 *  instancia y getInstance tienen que ser estaticos
 * 
 * Se accede: 
 * 		cliente c1 = cliente.getInstance() ;
 * 		cliente c2 = cliente.getInstance() ;
 * 
 * 
 * DESPUES de eso, ya se pueden tener otros metodos y propiedades
 * 
 * aqui un ejemplo de una de ellas, pero hay varias formas de hacerlo....
 * 	
 * 	p.e. usando el if (instancia == null) 
 * 
 * 
 * 
 * */

public class ClienteSingleton {
	
	
	// definir una propiedad privada "instancia"
	private static ClienteSingleton instancia = new ClienteSingleton() ;
	
	// constructor privado
	private ClienteSingleton() {
		super();
	}
	
	// necesita que sea estatico igual que la instancia
	public static ClienteSingleton getInstance(){
		return instancia ;
	}
	
}
