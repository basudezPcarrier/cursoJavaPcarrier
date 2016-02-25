package com.wpsnetwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Cliente;
import com.wpsnetwork.dao.interfaces.ClienteDao;

public class RepositorioClientesDao implements ClienteDao{
	private String consultaCliente = "SELECT ID, NOMBRE FROM CLIENTE WHERE ID = ?";
	private String updateCliente = "UPDATE CLIENTE SET NOMBRE = ? WHERE ID = ?";
	private String deleteCliente = "DELETE CLIENTE WHERE ID = ?";
	private String insertCliente = "INSERT INTO CLIENTE(ID, NOMBRE) VALUES(?,?)";
	private String consultaClientes = "SELECT ID, NOMBRE FROM CLIENTE";
	
	@Override
	public Cliente get(int clave) throws SQLException {
		Cliente cliente = null;
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoGet = conexion.prepareStatement(consultaCliente);
			comandoGet.setInt(1, clave);
			ResultSet resultado = comandoGet.executeQuery();
			while(resultado.next()){
				cliente = new Cliente( resultado.getInt("ID"), 
						               resultado.getString("NOMBRE"));
			}
		}
		return cliente;
	}

	@Override
	public void update(Cliente elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoUpdate = conexion.prepareStatement(updateCliente);
			comandoUpdate.setString(1, elemento.getNombre());
			comandoUpdate.setInt(2, elemento.getId());
			comandoUpdate.executeUpdate();
		}
	}

	@Override
	public void remove(Cliente elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoDelete = conexion.prepareStatement(deleteCliente);
			comandoDelete.setInt(1, elemento.getId());
			comandoDelete.executeUpdate();
		}
	}

	@Override
	public void insert(Cliente elemento) throws SQLException {
		try(Connection conexion = Util.getConexion()){
			PreparedStatement comandoInsert = conexion.prepareStatement(insertCliente);
			comandoInsert.setInt(1, elemento.getId());
			comandoInsert.setString(2, elemento.getNombre());
			comandoInsert.executeUpdate();
		}
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		try(Connection conexion = Util.getConexion()){
			Statement comando = conexion.createStatement();
			ResultSet resultado = comando.executeQuery(consultaClientes);
			while(resultado.next()){
				Cliente cliente = new Cliente( resultado.getInt("ID"), 
						               resultado.getString("NOMBRE"));
				clientes.add(cliente);
			}
		}
		return clientes;
	}
	
	

}
