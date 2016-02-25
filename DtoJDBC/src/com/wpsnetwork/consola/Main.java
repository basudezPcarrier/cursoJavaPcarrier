package com.wpsnetwork.consola;

import java.sql.SQLException;
import java.util.List;

import com.wpsnetwork.dao.RepositorioClientesDao;
import com.wpsnetwork.dao.RepositorioPedidosDao;
import com.wpsnetwork.dao.entidades.Cliente;
import com.wpsnetwork.dao.entidades.Pedido;
import com.wpsnetwork.dao.interfaces.Dao;

public class Main {

	public static void main(String[] args) throws SQLException  {
		Dao<Cliente> repositorioCliente = new RepositorioClientesDao();
		
		List<Cliente> clientes = repositorioCliente.getAll();
		System.out.println(clientes);
		
		
		Dao<Pedido> repositorioPedidos = new RepositorioPedidosDao();
		
		List<Pedido> pedidos = repositorioPedidos.getAll();
		System.out.println(pedidos);

	}

}
