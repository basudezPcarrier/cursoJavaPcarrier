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

import com.wpsnetwork.dao.entidades.*;
import com.wpsnetwork.dao.factorias.DaoFactory.TipoFactoria;

@Path("/proveedores")
public class ProveedoresRestful extends AbstractRestful<Proveedor> {
	
	
	
	public ProveedoresRestful() {
		super(Proveedor.class, TipoFactoria.PROVEEDORES);
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(
							@FormParam("id_dir") BigDecimal id_direccion,
							@FormParam("direccion") String direccion,
							@FormParam("ciudad") String ciudad,
							@FormParam("pais") String pais,
							@FormParam("cp") String cp,
							
							@FormParam("id_proveedor") BigDecimal id_proveedor,
							@FormParam("nombre") String nombre,
							
							@Context HttpServletResponse servletResponse) throws IOException{
		
		Direccion dir = new Direccion(id_direccion, direccion, ciudad, pais, cp, null);
		Proveedor objeto = new Proveedor(id_proveedor, dir, nombre, new ArrayList<Producto>());
		
		dir.setProveedor(objeto);
		
		dao.openCurrentSessionwithTransaction();
    	
    	dao.persist(objeto);
		
    	dao.closeCurrentSessionwithTransaction();
		servletResponse.sendRedirect("./proveedores/");
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Proveedor proveedorRest) {
		Response response;
		
		dao.openCurrentSessionwithTransaction();
		
		Proveedor p = dao.findById(Proveedor.class, proveedorRest.getId().toString());
		
		if ( p == null) {
			response = Response.notModified().build();
		} else {
			p.setNombre(proveedorRest.getNombre());
			p.setDireccion(proveedorRest.getDireccion());
			dao.update(p);
			response = Response.ok().build();
		}
		dao.closeCurrentSessionwithTransaction();
		return response;
	}
	
}
