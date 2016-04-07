package com.wpsnetwork.servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Hibernate;

import com.wpsnetwork.dao.*;
import com.wpsnetwork.dao.entidades.*;
import com.wpsnetwork.dao.factorias.DaoFactory.TipoFactoria;

@Path("/clientes")
public class ClientesRestful extends AbstractRestful<Cliente> {
	
	
	
	public ClientesRestful() {
		super(Cliente.class, TipoFactoria.CLIENTES);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(
							@FormParam("nombre") String nombre,
							@FormParam("apellidos") String apellidos,
							@Context HttpServletResponse servletResponse) throws IOException{
		
		Cliente c = new Cliente(null, nombre, apellidos, new ArrayList<Pedido>());
		
		ClientesDao clientes = new ClientesDao();
    	clientes.openCurrentSessionwithTransaction();
    	
    	clientes.persist(c);
		
    	clientes.closeCurrentSessionwithTransaction();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Cliente clienteRest) {
		Response response;
		
		dao.openCurrentSessionwithTransaction();
		
		Cliente c = dao.findById(Cliente.class, clienteRest.getId().toString());
		
		if ( c == null) {
			response = Response.notModified().build();
		} else {
			c.setNombre(clienteRest.getNombre());
			c.setApellidos(clienteRest.getApellidos());
			dao.update(c);
			response = Response.ok().build();
		}
		dao.closeCurrentSessionwithTransaction();
		return response;
	}
	
	@Path("pedidos/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> getPedidos(@PathParam("id") String id) {
	
		dao.openCurrentSession();
		
		Cliente c = (Cliente) dao.findById(Cliente.class,id);
		List<Pedido> pedidos = c.getPedidos();
		
		Hibernate.initialize(pedidos);
		
		dao.closeCurrentSession();
		
		return pedidos;
	}
	
}
