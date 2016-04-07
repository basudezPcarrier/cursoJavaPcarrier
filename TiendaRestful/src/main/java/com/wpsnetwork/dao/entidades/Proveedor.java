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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wpsnetwork.dao.entidades.interfaces.Identificable;

@Entity
@Table(name = "PROVEEDORES_TIENDA")
public class Proveedor implements java.io.Serializable, Identificable {

	private static final long serialVersionUID = -8312551576907210987L;
	private BigDecimal id;
	private Direccion direccion;
	private String nombre;
	private List<Producto> productos = new ArrayList<Producto>();

	public Proveedor() {
	}

	public Proveedor(BigDecimal id) {
		this.id = id;
	}

	public Proveedor(BigDecimal id, Direccion direccion, String nombre, List<Producto> productos) {
		this.id = id;
		this.direccion = direccion;
		this.nombre = nombre;
		this.productos = productos;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="proveedor_seq")
	@SequenceGenerator(name = "proveedor_seq", sequenceName = "SEQ_PROVEEDOR_TIENDA", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	@Override
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@OneToOne(	fetch = FetchType.EAGER,
				cascade = {CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="DIRECCION")
	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Column(name = "NOMBRE", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(	mappedBy = "proveedor",
				fetch = FetchType.LAZY, 
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
