package com.wpsnetwork.dto.entidades;

import java.util.List;

import com.wpsnetwork.dao.* ;

public class Cliente {
	
	private com.wpsnetwork.dao.entidades.Cliente clienteDao ;
	private List<Pedido> pedidos ;
	
	public Cliente(){
		super();
	}
	
	public Cliente ( int id , String nombre, List<Pedido> pedidos ) {
		
		clienteDao = new com.wpsnetwork.dao.entidades.Cliente(id , nombre) ;
		this.pedidos = pedidos;
	}
	
	public int getId () {
		return clienteDao.getId();
	}

	public void setId ( int id ) {
		clienteDao.setId(id);
	}
	
	public void setPedidos ( List<Pedido> listaPedidos ){
		this.pedidos = listaPedidos ;
	}
	
	public List<Pedido> getPedidos (){
		
		return this.pedidos ;
		
		// para hacelro sin el Lazy bastaría con return this.pedidos ; 
		
	}
	
	
	
}
