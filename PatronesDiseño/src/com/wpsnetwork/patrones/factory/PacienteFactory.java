package com.wpsnetwork.patrones.factory;

/* PATRON FACTORY
 * 
 * 		tiene un metodo get que recibe un parametro que distingira el objeto
 * 		que queremos que devuelva
 * 
 * 		en el ejemplo, recibe un parametros tipo de paciente y segun el 
 * 		valor que tome, creamos un pacienteHombre o un pacienteMujer
 * 
 * 
 * 
 * 
 * */


public class PacienteFactory {
	
	//
	
	public static Paciente getPaciente (String tipoPaciente) {
		
		Paciente paciente = null ;
		
		if (tipoPaciente.equalsIgnoreCase("HOMBRE")) 
			paciente = new PacienteHombre() ;
		else if (tipoPaciente.equalsIgnoreCase("MUJER")) 
			paciente = new PacienteMujer() ;
		
		return paciente ;
		
	}
	
}
