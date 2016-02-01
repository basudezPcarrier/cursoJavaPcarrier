package com.wpsnetwork.dao.entidades;

public class Libro {

	private int id;
	private String titulo ;
	private int paginas ;
	private String editorial ;
	private String edicion ;
	public Libro() {
		super();
	}
	public Libro(int id, String titulo, int paginas, String editorial, String edicion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.editorial = editorial;
		this.edicion = edicion;
	}
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public String getEditorial() {
		return editorial;
	}
	public String getEdicion() {
		return edicion;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", paginas=" + paginas + ", editorial=" + editorial
				+ ", edicion=" + edicion + "]";
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
		Libro other = (Libro) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
