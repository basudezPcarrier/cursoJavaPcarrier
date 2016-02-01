package com.wpsnetwork.dao.entidades;

import java.util.Date;

public class Prestamo {

	private int id ;
	private Date fechaInicio ;
	private Date fechaFin ;
	private boolean devuelto ;
	private int libro;
	private int persona;
	public Prestamo() {
		super();
	}
	public Prestamo(int id, Date fechaInicio, Date fechaFin, boolean devuelto, int libro, int persona) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
	}
	public int getId() {
		return id;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public int getLibro() {
		return libro;
	}
	public int getPersona() {
		return persona;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	public void setLibro(int libro) {
		this.libro = libro;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", devuelto="
				+ devuelto + ", libro=" + libro + ", persona=" + persona + "]";
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
		Prestamo other = (Prestamo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
