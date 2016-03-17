package com.wpsnetwork.consola;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.wpsnetwork.entidades.unoauno.Direccion;
import com.wpsnetwork.entidades.unoauno.Persona;

public class Main {

	public static void main(String[] args) {
		
		/*
		  
				CREATE TABLE direcciones 
				(
					id integer primary key ,
					calle varchar2(50),
					codigopostal varchar2(50)
				);
				CREATE TABLE personas 
				(
					id integer primary key ,
					nombre varchar2(50),
					direccion integer,
					CONSTRAINT  fk_direccion FOREIGN KEY (direccion) REFERENCES  direcciones(id)
				);
				 
 

		 * */
		
		Session sesion = HibernateUtil.getSession() ;
		
		
		// alta de entidades (personas y direccion)
		
		sesion.beginTransaction() ;
		
		Direccion dir = new Direccion( BigDecimal.valueOf(2) , "Calle 2" , "2222") ;
		Persona per = new Persona( BigDecimal.valueOf(2) , dir , "Nombre 2") ;
		
		sesion.persist(per);
		
		sesion.getTransaction().commit();
		sesion.close();

		
		
		// eliminar los datos
		
		sesion = HibernateUtil.getSession() ;
		
		sesion.beginTransaction() ;
		
		sesion.delete(per);
		
		sesion.getTransaction().commit();
		sesion.close();		
		
		HibernateUtil.setDown();

	}

}
