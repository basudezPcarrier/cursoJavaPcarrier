package com.wpsnetwork.consola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println(2.0);
		
		/* Leer con formato en funcion del idioma
		 * 	-> utilizar la clase scanner
		 * 
		 * */
		
		
		Scanner scanner = new Scanner("83,25") ;
		System.out.println(scanner.nextDouble());

		Scanner scannerIngles = new Scanner("83.25") ; // cambio la , por el .
		
		// con useLocale le indico el idioma y/o el pais utilizando un "new Locale(,)" 
		// 			por ejemplo podemos crear un new Locale ( System... y leer las propiedades del country e idioma del sistema)
		// o bien tambien podemos utilizar alguna de las constantes
		
		scannerIngles.useLocale(Locale.ENGLISH) ; 
		System.out.println(scannerIngles.nextDouble());
		
		// tambien podemos cambiar el idioma de la maquina virtual --> Locale.setDefault(newLocale);
		
		/* Vamos crear un fichero de propiedades y en vamos a rellenar valores de internacionalizacion
		 * 	configuracion.properties
		 * 		pais=es
		 * 		idioma=ES
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		
		// leer el fichero de propiedades
		
		Properties propiedades = new Properties() ;
		try {
			propiedades.load(new FileReader ("src/com/wpsnetwork/aplicacion.properties"));
			
			Locale.setDefault(new Locale(propiedades.getProperty("idioma"),propiedades.getProperty("pais")));
			
			ResourceBundle recursos = PropertyResourceBundle.getBundle("textos/internacionalizacion") ;
			
			System.out.println(recursos.getString("texto1"));
			System.out.println(recursos.getString("texto2"));
			System.out.println(recursos.getString("texto3"));
			System.out.println(recursos.getString("usuario.nombre"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// para imprimir textos formateados se utiliza el printf (System.out.printf("Esta linea pinta %d " , "esto");)
		// 
		// se puede utilizar el printf
		// o utilizar un String al que le indicamos el formato y luego utilizamos el println de siempre
		//
		// OJO!! a los saltos de linea
		
		// mostrar numeros con formato de idioma
		
		System.out.printf("%.2f", 2.3);
		
		String valor = String.format("\n%.2f", 5.6) ;
		System.out.println(valor);
		
		
	}

}
