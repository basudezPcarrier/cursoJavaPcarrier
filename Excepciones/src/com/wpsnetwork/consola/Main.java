package com.wpsnetwork.consola;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Inicio");
		
		
		/*  excepcion de tipo runtime
		 * 		int x = 10/0 ;
		 * 		el no se queja al compilar,tenemos que tratarlo nosotros si queremos
		 * 		si no, saltara el error al metodo que ha llevado 
		 * 
		 * para cazar la excepcion se mete en un bloque try catch
		 * 
		 * 	en los catch hay que poner todas las excepciones expresamente que queremos tratar
		 * 
		 *	
		 * OJO!! el orden correcto de poner los catch es de mas especifico a mas general
		 *       porque va intentanto uno a uno cada tipo de catch y ya no mira los siguientes  
		 *
		 *  hay un bloque opcional que es el finally
		 *  	
		 *  	se ejecuta siempre tanto si hay error como si no
		 *		p.e. en el try estamos abriendo un fichero, y en el finally nos aseguramos de cerrarlo
		 *
		 *		OJO!! si en el codigo tenemos un RETURN, primero se haría el finally y luego el RETURN
		 *
		 *		también se puede poner cualquier cosa en el finally (incluso en los catch) como por 
		 *		ejemplo registrar errores, llamar a otros metodos, etc etc
		 *
		 *
		 * a partir de la 7, se puede hacer try( abrir fichero ) y crear un objeto de una clase 
		 * 	en el caso del ejemplo de abrir fichero, nos crearia el finally directamente cerrnadolo
		 * 
		 * a partir de la 7, se permite cazar en el catch mas de una excepcion
		 * 		catch ( miExcepcion1 | miExcepcion2){ // do something}
		 *
		 * */
		
		try{
			int x = 10/0 ;
			System.out.println("Paso 1"); 
		}
		catch(ArithmeticException e) {
			// do something
			System.out.println("Error ArithmenticException ini");
			// e.printStackTrace();
			System.out.println("Error ArithmenticException fin");
		}
		catch( IndexOutOfBoundsException e ){
			System.out.println("Error IndexOutOfBoundsException");
		}
		catch (Exception e) {
			System.out.println("Error Exception");
		}
		finally{
			System.out.println("Estoy en el finally"); 
		}
		
		System.out.println("Fin 1er ejemplo");
		
		System.out.println("Inicio 2n ejemplo");
		
		boolean continuar ;
		int opcion = -1 ; // hay que declararla 
		do{
			continuar = false ;
			// mostrar el menu
			
			System.out.println("1. Opcion 1");
			System.out.println("2. Opcion 2");
			System.out.println("3. Opcion 3");
			System.out.println("4. Opcion 4");
			System.out.println("Salir");
			
			try{
				opcion = leerTeclado() ;
			}
			catch (NumeroNoValidoException e){
				continuar =true ;
			}
			
			
		} while (continuar) ;
		
		// debe ser static prque el main es static tambien y solo puede ejecutar metodos estaticos
		
		System.out.println("Hemos salido y seleccionado " + opcion );

		System.out.println("Fin");
		
	}
	
	/* para lanzar la excepcion que yo quiera debo indicarlo en la firma del metodo
	 * 
	 * como la he definido de la calse Exception, estoy obligado a tratar la excepcion con un try catch 
	 * si no el compilador se queja
	 * 
	 * 
	 * */
	
	private static int leerTeclado() throws NumeroNoValidoException{
		Scanner teclado = new Scanner(System.in) ;
		String linea = teclado.nextLine() ;
		int valor = Integer.parseInt(linea);
		
		if ( valor < 1 | valor > 4 ) throw new NumeroNoValidoException("La opción no es valida") ;
		
		
		return valor ;
	}
	
}
