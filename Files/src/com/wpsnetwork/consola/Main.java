package com.wpsnetwork.consola;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;

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
				
				// el Files.walk permite crear un Stream para "navegar por los ficheros y carpetas del
				// disco duro.
				
				Files.walk(Paths.get("c:","windows"), FileVisitOption.FOLLOW_LINKS)
					.filter(f -> Files.isReadable(f) && Files.isDirectory(f)) 
					.forEach( f -> System.out.println(f));
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
