package com.wpsnetwork.dao.entidades;

import java.time.LocalDateTime;

public class Pedido {
	private int id;
	private LocalDateTime fecha;
	private String info;
	private int cliente;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int id, LocalDateTime fecha, String info, int cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.info = info;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", info=" + info + ", cliente=" + cliente + "]";
	}

}
