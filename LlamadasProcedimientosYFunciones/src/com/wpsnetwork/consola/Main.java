package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	
	private static String url ;
	private static String usuario ;
	private static String driver ;
	private static String password ;
	private static DataSource datasource ;

	
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		// crear el recurso
		Properties recurso = new Properties() ;
		
		// cargar el recurso a partir del path de la clase Main (los ../ signigica ir atrás un nivel en los directorios)
		recurso.load( Main.class.getResourceAsStream("../../../configuracionDB.properties")  );
		
		// obtener las propiedades
		
		url = recurso.getProperty("url") ;
		usuario = recurso.getProperty("usuario") ;
		driver  = recurso.getProperty("driver") ;
		password = recurso.getProperty("password") ;
		
		// cargar el driver
		
		Class.forName(driver).newInstance() ;
		
		// en vez de crear una conexion, vamos a crear un data source
		
		OracleDataSource ds = new OracleDataSource() ;
		
		// configurar el data source (se supone que hay un set para 
		// el nº de conexiones, pero Marc no es capaz de encontrarlo)
		
		ds.setUser(usuario);
		ds.setPassword(password);
		ds.setURL(url);
		
		datasource = ds ; // no esta muy claro por qué ha hecho una variable fuera del Main en vez de utilizar el ds
		
		// 
		
		try( Connection conexion = getConnection() ){
			
			long milis = LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli() ;
			
			// llamada al procedimiento
			
			CallableStatement comando = conexion.prepareCall("{call INSERTA_PEDIDO(?,?,?)}") ;
			
			comando.setString(1, "Cliente 1");
			comando.setDate(2, new Date(milis) ); // ese Date no es un java.util.localTime sino un sql.time
			comando.setString(3, "Pedido nuevo del cliente 1");
			
			// ejecutar el procecimiento
			
			comando.executeUpdate() ;
			
			// llamada a funcion 
			
			comando = conexion.prepareCall("{?=call NOMBRE_DE_CLIENTE(?)}") ;
			
			comando.setInt(2, 1);
			comando.registerOutParameter(1	, java.sql.Types.VARCHAR);
			comando.execute() ;
			
			System.out.println(comando.getString(1));
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static Connection getConnection () throws SQLException {
		return datasource.getConnection() ;
	}
	
	
}
