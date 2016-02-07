package com.wpsnetwork.dto.entidades;

import java.util.List;

public class Categoria {

	private com.wpsnetwork.dao.entidades.Categoria Categoria ;
	private List<com.wpsnetwork.dto.entidades.Libro> libros;
	public Categoria(com.wpsnetwork.dao.entidades.Categoria categoria, List<Libro> libros) {
		super();
		Categoria = categoria;
		this.libros = libros;
	}
	public Categoria() {
		super();
	}
	public com.wpsnetwork.dao.entidades.Categoria getCategoria() {
		return Categoria;
	}
	public List<com.wpsnetwork.dto.entidades.Libro> getLibros() {
		return libros;
	}
	public void setCategoria(com.wpsnetwork.dao.entidades.Categoria categoria) {
		Categoria = categoria;
	}
	public void setLibros(List<com.wpsnetwork.dto.entidades.Libro> libros) {
		this.libros = libros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Categoria == null) ? 0 : Categoria.hashCode());
		result = prime * result + ((libros == null) ? 0 : libros.hashCode());
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
		Categoria other = (Categoria) obj;
		if (Categoria == null) {
			if (other.Categoria != null)
				return false;
		} else if (!Categoria.equals(other.Categoria))
			return false;
		if (libros == null) {
			if (other.libros != null)
				return false;
		} else if (!libros.equals(other.libros))
			return false;
		return true;
	}



}
