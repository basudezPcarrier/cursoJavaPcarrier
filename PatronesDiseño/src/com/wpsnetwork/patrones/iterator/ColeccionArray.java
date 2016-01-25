package com.wpsnetwork.patrones.iterator;

import com.wpsnetwork.patrones.iterator.interfaces.Coleccion;
import com.wpsnetwork.patrones.iterator.interfaces.Iterator;

public class ColeccionArray implements Coleccion {
	
	private int[] contenido ;
	
	public ColeccionArray(int ...contenido) {
		super();
		this.contenido = contenido ;
	}

	@Override
	public Iterator getIterator(){
		return new.IteratorArray() ;
	}
	
	private class IteratorArray implements Iterator{
		
		private int pos ;
		
		@Override
		private boolean hasNext(){
			
			boolean r = false ;
			
			if ( pos < contenido.length ) r = true ;
			return r ; 
		}
		
		@Override
		private Object next(){
			// si tenemos siguiente, lo devolvemos
			private Object valor ;
			if (this.hasNext()) valor = contenido[pos++] ; // pos++ es pos incremento: nos devuelve el valor de pos y luego le suma uno a poss
			
			return valor ;
		}
	}
}
