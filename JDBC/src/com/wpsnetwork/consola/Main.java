package com.wpsnetwork.consola;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.entidades.Clientes;

public class Main {

	private static final String CADENA_CONEXION = "jdbc:oracle:thin:@localhost:1521:pcarrier" ;
	private static final String USUARIO = "wps" ;
	private static final String PASS = "usuario" ;
	
	public static void main(String[] args) throws SQLException {
		
		/* Pasos:
		 * 		1. añadir el driver de oracle (o de la bbdd que sea) al proecto (en nuesrto caso ha suido el "ojdbc 7.jar"
		 * 		2. registrar el driver en la MV de java por código: hay varias alternativas
		 * 				a) DriverManager.registerDriver

							//		try {
							//			DriverManager.registerDriver( new oracle.jdbc.OracleDriver() ) ;
							//		} catch (SQLException e) {
							//			// TODO Auto-generated catch block
							//			e.printStackTrace();
							//		}
	 						
 						b) con el Class.forName

							//		try {
							//			Class.forName("oracle.jdbc.OracleDriver").newInstance() ;
							//		} catch (InstantiationException e) {
							//			// TODO Auto-generated catch block
							//			e.printStackTrace();
							//		} catch (IllegalAccessException e) {
							//			// TODO Auto-generated catch block
							//			e.printStackTrace();
							//		} catch (ClassNotFoundException e) {
							//			// TODO Auto-generated catch block
							//			e.printStackTrace();
							//		} 

		 * 		3. abrir la conexion con la bbdd
		 * 		4. realizar las operaciones en la bbdd
		 * 
		 * 
		 * 
		 * 
		 * */
	
		// registrar el driver en la MV de java por código
		
		DriverManager.registerDriver( new oracle.jdbc.OracleDriver() ) ;
		
		//  abrir la conexion con la bbdd
		
		try ( Connection conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, PASS)){
			// hemos hecho un try con recursos y por tanto, la conexcion se cerrará automaticamente
			
			
			// crear un statement que sera lo que utilicemos para enviar comandos a la bbdd
			
			Statement comando = conexion.createStatement() ;
			
			// los Statement tiene 
			// 		* executeQuery 	-> queries
			// 		* executeUpdate -> DDL y DML
			
			
//			comentamos despues de crearla la primera vez para que no nos pete
//			String sql = " CREATE TABLE CLIENTE ( ID NUMBER(5) PRIMARY KEY, NOMBRE VARCHAR2(100) NOT NULL)" ;
//			
//			comando.executeUpdate( sql ) ; 
//			
//			comando.executeUpdate("INSERT INTO CLIENTE ( ID , NOMBRE ) VALUES (1, 'Cliente 1' )") ; 
//			comando.executeUpdate("INSERT INTO CLIENTE ( ID , NOMBRE ) VALUES (2, 'Cliente 2' )") ; 
//			comando.executeUpdate("INSERT INTO CLIENTE ( ID , NOMBRE ) VALUES (3, 'Cliente 3' )") ; 
//			comando.executeUpdate("INSERT INTO CLIENTE ( ID , NOMBRE ) VALUES (4, 'Cliente 4' )") ; 

			
//			comentamos despues de crearla la primera vez para que no nos pete
//			// vamos a crear otra tabla...
//			
//			String sql = " CREATE TABLE PEDIDO ( " + 
//			                                  " ID NUMBER(5) PRIMARY KEY " +
//			                                  ", FECHA DATE NOT NULL " + 
//					                          ", INFO VARCHAR2(100) NOT NULL " + 
//			                                  ", IDCLIENTE NUMBER(5) REFERENCES CLIENTE(ID) NOT NULL )" ;
//			
//			comando.executeUpdate( sql ) ; 
//			
//			comando.executeUpdate("INSERT INTO PEDIDO ( ID , FECHA, INFO, IDCLIENTE ) VALUES (1, '1/5/2013', 'Pedido 1' , 1 )") ; 
//			comando.executeUpdate("INSERT INTO PEDIDO ( ID , FECHA, INFO, IDCLIENTE ) VALUES (2, '2/5/2013', 'Pedido 2' , 2 )") ; 

			
			// ejemplo de hacer una query
			
			String sql = " SELECT ID alias_id, NOMBRE FROM CLIENTE" ;
			
			ResultSet resultado = comando.executeQuery(sql) ;

			// recorrer el conjunto de resultados (creamos una lista de Clientes y vamos a meter ahi directamente el restultado de la query)
			
			List<Clientes> clientes = new ArrayList<>();
			
			while ( resultado.next()){ // resultado.next() indica si existe el siguiente elemento o no
				int id = resultado.getInt("alias_id") ;
				String nombre = resultado.getString("nombre") ;
				
				clientes.add( new Clientes(id, nombre) ) ;

			}
			
			System.out.println(clientes);
			

			
			
			// ejemplo de hacer una query
			
			sql = " SELECT ID , INFO FROM PEDIDO" ;
			resultado = comando.executeQuery(sql) ;

			// recorrer el conjunto de resultados (creamos una lista de Clientes y vamos a meter ahi directamente el restultado de la query)
			
			while ( resultado.next()){ // resultado.next() indica si existe el siguiente elemento o no
				int id = resultado.getInt("id") ;
				String nombre = resultado.getString("info") ;
				
				System.out.println("Resultado Pedido: " + id + " " + nombre );

			}
			
			// evitar sql injection --> usar los PreparedStatement
			
			int codigo = 4;
			sql = "SELECT id , nombre FROM CLIENTE WHERE ID = ?" ;
			
			PreparedStatement ps = conexion.prepareStatement(sql) ;
			
			// al compilar busca los comodines ?....hay que decirles los valores que queremos meter por cada uno
			
			ps.setInt(1, codigo); // en el primer comodin ?, lo sustituye por la variable codigo
						
			resultado = ps.executeQuery(sql) ;
			
			while ( resultado.next()){ // resultado.next() indica si existe el siguiente elemento o no
				int id = resultado.getInt("id") ;
				String nombre = resultado.getString("nombre") ;
				
				System.out.println( new Clientes(id, nombre) );

			}
			
			
			
			
			
			// automaticamente cierra la conexion de la bbdd ->> OJO!! recordar que hace un autocommit
			
		}
		catch (SQLException e){
			System.out.println("Mensaje DDBB: " + e.getMessage());
			System.out.println("Codigo de error de la BBDD: " + e.getErrorCode());
		}

	}

}
