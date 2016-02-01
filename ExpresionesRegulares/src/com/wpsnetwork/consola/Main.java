package com.wpsnetwork.consola;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Ejemplo String");
		
		String s = "Hola" ;
		s.toUpperCase() ;
		String l = s.toUpperCase() ;

		/* El System.out.println(s) va a mostrar el original (sin mayusculas) porque String 
		 * es inmmutable
		 * 
		 * s.toUpperCase() ; ha creado  un nuevo objeto...aunque no lo ha asignado a nadie
		 * 
		 * l = s.toUpperCase() ; va a crear el nuevo objeto ya en mayuscula
		 * 
		 * */
		
		System.out.println(s);
		System.out.println(l);
		
		
		/* Ejemplo StringBuilder
		 * 
		 * 
		 * */
		
		System.out.println("Ejemplo StringBuilder");

		StringBuilder builder = new StringBuilder() ;
		
		builder.append("Primera cadena") ;
		builder.append(" + a ") ;
		builder.append(" + b ") ;
		
		System.out.println("builder = " + builder.toString());
		
		// eliminar contenido de un StringBuilder segun las posiciones
		
		builder.delete(0, builder.length()) ;
		
		System.out.println("builder = " + builder.toString()); 
		
		// recorrer el StringBuilder
		
		for(char i = 'A' ; i<='Z' ; i++) {
			builder.append(i) ;
			System.out.println(builder.toString());
		
		}
		
		/* Operaciones con String
		 * 
		 * 
		 * */

		System.out.println("Operaciones con Strings");
		
		String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme...";
		
		// busqueda de una palabra
		
		 int pos = 0 ;
		 
		 // se asigna a pos el valor del text.indexOf y luego lo compara con el -1 
		 // luego, si verifica el -1, entra en el blucle
		 
		 while ((pos = texto.indexOf(" de ", pos)) != -1){
			 System.out.println("Coincidencia encontrada en pos: " + pos);
			 pos ++ ;
		 }
		 
		 // separar las palabras sueltas (vamos a separar por una cadena, en este caso el espacio " ")
		 
		 String[] palabras = texto.split( "(\\s+)|(\\p{Punct}+\\s*)" ) ;
		 
		 // mostrarlo uno a uno en lineas distintas

		 for( String c : palabras ){
			 System.out.println(c);
		 }
		 
		 // mostrarlo directamente como array
		 
		 System.out.println(Arrays.toString(palabras));
		 
		 /* Clase para separar cadenas: STRINGTOKENIZER
		  * 	
		  * 
		  * */
		 
		 System.out.println("Ejemplo StringTokenizer");
		 
		 StringTokenizer stringToken = new StringTokenizer(texto, " ,") ; // por defecto el delimitador es 
		                                                                  // espacio, tabulador y salto de linea
		 
		 while(stringToken.hasMoreTokens()){
			 System.out.println(stringToken.nextToken());
		 }
		 
		 /* Exp regulares
		  * 	
		  * 	Cómo buscar cadenas que cumplen una expresion regular, p.e. un DNI 
		  * 
		  * */
		 
		 // creamos el patron 
		 Pattern patron = Pattern.compile("(\\d{8})(\\p{Alpha})") ; // comprueba DNI
		 
		 // creamos la cadena a comprobar
		 
		 String dnis = "12345678A    32165487B" ;
		 
		 // crear un matcher que es la clase que comprueba si casan o no
		 
		 Matcher coincidencia = patron.matcher(dnis) ; // busca las coincidencias del patron dentro de dnis
		 
//		 if (coincidencia.matches()){ // .matches busca que la cadena completa coincida con el patron
//			 System.out.println("Coincide");
//		 }
//		 else
//			 System.out.println("No coincide");
		 
		 // OJO!! he tenido que comentar el coincidencia.matches porque parece que 
		 //       al ponerlo avanza la posicion en la cadena...> si no lo comentaba
		 //       resulta que tenía que añadir un espacio delante a la cadena dnis
		 //       para que la expresion regular lo reconociera
		 
		 while ( coincidencia.find() ){
			 System.out.println(coincidencia.group(1));
		 }
		 
		/* clase Scanner
		 * 	permite leer de algun metodo de entrada (opuede ser un canal de entrada -teclado, p.e.- , puede 
		 *  ser un fichero o un String
		 *  
		 *  permite leer textos y extraer tipos primitivos
		 *  
		 *  es sensible al idioma del usuario
		 *  	p.e. para el tema de los puntos de decimales es importante pues algunos
		 *           sitios nos lo encotramos con . y otros con , (dependiendo del idioma)
		 * 
		 *  la clase scanner hay que "cerrarla" miObjetoScanner.close();
		 *  	p.e. si el scanner está leyendo de un fichero (el ichero hay que abrirlo...)
		 *           pero al hacer el close() hace implicitamente un cierre del fichero
		 * */
		 
		 String csv = "1;Pepito;20;1;2;Juanito;30" ;
		 
		 Scanner scanner = new Scanner(csv); // por defecto, separa las cosas por unos delimitarores que 
		                                     // viene por defecto, que son el espacio y el salto de linea
		 
		 scanner.useDelimiter(";") ;
		 
		 while(scanner.hasNext()){ // busca cualquier cosa utilizando el separador
			 
//			 int id = scanner.nextInt();
//			 String nombre = scanner.next() ;
//			 int edad = scanner.nextInt() ;
//			 
//			 System.out.println("Mostrando id = " + id + " -- nombre = " + nombre + " -- edad = " + edad );
			 
			 String valor= scanner.next() ;
			 
			 System.out.println("Mostrando valor = " + valor );
					
		 }
		 
		 scanner.close();
		 
	}

}
