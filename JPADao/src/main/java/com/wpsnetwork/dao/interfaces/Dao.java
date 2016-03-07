package com.wpsnetwork.dao.interfaces;

import javax.persistence.EntityManager;

import com.wpsnetwork.jpa.EntityManagerUtil;

public interface Dao <T>{
	
	// con java 1.8 se puede poner un codigo por defecto a las interaces
	// hay que tocar las propiedades del proyecto para quitar la 1.5 que pone 
	// por defecto al crear un proy maven y ponerle 1.8
	
	default public T get( Class metaDatoClass , int clave ){
		
		EntityManager entityManager = null ;
		T objeto = null ;
		
		try{
			
			entityManager = EntityManagerUtil.getEntityManager() ;
			objeto = (T) entityManager.find( metaDatoClass , clave ) ;
		}
		catch (Exception ex) {
			throw new RuntimeException(ex) ;
		}
		
		return objeto ;
		
	};
	
	default public void insert ( T obj ){

		EntityManager entityManager = null ;

		try{
			
			entityManager = EntityManagerUtil.getEntityManager() ;
			
			entityManager.getTransaction().begin();
			
			entityManager.persist( obj );
			
			entityManager.getTransaction().commit();

		}
		catch (Exception ex) {
			
			entityManager.getTransaction().rollback();
			
			throw new RuntimeException(ex) ;
			
		}
		
	};
	
	default public void update ( T obj ){

		EntityManager entityManager = null ;

		try{
			
			entityManager = EntityManagerUtil.getEntityManager() ;
			
			entityManager.getTransaction().begin();
			
			entityManager.merge(obj);
			
			entityManager.getTransaction().commit();

		}
		catch (Exception ex) {
			
			entityManager.getTransaction().rollback();
			
			throw new RuntimeException(ex) ;
			
		}
	
	};
	
	default public void delete ( Class metaDatoClass , int clave) {

		EntityManager entityManager = null ;
		T objeto = null ;
		
		try{
			
			entityManager = EntityManagerUtil.getEntityManager() ;
			
			entityManager.getTransaction().begin();
			
			objeto = (T) entityManager.find( metaDatoClass , clave );
			
			entityManager.remove(objeto);
			
			entityManager.getTransaction().commit();
		}
		catch (Exception ex) {
			entityManager.getTransaction().rollback();
			
			throw new RuntimeException(ex) ;
		}
		
	
		
	};

}
