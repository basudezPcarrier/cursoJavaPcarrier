package com.wpsnetwork.consola;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wpsnetwork.entidades.empresa.Empresa;
import com.wpsnetwork.entidades.personal.Cliente;

public class Main {

	
	/* Logger
	 * 		recibe el mensaje
	 * 		normalmente se pone a nivel de paquete
	 * 		se puede tener herencia de loggers
	 * 			en ese caso, todos lo paquetes "hacia arriba" tambien reciben el mensaje
	 * 			que emite un paquete "de abajo"(el que  hereda de los de arriba)
	 * 
	 * appenders
	 * 		guarda los mensajes
	 * 		hay muchos tipos de appenders: 
	 * 			mostrar en consola
	 * 			guardar en fichero
	 * 			guardar en bbdd
	 * 			etc etc etc
	 * 		
	 * 		Si usamos de los que vuelcan a fichero, necesitaremos crear el fichero de configuración xml
	 * 		en el class_path
	 * 		Se edita un XML
	 * 			con etiquetas 
	 * 				coniguration
	 * 					appenders
	 * 						tipos ty nombre de appender
	 * 					loggers
	 * 
	 * 
	 * Niveles de errores
	 * 		
	 * TRACE
	 * 	-> por dónde va pasando del programa
	 * DEBUG
	 * 	-> valores de las propiedades, clases, artibutos, parametros...
	 * INFO
	 * 	-> info de interes
	 * 	p.e. versión, ids del usuario
	 * WARNING 
	 * 	-> situaciones anómalas que no afectan al funcionamiento de la aplicacion
	 * 	p.e. el usuario pone mal la contraseña
	 * ERROR
	 * 	-> parametros de configuracion incorrectos (no para la ejecución)
	 * FATAL
	 * 	-> la aplicación termina
	 * ------
	 * ------
	 * Tipos especiales
	 * 		ALL
	 * 		OFF
	 * 
	 * Cuando definimos un nivel, se muestran todos los logs de su tipo y los de nivel inferior (en el 
	 * mismo orden que arriba)
	 * 		p.e. si defino INFO se muestra info, warning, error y falta
	 * 		p.e trace muestra todos
	 * 		p.e. fatal solo mueste FATAL
	 * 
	 * 
	 * Documentacion del log:
	 * 		https://logging.apache.org/log4j/2.x/manual/layouts.html
	 * 
	 * */

	private static final Logger log = LogManager.getLogger(Main.class.getName()) ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		log.trace("Mensaje tpo trace");
		log.debug("Mensaje Debug");
		log.info("Mensaje Info");
		log.warn("Mensaje warning");
		log.error("Mensaje");
		log.fatal("Error fatal");
		*/
		
		Cliente c = new Cliente( 1 , "Paco" , 33 ) ;
		Empresa e = new Empresa( 1 , "La empresa de pago" , 1 ) ;
		
		
		
	}

}
