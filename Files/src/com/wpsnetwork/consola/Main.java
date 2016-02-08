package com.wpsnetwork.consola;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		// definimos una ruta con la clase File
		
		File rutaCarpeta = new File("c:/windows") ;
		
		if ( rutaCarpeta.isFile() )
			System.out.println("Es un fichero");
		
		if ( rutaCarpeta.isDirectory() )
			System.out.println("Es una carpeta");
				
		
		// crear una carpeta
		
		System.out.println("**********   Crear una carpeta");
		
		rutaCarpeta = new File ("c:/temp") ;
		boolean creada = rutaCarpeta.mkdir() ;

		System.out.println("**********   Ejecutar un fichero");
		
		File rutaFichero = new File ("c:/windows/notepad.exe") ;
		
		if ( rutaFichero.canExecute() )
			try {
				Runtime.getRuntime().exec(rutaFichero.getAbsolutePath()) ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// craer un fichero

		System.out.println("**********   Crear un fichero");
		
		rutaFichero = new File ("c:/temp/ficheroTest.txt");
		
		if (!rutaFichero.exists())
			try {
				rutaFichero.createNewFile() ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
