package com.wpsnetwork.practica2;

public class InquilinoBuilder {
	
	public static IInquilino getInquilino ( String nombre , String  id , String tipoInquilino ){
		IInquilino inquilino = null ;
		
		if ( tipoInquilino.equalsIgnoreCase("PARTICULAR"))
			inquilino = new InquilinoParticular( nombre , id);
		else if ( tipoInquilino.equalsIgnoreCase("EMPRESA"))
			inquilino = new InquilinoEmpresa( nombre , id);
		
		return inquilino ;
		
	}
	
	
	
}
