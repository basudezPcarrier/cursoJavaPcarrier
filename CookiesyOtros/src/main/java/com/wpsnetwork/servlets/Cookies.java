package com.wpsnetwork.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
public class Cookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
		
		Cookie cookies[] = request.getCookies() ;

		out.println( "Prueba de escritura 2");
		
		if ( cookies != null ){
			
			for( Cookie c : cookies ) {
				
				out.println(c.getName() + ": " + c.getValue());
				
			}
			
		}
		
		out.close();
		
	}

}
