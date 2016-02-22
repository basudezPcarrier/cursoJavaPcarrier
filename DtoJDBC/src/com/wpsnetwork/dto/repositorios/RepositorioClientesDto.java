package com.wpsnetwork.dto.repositorios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Cliente;
import com.wpsnetwork.dto.entidades.Pedido;
import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dao.repositorio.RepositorioClientesDao;

// queremos que tenga la misma funcionalidad del dao, asi que implementamos la interfaz (Dao<cliente del DTO>)
public class RepositorioClientesDto implements Dao<Clientes>{

	
	private  RepositorioClientesDao dao = new RepositorioClientesDao();
	
	@Override
	public Clientes get(int arg0) throws SQLException {
		
		com.wpsnetwork.dao.entidades.Cliente clienteDao = dao.get( arg0) ;
		
		//convertir de Dao a Dto
		
		Cliente clienteDto = convertirDaoADto( clienteDao ) ;
		
		return clienteDto ;
		
	}
	
	// convertir de Dao a DTO (lo hace estatico como poder utilziarlo en otros sitrios sin necesitdad de un objeto)
	
	private static Cliente convertirDaoADto( com.wpsnetwork.dao.entidades.Cliente clienteDao) {
		Cliente cDto = null ;
		
		if (clienteDao != null)
			cDto = new Cliente( clienteDao.getId(), 
					            clienteDao.getNombre() , 
					            null
					          ) ;
		
		return cDto ;
	}

	@Override
	public List<Clientes> getAll() throws SQLException {
		
		List<com.wpsnetwork.dao.entidades.Cliente> listaDao = dao.getAll() ;
		
		List<Cliente> listaDto = new ArrayList();
		
		for( com.wpsnetwork.dao.entidades.Cliente c : listaDao ) {
			listaDto.add( convertirDaoADto(c) )
		}
		
		return listaDto ;
	}

	@Override
	public void insert(Clientes cliente ) throws SQLException {
		
		// recibe un dto y hay que convertirlo a Dao para hacer el insert
		
		dao.insert(convertirDtoADao( cliente ) ); 
		
		
		// insertar los pedidos del cliente
		
		Dao<com.wpsnetwork.dao.entidades.Pedido> pedidosDao = new RepositorioPedidosDao();
		
		for ( Pedido p : cliente.getPedidos () ){
			pedidosDao.insert( new com.wpsnetwork.dao.entidades.Pedido(
					p.getId(), 
					p.getFecha(), 
					p.getInfo(), 
					p.getCliente().getId()
					) )  ;
		}
		
	}
	
	// recibe una entidad dto y devuelve una entidad Dao
	private com.wpsnetwork.dao.entidades.Cliente convertirDtoADao (  Cliente cliente ){
		com.wpsnetwork.dao.entidades.Cliente cDao =
				new com.wpsnetwork.dao.entidades.Cliente( cliente.getId(), cliente.getNombre()) ;
		
	}
	
	@Override
	public void remove(Clientes arg0) throws SQLException {
		
		
		// para hacerlo en cascada, eliminamos primero los pedidos y luego los clientes
		
		// eliminar los pedidos
		
		Dao<com.wpsnetwork.dao.entidades.Pedido> pedidosDao = new RepositorioPedidosDao();

		for ( Pedido p : cliente.getPedidos () ){
			pedidosDao.remove( new com.wpsnetwork.dao.entidades.Pedido(
					p.getId(), 
					p.getFecha(), 
					p.getInfo(), 
					p.getCliente().getId()
					) )  ;
		}
		
		
		// eliminar el cliente
		
		dao.remove( convertirDtoADao(arg0));
		
	}

	@Override
	public void update(Clientes arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	
}
