package com.wpsnetwork.dto.entidades;

import java.time.LocalDateTime;

public class Pedido {
	private com.wpsnetwork.dao.entidades.Pedido pedidoDao;
	private Cliente clienteDto;
	
	public Pedido(){
		
	}
	
	public Pedido(int id, LocalDateTime fecha, String info, Cliente cliente){
		pedidoDao = new com.wpsnetwork.dao.entidades.Pedido(
							id, fecha, info, cliente!=null?cliente.getId():0);
		this.clienteDto = cliente;
	}
	
	public int getId() {
		return pedidoDao.getId();
	}

	public void setId(int id) {
		pedidoDao.setId(id);
	}

	public LocalDateTime getFecha() {
		return pedidoDao.getFecha();
	}

	public void setFecha(LocalDateTime fecha) {
		pedidoDao.setFecha(fecha);
	}

	public String getInfo() {
		return pedidoDao.getInfo();
	}

	public void setInfo(String info) {
		pedidoDao.setInfo(info);
	}

	public Cliente getCliente() {
		return clienteDto;
	}

	public void setCliente(Cliente cliente) {
		this.clienteDto = cliente;
		pedidoDao.setCliente(cliente.getId());
	}

	@Override
	public String toString() {
		return "Pedido [id=" + pedidoDao.getId() + 
						", fecha=" + pedidoDao.getFecha() + 
						", info=" + pedidoDao.getInfo() + "]";
	}
}
