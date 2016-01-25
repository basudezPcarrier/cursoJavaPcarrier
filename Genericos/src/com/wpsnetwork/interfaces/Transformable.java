package com.wpsnetwork.interfaces;

/* tipos T,V
 * el primero es de entrada
 * el segundo es de devolucion
 * 
 * 
 * */

public interface Transformable <T,V> {
	V transforma(T elemento) ;
}
