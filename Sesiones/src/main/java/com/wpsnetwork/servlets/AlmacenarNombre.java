package com.wpsnetwork.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlmacenarNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;

		String nombre = request.getParameter( "datoNombre") ; // el "nombre" es el name que hemos puestos al input del inedx.html
		session.setAttribute("Usuario", nombre);
		
		// para eliminar una sesion --> session.invalidate();
		
		
		
	}

}
