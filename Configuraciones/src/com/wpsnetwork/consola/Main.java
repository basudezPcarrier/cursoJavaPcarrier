package com.wpsnetwork.consola;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.prefs.Preferences;

import javax.swing.SingleSelectionModel;

public class Main {

	public static void main(String[] args) {
		
		/* PROPIEDADES DEL SISTEMA
		 * 
		 * Clase System
		 * 
		 * 
		 * */

		System.out.println("Inicio propiedades systema");
		
		// System.out.println(System.getProperties().toString().replace(",", "\n"));
		
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.languaje"));

		System.out.println("Fin propiedades systema");

//		// finalizar el hilo de ejecucion
//		
//		System.out.println("Antes de finalizar");
//
//		System.exit(0);
//		
//		System.out.println("Despues de finalizar"); // al tener el exit antes, a este punto ni llega
		

		/* FICHERO DE PROPIEDADES / archivos de configuracion
		 * 
		 * 	es un fichero de texto que guarda propiedades de la forma "clave = valor"
		 * 
		 * 	suele tener la extension .properties
		 * 
		 * */
		
		System.out.println("Inicio fichero de propiedades / archivos de configuracion");
		
		// hemos creado un fichero de propiedades configuracion.properties
		// para leer el fichero, se utiliza una clase que se llama Properties
		
		Properties conf = new Properties(); 
		
		// cargar el fichero -> hay que poner la ruta relativa desde donde este el proyecto
		
		try {
			conf.load(new FileReader("C:/Users/Usuario/workspace_JAVA/Configuraciones/src/com/wpsnetwork/configuracion.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conf);
		System.out.println(conf.getProperty("usuario"));
		
		// guardar una propiedad
		// 	podemos crear una clave nueva o actualzar una existente
		// 	despues hay que guardar el fichero
		
		conf.setProperty("nueva clave", "esta") ;
		
		try {
			conf.store(new FileWriter("C:/Users/Usuario/workspace_JAVA/Configuraciones/src/com/wpsnetwork/configuracion.properties")
					                , "Comentarios que vamos a poner en el fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fin fichero de propiedades / archivos de configuracion");

		// probar un fichero sin ese nombre .properties
		
		Properties conf2 = new Properties(); 
		
		// cargar el fichero -> hay que poner la ruta relativa desde donde este el proyecto
		
		try {
			conf2.load(new FileReader("C:/Users/Usuario/workspace_JAVA/Configuraciones/src/com/wpsnetwork/conf.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(conf2);
		System.out.println(conf2.getProperty("fichero"));
		
		/* CONFIGURACION DE PROGRAMAS
		 * 	
		 * 	en windows se hace con la clase Preferences
		 * 		* en windows, se suele hacer en el registro, y ahi se 
		 *        pueden guardar a nivel de usuario o a nivel de maquina
		 * 
		 * */
		
		// preerencias a nivel de usuario

		System.out.println("Tocar preferencias del usuario");

		Preferences regWindUser = Preferences.userRoot() ;
				// HKEY_CURRENT_USER/Software/JavaSoft/prefs
				// solo para ese usuario
		
		// crear carpetas en el registro...
		
		regWindUser = regWindUser.node("com/wpsnetwork/preferencias") ; 

		// crear claves en el registro
		
		regWindUser.put("usuario", "Pepito");

		// leer clave del registro
		
		System.out.println(regWindUser.get("usuario", "Valor por defecto (Usuario no encontrado)") );
		System.out.println(regWindUser.get("usuariooooo", "Valor por defecto (Usuario no encontrado)") );
		

		// preerencias a nivel de sistema
		
		System.out.println("Tocar preferencias del sistema");
		
		Preferences regWindSist = Preferences.userRoot() ;
				// --> 32 bits HKEY_LOCAL_MACHINE/SOFTWARE/JavaSoft/prefs
				// --> 54 bits HKEY_LOCAL_MACHINE/SOFTWARE/Wow6432Node/JavaSoft/prefs
		
		// crear carpetas en el registro...
		
		regWindSist = regWindSist.node("com/wpsnetwork/preferencias") ; 

		// crear claves en el registro
		
		regWindSist.put("usuario", "Pepito");

		// leer clave del registro
		
		System.out.println(regWindSist.get("usuario", "Valor por defecto (Usuario no encontrado)") );
		System.out.println(regWindSist.get("usuariooooo", "Valor por defecto (Usuario no encontrado)") );
		
		/* obtener la MAQUINA VIRTUAL JAVA
		 * 	clase Runtime  --> OJO! no se puede crear un objeto porque la maquina ya está creada!!
		 * 
		 * */

		System.out.println("Obtener maquina virtual y lanzar aplicaciones externas");
		
		Runtime mv = Runtime.getRuntime();
		
		// ejecutar una aplicacion externa...
		
		try {
			
			// con este Process permite manipular la aplicacion que he lanzado
			Process p = mv.exec("calc.exe") ;
			
			System.out.println("Memoria total: " + mv.totalMemory() + " bytes" );
			System.out.println("Memoria libre: " + mv.freeMemory() + " bytes" );
			System.out.println("Memoria maxima: " + mv.maxMemory() + " bytes" );
			
			
			//finalizar la aplicacion lanzada p
			p.destroy();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
