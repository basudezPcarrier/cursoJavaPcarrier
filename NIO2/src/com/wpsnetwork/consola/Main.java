package com.wpsnetwork.consola;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) throws URISyntaxException {
		
		/* clases de la java.nio
		 * 
		 * 	Paths
		 * 		* representa una ruta
		 * 	Files
		 * 
		 * 
		 * 
		 * */
		
		Path pathUri = Paths.get( new URI ("file:///temp/ficheroTest.txt") ) ;
		Path path = Paths.get("c:/temp/ficheroTest.txt") ;
		Path path2 = Paths.get("c:/temp","ficheroTest.txt") ;
		
		Path carpeta = Paths.get("c:/temp") ;
		Path fichero = Paths.get("c:/temp/fichero1.txt") ;
		Path carpeta2 = Paths.get("temporal") ;
		
		// obtener la ruta relativa respecto a otro path
		
		System.out.println( "*******   Elimina el path comun de los dos Path y devuelve el resto: " + carpeta.relativize(fichero));
		
		// obtener la ruta absoluta combinando dos paths

		carpeta = Paths.get("c:/temp") ;
		fichero = Paths.get("fichero1.txt") ;
		
		System.out.println( "*******   Path de combinar dos path: " + carpeta.resolve(fichero));
		System.out.println( "*******   Path de combinar dos path: " + carpeta.resolve(carpeta2.resolve(fichero)));

		// para operar con Paths utilizaremos las clase Files
		
		
		try {

			Files.createDirectories(carpeta) ;
			Files.createFile(carpeta.resolve(fichero)) ;

			// aqui abajo falta algo de un enumerado en la opcion del copy...
			
//			Files.copy(carpeta.resolve(fichero),
//					carpeta.resolve(Paths.get("Fichero test 2.txt")),
//					
//					
//					) ;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
