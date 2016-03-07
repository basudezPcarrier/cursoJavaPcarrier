package com.wpsnetwork.consola;

import java.util.ArrayList;

import com.wpsnetwork.dao.Clientes;
import com.wpsnetwork.entidades.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Clientes repoClientes = new Clientes () ;
    	
    	Cliente c1 = new Cliente(1100, "Cliente 1100", new ArrayList<>()) ;
    	
    	repoClientes.insert(c1);
    	
    	c1 = repoClientes.get( Cliente.class , 1100) ;
    	
    	System.out.println(c1);
    	
    	// modificar un cliente
    	
    	c1.setNombre("Nombre modificado");
    	
    	repoClientes.update(c1);
    	
    	c1 = repoClientes.get( Cliente.class, 1100) ;
    	System.out.println(c1);
    	
    	// eliminados
    	
    	repoClientes.delete( Cliente.class , 1100);
    	
    	System.out.println("Cliente Borrado");
    	
    	// encuentro cliente?
    	
    	c1 = repoClientes.get( Cliente.class, 1100) ;
    	System.out.println(c1);    	
    }
}
