package com.wpsnetwork.dao.entidades;

import java.util.Date;

public class Persona {
	
	private int id ;
	private String nombre ;
	private String dni ;
	private Date fechaNacimiento ;
	private String direccion ;
	private int telefono ;
	private String provincia ;
	private String pais ;
	private String codigoPostal ;
	public Persona() {
		super();
	}
	public Persona(int id, String nombre, String dni, Date fechaNacimiento, String direccion, int telefono,
			String provincia, String pais, String codigoPostal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.provincia = provincia;
		this.pais = pais;
		this.codigoPostal = codigoPostal;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getProvincia() {
		return provincia;
	}
	public String getPais() {
		return pais;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", provincia=" + provincia + ", pais=" + pais
				+ ", codigoPostal=" + codigoPostal + "]";
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
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
