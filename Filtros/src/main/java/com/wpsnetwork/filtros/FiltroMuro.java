package com.wpsnetwork.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class FiltroMuro
 */
public class FiltroMuro implements Filter {

    public FiltroMuro() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		// redireccionamiento interno (el navegador no se entera del redireccionamiento) -> cuando es externo, sí que se entera el navegador
		// ademas, el interno permite acceder a carpetas del proyecto
		
		request.getRequestDispatcher("/pagNoDisponible.html").forward(request, response);
		
		// esto basicamente dice que se aplique el siguiente filtro y que cuando acabe vuelva al filtro actual
		// por eso es recomendable:
		//    * ponerlo en todos los filtros
		//    * ponerlo al final del doFilter

		chain.doFilter(request, response); 

	}

	public void destroy() {
	}

}
