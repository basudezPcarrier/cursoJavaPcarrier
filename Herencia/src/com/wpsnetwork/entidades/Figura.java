package com.wpsnetwork.entidades;

import com.wpsnetwork.interfaces.Dibujable;

// 		el abstract hace que no pueda hacer un objeto de esa clase
// 		como la clase es abstracta, aunque implementa una interfaz, no tiene
// 		obligacion de implementar los metodos de la interfaz
// 		esa obligación la "heredan" los hijos y hay que crear por tanto
// 		esos metodos en las clases que heredan de Figura
public abstract class Figura implements Dibujable {

	private int x ;
	private int y ;

	public Figura(){
		/*
		 * lo primero que debe tener el constructor es el super o el is
		 * 		
		 * 		el super es para llamar al constructor del parent (por defecto el de la clase object
		 * 			--> en general, el super es para acceder al parent inmediatemente superior
		 * 		el this hace referencia a la clase actual
		 * 
		 * */
		
		super(); // cogera el constructor del parent
		         // podemos hacer super( con mis parametros) y entonces buscaria
		         // en la clase parent un constructor con esos parametros
		
	}
	
	public Figura (int x , int y){
		this();
		this.x = x ;
		this.y = y ;
		// es mejor costumbre utilizar los setters
	}

	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

	// un metod abstract solo puede estar en una clase abstracta
	// 		el abstract indica que el metodo va a ser definido en los hijos
	public abstract double getArea() ;
	
	@Override
	public String toString(){
		return "Soy una figura" ;
	}
	
}
