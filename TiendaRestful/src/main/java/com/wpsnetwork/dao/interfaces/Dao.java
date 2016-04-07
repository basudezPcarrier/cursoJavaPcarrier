package com.wpsnetwork.dao.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

public interface Dao<T> {
	public Session openCurrentSession();
	public Session openCurrentSessionwithTransaction();
	public void closeCurrentSession();
	public void closeCurrentSessionwithTransaction();
	public Session getCurrentSession();
	public void setCurrentSession(Session currentSession);
	
	default public void persist(T entity){
		getCurrentSession().persist(entity);
	};
	
	default public void update(T entity){
		getCurrentSession().merge(entity);
	};
	
	default public T findById(Class<T> metadato,String id){
		T result = (T) getCurrentSession().get(metadato, new BigDecimal(id));
		return result;
	};
	
	default public void delete(T entity){
		getCurrentSession().delete(entity);
	};
	
	@SuppressWarnings("unchecked")
	default public List<T> findAll(Class<T> metadato){
		String sql = "from " + metadato.getName();
		List<T> lista = (List<T>) getCurrentSession().createQuery(sql).list();
		return lista;
	};
	
	default public void deleteAll(Class<T> metadato){
		List<T> entityList = findAll(metadato);
		for (T entity : entityList) {
			delete(entity);
		}
	};
}
