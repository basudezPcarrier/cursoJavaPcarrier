package com.wpsnetwork.dao.repositorio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Pedido;
import com.wpsnetwork.dao.interfaces.PedidoDao;
import com.wpsnetwork.dao.util.Util;

public class RepositorioPedidoDao implements PedidoDao {

	// variables para las distincta instrucciones
	
	private String consultaPedido = "SELECT ID, INFO , FECHA , IDCLIENTE FROM PEDIDO WHERE ID = ?" ;
	private String updatePedido = "UPDATE PEDIDO SET FECHA = ? , INFO = ? , IDCLIENTE = ? WHERE ID = ?" ;
	private String removePedido = "DELETE PEDIDO WHERE ID = ?" ;
	private String insertPedido = "INSERT PEDIDO ( ID , FECHA , INFO , IDCLIENTE ) VALUES (?, ?, ?, ?) " ;
	private String consultaPedidos = "SELECT ID , FECHA , INFO , IDCLIENTE FROM PEDIDO " ;
	
	
	
	@Override
	public Pedido get(int clave) throws SQLException {
		
		Pedido pedido= null ;
		
		try( Connection conexion = Util.getConexion() ){
			// preparar el statement
			PreparedStatement comandoGet = conexion.prepareStatement( consultaPedido ) ;
			
			// definir el parametro de entrada
			comandoGet.setInt(1, clave);
			
			// ejecutar el comando y obtener un result set 
			ResultSet  resultado = comandoGet.executeQuery() ;
			
			// recorrer el resultado para obtener la respuesta (es un poco raro porque si tuvieramos mas de uno )
			while( resultado.next() ){
				pedido = new Pedido( 
						resultado.getInt("ID"),
						
						LocalDateTime.ofInstant(
								Instant.ofEpochMilli(
										resultado.getDate("FECHA").getTime()), 
								ZoneId.of("UTC")) , 
						
						resultado.getString("INFO"), 
						resultado.getInt("IDCLIENTE") 
						) ;
			}
			
		}
		
		return pedido ;
	}

	@Override
	public void update(Pedido elemento) throws SQLException {


		try( Connection conexion = Util.getConexion() ){
	
			// preparar el statement
			PreparedStatement comandoUpd = conexion.prepareStatement( updatePedido ) ;
			
			// definir los parametros
			comandoUpd.setDate(1, new Date( elemento.getFecha().toInstant(ZoneOffset.UTC).toEpochMilli() ) );
			comandoUpd.setString(2, elemento.getInfo() );
			comandoUpd.setInt(3, elemento.getCliente() );
			comandoUpd.setInt(4, elemento.getId() );
			
			// ejecutar el comando  
			comandoUpd.executeUpdate() ;

		}
	}

	@Override
	public void remove(Pedido elemento) throws SQLException {

		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement
			PreparedStatement comandoDel = conexion.prepareStatement( removePedido ) ;
			
			// definir los parametros
			comandoDel.setInt(1, elemento.getId() );
			
			// ejecutar el comando  
			comandoDel.executeUpdate() ;

		}

	}

	@Override
	public void insert(Pedido elemento) throws SQLException {

		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement
			PreparedStatement comandoIns = conexion.prepareStatement( insertPedido ) ;
			
			// definir los parametros
			comandoIns.setInt(1, elemento.getId() );
			comandoIns.setDate(2, new Date( elemento.getFecha().toInstant(ZoneOffset.UTC).toEpochMilli() ) );
			comandoIns.setString(3, elemento.getInfo() );
			comandoIns.setInt(4, elemento.getCliente() );
			
			
			// ejecutar el comando  
			comandoIns.executeUpdate() ;

		}

	}

	@Override
	public List<Pedido> getAll() throws SQLException {

		List<Pedido> listaPedidos = new ArrayList<>() ;
		
		try( Connection conexion = Util.getConexion() ){
			
			// preparar el statement (no hace falta hacer el prepared statement porque no tengo variables...)
			Statement comandoGet = conexion.createStatement() ;
			
			// ejecutar el comando y obtener un result set 
			ResultSet  resultado = comandoGet.executeQuery(consultaPedidos) ;
			
			// recorrer el resultado para obtener la respuesta (es un poco raro porque si tuvieramos mas de uno )
			while( resultado.next() ){
				Pedido pedido = new Pedido( 
						resultado.getInt("ID"),
						
						LocalDateTime.ofInstant(
								Instant.ofEpochMilli(
										resultado.getDate("FECHA").getTime()), 
								ZoneId.of("UTC")) , 
						
						resultado.getString("INFO"), 
						resultado.getInt("IDCLIENTE") 
						) ;
				listaPedidos.add( pedido ) ;
			}

		}
		
		return listaPedidos ;			
		
	}

}
