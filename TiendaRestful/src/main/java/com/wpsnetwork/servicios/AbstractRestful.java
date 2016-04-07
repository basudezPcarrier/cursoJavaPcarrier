package com.wpsnetwork.servicios;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.wpsnetwork.dao.entidades.interfaces.Identificable;
import com.wpsnetwork.dao.factorias.DaoFactory;
import com.wpsnetwork.dao.factorias.DaoFactory.TipoFactoria;
import com.wpsnetwork.dao.interfaces.Dao;

public abstract class AbstractRestful <T extends Identificable> {

	@Context
	protected UriInfo uriInfo;
	@Context
	protected Request request;
	
	protected Dao<T> dao;
	private Class<T> metadato;

	@SuppressWarnings("unchecked")
	public AbstractRestful(Class<T> metadato, TipoFactoria tipoDao) {
		super();
		this.dao = DaoFactory.createInstance(tipoDao);
		this.metadato = metadato;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> getAll() {
	
		dao.openCurrentSession();
		
		List<T> lista = dao.findAll(metadato);
		
		dao.closeCurrentSession();
		
		return lista;
	}

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public T get(@PathParam("id") String id) {
	
		dao.openCurrentSession();
		
		T c = (T) dao.findById(metadato,id);
		
		dao.closeCurrentSession();
		
		return c;
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		dao.openCurrentSession();
		
		int total = dao.findAll(metadato).size();
		
		dao.closeCurrentSession();
		
		return String.valueOf(total);
	}
	

	@Path("{id}")
	@DELETE
	public void delete(@PathParam("id") String id) {
		
		dao.openCurrentSessionwithTransaction();
		
		T c = (T) dao.findById(metadato,id);
		dao.delete(c);
		
		dao.closeCurrentSessionwithTransaction();
	}

	
}