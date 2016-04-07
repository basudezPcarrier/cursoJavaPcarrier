package com.wpsnetwork.dao.factorias;

import com.wpsnetwork.dao.*;
import com.wpsnetwork.dao.interfaces.Dao;

public class DaoFactory {
	
	public enum TipoFactoria { CLIENTES, DIRECCIONES, PEDIDOS, PRODUCTOS, PROVEEDORES }
	
	public static Dao createInstance(TipoFactoria tipoFactoria){
		
		Dao dao = null;
		
		switch(tipoFactoria){
		case CLIENTES:
			dao = new ClientesDao();
			break;
		case DIRECCIONES:
			dao = new DireccionesDao();
			break;
		case PEDIDOS:
			dao = new PedidosDao();
			break;
		case PRODUCTOS:
			dao = new ProductosDao();
			break;
		case PROVEEDORES:
			dao = new ProveedoresDao();
		}
		
		return dao;
	}
}
