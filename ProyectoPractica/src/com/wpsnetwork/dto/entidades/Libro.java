package com.wpsnetwork.dto.entidades;

import java.util.List;

public class Libro {

	private com.wpsnetwork.dao.entidades.Libro libroDao ;

	private List<com.wpsnetwork.dto.entidades.Autor> autores ;
	private List<com.wpsnetwork.dto.entidades.Categoria> categorias ;
	public Libro(com.wpsnetwork.dao.entidades.Libro libroDao, List<Autor> autores, List<Categoria> categorias) {
		super();
		this.libroDao = libroDao;
		this.autores = autores;
		this.categorias = categorias;
	}
	public Libro() {
		super();
	}
	public com.wpsnetwork.dao.entidades.Libro getLibroDao() {
		return libroDao;
	}
	public List<com.wpsnetwork.dto.entidades.Autor> getAutores() {
		return autores;
	}
	public List<com.wpsnetwork.dto.entidades.Categoria> getCategorias() {
		return categorias;
	}
	public void setLibroDao(com.wpsnetwork.dao.entidades.Libro libroDao) {
		this.libroDao = libroDao;
	}
	public void setAutores(List<com.wpsnetwork.dto.entidades.Autor> autores) {
		this.autores = autores;
	}
	public void setCategorias(List<com.wpsnetwork.dto.entidades.Categoria> categorias) {
		this.categorias = categorias;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + ((libroDao == null) ? 0 : libroDao.hashCode());
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
		Libro other = (Libro) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (libroDao == null) {
			if (other.libroDao != null)
				return false;
		} else if (!libroDao.equals(other.libroDao))
			return false;
		return true;
	}



}
