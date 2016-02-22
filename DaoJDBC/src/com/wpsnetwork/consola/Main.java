package com.wpsnetwork.consola;

import com.wpsnetwork.dao.repositorio.RepositorioClientesDao;
import com.wpsnetwork.dao.repositorio.RepositorioPedidoDao;

import java.sql.SQLException;
import java.util.List;

import com.wpsnetwork.dao.entidades.Cliente;
import com.wpsnetwork.dao.entidades.Pedido;
import com.wpsnetwork.dao.interfaces.Dao;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Dao<Cliente> repositorioCliente = new RepositorioClientesDao() ;
		
		List<Cliente> clientes = repositorioCliente.getAll() ;
		
		System.out.println(clientes);

		// 
		Dao<Pedido> repositorioPedido = new RepositorioPedidoDao() ;
		
		List<Pedido> pedidos = repositorioPedido.getAll() ;
		
		System.out.println(pedidos);


	}

}
