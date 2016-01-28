package com.wpsnetwork.entidades;

public class Cliente implements Comparable<Cliente> , Cloneable {
	
	private int codigo ;
	private String nombre ;
	private int edad ;
	
	// patron java bean: constructor sin parametros y getters y setters
	
	public Cliente() {
		super();
	}
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	// constructor con parametros
	
	public Cliente(int codigo, String nombre, int edad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	// sobreescribir el toString
	// sobreescribir el metodo Equals():boolean para adaptartlo a nuestras necesidades 
	//
	// para ello tambien tenemos que sobreescribir el metodo hashCode():int
	

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	// metodo creado al implementar la clase Comparable
	// 
	// debe compararlo con mi this.
	// 		-> + si this. > parametro
	// 		-> - si this. < parametro
	// 		-> 0 si this. = parametro
	
	@Override
	public int compareTo(Cliente o) {
		// TODO Auto-generated method stub
		int r = 0 ;
		
//		if ( this.codigo > o.codigo )
//			r = 1 ;
//		else if ( this.codigo < o.codigo )
//			r = -1 ;
//		
		
		/*
		 * tambien se puede hacer directamente 
		 * 		return this.codigo - o.codigo ;
		 * 
		 * o simplemente 
		 * 		return Integer.compare(this.codigo , o.codigo ) ;
		 * 
		 * de esta forma usamos ya el comparador de la clase
		 * */
		
		// para comparar el nombre --> lo hacemos directamente con la clase  
		
		return this.nombre.compareTo(o.nombre) ;
		
		
	}
	
	// tenemos que hacer el cast al comparar
	// OJO!! no podemos hacerlo en la firma del metodo porque al sobreescribirlo
	//       tenems que dejar la firma igual!
	
	@Override
	public boolean equals(Object obj) {
		return this.codigo == ((Cliente)obj).codigo ;
	}
	@Override
	public int hashCode() {
		return this.codigo * 50 ;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}
