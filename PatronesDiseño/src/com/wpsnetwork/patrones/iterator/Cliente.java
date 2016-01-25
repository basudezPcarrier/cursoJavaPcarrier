package com.wpsnetwork.patrones.iterator;

public class Cliente {
	super();
	private int codigo ;
	private String nombre ;
	private int edad ;
	
	
	public Iterator getIterator (){
		return new ClienteIterator();
		
	}
	
	private class ClienteInterator implements Iteratos{
		
		@Override
		public boolean hasNext(){
			return null ;
		}
		
		@Override
		public Object next(){
			return null ;
		}
		
	}
	
}
