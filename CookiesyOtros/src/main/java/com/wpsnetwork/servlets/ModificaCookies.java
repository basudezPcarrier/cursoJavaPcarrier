package com.wpsnetwork.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificaCookies
 */
public class ModificaCookies extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*
 * 		PrintWriter out = response.getWriter() ;
		
		Cookie cookies = new Cookie("Color", request.getParameter("colorFondo")) ;
		
		response.addCookie( cookies );
		
		out.println("Cookie modificada");
		
		out.close();

 * */

		Cookie cookies = new Cookie("Color", request.getParameter("colorFondo")) ;
		
		response.addCookie( cookies );
		
		// redireccionamos al m
		response.sendRedirect( response.encodeRedirectURL("index.html"));
		
		
	}

}
