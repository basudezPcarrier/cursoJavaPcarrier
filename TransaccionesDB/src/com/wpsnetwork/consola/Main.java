package com.wpsnetwork.consola;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Main {
	
	private static DataSource ds ;
	
	static{
		
		try{

			
			Properties prop = new Properties();
			
			prop.load( Main.class.getResourceAsStream("../../../configuracionDB.properties"));
			
			String url = prop.getProperty("url") ;
			String user= prop.getProperty("driver") ;
			String pass = prop.getProperty("password") ;
			String driver = prop.getProperty("driver") ;
			
			// cargar el driver
			
			Class.forName(driver).newInstance() ;
			
			// asignar las propiedades al dada source
			
			OracleDataSource dataSource = new OracleDataSource() ;
			dataSource.setURL(url);
			dataSource.setUser(user);
			dataSource.setPassword(pass);
			
			ds = dataSource ;
		}
		
		// cualquier tipo de excepcion lo coge este catch y lo relanza como ExceptionInInitializerError
		
		catch (Exception ex) {
			throw new ExceptionInInitializerError(ex) ;
		}
		
		
	}
	
	public static void main ( String[] args) throws SQLException{
		
		Savepoint savepoint1 = null ;
		Connection conexion = null ;
		
		try {
			conexion = getConexion();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} // como quiero tener acceso a la conexion en la excepcion, debe abrir la conexion dentro del try y asegurarme de que luego la cierro...p.e. en el finally
		
//		try {
//			
//			// por defecto las conecsiones de SQL tiene el autocommit a tru
//
//			conexion.setAutoCommit(false);
//			
//			Statement comando = conexion.createStatement() ;
//			comando.executeUpdate("INSERT INTO CLIENTE VALUES(5,'Cliente 5')") ;
//			
//			savepoint1 = conexion.setSavepoint() ;
//			
//			// como el pedido 5 ya existe, va a saltar la pk y por tanto una excepcion
//			PreparedStatement comando2 = conexion.prepareStatement("INSERT INTO PEDIDO VALUES (5,?,'Pedido 5', 5)") ; 
//			comando2.setDate(1, new java.sql.Date( new java.util.Date().getTime() ) );
//			comando2.executeUpdate() ;
//			
//			conexion.commit(); 
//			
//			
//		}
//		catch ( SQLException e ) {
//			
//			if ( ( conexion != null ) && ( savepoint1 != null ) ){
//				try {
//					conexion.rollback(savepoint1);
//				
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			
//		}
//		finally {
//			if (conexion != null){
//				try {
//					conexion.close();
//				
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		Thread hilo1 = new Thread( () -> {
			try {
				Connection con = getConexion() ;
				
				con.setAutoCommit(false);
				
				Statement comando = con.createStatement() ;
				comando.executeUpdate("INSERT INTO CLIENTE VALUES(10,'Cliente 10')") ;
				
				// bloqueamos una fila de la bbdd haciendo un update

				comando.executeUpdate("UPDATE CLIENTE SET nombre = 'Cliente 10 modificado' WHERE id= 10") ;
				
				Thread.sleep(2000); // espero un poco para dejar que otro hilo bloquee tambien la base de datos una fila distinta
				
				
				// otra transaccion
				
				comando.executeUpdate("UPDATE CLIENTE SET nombre = 'Cliente 11 modificado' WHERE id = 11") ;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}) ;

		
		Thread hilo2 = new Thread( () -> {
			try {
				Connection con = getConexion() ;
				
				con.setAutoCommit(false);
				
				Statement comando = con.createStatement() ;
				comando.executeUpdate("INSERT INTO CLIENTE VALUES(11,'Cliente 11')") ;
				
				// bloqueamos una fila de la bbdd haciendo un update

				comando.executeUpdate("UPDATE CLIENTE SET nombre = 'Cliente 11 modificado' WHERE id= 11") ;
				
				Thread.sleep(2000); // espero un poco para dejar que otro hilo bloquee tambien la base de datos una fila distinta
				
				
				// otra transaccion
				
				comando.executeUpdate("UPDATE CLIENTE SET nombre = 'Cliente 10 modificado' WHERE id = 10") ;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}) ;
		
		
		hilo1.start();
		hilo2.start();
		
	}
	
	private static Connection getConexion () throws SQLException{
		return ds.getConnection() ;
	}

}
