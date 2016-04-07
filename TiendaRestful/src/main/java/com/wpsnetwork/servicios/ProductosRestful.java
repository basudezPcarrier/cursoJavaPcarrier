package com.wpsnetwork.servicios;

import java.io.IOException;
import java.math.BigDecimal;
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

@Path("/productos")
public class ProductosRestful extends AbstractRestful<Producto> {
	
	
	
	public ProductosRestful() {
		super(Producto.class, TipoFactoria.PRODUCTOS);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(
							@FormParam("id") BigDecimal id,
							@FormParam("proveedor") BigDecimal id_proveedor,
							@FormParam("nombre") String nombre,
							@FormParam("precio") Double precio,
							@FormParam("moneda") String moneda,
							@Context HttpServletResponse servletResponse) throws IOException{
		
		
		ProveedoresDao proveedores = new ProveedoresDao();
    	proveedores.openCurrentSession();
    	
    	Proveedor p = proveedores.findById(Proveedor.class,id_proveedor.toString());
		
    	proveedores.closeCurrentSession();
    	
		Producto objeto = new Producto(id, p, nombre, precio, moneda, new ArrayList<ProductoPedido>());
		
		dao.openCurrentSessionwithTransaction();
    	
    	dao.persist(objeto);
		
    	dao.closeCurrentSessionwithTransaction();
		servletResponse.sendRedirect("./productos/");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Producto productoRest) {
		Response response;
		
		dao.openCurrentSessionwithTransaction();
		
		Producto p = dao.findById(Producto.class, productoRest.getId().toString());
		
		if ( p == null) {
			response = Response.notModified().build();
		} else {
			p.setNombre(productoRest.getNombre());
			p.setPrecio(productoRest.getPrecio());
			p.setMoneda(productoRest.getMoneda());
			dao.update(p);
			response = Response.ok().build();
		}
		dao.closeCurrentSessionwithTransaction();
		return response;
	}
	
}
