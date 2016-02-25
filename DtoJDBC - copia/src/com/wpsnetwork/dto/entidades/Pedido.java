package com.wpsnetwork.dto.entidades;

import java.time.LocalDateTime;

public class Pedido {
	
	private com.wpsnetwork.dao.entidades.Pedido pedidoDao ;
	private Cliente clienteDto ;
	
	public void pedido(){
		
	}
	
	public Pedido ( int id , LocalDateTime fecha , String info , Cliente cliente ) {
		pedidoDao = new com.wpsnetwork.dao.entidades.Pedido( id , fecha , info , cliente.getId() ) ;
		this.clienteDto = cliente ;
	}
	
		
	
	// OJO!! para los get y los set va a utilizar los clienteDto
	
	
	public Cliente getCliente(){
		return clienteDto ;
	}
	
	public void setCliente ( Cliente cliente ) {
		this.clienteDto = cliente ;
		pedidoDao.setCliente( cliente.getId() ) ;
	}
	
	public List<Pedido> buscarPedidos(){
		
		dao<com.wpnetwork.dao.entidades.Pedido> dao = new RepositorioPedidosDao();
		List<com.wpnetwork.dao.entidades.Pedido> pedidosDao = dao.getAll();
		List<Pedido>  = listaDt
 		
	}
	
}
