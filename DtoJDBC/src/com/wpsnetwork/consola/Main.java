package com.wpsnetwork.consola;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.wpsnetwork.dao.interfaces.Dao;
import com.wpsnetwork.dto.RepositorioClientesDto;
import com.wpsnetwork.dto.entidades.Cliente;
import com.wpsnetwork.dto.entidades.Pedido;

public class Main {

	public static void main(String[] args) {
		Dao<Cliente> clientes = new RepositorioClientesDto();
		
		try{
			
			List<Cliente> lista = clientes.getAll();
			System.out.println(lista);
			
			//Obtenemos el cliente 2
			Cliente c = clientes.get(2);
			c.getPedidos().add(new Pedido(5, LocalDateTime.now(), "Pedido cliente 2", c));
			clientes.update(c);
			
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}

}
