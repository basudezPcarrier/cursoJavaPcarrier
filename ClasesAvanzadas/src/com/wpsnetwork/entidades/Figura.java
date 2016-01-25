package com.wpsnetwork.entidades;

public class Figura {
	
	/* Clase interna estatica (es la mas normal)
	 * 	
	 * 	- no importa donde la coloquemos dentro de la clase contenedora (se suele poner arriba del todo
	 *    o abajo del todo (igual que las propiedades)
	 *  - se comporta como una clase normal
	 *  - solo pùede acceder a las propiedades estaticas de la clase contenedora
	 *  - en la clase contenedora, se puede usar la clase intera
	 *  
	 *  - los modificadores que puede tener son: final, public, protected o private
	 * 
	 * */
	
	public static class Coordenada2D {
		
		/* Clase interna miembro
		 * 
		 *  - tiene acceso a las propiedades de la clase contenedor aunque 
		 *    sean privadas ()
		 *  - no pueden tener propiedades estaticas
		 *  
		 *  - los modificadores que puede tener son: public, protected o private
		 * 
		 * */
		
		private class Punto {
			private int valor ;
			
			// como hacer una propiedad de solo lectura: haciendola private y no definiendo el setter
			
			public int getValor() {
				return valor;
			}

			public void setValor(int valor) {
				this.valor = valor;
			}

			public Punto() {
				this(0);
			}

			public Punto(int valor) {
				super();
				this.valor = valor;
			}

		}
		
		private Punto x ;
		private Punto y ;
		public Coordenada2D(int x, int y) {
			super();
			this.x = new Punto(x);
			this.y = new Punto(y);
			// accede directamente a la propiedad de la clase contenedora
			numCoordenadas++ ;
		}
		
		/* El asistente me crea los getters y setters con los objetos Punto
		 * 
		 * nosotros los hemos cambiado para utilizar como int y luego
		 * usar los getters de la clase Punto "para que no se vean desde fuera"
		 * 
		 * los mismo hemos hecho con los setters
		 * 
		 * */
		
		public int getX() {
			return x.getValor();
		}
		public int getY() {
			return y.getValor();
		}

		public void setX(int x) {
			this.x = new Punto(x);
		}
		public void setY(int y) {
			this.y = new Punto(y);
		}
		
	}
	
	private Coordenada2D posicion ; // propiedad de la clase interna

	/* las propiedades no hace falta inicializarlas...las int dice que 
	 * coge el valor 0 (private static int numCoordenadas ;)
	 * 
	 * si las inicializamos en el constructor, resulta que solo podemos
	 * acceder al valor iniciado si hemos usado previamente el contructor
	 * 
	 * esto se puede evitar si el contructor es statico
	 * 
	 * */
	
	private static int numCoordenadas ;
	
	/* CONSTRUCTOR ESTATICO
	 *	static {
	 * 		do something ;
	 *  } 
	 * 
	 * 	- solo tenemos acceso a las propiedades y metodos estaticos
	 * 	- solo se llama una vez...que es la primera vez que utilizamos la clase
	 * 
	 * */
	
	static{
		numCoordenadas = 0 ;
	}

	
	public Figura(Coordenada2D posicion) {
		super();
		this.posicion = posicion;
	}

	public Coordenada2D getPosicion() {
		return posicion;
	}

	public void setPosicion(Coordenada2D posicion) {
		this.posicion = posicion;
	}

	public static int getNumCoordenadas() {
		return numCoordenadas;
	}

	public static void setNumCoordenadas(int numCoordenadas) {
		Figura.numCoordenadas = numCoordenadas;
	}
	
	
	
}
