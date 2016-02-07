package com.wpsnetwork.dao.entidades;

public class CategoriaLibro {
	
	private int id ;
	private int idLibro ;
	private int idCategoria ;
	public int getId() {
		return id;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public CategoriaLibro(int id, int idLibro, int idCategoria) {
		super();
		this.id = id;
		this.idLibro = idLibro;
		this.idCategoria = idCategoria;
	}
	public CategoriaLibro() {
		super();
	}
	
	
	
}
