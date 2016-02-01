package com.wpsnetwork.dto.factorias;

import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.CategoriaLibro;
import com.wpsnetwork.dto.entidades.Libro;
import com.wpsnetwork.dto.entidades.Persona;
import com.wpsnetwork.dto.entidades.Prestamo;

public abstract class FactoriaDto {
		
	public static <Dto> Dto FactoriaDto (String tipoAcceso , Objetos tipoObjeto){
		
		Dto r = null ;
		
		if (tipoAcceso == "MEMORIA")
			switch (tipoObjeto){
				case LIBRO:
					r = (Dto) new Libro() ;
				case AUTOR:
					r = (Dto) new Autor() ;
				case PERSONA:
					r = (Dto) new Persona() ;
				case PRESTAMO:
					r = (Dto) new Prestamo() ;
				case CATEGORIA:
					r = (Dto) new CategoriaLibro() ;
			}
		
		return r ;
		
	}
}
