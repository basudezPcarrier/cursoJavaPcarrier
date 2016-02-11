package com.wpsnetwork.entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LibroJson {

	Libro libro = new Libro();

	public LibroJson() {
		super();
	}
	
	public LibroJson(int codigo, String titulo, int anyo, String autor) {
		libro = new Libro (codigo, titulo, anyo, autor) ;
	}	
	
	public void guardarLibros(){
		
		try(FileOutputStream out = new FileOutputStream("libro.json")){
			
			ObjectMapper codificador = new ObjectMapper () ;
			
			codificador.writeValue(out, libro);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Libro leerLibros(){
		
		try ( FileInputStream in = new FileInputStream("libro.json")){

			ObjectMapper codificador = new ObjectMapper () ;
			libro = codificador.readValue(in , Libro.class ) ;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return libro ;
		
	}

	
}
