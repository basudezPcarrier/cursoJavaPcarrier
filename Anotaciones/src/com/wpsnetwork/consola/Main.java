package com.wpsnetwork.consola;

import java.lang.reflect.Field;

import com.wpsnetwork.anotaciones.Descripcion;
import com.wpsnetwork.entidades.Personas;
import com.wpsnetwork.entidades.RepositorioPersonas;

public class Main {

	
	/* Anotaciones
	 * 	
	 * 	+ De compilador (una vez compiladas, desaparecen)
	 * 		
	 * 		Ejemplos:
	 * 			@Override 				-> mira si existe en alguna superclase
	 * 			@Supres Warnings 		-> para eliminar ciertos warnings
	 * 			@Deprecated 			-> en el editor sale con una llinea tachada y en el compilador salta  una alerta
	 * 			@FunctionlaInterface	-> el compilador comprueba que la interfaz solo tenga un unico metodo
	 * 
	 * 	+ Anotaciones que "sobreviven" al compilador
	 * 		
	 * 		Aquí es donde crearemos nuestras propias anotaciones
	 * 
	 * */	
	
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		
		// cómo acceder a esos metadatos de las anotaciones
		
		// primero accedemos al campo
		
		Class metadato = Personas.class ;
		
		Field codigo = metadato.getDeclaredField("codigo") ;
		
		// luego accedemos a las anotaciones del campio
		
		Descripcion anotacion = codigo.getAnnotation(Descripcion.class) ;
		
		// para obtener el contenido de la propiedad de la anotacion
		
		System.out.println(anotacion.value());
		
		System.out.println("**********   Validar una persona");

		// validar una persona
		
		Personas p = new Personas( 0 , "pepito") ; // asi daria error
		Personas p2 = new Personas( 8 , "Pepito") ; // asi no daria error

		RepositorioPersonas repositorio = new RepositorioPersonas() ;
		
		repositorio.add(p2); 

	}

}
