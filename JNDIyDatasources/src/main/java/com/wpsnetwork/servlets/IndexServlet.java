package com.wpsnetwork.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.wpsnetwork.entidades.Cliente;
import com.wpsnetwork.utils.Utilidades;


public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
		
		out.println("Entrando en el servlet IndexServlet");
		
		Number valor = null;
		
		try {

			valor = Utilidades.getNumeroJNDI("valor3");
		
			out.println("El valor delido del JINDI es: " + valor);
			
//			Cliente c = new Cliente ("Pepito") ;
//			
//			try {
//				
//				Utilidades.setCliente("cliente1", c);
//			}
//			catch ( NamingException e ) {
//				Cliente c1 = new Cliente ("Pepito");
//				Utilidades.setCliente("cliente1" , c1) ;
//				
//			}
			
//			out.println( Utilidades.getCliente("cliente1").toString()  );
			
			DataSource ds = Utilidades.getDataSource() ;
			
			try ( Connection con = ds.getConnection() ) {
				
				Statement comando = con.createStatement();
				ResultSet rs = comando.executeQuery("select * from libro") ;
				
				while( (rs.next()) ){
					
					out.println( rs.getString("titulo"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ServletException(e) ; // encapsulamos en una ServletException
			}
			
		
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			out.println("Sale por la exception: " + e.getMessage() );
			// e.printStackTrace();
			throw new ServletException(e) ; // encapsulamos en una ServletException
		}
		
		out.close(); 
		
	}
	

}
