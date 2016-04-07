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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wpsnetwork.dao.entidades.interfaces.Identificable;

@Entity
@Table(name = "PRODUCTOS_TIENDA")
public class Producto implements java.io.Serializable, Identificable {

	private static final long serialVersionUID = -5603671085010910446L;
	private BigDecimal id;
	private Proveedor proveedor;
	private String nombre;
	private double precio;
	private String moneda;
	private List<ProductoPedido> productosPedido = new ArrayList<ProductoPedido>();

	public Producto() {
	}

	public Producto(BigDecimal id) {
		this.id = id;
	}

	public Producto(BigDecimal id, Proveedor proveedor, String nombre, double precio, String moneda,
			List<ProductoPedido> productosPedido) {
		this.id = id;
		this.proveedor = proveedor;
		this.nombre = nombre;
		this.precio = precio;
		this.moneda = moneda;
		this.productosPedido = productosPedido;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="producto_seq")
	@SequenceGenerator(name = "producto_seq", sequenceName = "SEQ_PRODUCTO_TIENDA", allocationSize = 1)
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
	@JoinColumn(name = "PROVEEDOR")
	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedores) {
		this.proveedor = proveedores;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRECIO", precision = 5)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "MONEDA", length = 3)
	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@JsonIgnore
	@OneToMany(	mappedBy = "producto", 
			fetch = FetchType.EAGER,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<ProductoPedido> getProductosPedido() {
		return this.productosPedido;
	}

	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
	}

}
