package com.wpsnetwork.dto.entidades;

import java.util.List;

public class CategoriaLibro {

	private int id;
	private String nombre ;
	private List<com.wpsnetwork.dto.entidades.Libro> libros;

	public CategoriaLibro() {
		super();
	}
	public CategoriaLibro(int id, String nombre, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.libros = libros;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public List<com.wpsnetwork.dto.entidades.Libro> getLibros() {
		return libros;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setLibros(List<com.wpsnetwork.dto.entidades.Libro> libros) {
		this.libros = libros;
	}
	@Override
	public String toString() {
		return "CategoriaLibro [id=" + id + ", nombre=" + nombre + "]";
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
		CategoriaLibro other = (CategoriaLibro) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
