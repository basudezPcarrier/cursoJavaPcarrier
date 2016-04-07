package com.wpsnetwork.dao.entidades;
// Generated 05-mar-2016 11:16:42 by Hibernate Tools 4.0.0

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECCIONES_TIENDA")
public class Direccion implements java.io.Serializable {

	private static final long serialVersionUID = -5062595673355489967L;
	private BigDecimal id;
	private String direccion;
	private String ciudad;
	private String pais;
	private String cp;
	private Proveedor proveedor;

	public Direccion() {
	}

	public Direccion(BigDecimal id) {
		this.id = id;
	}

	public Direccion(BigDecimal id, String direccion, String ciudad, String pais, String cp,
			Proveedor proveedor) {
		this.id = id;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		this.cp = cp;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="direccion_seq")
	@SequenceGenerator(name = "direccion_seq", sequenceName = "SEQ_DIRECCION_TIENDA", allocationSize = 1)
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "DIRECCION", length = 50)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "CIUDAD", length = 30)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "PAIS", length = 30)
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "CP", length = 10)
	public String getCp() {
		return this.cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@OneToOne(	mappedBy="direccion",
				cascade={CascadeType.PERSIST, CascadeType.MERGE})
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
}
