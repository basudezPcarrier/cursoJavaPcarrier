package com.wpsnetwork.dao.entidades;
// Generated 05-mar-2016 11:16:42 by Hibernate Tools 4.0.0

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS_PEDIDO_TIENDA")
public class ProductoPedido implements java.io.Serializable {

	private static final long serialVersionUID = -4437076823738595890L;
	private Producto producto;
	private Pedido pedido;
	private int lineaPedido;

	public ProductoPedido() {
	}

	public ProductoPedido(Producto producto, Pedido pedido) {
		this.producto = producto;
		this.pedido = pedido;
	}

	public ProductoPedido(Producto producto, Pedido pedido, int lineaPedido) {
		this.producto = producto;
		this.pedido = pedido;
		this.lineaPedido = lineaPedido;
	}
	
	@Id
	@ManyToOne(	fetch = FetchType.LAZY,
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "IDPRODUCTO")
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Id
	@ManyToOne(	fetch = FetchType.LAZY,
	cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "IDPEDIDO")
	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Column(name = "LINEAPEDIDO", precision = 22, scale = 0)
	public int getLineaPedido() {
		return this.lineaPedido;
	}

	public void setLineaPedido(int lineaPedido) {
		this.lineaPedido = lineaPedido;
	}

}
