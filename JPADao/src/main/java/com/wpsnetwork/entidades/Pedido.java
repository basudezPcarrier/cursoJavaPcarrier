package com.wpsnetwork.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PEDIDO")

public class Pedido implements Serializable{
	
	@Id
	@Column(name="ID")
	private int id ;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA",nullable=false)
	private Date fecha ; 		// estamos importando el java.util no el java.sql

	@Column(name="INFO",nullable=false,length=100)
	private String info ;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="IDCLIENTE")
	private Cliente idCliente ;
	
	private static final long serialVersionUID = 4302873756894434700L;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int id, Date fecha, String info, Cliente idCliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.info = info;
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	// estamos quitando el idpedidos para que no vaya a pintar el cliente para evitar recursividad
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", " + (fecha != null ? "fecha=" + fecha + ", " : "")
				+ (info != null ? "info=" + info : "") + "]";
	}
	
	

}
