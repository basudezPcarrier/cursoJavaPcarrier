package com.wpsnetwork.entidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAutores implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 11839623128681338L;
	
	transient private LocalDateTime ultimaLectura ;
	
	static public List<Autor> autores = new ArrayList<>() ;
	
	// singleton
	
	private static RepositorioAutores instance = new RepositorioAutores();
	
	private RepositorioAutores() {
		super();
	}
	
	public static RepositorioAutores getInstance(){
		return instance ;
	}
	
	// inicializar valores
	
	static {
		
		autores.add( new Autor(1 , "Pepito") ) ;
		autores.add( new Autor(2 , "Juanito") ) ;
		autores.add( new Autor(3 , "Jaimito") ) ;
		autores.add( new Autor(4 , "Jorguito") ) ;
		
	}
	
	
	public List<Autor> getAll(){
		return autores ;
	}

	@Override
	public String toString() {
		return "RepositorioAutores [ultimaLectura=" + ultimaLectura + ", instance=" + instance + "]";
	}
	
	// metodos para serializar (escribir ) y deserializar (leer)
	
	public void serializacionObject (File fichero) throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream( fichero ))) ;
		out.writeObject( this ); 
		out.flush();
		out.close();
	}

	public void deserializacionObject (File fichero) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( fichero ))) ;
		
		RepositorioAutores repositorio = (RepositorioAutores) in.readObject() ;
		
		// this.autores = repositorio.autores ; --> no hace falta xq ya se hace en el writeObjet que hemos escrito
		
		in.close();
	}
	
	// para retocar la serializacion y deserializacion, podemos implementar estos dos metodos para
	// que se comporte como nosotros queremos, p.e. para añadir nuestras propiedades estaticas
	//
	// tienen que tener la misma firma (salvo el nombre del parametro) que los que tiene Serializable
	// esto es, solo los estamos declarando porque queremos hacer algo raro, si no fuera asi, no haria falta ponerlos
	
	private void writeObject ( ObjectOutputStream out ) throws IOException {
		out.defaultWriteObject(); // hace la serializacon por defecto
		out.writeObject(autores); 
	}

	private void readObject ( ObjectInputStream in ) throws ClassNotFoundException, IOException {
		in.defaultReadObject(); // hace la deserializacon por defecto
		
		// ojo...no ponemos this.autores y this.ultimaLectura porque con el singleton trabajamos siempre con el instance 
		
		instance.autores = (List<Autor>) in.readObject();
		instance.ultimaLectura = LocalDateTime.now();
	}
	
	
}
