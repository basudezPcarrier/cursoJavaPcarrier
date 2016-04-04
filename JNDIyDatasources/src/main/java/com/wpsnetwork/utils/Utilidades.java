package com.wpsnetwork.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.wpsnetwork.entidades.Cliente;

public class Utilidades {
	
	public static Number getNumeroJNDI ( String recurso ) throws NamingException {
		
		// obtento el JNDI del servidor (normalmente se pone la ruta, al estar en el servidor no hace falta ponersela)
		InitialContext ctx = new InitialContext() ;
		
		// debe emepzar por "java:comp/env" + luego el contenedor que queremos
		return (Number) ctx.lookup("java:comp/env/numeros/" + recurso) ; // en nuestro caso vamos buscando los recursor numbero
	}
	
	public static void setCliente ( String recurso , Cliente c) throws NamingException {
		
		InitialContext ctx = new InitialContext() ;
		ctx.bind(recurso, c );
		
	}
	
	public static Cliente getCliente ( String recurso ) throws NamingException {
		
		InitialContext ctx = new InitialContext() ;
		
		return (Cliente) ctx.lookup(recurso) ;
		
	}

	public static DataSource getDataSource() throws NamingException {

		InitialContext ctx = new InitialContext() ;
		return (DataSource) ctx.lookup("java:comp/env/jdbc/myoracle") ; // "java:comp/env" + nombre del data source 
	}

	
}
