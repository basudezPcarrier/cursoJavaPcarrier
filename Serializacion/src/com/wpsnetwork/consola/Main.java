package com.wpsnetwork.consola;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.wpsnetwork.entidades.Autor;
import com.wpsnetwork.entidades.RepositorioAutores;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		/* Vamos a intentar guardar en fichero "objetos"
//		 * 
//		 *  
//		 * */
//		
		Autor a1 = new Autor(1 , "Pepito") ;
		Autor a ; 
//		
		Path fichero = Paths.get("fichero.ser") ;
//		ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream( fichero.toFile() ))) ;
//		
//		out.writeObject(a1); // hacer esto tal cual da error si nuestra clase no es Serializable -> hay que añadir la interfaz  a la clase Autor 
//
//		out.flush();
//		out.close(); 
//
//		// leer lo que hemos escrito
//	
//		ObjectInputStream in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( fichero.toFile() ))) ;
//		
//		a = (Autor) in.readObject(); 
//		
//		in.close();
//		
//		System.out.println(a.toString());
		
		RepositorioAutores.getInstance().serializacionObject( fichero.toFile() ); 

		RepositorioAutores.getInstance().deserializacionObject( fichero.toFile() );
		
	}

}
