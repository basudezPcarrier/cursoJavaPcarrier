package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	
	private static String driver ;  
	private static String url;  
	private static String user ;  
	private static String password ;  
	
	private static final String DATASOURCE_NAME = "DSWps" ; 
	
	static {
		
		Properties prop = new Properties();
		
		try {
			prop.load(Main.class.getResourceAsStream("../../../configuracionDB.properties"));
		
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e) ; 
		}
		
		driver = prop.getProperty("DRIVER") ;
		url= prop.getProperty("URL") ;
		user = prop.getProperty("USER") ;
		password = prop.getProperty("PASSWORD") ;
		
		try {
			Class.forName(driver).newInstance() ;
		
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// si no existe 
		
		crearGuadarDataSource();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void crearGuadarDataSource() {

		// conectarse al JINDI en cuestión

		// antes se hacía con un hashmap, pero ahora permiten hacer un Properties
		Properties props = new Properties() ;

		// cada fabricante del JINDI nos tiene qe inficar cómo configurar su JINDI...en el de oracle que 
		// estamos usando ahora, basta con el initial context factory y la url (en nuestro caso, 
		// utilizaremos un fichero)
		
		// decimo cual es el JINDI al que nos conectamos
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory") ;
		// decimos dónde esta ese jindi
		props.setProperty(Context.PROVIDER_URL, "file:///c:/fscontext") ; //lo hacemos en local (poxría ser internet). En local tenemos que asegurarnos que esta creada la carpeta
		
		// conectamos con el JINDI
		InitialContext ctx = null ;
		try {
			ctx = new InitialContext(props) ; // se conecta con el JINFI
			
			// ver si existe un objeto en el JINDI. Si no existe, lanza una excepcion...pero tambien 
			// podemos crearlo, y eso lo haremos en el catch
			Object obj = ctx.lookup(DATASOURCE_NAME) ;
			
			
			
			
			
			
			
			
			
//			// suponiendo que ya he creado el ojbeto (A a mi me está fallando pot algún motivo)
//			DataSource ds = (DataSource) ctx.lookup(DATASOURCE_NAME) ;
//
//			try( Connection con = ds.getConnection()){
//				
//				Statement comando = con.createStatement() ;
//				ResultSet resultado = comando.executeQuery("SELECT COUNT(*) FROM CLIENTE") ;
//				
//				resultado.next() ;
//				System.out.println("Numero de cliente: " + resultado.getInt(1));
//				
//	
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			
			
			
			
			
			
			
		}
		catch (NamingException ex) {
			
			
			try {
				
				// creamos el datasource
				
				OracleDataSource ds = new OracleDataSource() ;
				
				ds.setURL(url);
				ds.setPassword(password);
				ds.setUser(user);
				
				// creamos el data source en el JINDI
				
				ctx.bind(DATASOURCE_NAME, ds);
			
			}
			catch (SQLException e) {
				e.getStackTrace() ;
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
		
		
	}

}
