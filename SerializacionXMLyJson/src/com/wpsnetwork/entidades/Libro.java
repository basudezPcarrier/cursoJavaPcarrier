package com.wpsnetwork.entidades;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Libro implements Externalizable {
	
	private int codigo ;
	private String titulo ;
	private int anyo ;
	private String autor ;
	
	public Libro() {
	}
	public Libro(int codigo, String titulo, int anyo, String autor) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.anyo = anyo;
		this.autor = autor;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		// no hace falta pasarle parametros al readInt, readUTF y tal...pero hay que ponerlo
		// en el mismo orden que hemos escrito los write del writeExternal
		
		this.codigo = in.readInt();
		this.titulo = in.readUTF();
//		this.anyo = in.readInt();
//		this.autor = in.readUTF();
		
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		out.writeInt(codigo);
		out.writeUTF(titulo);
//		out.writeInt(anyo);
//		out.writeUTF(autor);
		
	}
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", anyo=" + anyo + ", autor=" + autor + "]";
	}
	 
}
