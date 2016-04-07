package com.wpsnetwork.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class DaoHibernate{
	private Session currentSession;
	private Transaction currentTransaction;

	
	public Session openCurrentSession(){
		currentSession = getSessionFactory().openSession();
		
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction(){
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;

	}
		
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction(){
		currentTransaction.commit();
		
		currentSession.close();
	}
	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
    	
    	// A SessionFactory is set up once for an application!
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure() // configures settings from hibernate.cfg.xml
    			.build();
    	try {
    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    	}
    	catch (HibernateException e) {
    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
    		// so destroy it manually.
    		StandardServiceRegistryBuilder.destroy( registry );
    		throw e;
    	}
    	return sessionFactory;

	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
		setCurrentTransaction(currentSession.getTransaction());
	}
	
	private Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	
	private void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
}
