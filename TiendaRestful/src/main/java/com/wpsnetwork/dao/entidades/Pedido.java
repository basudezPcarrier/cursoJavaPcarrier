package com.wpsnetwork.dao.entidades;
// Generated 05-mar-2016 11:16:42 by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wpsnetwork.dao.entidades.interfaces.Identificable;
import com.wpsnetwork.servicios.conversores.LocalDateTimeAdapter;

@Entity
@Table(name = "PEDIDOS_TIENDA")
public class Pedido implements Serializable, Identificable {

	private static final long serialVersionUID = -6714061608865940577L;
	private BigDecimal id;
	private Cliente cliente;
	private LocalDateTime fecha;
	private List<ProductoPedido> productosPedido = new ArrayList<ProductoPedido>();

	public Pedido() {
	}

	public Pedido(BigDecimal id) {
		this.id = id;
	}

	public Pedido(BigDecimal id, Cliente cliente, LocalDateTime fecha, List<ProductoPedido> productosPedido) {
		this.id = id;
		this.cliente = cliente;
		this.fecha = fecha;
		this.productosPedido = productosPedido;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedido_seq")
	@SequenceGenerator(name = "pedido_seq", sequenceName = "SEQ_PEDIDO_TIENDA", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@Override
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(	fetch = FetchType.EAGER,
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "CLIENTE")
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	@Column(name = "FECHA")
	public LocalDateTime getFecha() {
		return this.fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@JsonIgnore
	@OneToMany(	mappedBy = "pedido", 
				fetch = FetchType.LAZY,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<ProductoPedido> getProductosPedido() {
		return this.productosPedido;
	}

	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
	}

}
