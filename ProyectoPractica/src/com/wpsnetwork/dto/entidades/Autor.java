package com.wpsnetwork.dto.entidades;

import java.util.List;

public class Autor {
	
	private com.wpsnetwork.dao.entidades.Autor AutorDao ;
	private List<com.wpsnetwork.dto.entidades.Libro> libros;

	public Autor() {
		super();
	}
	public Autor(com.wpsnetwork.dao.entidades.Autor autorDao, List<Libro> libros) {
		super();
		AutorDao = autorDao;
		this.libros = libros;
	}
	public com.wpsnetwork.dao.entidades.Autor getAutorDao() {
		return AutorDao;
	}
	public List<com.wpsnetwork.dto.entidades.Libro> getLibros() {
		return libros;
	}
	public void setAutorDao(com.wpsnetwork.dao.entidades.Autor autorDao) {
		AutorDao = autorDao;
	}
	public void setLibros(List<com.wpsnetwork.dto.entidades.Libro> libros) {
		this.libros = libros;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AutorDao == null) ? 0 : AutorDao.hashCode());
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
		Autor other = (Autor) obj;
		if (AutorDao == null) {
			if (other.AutorDao != null)
				return false;
		} else if (!AutorDao.equals(other.AutorDao))
			return false;
		if (libros == null) {
			if (other.libros != null)
				return false;
		} else if (!libros.equals(other.libros))
			return false;
		return true;
	}


	
}
