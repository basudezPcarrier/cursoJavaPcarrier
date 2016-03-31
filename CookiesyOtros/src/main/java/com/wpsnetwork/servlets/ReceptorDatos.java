package com.wpsnetwork.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// poniendo las anotaciones, no hace alta entonces que este puesto en el web.xml

/*
<servlet-mapping>
<servlet-name>ReceptorDatos</servlet-name>
<url-pattern>/receptorDatos</url-pattern>
</servlet-mapping>
*/

@WebServlet(
			name ="ReceptorDatos" ,
			urlPatterns = { "/receptorDatos" }
		)
public class ReceptorDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter() ;
			
		// para utilizar con POST sí sirve esto puesto que llega como parametro
		// out.println("El resultado recibido es: " + request.getParameter("suma"));
		
		// para utilizar por AJAX, el dato viene en el cuerpo de la peticion
//		out.println( request.getReader().readLine() );
		
		// para miralo vamos a utilizar un log de java util parecido al log4j que se vera en la consola del eclipse
		Logger.getLogger(ReceptorDatos.class.getName()).log(Level.SEVERE, request.getReader().readLine() );
		
		// la  dif de hacerlo en ajax o en POST en nuestro sessionStorageResultado.html
		// es que hemos utilizado dos funciones javascript distintas: leerResultado y enviar
		
		out.close();
		
		
	}

}
