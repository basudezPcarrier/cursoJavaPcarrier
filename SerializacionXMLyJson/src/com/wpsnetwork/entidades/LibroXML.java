package com.wpsnetwork.entidades;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LibroXML {
	
	Libro libro = new Libro();

	public LibroXML() {
		super();
	}
	
	public LibroXML(int codigo, String titulo, int anyo, String autor) {
		libro = new Libro (codigo, titulo, anyo, autor) ;
	}	
	
	public void guardarLibros(){
		
		try(XMLEncoder out = new XMLEncoder( new FileOutputStream("libro.xml"))){
			
			out.writeObject(libro);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Libro leerLibros(){
		
		try(XMLDecoder in = new XMLDecoder( new FileInputStream("libro.xml"))){
			
			libro = (Libro) in.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libro ;
		
	}
	
	
}
