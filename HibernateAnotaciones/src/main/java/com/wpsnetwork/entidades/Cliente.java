package com.wpsnetwork.entidades;
// Generated 07-mar-2016 12:11:42 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

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


/**
 * Cliente generated by hbm2java
 */

// ofrece importar de java persistence qy de hibernate. Utilizaremos java persistence porque en general
// salvo alguna cosa son equivalentes
@Entity
@Table (name="CLIENTE")

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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator = "cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="CLIENTE_ID_SEQ", allocationSize=1 ) // no nos esta pillando la secuencia bien y marc no sabe donde puede estar fallando
	@Column(name="ID") 
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="NOMBRE") 
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY
			 , mappedBy="cliente"
			 , cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}
			 )
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
