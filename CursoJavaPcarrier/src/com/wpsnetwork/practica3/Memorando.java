package com.wpsnetwork.practica3;

public class Memorando {
	
	private String titulo ;
	private int numArticulos ;
	private String[] articulos ;
	
	
	public String[] articulosQueCumplenCon ( IProcesa validacion ) {
		// crear array para almacenar el valiadcion.valida 
		String[] r = new String [numArticulos];
		int y = 0 ;
		// recorrer el array articulos y llamar al Iprocesa.valida
		for ( int x = 0 ; x < articulos.length;x++){
			
			if (validacion.valida( articulos[x] )) {
				r[y] = articulos[x] ;
				y++ ;
			}
			
		}
		
		// para evitar que devuelva r con articulos vacios, se puede usar otro array 
		// para recorrer r y devolver solo las posiciones de r que están rellenas 
		
		return r ;
		
	}
	
	public String[] articulosCon ( String cond ){
		
		return articulosQueCumplenCon( a -> a.contains(cond) ) ;
		
	}
	
	public Memorando(int numArticulos) {
		super();
		this.setNumArticulos(numArticulos);
	}
	
	public Memorando(String titulo, int numArticulos) {
		super();
		this.setTitulo(titulo);
		this.setNumArticulos(numArticulos);
	}
	
	public String getArticulo( int posicion , String[] articulos  ) {
		return this.articulos[posicion] ;
	}
	public void setArticulo( int posicion , String valor  ) {
		this.articulos[posicion] = valor ;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public int getNumArticulos() {
		return numArticulos;
	}
	public String[] getArticulos() {
		return articulos;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	private void setNumArticulos(int numArticulos) {
		this.numArticulos = numArticulos;
	}
	public void setArticulos(String[] articulos) {
		this.articulos = articulos;
	}
	
	
	
}
