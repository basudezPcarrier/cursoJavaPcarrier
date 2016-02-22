package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	
	private static String url ;
	private static String password ;
	private static String usuario ;
	private static DataSource datasource ;
	
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Properties recurso = new Properties();
		recurso.load( Main.class.getResourceAsStream("../../../configuracionDB.properties"));
		
		Class.forName( recurso.getProperty("DRIVER")).newInstance() ;
		
		url = recurso.getProperty("URL") ;
		password = recurso.getProperty("PASSWORD") ;
		usuario = recurso.getProperty("USUARIO") ;
		
		OracleDataSource ds = new OracleDataSource() ;
		ds.setURL(url);
		ds.setUser(usuario);
		ds.setPassword(password);
		
		datasource = ds ;
		
		try( Connection conexion = getConnection() ){
			
			// obtener los metadatos de la base de datos
			
			DatabaseMetaData metadatos = conexion.getMetaData() ;
			
			System.out.println("Base de datos: " + metadatos.getDatabaseProductName());
			System.out.println("Base de datos - version : " + metadatos.getDatabaseMajorVersion());
			
			// obtener esquemas de la bbdd
			
			ResultSet esquemas = metadatos.getSchemas() ;
			
			while ( esquemas.next() ){
				System.out.println( "Esquema: " + esquemas.getString("TABLE_SCHEM"));
			}
			
			// obtener tablas
			
			ResultSet tablas = metadatos.getTables(null, "WPS", "%", null) ;
			
			while ( tablas.next() ){
				System.out.println( "Tablas: " + tablas.getString("TABLE_NAME") + " Tipo: " + tablas.getString("TABLE_TYPE"));
			}
			
			
			// obtener las funciones del esquema WPS
			
			ResultSet functiones= metadatos.getFunctionColumns(null, "WPS", "%", null) ;
			
			while ( functiones.next() ){
				System.out.println( "Funciones: " + functiones.getString("FUNCTION_NAME") + " Nombre espeífico: " + functiones.getString("SPECIFIC_NAME") );
			}

			// obtener el nombre de usuario
			
			System.out.println( metadatos.getUserName() ); 
			
			// obtener info de las columnas de una tabla
			
			ResultSet columnas = metadatos.getColumns(null, "WPS", "CLIENTE", "%" ) ;
			
			while ( columnas.next() ){
				System.out.println( "Columnas: " + 
						columnas.getString("TABLE_SCHEM") + "." + 
						columnas.getString("TABLE_NAME") + "." + 
						columnas.getString("COLUMN_NAME") + "  " +
						columnas.getString("DATA_TYPE") + "(" + columnas.getString("TYPE_NAME") + ")"
						
						/* Otras csas
						 * 	
						 * 	
						 * 	COLUMN_SIZE			tamaño de la columna
						 * 	DECIMAL_DIGITS		decimales de la columna
						 * 	NUM_PREC_RADIX 		precision de la columnas
						 * 	NULLABLE 			
						 * 	ORDINAL_POSITION
						 * 	IS_AUTOINCREMENT
						 * */
						);
			}

		}
		catch( SQLException e){
			System.out.println(e.getMessage());
		}

	}
	
	private static Connection getConnection() throws SQLException{
		return datasource.getConnection() ;
	}
	
}
