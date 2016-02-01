package com.wpsnetwork.visualizacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.wpsnetwork.entidades.Persona;

public class Consola {

	public static void main(String[] args) {
		
		List<String> listaNombres = new ArrayList<>();
		
		listaNombres.add("Paco") ;
		listaNombres.add("Juan") ;
		listaNombres.add("Pedro") ;
		listaNombres.add("María") ;
		listaNombres.add("Marta") ;
		listaNombres.add("Juan") ; // esta repetido a propósito
		
		// EJERCICIO
		// 		obtener la lista de nombres -sin repetidos- que tenga mas de cuato letras
		// 		el restultado debe estar ordenador
		
		// vamoa a hacerlo a kla viajea usanza
		
		List<String> resultado = new ArrayList<>() ;
		
//		for( String s : listaNombres ){
//			if( s.length() > 3 && resultado.contains(s))
//					resultado.add(s) ;
//		}
//		
//		resultado.sort(new Comparator<String>(){
//			@Override
//			public int compare(String o1 , String o2) {
//				return o1.compareTo(o2) ;
//			}
//		});
		
//		no sé por qué lo de arriba no funciona!!
		
		// a listaNombres, lo pasamos a stream, luego utilizaremos los metodos de ese clase
		// stream para ir haciendo ordenaciones, filtros, etc etc como intentabamos hacerlo arriba 
		
		String[] nombres = 
		
		listaNombres.stream()
		            .sorted() 		// ordenamos 
		            .distinct()		// distingue para dar valores unicos
		            .filter(e -> e.length() > 3 ) 	// filtramos segun cierto criterio...utilizaremos una lambda 
		            .toArray( len -> new String[len] ) // necesitamos un metodo final que me devuelva algo...utilizamos un toArray que me da un array 
		            ;
		
		System.out.println(Arrays.toString(nombres));
		
		System.out.println("La lista original");

		for (String s : listaNombres)
			System.out.println(s);
		
		System.out.println("La lista ya ordenada y filtrada");

		for (String s : nombres)
			System.out.println(s);
		

		System.out.println("obneter un array con las longitudes de los nombres");

		// obneter un array con las longitudes de los nombres
		
		int[] longitudes = listaNombres
				          .stream()
				          .mapToInt( e -> e.length())
				          .toArray() ;
		
		System.out.println(Arrays.toString(longitudes));

		
		// otra orma de hacerlo
		
		int[] longitudes2 = listaNombres
		          .stream()
		          .mapToInt( String::length ) // le indica de que clase son los elementos y el metodo que vamos a aplicar ahi
		          .toArray() ;

		System.out.println(Arrays.toString(longitudes2));
		
		
		List<Persona> personas = new ArrayList<>() ;
		
		personas.add( new Persona("Paco"  , 33 ) ) ;
		personas.add( new Persona("Pepe"  , 43 ) ) ;
		personas.add( new Persona("Pedro" , 43 ) ) ;
		personas.add( new Persona("Juan"  , 13 ) ) ;
		personas.add( new Persona("luis"  , 50 ) ) ;
		personas.add( new Persona("Marta" , 50 ) ) ;
		personas.add( new Persona("Maria" , 26 ) ) ;
		
		// obtener el nomnbre de la persona mas mayor
		
		System.out.println("Obtener el nombre de la persona mas mayor");
		
		String nombre = personas
				       .stream()
				       .max( (e1 ,e2) -> Integer.compare(e1.getEdad(), e2.getEdad()))
				       .get()
				       .getNombre() ;
		
		System.out.println(nombre);

		// obtener el nomnbre de las personas ordenadas
		//
		// es similar al que hicimos antes con tipos primitivos String pero ahora lo que
		// va a pasar por el flujo son personas
		
		System.out.println("obtener el nomnbre de las personas ordenadas");
		
		String[] n2 = personas.stream() 
				              .map(Persona::getNombre) // equivale a map(p -> p.getNombre() ) y convierte Personas a Strng
				              .sorted() // ordena strings
				              .toArray( len -> new String[len]) ;

		System.out.println( Arrays.toString(n2) );

		
		/* para hacer el ordenar por edad y mostrar los nombres
		 * 
		 * hay que hacer un pequeño sor antes 
		 * 		stream
				sort (con un compartor) que me devolvera personas ordenadas por edad
				hacer el map de personas para devolver como string

		String[] n2 = personas.stream() 
				              .sort( ordenar por la edad )
				              .map(Persona::getNombre) // equivale a map(p -> p.getNombre() ) y convierte Personas a Strng
				              .sorted() // ordena strings
				              .toArray( len -> new String[len]) ;


		 * 
		 * 
		 * */
		
		// obtener medias de las edad
		
		System.out.println("obtener medias de las edad");
		
		double edadMedia = personas.stream()
				                   .mapToInt(Persona::getEdad)
				                   .average()
				                   .getAsDouble() ;
		
		System.out.println(edadMedia);

		// obtener suma de las edades 
		
		System.out.println("obtener medias de las edad");
		
		int sumaEdades = personas.stream()
				                 .mapToInt(Persona::getEdad)
				                 .sum()
				                 ;
		
		System.out.println(sumaEdades);
		
		// ejemplo de reduce
		//
		// sirve para reducir los objetos a algo mas pequeño, en nuestro caso
		// recorreoms la lista de personas para crear una persona que acumulará 
		// en la edad la suma de las edades de las personas del stream
		
		System.out.println("Ejemplos de REDUCE");
		
		int sumaEdad = personas.stream()
		                       .reduce(new Persona("",0) , (acc , e) -> {
						        	acc.setEdad(acc.getEdad() + e.getEdad());
						        	return acc ;
						        }) // el acumulador es una expreson lambda en el que leo la edad de las personas que pasan por el stream y la voy añadiendo al accumulador para devolverlo
                               .getEdad() ;
		
		System.out.println("La suma de edad obtenida con el reduce es " + sumaEdad );


		// ejemplo de COLLECT
		
		System.out.println("Ejemplos de COLLECT");
		
		// agrupar por edades (haremos un mapa para agrupas personas segun su edad)
		
		System.out.println("Ejemplo grouping" );

		Map<Integer, List<Persona>> mapa = personas.stream()
				                                    .collect(Collectors.groupingBy(Persona::getEdad));
		
		
		for(int edad : mapa.keySet()) {
			System.out.println("Edad : " + edad );
			
			for (Persona p : mapa.get(edad)){
				System.out.println("    Nombre: " + p.getNombre());
			}
		}
		
		// Ejemplo particionar: crear dos grupos, uno para personas edad > 30 y otro para personas edad <= 30
		
		System.out.println("Ejemplo partition" );
		
		Map<Boolean,List<Persona>> mapa2 = personas
				                          .stream()
				                          .collect(Collectors.partitioningBy(p -> p.getEdad()<= 30 )) ;
		
		for(boolean cond : mapa2.keySet()) {
			System.out.println("Condicion : " + cond );
			
			for (Persona p : mapa2.get(cond)){
				System.out.println("    Nombre: " + p.getNombre());
			}
		}
		
		// Obtener todos los nombres en un unico string (concatenar los nombres)

		System.out.println("Ejemplo concatenar" );
		
		String nombresConcat = personas.stream().map(Persona::getNombre).collect(Collectors.joining("--")) ;
		// --> hace el map para que para cada Persona haga el getNombre
		
		
		System.out.println("Nombres: " + nombresConcat );
	
	}

}
