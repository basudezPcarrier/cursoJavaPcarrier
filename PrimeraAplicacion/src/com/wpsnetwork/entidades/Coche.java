package com.wpsnetwork.entidades;

public class Coche {
	
	// private delante del atributo significa que solo se tienen acceso desde dentro de la clase, no desde fuera
	private String matricula ;
	private String marca ;
	private String modelo ;
	private String puertas ;
	
	public Coche(String matricula, String marca, String modelo, String puertas) {
		super(); // se pone automatico pero normalmente no hace falta ponerlo
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		
		/* Otra forma -segun este hombre es mejor diseño asi- es utilizar los setters
		 * porque asi centralizamos la asignacion al crear objetos en los setters
		 * 
		 * setMatricula( matricula ) ;
		 * setMarca( marca ) ;
		 * setModelo( modelo ) ;
		 * setPuertas( puertas ) ;
		 * 
		 * */
	}
	
	// constructor sin parametros...lo que se suele hacer es definir unos atributos por defectos
	public Coche(){
		// indicando this al principio, busca el metodo adecuado a los parametros recibidos
		this("XXX","Renault","mi modelo","5") ;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		// los parametros equivalen a variables locales del metodo...
		// por ejemplo si hago matricula = matricula estaremos asigando siempre al paremetro de entrada
		// para eso se añade el this. delante... es una referencia a la clase
		// viene a significar que estamos tocando uno de los atributos de la clase
		// a diferencia del set, el get no pone el this delante...porque no hay confusion porque no recibe ninguna variable matricula 
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPuertas() {
		return puertas;
	}

	public void setPuertas(String puertas) {
		this.puertas = puertas;
	}


}
