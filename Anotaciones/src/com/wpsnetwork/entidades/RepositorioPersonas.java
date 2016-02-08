package com.wpsnetwork.entidades;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.wpsnetwork.anotaciones.ValidarPersona;

public class RepositorioPersonas {
	
	private List<Personas> personas = new ArrayList<>() ;
	
	public void add ( Personas persona ) {
			
		if ( !validaPersona(persona) )
			throw new RuntimeException("La persoa no cumple las condiciones");
		
		personas.add(persona) ;
	}
	
	private boolean validaPersona( Personas persona ) {
		boolean resultado = true ;
		
		// obtenemos la anotacion y validamos con la persona
		
		Class meta = Personas.class ;
		
		ValidarPersona anotacion = (ValidarPersona) meta.getAnnotation(ValidarPersona.class) ;
		
//		// con los datos de la anotation, hay que validar los valores
//		
//		if ( anotacion == null )
//			resultado = false ;		// no hay anotaciones, entonces no cumplimos la anotacion y devuelvo false
//		else
//			resultado = validacion( anotacion, meta , persona ) ;
//
//		return resultado ;
		
		// para  varias anortaciones, obtenemos primero todos los anotations del tipo en cuestion
		// asi hecho es porque yo ya se que tengo mas de una anotacion ValidarPersona
		
		ValidarPersona[] anotaciones = (ValidarPersona[]) meta.getAnnotationsByType(ValidarPersona.class) ;
		
		if ( anotaciones.length == 0 ) 
			resultado = false ;
		else{
			
			for ( ValidarPersona a : anotaciones )
				if( (resultado != false) && (!validacion(a , meta, persona)))
					resultado = false ;
		}	
		
		return resultado ;
	}
	
	private boolean validacion( ValidarPersona anotacion , Class meta , Personas persona ){
		boolean resultado = true ;
		
		int min = anotacion.minCodigo() ;
		int max = anotacion.maxCodigo() ;
		String patronNombre = anotacion.patronNombre() ;
		
		// podriamos hace directamente persona.getcodigo pero vamnos a hacerlo
		// con metadatos para practicar
		
		try {
		
			int codigo = (int) meta.getMethod("getCodigo").invoke(persona) ;

			// con el codigo de la persona obtenido, vamos a verificar el codigo
			
			if ( codigo < min || codigo > max )
				resultado = false ;
//			else{
//				// si el codigo ha ido bien, miramos el patron
//				String patron = anotacion.patronNombre() ;
//				String nombre = (String) meta.getMethod("getNombre").invoke(persona) ;
//				
//				if ( Pattern.compile(patron).matcher(nombre).find() ) {
//					resultado = false ;
//				}
				
			}
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultado ;
	}
	
}
