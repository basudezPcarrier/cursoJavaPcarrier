package com.wpsnetwork.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.config.Cascade;

/* Para implementar JPA:
 * 
 *    - la clase debe ser serializable
 *    - debe tener la anotación @Entity
 *    - la anotacion @table indica la tabla (si tuviera el nombre de la clase distinta
 *      a la de la clase, se especifica el nombre de la tabla 
 *    - para indicar la variable que será PK, se pone @Id delante del atributo en cuestión
 *      
 *      Si la PK tuviera mas de un atributo, se puede pone el @Id en cada atributo de la PK
 *      , luego se crea una clase embebida con esos atributos, y se indica con la anotación @ClassId 
 * 		
 * 		Si el atributo (de la PK o no) no se llama igual que la columna de la tabla, se le pone la
 *      anotación @Column indicando el bnombre del la columna de la tabla
 * 
 *    - indicar relaciones entre tablas
 *    	
 *    	Se crean listas de objetos de la clase con la que tiene la relacion y se indica justo antes el tipo
 *      de relación que tiene	
 *    		@OneToOne
 *    		@ManyToMany
 *    		@OneToMany
 *    		@ManyToMany
 * 		
 * 		el @Column puede indicar muchas cosas 
 * 				el nombre de la columna
 * 				el tipo de fecha 
 * 				la longitud max
 * 				si es nullable o no
 *   
 * */

@Entity
@Table(name="CLIENTE")
@NamedQueries({
		@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c") // OJO!! ese Cliente es la entidad de persistenca, no el nombre de la tabla de la bbdd
  	  , @NamedQuery(name="Cliente.findById", query="SELECT c FROM Cliente c WHERE c.id = :id") 
})

public class Cliente implements Serializable{

	private static final long serialVersionUID = -8530861527760414026L;
	
	@Id
	@Column(name="ID")
	private int id ;
	
	@Column(name="NOMBRE")
	private String nombre ;
	
	// indicar la relación entre tablas y el tipo de operacion en cascada que se relalica
	
	@OneToMany(cascade=CascadeType.ALL		// indicar el tipo de operacion en cascada que vamos a hacer
			  ,fetch=FetchType.LAZY 		// incidcar el tipo de fetch de la operacion
			  ,mappedBy="idCliente" 		// le indicamos el atributo de la otra tabla que relaciona esa clase con la nuestra
			)
	private List<Pedido> pedidos ;
	
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pedidos = pedidos ;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	protected List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", " + (nombre != null ? "nombre=" + nombre : "") + ", pedidos=" + pedidos + "]";
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
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}



	
	
}
