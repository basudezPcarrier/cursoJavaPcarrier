package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Temperatura;

/* métodos:
 *   get: obtiene
 *   post: insertar/enviar
 *   put: updatea
 *   delete: eliminar
 * 
 * @produces 	--> indica el tipo de resultado que devuelve (p.e. XML, JSON)
 * @consumes 	--> indica el tipo de parametro que consume 
 * @path  		--> 
 * 		a un metodo tambien se le puede poner el @path
 * 			-> de esta forma, se "suma" el path de la clase y la del metodo
 * 		tb se puede utilizar para pasar parametros a un metodo o dirección 
 * 
 * 
 * */

// path relativa a los restfull
@Path("/temperaturaJSON")
public class TemperaturaJSON {
	
	private final String miTexto = "cadena por defecto" ;
	
	/* OJO!! al probarlo hay que poner la url http://localhost:8080/RestFull/restfull/temperaturaJSON
	 * 
	 * 		no recuerdo por qué XD....creo que 
	 * 
	 * 
	 * */
	
	
	@GET // indica el metodo
	@Produces(MediaType.APPLICATION_JSON)  // la respuesta: dice lo que va a devolver
	public Temperatura convertirCaF(){
		double farenheit ;
		double celsius = 36.8 ;
				
		farenheit = (( celsius * 9 ) / 5 ) + 32 ;
		
		Temperatura temp = new Temperatura( celsius, farenheit , miTexto ) ;
		
		return temp ;
	}
	
	// modifico el metodo anterior para pasarle un parametro...lo haremos utilizando la 
	// etiqueta path (no tiene porque llamarse igual el path que el parametro)
	// y luego 
	// lo que hará entonces es "/temperaturaXML" + "celsius"
	
	@GET // indica el metodo
	@Produces(MediaType.APPLICATION_JSON)  // la respuesta: dice lo que va a devolver
	@Path("{celsius}")
	public Temperatura convertirCaF( @PathParam("celsius") double c ){
		double farenheit ;
				
		farenheit = (( c * 9 ) / 5 ) + 32 ;
		
		Temperatura temp = new Temperatura( c, farenheit , miTexto ) ;
		
		return temp ;
	}
		
	@GET // indica el metodo
	@Produces(MediaType.APPLICATION_JSON)  // la respuesta: dice lo que va a devolver
	@Path("{celsius}/{cadena}")
	public Temperatura convertirCaF( @PathParam("celsius") double c , @PathParam("cadena") String texto){
		double farenheit ;
				
		farenheit = (( c * 9 ) / 5 ) + 32 ;
		
		Temperatura temp = new Temperatura( c, farenheit , texto ) ;
		
		return temp ;
	}
		
}
