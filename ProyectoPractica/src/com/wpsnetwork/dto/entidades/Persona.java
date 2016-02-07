package com.wpsnetwork.dto.entidades;

import java.util.Date;
import java.util.List;

public class Persona {

	private com.wpsnetwork.dao.entidades.Persona Persona ;
	private List<com.wpsnetwork.dto.entidades.Prestamo> prestamos ;
	public Persona(com.wpsnetwork.dao.entidades.Persona persona, List<Prestamo> prestamos) {
		super();
		Persona = persona;
		this.prestamos = prestamos;
	}
	public Persona() {
		super();
	}
	public com.wpsnetwork.dao.entidades.Persona getPersona() {
		return Persona;
	}
	public List<com.wpsnetwork.dto.entidades.Prestamo> getPrestamos() {
		return prestamos;
	}
	public void setPersona(com.wpsnetwork.dao.entidades.Persona persona) {
		Persona = persona;
	}
	public void setPrestamos(List<com.wpsnetwork.dto.entidades.Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Persona == null) ? 0 : Persona.hashCode());
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
		Persona other = (Persona) obj;
		if (Persona == null) {
			if (other.Persona != null)
				return false;
		} else if (!Persona.equals(other.Persona))
			return false;
		if (prestamos == null) {
			if (other.prestamos != null)
				return false;
		} else if (!prestamos.equals(other.prestamos))
			return false;
		return true;
	}

	

}
