package com.wpsnetwork.dto.entidades;

import java.util.Date;
import java.util.List;

public class Prestamo {

	private com.wpsnetwork.dao.entidades.Prestamo Prestamo ;

	private List<com.wpsnetwork.dto.entidades.Prestamo> prestamos;

	public Prestamo(com.wpsnetwork.dao.entidades.Prestamo prestamo, List<Prestamo> prestamos) {
		super();
		Prestamo = prestamo;
		this.prestamos = prestamos;
	}

	public Prestamo() {
		super();
	}

	public com.wpsnetwork.dao.entidades.Prestamo getPrestamo() {
		return Prestamo;
	}

	public List<com.wpsnetwork.dto.entidades.Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamo(com.wpsnetwork.dao.entidades.Prestamo prestamo) {
		Prestamo = prestamo;
	}

	public void setPrestamos(List<com.wpsnetwork.dto.entidades.Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Prestamo == null) ? 0 : Prestamo.hashCode());
		result = prime * result + ((prestamos == null) ? 0 : prestamos.hashCode());
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
		if (Prestamo == null) {
			if (other.Prestamo != null)
				return false;
		} else if (!Prestamo.equals(other.Prestamo))
			return false;
		if (prestamos == null) {
			if (other.prestamos != null)
				return false;
		} else if (!prestamos.equals(other.prestamos))
			return false;
		return true;
	}


}
