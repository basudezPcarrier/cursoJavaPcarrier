package com.wpsnetwork.consola;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.wpsnetwork.entidades.Cliente;
import com.wpsnetwork.entidades.Pedido;

public class Main {

	public static void main(String[] args) {

		// Ejemplo de actualizar datos
		
		
//		System.out.println("******** abrir session de Hibernate");
//		
//		// abrir sesion
//		Session sesion = HibernateUtil.getSession() ;
//		
//		System.out.println("******** abrir session de Hibernate  ->  abierta");
//		
//		// abrir transacion
//		sesion.beginTransaction() ;
//		
//		// creo un cliente y una lista de pedido
//		
//		Cliente c1 = new Cliente( 10000 , "Cliente 10000" , null ) ;
//		Set<Pedido> pedidos = new HashSet<Pedido>() ;
//		
//		// añado un pedido a la lista de pedidos
//		//
//		// recordar que en el de ingenieria inversa le indicamos que los DATE de la bbdd los tratara como LocalDate, por
//		// eso podemos trabajar con LocalDate en vez de con el Date antiguo de java
//		pedidos.add ( new Pedido( 10000 , c1 , LocalDate.now() , "Info pedido 10000" ) ) ;
//		
//		// añado al cliente la lista de pedidos
//		c1.setPedidos(pedidos);
//		
//		
//		sesion.persist(c1);
//		
//		// cerrar transaccion
//		sesion.getTransaction().commit();
//
//		// cerrar sesion
//		
//		sesion.close();
//		
//		
//		System.out.println("******** cerrar session de Hibernate");
//
//		// cerrar sesion
//		HibernateUtil.setDown();
//		
//		System.out.println("******** cerrar session de Hibernate  ->  cerrada");

		
		
//		// Ejemplo de actualizar datos
//		
//		System.out.println("******** abrir session de Hibernate");
//		Session sesion = HibernateUtil.getSession() ;
//		System.out.println("******** abrir session de Hibernate  ->  abierta");
//		
//		sesion.beginTransaction() ;
//		
//		// consideramos el cliente y le cambiamos el nombre
//
//		Cliente c1 = new Cliente( 10000 , "Cliente 10000" , null ) ;
//		Set<Pedido> pedidos = new HashSet<Pedido>() ;
//		c1.setPedidos(pedidos);
//		
//		// he comentado antes la parte del pedido para hacer el merge con los pedidos a null
//		// no me ha hecho nada en la tabla pedidos. PArece que es por el tipo de cascade que hemos puesto 
//		// en el fichero de conf de la clase 
//		
//		
//		c1.setNombre("Nombre modificado hibernate 2");
//		sesion.merge(c1);
//		
//		
//		sesion.getTransaction().commit();
//		sesion.close();
//		
//		
//		System.out.println("******** cerrar session de Hibernate");
//		HibernateUtil.setDown();
//		System.out.println("******** cerrar session de Hibernate  ->  cerrada");
		

//		// Ejemplo de eliminar datos
//		
//		System.out.println("******** abrir session de Hibernate");
//		Session sesion = HibernateUtil.getSession() ;
//		System.out.println("******** abrir session de Hibernate  ->  abierta");
//		
//		sesion.beginTransaction() ;
//		
//		// consideramos el cliente y le cambiamos el nombre
//
//		Cliente c1 = new Cliente( 10000 , "Cliente 10000" , null ) ;
//		Set<Pedido> pedidos = new HashSet<Pedido>() ;
//		c1.setPedidos(pedidos);
//		pedidos.add ( new Pedido( 10000 , c1 , LocalDate.now() , "Info pedido 10000" ) ) ;
//		
//		sesion.delete(c1);
//		
//		sesion.getTransaction().commit();
//		sesion.close();
//		
//		
//		System.out.println("******** cerrar session de Hibernate");
//		HibernateUtil.setDown();
//		System.out.println("******** cerrar session de Hibernate  ->  cerrada");


		// Ejemplo de eliminar datos
		
		System.out.println("******** abrir session de Hibernate");
		Session sesion = HibernateUtil.getSession() ;
		System.out.println("******** abrir session de Hibernate  ->  abierta");
		
		sesion.beginTransaction() ;
		
		// OJO con las mayusculas! lo que va en el from es el nombre de la clase
		
		// esto funciona
		// List<Cliente> resultado = (List<Cliente>) sesion.createQuery("from Cliente" ).list() ; // tambien hay un findFirstResult 
		
		// pero hemos creado en la HibernateUtil un func generica para transformar a lista 
		List<Cliente> resultado = HibernateUtil.listAndCast( sesion.createQuery("from Cliente")); 
		

		System.out.println(resultado);
		
//		
		
		
		sesion.close();
		
		System.out.println("******** cerrar session de Hibernate");
		HibernateUtil.setDown();
		System.out.println("******** cerrar session de Hibernate  ->  cerrada");		
		
	}

}
