package com.wpsnetwork.patrones.dao;

import java.util.List;

import com.wpsnetwork.patrones.dao.interfaces.IClienteDao;
import com.wpsnetwork.patrones.iterator.interfaces.Iterator;

public class ClienteHibernateDao implements IClienteDao, Iterator {

	@Override
	public List<Clientes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Clientes c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Clientes c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Clientes get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
