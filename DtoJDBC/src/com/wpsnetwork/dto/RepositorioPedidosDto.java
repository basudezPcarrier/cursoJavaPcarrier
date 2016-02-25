package com.wpsnetwork.dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.repositorio.RepositorioClientesDao;
import com.wpsnetwork.dao.repositorio.RepositorioPedidosDao;
import com.wpsnetwork.dto.entidades.Cliente;
import com.wpsnetwork.dto.entidades.Pedido;

public class RepositorioPedidosDto implements Dao<Pedido> {
	private RepositorioPedidosDao pedidosDao = new RepositorioPedidosDao();
	
	@Override
	public Pedido get(int pedido) throws SQLException {
		com.wpsnetwork.dao.entidades.Pedido pDao = pedidosDao.get(pedido);
		
		return convertirDaoADto(pDao);
	}

	@Override
	public List<Pedido> getAll() throws SQLException {
		List<com.wpsnetwork.dao.entidades.Pedido> listaDao = pedidosDao.getAll();
		List<Pedido> listaDto = new ArrayList<>();
		
		for(com.wpsnetwork.dao.entidades.Pedido pDao : listaDao)
			listaDto.add(convertirDaoADto(pDao));
	
		return listaDto;
	}

	@Override
	public void insert(Pedido pedido) throws SQLException {
		RepositorioClientesDao clientesDao = new RepositorioClientesDao();
		if(clientesDao.get(pedido.getCliente().getId()) == null)
			clientesDao.insert(RepositorioClientesDto.convertirDtoADao(pedido.getCliente()));
		
		pedidosDao.insert(RepositorioPedidosDto.convertirDtoADao(pedido));
	}

	@Override
	public void remove(Pedido pedido) throws SQLException {
		pedidosDao.remove(RepositorioPedidosDto.convertirDtoADao(pedido));
	}

	@Override
	public void update(Pedido pedido) throws SQLException {
		RepositorioClientesDao clientesDao = new RepositorioClientesDao();
		
		if(clientesDao.get(pedido.getCliente().getId()) != null)
			clientesDao.update(RepositorioClientesDto.convertirDtoADao(pedido.getCliente()));
		else
			throw new SQLException("El cliente no existe para el pedido en la base de datos");
		
		pedidosDao.update(convertirDtoADao(pedido));
		
	}

	public static Pedido convertirDaoADto(com.wpsnetwork.dao.entidades.Pedido pedidoDao) throws SQLException{
		Pedido pDto = null;
		
		if(pedidoDao != null)
			pDto = new Pedido(	pedidoDao.getId(), 
								pedidoDao.getFecha(), 
								pedidoDao.getInfo(), 
								buscarClientePedido(pedidoDao.getCliente()));
		
		return pDto;
	}
	
	public static com.wpsnetwork.dao.entidades.Pedido convertirDtoADao(Pedido pedidoDto) throws SQLException{
		com.wpsnetwork.dao.entidades.Pedido pDao = new com.wpsnetwork.dao.entidades.Pedido(	pedidoDto.getId(), 
																							pedidoDto.getFecha(), 
																							pedidoDto.getInfo(), 
																							pedidoDto.getCliente().getId());
		return pDao;
	}

	private static Cliente buscarClientePedido(int cliente) throws SQLException{
		RepositorioClientesDao clientesDao = new RepositorioClientesDao();
		com.wpsnetwork.dao.entidades.Cliente clienteDao = clientesDao.get(cliente);
		
		return RepositorioClientesDto.convertirDaoADto(clienteDao);
	}
}





















