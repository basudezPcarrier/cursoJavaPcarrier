package com.wpsnetwork.filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


@WebFilter (
		
		filterName ="FiltroImagenes",
		urlPatterns = {"/imagenes/"} 
		)
public class FiltroImagenes implements Filter {

    public FiltroImagenes() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// moldeamos la request de entrada que es ServletResponse a HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request ;
			
		String[] rutas = req.getRequestURI().split("/") ;
		String nombreFichero = rutas[rutas.length -1 ] ;
		
		// pass the request along the filter chain
		// chain.doFilter(request, response);
		
//		request.getRequestDispatcher("/img/"+ nombreFichero).forward(request, response);
		
		// para añadir mas parametros al request, no podemos hacerlo directamente
		// debemos hacerlo con un wrapper
		// 		debemos tener una clase class ..... extends ServletRequest
		// 		utilizar la request original para mantenerla en la nueva de nuestra clase
		//
		// comento la linea anterior  request.getRequestDispatcher("/img/"+ nombreFichero).forward(request, response); para probar esto
		
		MiRequest mireq = new MiRequest( req, "imagen", nombreFichero ) ;
		
		request.getRequestDispatcher("/imagen.jsp").forward(mireq, response);
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public static class MiRequest extends HttpServletRequestWrapper {
		
		private final String nombreParam ;
		private final String valorParam ;
		
		public MiRequest(HttpServletRequest request, String nombre , String valor ) {
			super(request); // guarda la request original
			this.nombreParam = nombre ;
			this.valorParam = valor ;
		}

		@Override
		public String getParameter(String name) {
			
			if ( name.equals(nombreParam))
				return valorParam ;
			else
				return super.getParameter(name);
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			// TODO Auto-generated method stub
			return super.getParameterMap();
		}

		@Override
		public Enumeration<String> getParameterNames() {
			
			
			List<String> resultado = new ArrayList<String>() ;
			return null;
			
			
		}

		@Override
		public String[] getParameterValues(String name) {
			// TODO Auto-generated method stub
			return super.getParameterValues(name);
		}
		
		
		

	}

}

