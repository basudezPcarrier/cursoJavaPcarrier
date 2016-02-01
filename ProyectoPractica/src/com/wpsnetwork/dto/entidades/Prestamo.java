package com.wpsnetwork.dto.entidades;

import java.util.Date;
import java.util.List;

public class Prestamo {

	private int id ;
	private Date fechaInicio ;
	private Date fechaFin ;
	private boolean devuelto ;
	private int libro;
	private int persona;

	private List<com.wpsnetwork.dto.entidades.Prestamo> prestamos;

	public Prestamo() {
		super();
	}
	public Prestamo(int id, Date fechaInicio, Date fechaFin, boolean devuelto, int libro, int persona,
			List<Prestamo> prestamos) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.devuelto = devuelto;
		this.libro = libro;
		this.persona = persona;
		this.prestamos = prestamos;
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
	public List<com.wpsnetwork.dto.entidades.Prestamo> getPrestamos() {
		return prestamos;
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
	public void setPrestamos(List<com.wpsnetwork.dto.entidades.Prestamo> prestamos) {
		this.prestamos = prestamos;
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
