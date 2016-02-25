package com.wpsnetwork.dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.wpsnetwork.dto.entidades.Pedido;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.repositorio.RepositorioClientesDao;
import com.wpsnetwork.dao.repositorio.RepositorioPedidosDao;
import com.wpsnetwork.dto.entidades.Cliente;

public class RepositorioClientesDto implements Dao<Cliente>{
	private RepositorioClientesDao dao = new RepositorioClientesDao();
	
	@Override
	public Cliente get(int id) throws SQLException {
		com.wpsnetwork.dao.entidades.Cliente clienteDao = dao.get(id);
		Cliente clienteDto = convertirDaoADto(clienteDao);
		return clienteDto;
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		List<com.wpsnetwork.dao.entidades.Cliente> listaDao = dao.getAll();
		List<Cliente> listaDto = new ArrayList<>();
		for(com.wpsnetwork.dao.entidades.Cliente c : listaDao)
			listaDto.add(convertirDaoADto(c));
		return listaDto;
	}

	@Override
	public void insert(Cliente cliente) throws SQLException {
		dao.insert(convertirDtoADao(cliente));
		
		Dao<com.wpsnetwork.dao.entidades.Pedido> pedidosDao = new RepositorioPedidosDao();
		for(Pedido p: cliente.getPedidos())
			pedidosDao.insert(
					new com.wpsnetwork.dao.entidades.Pedido(
							p.getId(), 
							p.getFecha(), 
							p.getInfo(), 
							p.getCliente().getId()
					));
			
	}

	@Override
	public void remove(Cliente cliente) throws SQLException {
		Dao<com.wpsnetwork.dao.entidades.Pedido> pedidosDao = new RepositorioPedidosDao();
		
		for(Pedido p: cliente.getPedidos())
			pedidosDao.remove(
					new com.wpsnetwork.dao.entidades.Pedido(
							p.getId(), 
							p.getFecha(), 
							p.getInfo(), 
							p.getCliente().getId()
					));
		
		dao.remove(convertirDtoADao(cliente));
	}

	@Override
	public void update(Cliente cliente) throws SQLException {
		dao.update(convertirDtoADao(cliente));
		RepositorioPedidosDao pedidosDao = new RepositorioPedidosDao();
		
		for(Pedido pedido : cliente.getPedidos()){
			com.wpsnetwork.dao.entidades.Pedido pedidoDao = pedidosDao.get(pedido.getId());
			
			if(pedidoDao == null)
				pedidosDao.insert(RepositorioPedidosDto.convertirDtoADao(pedido));
			else
				pedidosDao.update(RepositorioPedidosDto.convertirDtoADao(pedido));
		}
	}
	
	public static Cliente convertirDaoADto(com.wpsnetwork.dao.entidades.Cliente clienteDao) {
		Cliente cDto = null;
		if(clienteDao!=null)
			cDto = new Cliente(clienteDao.getId(), 
								clienteDao.getNombre(), 
								null);
		return cDto;
	}

	public static com.wpsnetwork.dao.entidades.Cliente convertirDtoADao(Cliente cliente) {
		return new com.wpsnetwork.dao.entidades.Cliente(cliente.getId(), 
														cliente.getNombre());
	}
}
