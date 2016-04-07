package com.wpsnetwork.dao.entidades;
// Generated 05-mar-2016 11:16:42 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTES_TIENDA")
public class Cliente implements java.io.Serializable {

	private static final long serialVersionUID = -502630329335668512L;
	private BigDecimal id;
	private String nombre;
	private String apellidos;
	private List<Pedido> pedidos = new ArrayList<Pedido>();

	public Cliente() {
	}

	public Cliente(BigDecimal id) {
		this.id = id;
	}

	public Cliente(BigDecimal id, String nombre, String apellidos, List<Pedido> pedidos) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.pedidos = pedidos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(name = "cliente_seq", sequenceName = "SEQ_CLIENTE_TIENDA",allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDOS", length = 50)
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@OneToMany(	mappedBy = "cliente",
				fetch = FetchType.LAZY,
				cascade={CascadeType.PERSIST, CascadeType.MERGE}
				)
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
