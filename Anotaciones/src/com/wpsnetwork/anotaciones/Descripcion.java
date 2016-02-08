package com.wpsnetwork.anotaciones;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// indica donde se puede poner nuestra anotacion

@Target({
	ElementType.FIELD, // indica que permite e
	ElementType.METHOD, // indica que permite a nivel de metodo
	ElementType.TYPE // indica que permite a nivel de clase
})

// indica hasta donde tiene que sobrevivir...compilador, runtime, etc
/* RetentionPolicy tiene 3 valores posibles
 * 		CLASS 		-> se gurda en los .class pero no estan disponivles en tiempo de ejecucion
 * 		RUNTIME 	-> estan accesibles en tiempo de ejecucion (en teoría este es el mejor para nosotros)
 * 		SOURCE 		-> son elimionado por el compilador (ni si quiera llegan por tanto a los .class) 
 * 
 * */
@Retention(RetentionPolicy.RUNTIME)

// indica que nuestra anotacion esta accesible en el objeto donde se coloca y en sus clases. 
// Por defecto, la anotacion no se hererda y hay que poner esto para forzar la herencia de la anotacion
@Inherited

// para añadir la anotacion al javaDoc
@Documented

public @interface Descripcion {
	
	/* Es similar a una interfaz (pero se definie como @interface)
	 * 
	 * 
	 * Vamos a definir un atributo + un getter + un setter
	 * 
	 * 
	 * 
	 * */
	
	
	String value();
	
}
