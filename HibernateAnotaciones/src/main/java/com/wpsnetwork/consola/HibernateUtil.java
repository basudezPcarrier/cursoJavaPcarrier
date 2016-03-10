package com.wpsnetwork.consola;

import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory = null ;
	
	// metodo publico para onbtener una session
	
	public static Session getSession(){
		
		if (sessionFactory == null ){
			
			try {
				sessionFactory = setUp() ;
			}
			catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory.openSession() ; // de la factoria de sesiones obtenemos una sesion (eso lo que hace es obtener una conexion a bbdd)
	
	}
	
	
	// metodo para arrancar hibernate
	
	private static SessionFactory setUp () throws Exception {
		SessionFactory sessionFactory = null ;
		
		// 
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build() ;
		
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory() ;
		}
		catch (HibernateException e) {
			
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
		return sessionFactory ;
	}
	
	// metodo para cerrar hibernate
	
	public static void setDown () {
		sessionFactory.close();
	}
	
	
	// otros metodos que nos interesan para los ejemplos
	
	public static <T> List<T> listAndCast ( Query q) {
		
		@SuppressWarnings("unchecked")
		List<T> lista = q.list() ;
		return lista ;
		
	}
	
	
	
}
