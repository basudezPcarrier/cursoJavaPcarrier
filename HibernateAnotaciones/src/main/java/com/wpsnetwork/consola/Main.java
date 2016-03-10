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

		
		// le decimos que sistema de logs dee usar hibernate 
		System.setProperty("org.jboss.logging.provider", "log4j2") ; // hay que añadir ese log4j2 a las dependencias del pom.xml
	
		System.out.println("******** abrir session de Hibernate");
		Session sesion = HibernateUtil.getSession() ;
		System.out.println("******** abrir session de Hibernate  ->  abierta");
		

//		Ejemplo de crear datos
		
		sesion.beginTransaction() ;
		
		Cliente c1 = new Cliente( 0 , "Cliente 10000" , null ) ;
		Set<Pedido> pedidos = new HashSet<Pedido>() ;
		
		Pedido  p1 = new Pedido( 0 , c1 , LocalDate.now() , "Info pedido 10000" ) ;
		
		pedidos.add ( p1 ) ;
		c1.setPedidos(pedidos);
		
		sesion.persist(c1);
		
		sesion.getTransaction().commit();

		sesion.close();

//		Ejemplo de actualizar datos

		sesion = HibernateUtil.getSession() ;
		
		sesion.beginTransaction() ;
		
		c1.setNombre("Nombre modificado hibernate otra vez");
		sesion.merge(c1);		
		
		sesion.getTransaction().commit();
		sesion.close();
		
		
//		Ejemplo de eliminar datos
		
		sesion = HibernateUtil.getSession() ;
		
		sesion.beginTransaction() ;
		
//		sesion.delete(c1);
		
		sesion.getTransaction().commit();
		sesion.close();
		

//		cerrar hibernate
		
		System.out.println("******** cerrar session de Hibernate");
		HibernateUtil.setDown();
		System.out.println("******** cerrar session de Hibernate  ->  cerrada");		
	
	
	}

}
