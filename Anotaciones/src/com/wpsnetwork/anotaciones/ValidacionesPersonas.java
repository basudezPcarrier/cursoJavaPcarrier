package com.wpsnetwork.anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidacionesPersonas {
	
	ValidarPersona[] value(); // lo que tiene es un array de anotaciones
	
}
