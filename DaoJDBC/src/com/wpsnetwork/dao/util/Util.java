package com.wpsnetwork.dao.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Util {

	
	private static DataSource datasource ; 
	
	// inicializar con la clase
	
	static {
		
		try{
			
			// vamos a cogerlo de un uichero de propiedades
			
			Properties recurso = new Properties();
			recurso.load(Util.class.getResourceAsStream("configuracionDB.properties"));
			
			// cargar el driver
			
			Class.forName( recurso.getProperty("DRIVER")).newInstance() ;
			
			// crear el datasource y la conexion 
			
			OracleDataSource ds = new OracleDataSource() ;
			
			ds.setURL(recurso.getProperty("URL"));
			ds.setUser(recurso.getProperty("USUARIO"));
			ds.setPassword(recurso.getProperty("PASSWORD"));
			
			datasource = ds ; 
			
			// obtener la conexion
			
		}
		catch ( Exception e ){
			throw new ExceptionInInitializerError(e) ;			
		}
	}
	
	
	public static Connection getConexion () throws SQLException{
		return datasource.getConnection() ;
	}

}
