package com.wpsnetwork.consola;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
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

		
// no me funciona... :(	parece que no trinca bien el class path	
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
		
		// aqui se puede poner un rowSet.setFilter para filtrar la consulta (hacer un where basicamente)
		
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
		
		/////////////////////////////
		/////////////////////////////
		/////////////////////////////
		/////////////////////////////
		/////////////////////////////
		
		// hacer join de de tablas
		
		/* Supongamos la query:
		 * 
		 * SELECT p.id , pfecha ,p.info , p.idcliente , c.id , c.nombre 
		 *   FROM pedidos p JOIN clientes c ON p.idcliente = c.id
		 *    
		 * */
		
		
		
		JoinRowSet setPedidosClientes = fabricador.createJoinRowSet() ;
		
		// hacemos dos rowsets, uno por cada tabla
		JdbcRowSet rowsetClientes = fabricador.createJdbcRowSet() ;
		
		rowsetClientes.setUrl(prop.getProperty("url")); 
		rowsetClientes.setUsername( prop.getProperty("user")); 
		rowsetClientes.setPassword(prop.getProperty("password")); 
		
		rowset.setCommand("SELECT ID codcliente , NOMBRE FROM CLIENTE");
		

		JdbcRowSet rowsetPedidos = fabricador.createJdbcRowSet() ;
		
		rowsetPedidos.setUrl(prop.getProperty("url")); 
		rowsetPedidos.setUsername( prop.getProperty("user")); 
		rowsetPedidos.setPassword(prop.getProperty("password")); 
		
		rowsetPedidos.setCommand("SELECT id codpedido , fecha , info , idcliente FROM PEDIDOS ");
		
		// añadimos los rowsets al joinrow indicando el campo por el que se hace join
		
		setPedidosClientes.addRowSet( rowsetClientes , "CODCLIENTE") ;
		setPedidosClientes.addRowSet( rowsetPedidos , "CODPEDIDO") ;
		
		// necesito saber el nº de columnas para poder iterar
		
		ResultSetMetaData meta = setPedidosClientes.getMetaData() ;
		int numCols = meta.getColumnCount() ; // obtener el nº de columnas del resulset de setPedidosClientes
		
		setPedidosClientes.beforeFirst(); ;
		
		while ( setPedidosClientes.next() ) {
			for ( int i = 0 ; i <= numCols ; i++ ) {
				System.out.printf("%s = %s\n", meta.getColumnLabel( i ) , setPedidosClientes.getObject(i).toString() ); // tenemos que pasar de Object a string... por eso el toString
			}
		}
		
		//  cerramos los rowsets
		
		rowsetClientes.close();
		rowsetPedidos.close();
		setPedidosClientes.close();
		
		

		
	}

}
