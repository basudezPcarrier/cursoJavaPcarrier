package com.wpsnetwork.servicios;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wpsnetwork.dao.*;
import com.wpsnetwork.dao.entidades.*;
import com.wpsnetwork.dao.factorias.DaoFactory.TipoFactoria;

@Path("/pedidos")
public class PedidosRestful extends AbstractRestful<Pedido> {
	
	
	
	public PedidosRestful() {
		super(Pedido.class, TipoFactoria.PEDIDOS);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(
							@FormParam("id") BigDecimal id,
							@FormParam("cliente") BigDecimal id_cliente,
							@FormParam("fecha") String fecha,
							@Context HttpServletResponse servletResponse) throws IOException{
		
		ClientesDao clientes = new ClientesDao();
    	clientes.openCurrentSession();
    	
    	Cliente c = clientes.findById(Cliente.class, id_cliente.toString());
		
    	clientes.closeCurrentSession();
    	
		Pedido objeto = new Pedido(id, c, LocalDateTime.parse(fecha), new ArrayList<ProductoPedido>());
		
		dao.openCurrentSessionwithTransaction();
    	
    	dao.persist(objeto);
		
    	dao.closeCurrentSessionwithTransaction();
		servletResponse.sendRedirect("./pedidos/");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Pedido pedidoRest) {
		Response response;
		
		dao.openCurrentSessionwithTransaction();
		
		Pedido p = dao.findById(Pedido.class, pedidoRest.getId().toString());
		
		if ( p == null) {
			response = Response.notModified().build();
		} else {
			p.setFecha(pedidoRest.getFecha());
			dao.update(p);
			response = Response.ok().build();
		}
		dao.closeCurrentSessionwithTransaction();
		return response;
	}
	
}
