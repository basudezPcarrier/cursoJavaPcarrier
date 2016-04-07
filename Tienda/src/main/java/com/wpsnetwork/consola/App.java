package com.wpsnetwork.consola;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.*;
import com.wpsnetwork.dao.entidades.*;

public class App{
    public static void main( String[] args ){
        /*
         
          1.- Crear las tablas y secuencias
          =================================
       
          CREATE TABLE DIRECCIONES_TIENDA(
          		id 			INTEGER PRIMARY KEY,
          		direccion	VARCHAR2(50),
          		ciudad		VARCHAR2(30),
          		pais		VARCHAR2(30),
          		cp			VARCHAR(10)
          );
          
          CREATE TABLE CLIENTES_TIENDA(
          		id			INTEGER PRIMARY KEY,
          		nombre		VARCHAR2(50),
          		apellidos	VARCHAR2(50)
          );
          
          CREATE TABLE PROVEEDORES_TIENDA(
          		id			INTEGER PRIMARY KEY,
          		nombre		VARCHAR2(50),
          		direccion	INTEGER,
          		CONSTRAINT fk_direcciones_tienda FOREIGN KEY (direccion) 
        			REFERENCES direcciones_tienda(id)
          );
          
          CREATE TABLE PRODUCTOS_TIENDA(
          		id			INTEGER PRIMARY KEY,
          		nombre		VARCHAR2(50),
          		precio		DECIMAL(5,2),
          		moneda		VARCHAR2(3),
          		proveedor	INTEGER,
          		CONSTRAINT fk_proveedores_tienda FOREIGN KEY (proveedor) 
        			REFERENCES proveedores_tienda(id)
          );
          
          CREATE TABLE PEDIDOS_TIENDA(
          		id			INTEGER PRIMARY KEY,
          		fecha		TIMESTAMP,
          		cliente		INTEGER,
          		CONSTRAINT fk_clientes_tienda FOREIGN KEY (cliente) 
        			REFERENCES clientes_tienda(id)
          );
          
          CREATE TABLE PRODUCTOS_PEDIDO_TIENDA(
          		idproducto	INTEGER,
          		idpedido	INTEGER,
          		lineaPedido	INTEGER,
          		CONSTRAINT pk_productos_pedido PRIMARY KEY(idproducto, idpedido), 
          		CONSTRAINT fk_productos_tienda FOREIGN KEY (idproducto) 
        			REFERENCES productos_tienda(id),
        		CONSTRAINT fk_pedidos_tienda FOREIGN KEY (idpedido) 
        			REFERENCES pedidos_tienda(id)
          );
          
          CREATE SEQUENCE SEQ_DIRECCION_TIENDA START WITH 1;
          CREATE SEQUENCE SEQ_CLIENTE_TIENDA START WITH 1;
          CREATE SEQUENCE SEQ_PROVEEDOR_TIENDA START WITH 1;
          CREATE SEQUENCE SEQ_PRODUCTO_TIENDA START WITH 1;
          CREATE SEQUENCE SEQ_PEDIDO_TIENDA START WITH 1;
          
          
          2.- Crear el fichero de configuración de Hibernate
          ===================================================
          Crear carpeta src/main/resources
          New->Other->Hibernate-> Create Hibernate Configuration File
          
          
          3.- Crear el fichero de Consola de configuración
          ===================================================
          New->Other->Hibernate-> Create Hibernate Console Configurator
          
          4.- Crear el fichero de Ingenieria Inversa
          ===================================================
          Ir a la carpeta resources
          New->Other->Hibernate-> Create Hibernate reverse engineering File 
          
          5.- Empezar asistente
          ======================
          
          Crear los pojo, el fichero de configuración de nuevo
         */
    	
    	//Le decimos que sistem de log debe usar Hibernate
    	System.setProperty("org.jboss.logging.provider", "log4j2");
    	
    	
    	Producto prod1 = new Producto(null, null, "Producto 1", 1.00, "EUR", new ArrayList<ProductoPedido>());
    	Producto prod2 = new Producto(null, null, "Producto 2", 2.00, "EUR", new ArrayList<ProductoPedido>());
    	Producto prod3 = new Producto(null, null, "Producto 3", 3.00, "EUR", new ArrayList<ProductoPedido>());
    	
    	Proveedor prov1 = new Proveedor(null, null, "Proveedor 1", new ArrayList<Producto>());
    	Proveedor prov2 = new Proveedor(null, null, "Proveedor 2", new ArrayList<Producto>());
    	Proveedor prov3 = new Proveedor(null, null, "Proveedor 3", new ArrayList<Producto>());
    	
    	Direccion dir1 = new Direccion(null, "Dirección proveedor 1", "Ciudad 1", "Pais 1", "1000", prov1);
    	Direccion dir2 = new Direccion(null, "Dirección proveedor 2", "Ciudad 2", "Pais 2", "2000", prov2);
    	Direccion dir3 = new Direccion(null, "Dirección proveedor 3", "Ciudad 3", "Pais 3", "3000", prov3);
    	
    	prov1.setDireccion(dir1);
    	prov2.setDireccion(dir2);
    	prov3.setDireccion(dir3);
    	
    	prod1.setProveedor(prov1);
    	prod2.setProveedor(prov2);
    	prod3.setProveedor(prov3);
    	
    	prov1.getProductos().add(prod1);
    	prov2.getProductos().add(prod2);
    	prov3.getProductos().add(prod3);
    	   	
    	
    	ProveedoresDao proveedores = new ProveedoresDao();
    	proveedores.openCurrentSessionwithTransaction();
    	
    	proveedores.persist(prov1);
    	proveedores.persist(prov2);
    	proveedores.persist(prov3);
    	
    	proveedores.closeCurrentSessionwithTransaction();
    	
    	
    	Cliente c1 = new Cliente(null, "Cliente 1", "Apellido 1", new ArrayList<Pedido>());
    	Pedido p1 = new Pedido(null, c1, LocalDateTime.now(), new ArrayList<ProductoPedido>());
    	p1.getProductosPedido().add(new ProductoPedido(prod1, p1, 2));
    	p1.getProductosPedido().add(new ProductoPedido(prod2, p1, 1));
    	
    	Pedido p2 = new Pedido(null, c1, LocalDateTime.now(), new ArrayList<ProductoPedido>());
    	p2.getProductosPedido().add(new ProductoPedido(prod3, p2, 1));
    	
    	c1.getPedidos().add(p1);
    	c1.getPedidos().add(p2);
    	
    	System.out.println("*** Añadimos clientes ***");
    	ClientesDao clientes = new ClientesDao();
    	clientes.openCurrentSessionwithTransaction();
    	
    	clientes.persist(c1);
    	   	
    	clientes.closeCurrentSessionwithTransaction();
    	System.out.println("*** Fin inserción ***");
		
    	
    }
}
