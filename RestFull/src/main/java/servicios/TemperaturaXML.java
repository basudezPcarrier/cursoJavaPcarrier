package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Temperatura;

// path relativa a los restfull
@Path("/temperaturaXML")
public class TemperaturaXML {
	
	@GET // indica el metodo
	@Produces(MediaType.APPLICATION_XML)  // la respuesta: dice lo que va a devolver
	public Temperatura convertirCaF(){
		double farenheit ;
		double celsius = 36.8 ;
				
		farenheit = (( celsius * 9 ) / 5 ) + 32 ;
		
		Temperatura temp = new Temperatura( celsius, farenheit ) ;
		
		return temp ;
	}
	
}
