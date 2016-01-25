package com.wpsnetwork.patrones.dao.interfaces;

import java.util.List;

import com.wpsnetwork.patrones.dao.Clientes;

public interface IClienteDao {
	
	List<Clientes> getAll();
	boolean update(Clientes c) ;
	boolean add (Clientes c ) ;
	boolean delete (int id) ;
	Clientes get(int id) ;
	
	
	
}
