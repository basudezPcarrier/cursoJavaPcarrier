package com.wpsnetwork.entidades;
// Generated 07-mar-2016 12:11:42 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente implements java.io.Serializable {

	private int id;
	private String nombre;
	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Cliente() {
	}

	public Cliente(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Cliente(int id, String nombre, Set<Pedido> pedidos) {
		this.id = id;
		this.nombre = nombre;
		this.pedidos = pedidos;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (pedidos != null ? "pedidos=" + pedidos : "") + "]";
	}

	
	
}