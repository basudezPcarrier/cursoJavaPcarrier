package com.wpsnetwork.consola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.wpsnetwork.entidades.Cliente;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		System.out.println("**********  Inicio ejemplos ARRAYLIST");

		/* ejemplos de listas */
		
		/* LISTAS...en concreto ARRAYLIST
		 * 	
		 * 
		 * 		Si no le ponemos nada, tomara que tiene ojetos del tipo Object
		 * 			ArrayList lista = new ArrayList();
		 *  	y eso no es del todo util
		 *  	
		 *  	Para evitarlo, se suele hacer moldeo a su interfaz de esta forma
		 * 			List lista = new ArrayList();
		 * 		
		 * 		Tambien podemos restringir el tipo de datos que va a guardar
		 * 			List<String> lista = new ArrayList<String>();
		 * 		
		 * 		implementa la interfaz iterator por lo que se puede utilizar el bucle for ampliado 
		 * 
		 * */ 
		
		List<String> lista = new ArrayList<>();
		
		lista.add("Paco") ;
		lista.add("Pepe") ;
		
		// saber el tamaño de la lista...el nº de elementos que tiene -> lista.size()
		// OJO! me da el nº de posiciones ocupadas, no el nº de posiciones de la collección
		
		System.out.println( "Tamaño de la lista: " + lista.size());
		
		// recorrer listas
		// 
		// podemos hacer for normales
		
		for (int i = 0 ; i < lista.size() ; i++) {
			System.out.println(lista.get(i));
		}
		
		// pero tambien podemos hacer for ampliados ya que las listas implementan el interaz Iterator
		
		for ( String c : lista ) {
			System.out.println( c ); // --> ya lleva implicito el get
		}
		
		System.out.println("**********  Fin ejemplos SET");
		
		
		/* CONJUNTOS  (SET)
		 * 	
		 * 	 -> vamos a ver un treeSet  
		 * 
		 * 
		 * 
		 * */
		
		System.out.println("**********  Inicio ejemplos SET");
		
		Set<Cliente> clientes = new TreeSet<>();
		
		clientes.add( new Cliente( 3 , "A Nombre de 3" , 30 ) ) ;
		clientes.add( new Cliente( 5 , "B Nombre de 5" , 50 ) ) ;
		clientes.add( new Cliente( 1 , "C Nombre de 1" , 10 ) ) ;
		clientes.add( new Cliente( 2 , "D Nombre de 2" , 20 ) ) ;
		
		// voy a crear otro cliente 1 cambiandole la edad
		clientes.add( new Cliente( 1 , "Y Nombre de 1" , 100 ) ) ;
		
		/* Tal cual, resulta que el treeSet intenta ordenar pero no saber como hacerlo
		 * 
		 * Para hacerlo, mi objecto tiene que implementar la interfaz Comparable que es la que le
		 * dice como ordenar
		 * 
		 * Tal que así, resulta que el ultimo cliente no lo pinta al recorrer clientes porque
		 * piensa que es el mismo valor (porque el compareTo lo hacía por el nombre)
		 * 
		 * al comparar en el compareTo por el nombre en vez de por el id, ahora si me pinta el ultimo cliente
		 * 
		 * */
		
		for ( Cliente c : clientes ) {
			System.out.println( c );
		}
		
		/* Ahora vamos a sobre escribir los metodos Equals y hashCode para alterar 
		 * el comportamiento del compareTo
		 * 
		 * despues de sobrescribirlos resulta que el treeSet como usa el compareTo
		 * me sigue saliendo el mismo resultado que antes 
		 *
		 * 
		 * vamos a ver como se puede solucionar
		 * */
		
		Cliente cm1 = new Cliente(1 , "A", 10) ;
		Cliente cm2 = new Cliente(1 , "A", 10) ;
		
		System.out.println( cm1 == cm2 ); // --> me apunta a la misma posicion de memoria y devuelve false
		
		Cliente c1 = new Cliente(1 , "A", 10) ;
		Cliente c2 = new Cliente(1 , "A", 10) ;
		
		System.out.println( c1.equals(c2)); // --> compara segun el metod Clientes.equal y devuelve tru
		
		/* Crear un objeto exactamente igual que el otro: 
		 *	
		 *		c3 = c1.clone 
		 *
		 * eso da error porque resulta que no somos capaces de ver el metodo clone de la clase Cliente
		 * ni de la clase Objetc
		 * 
		 * Para poder "verlo", nuestra clase Cliente debe implementar la interfaz Cloneable
		 * 
		 * Además, el metodo Objetc.clone es privado, asi que aun no podemos acceder a el. Lo que hay que
		 * hacer es sobreescribirlo y hacerlo protected (no publica) 
		 * 
		 * 		-->> OJO! si quito la interfaz Cloneable de Clientes, salta una excepcion
		 * 
		 * */
		
		Cliente c3 = (Cliente)c1.clone() ;
		
		System.out.println( c1.toString());
		System.out.println( c3.toString());
		
		System.out.println("**********  Fin ejemplos SET");
		
		// pasar de un SET a un LIST (de un conjnto a una lista)
		//
		// para eso utilizaremos la clase superior Coleccions
		
		System.out.println("**********  Inicio ejemplos pasar conjuntos a listas");
		
		// se puede asar a lista de esta forma
		// 		List<Cliente> listaClientes = Collections.list( Collections.enumeration( clientes)) ;
		// aunque es una forma obsoleta de hacerlo
		//
		// la forma correcta es List<Cliente> listaClientes = new ArrayList<>(clientes) ;
		
		List<Cliente> listaClientes = new ArrayList<>(clientes) ;
		
		// ejecutado tal cual no tenemos asegurada ninguna ordenacion...vamos a comprobarlo desordenandolo 

		System.out.println("Lista desordenada");
		
		Collections.shuffle(listaClientes);
		
		for (Cliente c : listaClientes )
			System.out.println(c);
		
		// vamos a ordenar de nuevo la lista
		//
		// la clase Lista tiene un metodo sort pero que recibe una clase Comparator
		//
		// vamos a crear una clase generica Comparator y en vez de hacerlo aparte, lo haremos
		// aquí mismo
		
		listaClientes.sort( new Comparator<Cliente>() {

			@Override
			public int compare(Cliente arg0, Cliente arg1) {
				// comparamos por codigo
				return Integer.compare(arg0.getCodigo(), arg1.getCodigo()) ;
			}
			
		});

		System.out.println("desordenada");

		for (Cliente c : listaClientes )
			System.out.println(c);

		System.out.println("**********  Fin ejemplos pasar conjuntos a listas");

		/* ejemplos de listas */
		
		/* MAPAS...en concreto hashMap
		 * 		
		 * 
		 * 		Map<key,valor> 
		 * 			
		 * 			ambos tienen que ser clases primitivos. Normalmente Key puede ser un Integer
		 * 			o cualquier otra clase y valor puede ser también cualquier otra clase
		 * 
		 * */ 

		System.out.println("**********  Inicio ejemplos MAPAS hashMap");
		
		Map<Integer,String> diccionario = new HashMap<>() ;
		
		// en el caso de un treeMap, la parte que se "ordena" es el indice (en este caso seria el Integer)
		// en nuestro caso, no es un treeMap y la ordenacion que nos va a dar es un poco extraña como
		// veremos al recorrer las claves y los valores
		
		diccionario.put(10, "Valor 1") ;
		diccionario.put(30, "Valor 3") ;
		diccionario.put(50, "Valor 5") ;
		diccionario.put(20, "Valor 2") ;
		
		// como todas las colecciones, es iterable...
			
		System.out.println("Recorrer los valores");
		
		for ( String c : diccionario.values() )
			System.out.println(c);
	
		System.out.println("Recorrer las claves");

		for ( Integer c : diccionario.keySet() )
			System.out.println(c);
	
		System.out.println("Acceder al diccionario por sus claves");
		
		System.out.println(diccionario.get(20));
		
	}

}
