package com.wpsnetwork.dao.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.wpsnetwork.dao.entidades.Cliente;
import com.wpsnetwork.dao.interfaces.ClienteDao;
import com.wpsnetwork.dao.util.Util;


public class RepositorioClientesDao implements ClienteDao {
	
	// variables para las distincta instrucciones
	
	private String consultaCliente = "SELECT ID, NOMBRE FROM CLIENTE WHERE ID = ?" ;
	private String updateCliente = "UPDATE CLIENTE SET NOMBRE = ? WHERE ID = ?" ;
	private String removeCliente = "DELETE CLIENTE WHERE ID = ?" ;
	private String insertCliente = "INSERT CLIENTE ( ID , NOMBRE ) VALUES (?, ?) " ;
	private String consultaClientes = "SELECT ID, NOMBRE FROM CLIENTE" ;
	
	
	@Override
	public Cliente get(int clave) throws SQLException {
		
		Cliente cliente = null ;
		
		try( Connection conexion = Util.getConexion() ){
			// preparar el statement
			PreparedStatement comandoGet = conexion.prepareStatement( consultaCliente ) ;
			
			// definir el parametro de entrada
			comandoGet.setInt(1, clave);
			
			// ejecutar el comando y obtener un result set 
			ResultSet  resultado = comandoGet.executeQuery() ;
			
			// recorrer el resultado para obtener la respuesta (es un poco raro porque si tuvieramos mas de uno )
			while( resultado.next() ){
				cliente = new Cliente( resultado.getInt("ID"), resultado.getString("NOMBRE")) ;
			}
			
//			// tambien valdria simplemente
//			resultado.next() ;
//			cliente = new Cliente( resultado.getInt("ID"), resultado.getString("NOMBRE")) ;
			
		}
		
		return cliente ;
		
	}

	@Override
	public void update(Cliente elemento) throws SQLException {

		try( Connection conexion = Util.getConexion() ){
	
			// preparar el statement
			PreparedStatement comandoUpd = conexion.prepareStatement( updateCliente ) ;
			
			// definir los parametros
			comandoUpd.setString(1, elemento.getNombre() );
			comandoUpd.setInt(2, elemento.getId() );
			
			// ejecutar el comando  
			comandoUpd.executeUpdate() ;

		}

	}

	@Override
	public void remove(Cliente elemento) throws SQLException {

		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement
			PreparedStatement comandoDel = conexion.prepareStatement( removeCliente ) ;
			
			// definir los parametros
			comandoDel.setInt(1, elemento.getId() );
			
			// ejecutar el comando  
			comandoDel.executeUpdate() ;

		}		
		
	}

	@Override
	public void insert(Cliente elemento) throws SQLException {

		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement
			PreparedStatement comandoIns = conexion.prepareStatement( insertCliente ) ;
			
			// definir los parametros
			comandoIns.setInt(1, elemento.getId() );
			comandoIns.setString(2 ,  elemento.getNombre());
			
			// ejecutar el comando  
			comandoIns.executeUpdate() ;

		}		

	}

	@Override
	public List<Cliente> getAll() throws SQLException {

		List<Cliente> listaClientes = new ArrayList<>() ;
		
		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement (no hace falta hacer el prepared statement porque no tengo variables...)
			Statement comandoGet = conexion.createStatement() ;
			
			// ejecutar el comando y obtener un result set 
			ResultSet  resultado = comandoGet.executeQuery(consultaClientes) ;
			
			// recorrer el resultado para obtener la respuesta (es un poco raro porque si tuvieramos mas de uno )
			while( resultado.next() ){
				Cliente cliente = new Cliente( resultado.getInt("ID"), resultado.getString("NOMBRE")) ;
				listaClientes.add(cliente ) ;
			}

		}
		
		return listaClientes  ;	
	
	}

}
