package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.wpsnetwork.entidades.Cliente;

import oracle.jdbc.pool.OracleDataSource;

public class Main {

	private static String url ;
	private static String user ;
	private static String pass ;
	private static String driver ;
	
	public static void main(String[] args) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		
		Properties prop = new Properties();
		prop.load( Main.class.getResourceAsStream("configuracionBD.properties"));

		OracleDataSource dataSource = new OracleDataSource() ;
		
		url = prop.getProperty("url") ;
		user= prop.getProperty("driver") ;
		pass = prop.getProperty("password") ;
//		driver = prop.getProperty("driver") ;
		driver = "oracle.jdbc.OracleDrive" ;
		
		// cargar el driver

		
// no me funciona... :(		
		Class.forName(driver).newInstance() ;		
//		Class.forName("com.wpsnetwork.consola.Main").newInstance() ;
		
		// utiliza
		
		RowSetFactory fabricador = RowSetProvider.newFactory() ;
		
		JdbcRowSet rowset = fabricador.createJdbcRowSet() ;
		
		rowset.setUrl(prop.getProperty("url")); 
		rowset.setUsername( prop.getProperty("user")); 
		rowset.setPassword(prop.getProperty("password")); 
		
		rowset.setCommand("SELECT ID , NOMBRE FROM CLIENTE");
		
		rowset.execute(); 
		
		List<Cliente> clientes = new ArrayList<>();
		
		// nos tenemos que posicionar en la posicion antes de la primera posicion
		
		rowset.beforeFirst(); 
		
		// recorrer igual que recorriamos el resultset
		
		while ( rowset.next() ) {
			clientes.add( new Cliente( rowset.getInt("id") , rowset.getString("nombre"))) ;
		}
		
		System.out.println(clientes);
		
		// una vez terminemos todo, hay que cerrarlo
		
		rowset.close();
		
	}

}
