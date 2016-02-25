package com.wpsnetwork.dao;

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

public class RepositorioPedidosDao implements PedidoDao{
	private String consultaPedido = "SELECT ID, FECHA, INFO, IDCLIENTE FROM PEDIDO WHERE ID = ?";
	private String updatePedido = "UPDATE PEDIDO SET FECHA = ?, INFO = ?, IDCLIENTE = ? WHERE ID = ?";
	private String deletePedido = "DELETE PEDIDO WHERE ID = ?";
	private String insertPedido = "INSERT INTO PEDIDO(ID, FECHA, INFO, IDCLIENTE) VALUES(?,?,?,?)";
	private String consultaPedidos = "SELECT ID, FECHA, INFO, IDCLIENTE FROM PEDIDO";

	@Override
	public Pedido get(int clave) throws SQLException {
		Pedido pedido = null;
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoGet = conexion.prepareStatement(consultaPedido);
			comandoGet.setInt(1, clave);
			ResultSet resultado = comandoGet.executeQuery();
			while(resultado.next()){
				pedido = new Pedido( resultado.getInt("ID"), 
						               LocalDateTime.ofInstant(
						            		   Instant.ofEpochMilli(
						            				   		resultado.getDate("FECHA")
						            				   				 .getTime()),
						            		   ZoneId.of("UTC")),
						               resultado.getString("INFO"),
						               resultado.getInt("IDCLIENTE"));
			}
		}
		return pedido;
	}

	@Override
	public void update(Pedido elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoUpdate = conexion.prepareStatement(updatePedido);
			comandoUpdate.setDate(1, new Date(elemento.getFecha()
														.toInstant(ZoneOffset.UTC)
														.toEpochMilli()
											));
			comandoUpdate.setString(2, elemento.getInfo());
			comandoUpdate.setInt(3, elemento.getCliente());
			comandoUpdate.setInt(4, elemento.getId());
			comandoUpdate.executeUpdate();
		}
	}

	@Override
	public void remove(Pedido elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoDelete = conexion.prepareStatement(deletePedido);
			comandoDelete.setInt(1, elemento.getId());
			comandoDelete.executeUpdate();
		}
	}

	@Override
	public void insert(Pedido elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoInsert = conexion.prepareStatement(insertPedido);
			comandoInsert.setInt(1, elemento.getId());
			comandoInsert.setDate(2, new Date(elemento.getFecha()
														.toInstant(ZoneOffset.UTC)
														.toEpochMilli()
											));
			comandoInsert.setString(3, elemento.getInfo());
			comandoInsert.setInt(4, elemento.getCliente());
			comandoInsert.executeUpdate();
		}
	}

	@Override
	public List<Pedido> getAll() throws SQLException {
		List<Pedido> pedidos = new ArrayList<>();
		try(Connection conexion = Util.getConexion()){
			Statement comando = conexion.createStatement();
			ResultSet resultado = comando.executeQuery(consultaPedidos);
			while(resultado.next()){
				Pedido pedido = new Pedido( resultado.getInt("ID"), 
							               LocalDateTime.ofInstant(
							            		   Instant.ofEpochMilli(
							            				   		resultado.getDate("FECHA")
							            				   				 .getTime()),
							            		   ZoneId.of("UTC")),
							               resultado.getString("INFO"),
							               resultado.getInt("IDCLIENTE"));
				pedidos.add(pedido);
			}
		}
		return pedidos;
	}

}
