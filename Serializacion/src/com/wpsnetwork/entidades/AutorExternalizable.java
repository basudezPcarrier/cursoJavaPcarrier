package com.wpsnetwork.entidades;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class AutorExternalizable implements Externalizable {

	/* Externalizable sirve tambi'en para la serializacion pero tiene sus propios metodos que 
	 * nos fuerza a implementarlos
	 * 
	 * */
	
	
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	// este serialVersionUID lo va a utlizar para saber qué objeto esta escribiendo
	private static final long serialVersionUID = 1L;

	private int codigo ;
	private String nombre ;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public AutorExternalizable(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public AutorExternalizable() {
		super();
	}
	@Override
	public void readExternal(ObjectInput in ) throws IOException, ClassNotFoundException {
		this.codigo = in.readInt();
		this.nombre = in.readUTF() ;
		
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(codigo);
		out.writeUTF(nombre);
	}
	
	
}
