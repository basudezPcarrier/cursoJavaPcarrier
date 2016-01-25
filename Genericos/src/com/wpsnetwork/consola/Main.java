package com.wpsnetwork.consola;

import com.wpsnetwork.colecciones.ColeccionArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		ColeccionArray<Integer> listaInt = new ColeccionArray<Integer>();
//		listaInt.add(0, 5);
//		listaInt.add(1, 10);
//		listaInt.add(2, 15);
//		listaInt.add(3, 25);
//		listaInt.add(4, 30);
//		listaInt.add(5, 50);
//		listaInt.add(6, 60);
//		
//		ColeccionArray<String> listaStrings = new ColeccionArray<String>();
//		listaStrings.add(1, "Valor String");
//		
//		// tal cual necesitamos que listaInt sea iterable... y por defecto no lo es
//		// para solucionarlo utilizaremos el patron iterator y eso eso lo resolvemos 
//		// diciendole a la clase ColeccionArray que extienda de Iterator
//		// 		extendiendola de Iterator como de objetos T para hacerla generica tambien
//		// 		implementando el metodo iterator
//			
//		System.out.println("antes");
//
//		for (Integer w : listaInt ) {
//			System.out.println(w);
//		}
//		
//		listaInt.remove( e -> e%2 == 0 );
//		
//		System.out.println("despues");
//		
//		for (Integer w : listaInt ) {
//			System.out.println(w);
//		}
		

		ColeccionArray<Integer,Double> lista = new ColeccionArray<>();

		lista.add(0, 5);
		lista.add(1, 10);
		lista.add(2, 15);
		lista.add(3, 25);
		lista.add(4, 30);
		lista.add(5, 50);
		lista.add(6, 60);

		Double[] listaDouble = lista.transforma(Double.class, e -> e*10.0) ;
		
		for( Double v : listaDouble )
			System.out.println(v);
		
		
		System.out.println( ColeccionArray.sumaM(1 , 2 , 3 , 4 , -1 ) );
		System.out.println( ColeccionArray.sumaM(1.5 , 2.5 , 3 , 4 , -1 ) );

	}

}

