package com.wpsnetwork.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class Principal
 */
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter() ;
		
		Cookie cookies[] = request.getCookies() ;
		String color = "" ;
		
		for ( Cookie c : cookies ) {
			if (c.getName().equals("Color"))
				color = c.getValue() ;
		}
		
		out.println( "<!DOCTYPE html>" );
		out.println( "<html>" );
		out.println( "	<head>" );
		out.println( "		<meta charset='UTF-8'>" );
		out.println( "		<title>Selección de color</title>" );
		
		out.println( "		<style>" );
		out.println( "			body {" );
		out.println( "				background-color: " + color );
		out.println( "			}" );
		out.println( "		</style>" );
		
		out.println( "	</head>" );
		out.println( "	<body>" );
		out.println( "		<form action='/CookiesyOtros/modificaCookies'method='post'>" );
		out.println( "			<input type='color' name='colorFondo' value='" + color + "'/>" );
		out.println( "			<input type='submit' value='Cambiar Color'/>" );
		out.println( "		</form>" );
		out.println( "	Escribo por si acaso -> el valor de color es: " + color );
		out.println( "	</body>" );
		out.println( "</html>	" );
	
		out.close();
	}    

}
