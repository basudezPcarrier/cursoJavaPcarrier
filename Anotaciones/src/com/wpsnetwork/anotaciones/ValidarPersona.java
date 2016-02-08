package com.wpsnetwork.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ValidacionesPersonas.class) // donde almacenar la lista de anotaciones de este tipo para
                                        // permitir usar mas de una vez esta anotacion en un mismo objeto/metodo...
                                        // 
                                        // ese ValidacionesPersona es una anotacion y debe tener al menos  
                                        // los mismos comportamientos (@Target, @Retention...) que esta anotacion
public @interface ValidarPersona {
	
	int minCodigo () default 1; // podemos indicar un valor por defecto con el default...
	int maxCodigo ();
	String patronNombre();
	
	
}
