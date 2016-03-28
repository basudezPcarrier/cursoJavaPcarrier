package com.wpsnetwork.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String initParam ;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 
		// para que nos los escriba, hay que devolverlo en el getWritter y concatenarle lo que queramos

		// getContextPath() -> ruta de la aplicacion --> en nuestro caso, /Servlets
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// getMethod() -> devuelve el tipo de petición (get, post, ...) --> en nuestro caso, GET
		response.getWriter().append("Metodo: "+request.getMethod()) ;
		
		*/
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter() ; 
		
		out.println("<html>");
		out.println("<body>");
		out.println("<strong>Mensaje desde el servidor</strong>");
		
		
		// leer el parametro de entrada recibido
		
		String codigoParam = request.getParameter("codigo") ;
		
		if ( codigoParam == null ) 
			codigoParam = "No existe el parámetro 'codigo'" ;
		out.println("<p>Código: "+codigoParam+"</p>");
		out.println("<p>Path: "+request.getPathInfo()+"</p>");
		out.println("<p>Url: "+request.getRequestURL()+"</p>");
		out.println("<p>Uri: "+request.getRequestURI()+"</p>");
		out.println("<p>Context: "+request.getContextPath()+"</p>");
		out.println("<p>Servlet Path: "+request.getServletPath()+"</p>");
		out.println("<p>Locale: "+request.getLocale()+"</p>");

		out.println("<p>Parametro inicial: "+ initParam+"</p>");

		out.println("</body>");
		out.println("</html>");
		
		// OJO!! hay que cerrar el canal! --> en ese momento es cuando ya se envia la respuesta
		
		out.close();
		
	}

	@Override
	public void init( ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init( config );
		
		initParam = config.getInitParameter("parametro") ;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
