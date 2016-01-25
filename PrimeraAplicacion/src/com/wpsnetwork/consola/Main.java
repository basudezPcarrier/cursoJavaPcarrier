// lo primero que se pone es el paquete
package com.wpsnetwork.consola;

// importar el paquete entidades
// si ese paquete tuviera mas paquetes dentro asociados, no vale con el *, jhay que
// hacer el import por cada subpaquete
import com.wpsnetwork.entidades.*;
// tambien puedo importar solo la clases que me interesen
// de la forma import com.wpsnetwork.entidades.coche; donde coche representa la clase que quiero importar

// este es un comentario de una sola linea

/* este
 * es
 * un
 * comentario
 * de
 * varias
 * filas
 * */

/* def de la clase: 
 *    modificador de la clase
 *		public 			--> no restringido (cualquiera la puede ver)
 *		protected 		--> relativo a herencia
 *  	.... (default) 	--> accesible desde el paquete
 *		private 		--> solo se puede acceder a metodos de la clase desde la propia clase
 *  + class 			--> es el literal que indica que es una clase
 *  + nombre de la clase
 * */

// no se puede poner dos clases publicas en un mismo fichero
// 		en general, un fichero suele ser una clase


public class Main {
	
	/* def del metodo
	 *    modificador del metodo 	--> hay varios...
	 *  + indicador de retorno 		--> que devuelve el metodo
	 *  + firma del metodo 			--> nombre del metedo + argumentos
	 *  void
	 * */
	// para se llamada la clase, necesita un metodo main
	public static void main(String[] args) {
		
		System.out.println("Hola, mundo");
		
		/* Tipos de datos numericos
		 * 
		 *    	byte 		-> (-128, 127)  	-> 2^8
		 *    	short 		-> (-32768,32767) 	-> 2^16
		 *    	int 		-> (-20000000, ) 	-> 2^32
		 *    	long 		-> (-40000000000) 	-> 2^64
		 * 
		 * */
		
		// ejemplo de variable local y de asignacion
		int numero1 = 5 ;
		int numero2 ;
		numero2 = numero1 / 3 ; // hace la conversion a int y devolvera 1
		
		System.out.println ("Valor de numero1 " + numero1) ;
		System.out.println ("Valor de numero2 " + numero2) ;

		byte valorByte ;
		valorByte = (byte) numero1 ;  // valorByte = numero1 se queja de la conversion, asi que hacemos la conversion (cast) que es indicar el tipo de dato al que queremos convertir
		System.out.println ("Valor de valorByte " + valorByte ) ;
		
		/* Tipos de datos reales
		 * 		float 		--> la diff entre los dos es el numero de decimales
		 * 		double 		--> 
		 * */
		
		double pi = 3.1416 ;
		// si no pongo la f al final, el compilador entiende que es un double y se queja. Igual pasa con los long (en ese caso se pondria una l)
		float piFloat = 3.14f ; 
		
		// se puede poner un _ como separador de miles para facilitar la lectura del codigo
		int numeroLargo = 2_000_000 ; 
		
		/* tipo de datos caracter
		 * 		char 	--> un unico caracter -> es UNICODE 2^16
		 * 
		 * La clase String
		 * 		es una cadena de char sin tamaño (ira creciendo conforme la necesitemos)
		 * 		es inmutable  --> crea un puntero a memoria. Cuando creamos un objeto nuevo -incluso con el mismo nombre- el objeto nuevo apunta a un nuevo espacio en memoria y el espacio ocupado por el antiguo se queda ahi ocupado 
		 * 
		 * */
		
		String cadena = "Esta es mi cadena" ;
		System.out.println("Valor Cadena: " + cadena);
		System.out.println("longitud  Cadena: " + cadena.length() );
		
		// crea un objeto nuevo en memoria y deja relleno el espacio en memoria ocupado por el antiguo objeto cadena 
		cadena = cadena.toUpperCase()  ; 
		// crea un nuevo objeto en memoria --> en este momento tenemos 3 espacios en memoria 
		String cadena2= cadena.toLowerCase()  ; 
		
		cadena = cadena + " modificada" ;
		
		System.out.println("Valor Cadena: " + cadena);
		System.out.println("longitud  Cadena: " + cadena.length());
		
		/* Tipo de datos booleanos
		 * 		boolean 	--> true / false
		 * */
		
		boolean bVar =  true;
		System.out.println (bVar) ;
		
		/* Sentencias de control
		 *		
		 *		IF:
		 *			
		 *			// lo do something en cualquier caso (if, for, while...)...si es solo una cosa, no hacen falta las llaves 
		 *			if (condicion){
		 *          	// do something si la condicion es valida
		 *          } esle if {
		 *          	// do something si la condicion es valida
		 *          } esle {
		 *          	// do something else
		 *          }
		 * 		SWITCH:
		 * 			
		 * 			switch(valor) {
		 * 				case valor1:
		 * 					do something
		 * 					break (es opcional) --> lo habitual es que cada caso tenga su propio break
		 * 				case valor2:
		 * 					do something
		 * 					break (es opcional)
		 * 				case valor3:
		 * 					do something
		 * 					break (es opcional)
		 * 				default: (es opcional)
		 * 					do something
		 * 					--> OJO!! si no exite break en los case...siempre se metera despues en el default
		 *  			
		 *  		}
		 * 		
		 * 		IF TERCIARIO --> es una forma simplidicada de hacer un if (los do something deben tener solo una linea)
		 * 				
		 * 			condicion?instruccion si cierto:instruccion si false
		 * 
		 * 		
		 * */
		
		boolean condicion = true ;
		// ejemplo de if con un solo so something
		if (condicion)
			System.out.println(condicion) ;
		else
			System.out.println("Entra por el else") ;
			
		// ejemplo de if con mas de un something principal pero solo un do something else
		if (condicion) {
			condicion = false ;
			System.out.println(condicion) ;
		} else
			System.out.println("Entra por el else") ;
			
		// ejemplo de if con mas de un something principal pero solo un do something else
		if (condicion) {
			condicion = false ;
			System.out.println(condicion) ;
		} else if (3 == 5)
			System.out.println("Entra por el else if") ;			
		else
			System.out.println("Entra por el else") ;
		
		// ejemplo switch
		
		int valor = 2 ;
		switch(valor) {
		case 1:
			System.out.println("Primer caso ");
			break ;
		case 2:
			System.out.println("Segundo caso ");
		// si el case por el que entre no tiene break y tenemos puesto un default, entonces entrara por el default tambien
		default:
			System.out.println("Entra por el default");
		}
		
		// ejemplo de if terciario
		
		boolean resultado = (2==3)?true:false;
		
		/* Sentencias iterativas
		 * 	
		 * 		WHILE
		 * 			
		 * 			while condicion{
		 * 				do something mientras la condicion sea cierta
		 * 
		 * 				break (condicional) -->
		 * 				continue (condicional) --> salta a la  
		 * 
		 * 			}
		 * 
		 * 		FOR
		 * 		
		 * 			for(inicializacion;condicion;incremento){
		 * 				do something
		 * 			}
		 *
		 *		DO WHILE
		 *			
		 *			los primero que se hace es el do y luego se evalua el while
		 *			de esta forma nos aseguramos de que el do something se ejecuta al menos una vez			
		 *
		 *			do{
		 *				do something
		 * 			}
		 * 			while (condicion)
		 * 
		 *		FOR ampliado para arrarys o colecciones  
		 * 			for(declaracion variable : elemento a recorrer)
		 *				do something
		 *
		 * 
		 * */
		
		/*
		int i = 0 ;
		while (i < 4) {
			System.out.println("Entra en el bucle con valor " + i) ;
			if (i==1) continue ;
			if (i==2) break ;
			System.out.println("Valor de i = " + i) ;
			i = i + 1 ;
		}
		*/
		
		// ejemplo while
		int i = 0 ;
		while(i<9){
			System.out.println(i++); // --> i++ evalua para devolver el resultado y luego incrementa
		}
		
		// ejemplo for
		System.out.println("Ejemplo for");
		// int j = 0 ; --> poniendo eso y la j directamente en el for no funciona 
		for (int j = 0 ;j<10;j++)
			System.out.println(j);

		// ejemplo do while
		/*
		System.out.println("Ejemplo do while");
		int opcion = 1 ;
		do{
			System.out.println("1. Opcion 1");
			System.out.println("2. Opcion 2");
			opcion = 0 ;
		}	
		while (opcion == 0) ;
		*/
		
		/* ARRAYS
		 * 
		 * 
		 * */
		
		System.out.println("Ejemplos de arrarys basicos");
		
		int[] array1D = new int[3] ;
		int[][] array2D = new int[3][2] ;
		
		// para que cada uno de los arrays tuviera una longitud distinta, en la def no podemos poner la longitud
		int[][] array = {{1,2},{2,3,10,11},{4,5}} ;
		
		System.out.println(array[0][1]);
		
		// ejemplo para cambiar 
		
		System.out.println("Ejemplos de recorrer basico");
		
		for(int x = 0 ; x<array.length;x++){
			for ( int y=0;y<array[x].length;y++){
				System.out.println(array[x][y]);
			}
		}
			
		
		// ejemplo for ampliado -- para recorrer arrays
		/*
		 * 		en el primer for define una variable a, que es un array
		 *	 	en el segundo for recorre el array a
		 * 		
		 * 		no necesita controlar los indices de los arrays
		 * */
		
		System.out.println("Ejemplos de recorrer for amplicado");
		for (int[] a : array){
			for(int b : a ){
				System.out.println(b) ;
			}
		}

		System.out.println("Ejemplos de recorrer for amplicado 2");
		int[] arrayA = {1,2,3} ;
		for (int a : arrayA){
			System.out.println(a) ;
		}
		
		// empezamos con clases ty objetos
		
		System.out.println("Empezamos con ejemplo de entidades");
		
		// por defecto solo ve las clases de su paquete. Pare poder acceder a otras hay 
		// que hacer el import del paquete donde estan las clases que queremos utilizar
		Coche c = new Coche();
		
		// podemos construir el coche creando la variable con el contructor 
		// por defecto (supuesto que no lo hayamos creado expresamente 
		// aun) y luego ir asignando cada una de sus atributos
		Coche c1 = new Coche();
		c1.setMarca("Peugot");
		c1.setMatricula("XYZ");
		c1.setPuertas("4");
		c1.setModelo("205");
		
		// podemos contruir el coche llamando al constructor adecuado, con o sin parametros
		Coche c2 = new Coche() ;
		Coche c3 = new Coche("AAA","Otra marca","Otro modelo","2") ;
		
		System.out.println("Marca del coche c1: " + c1.getMarca());
		System.out.println("Marca del coche c2: " + c2.getMarca());
		System.out.println("Marca del coche c3: " + c3.getMarca());
		
	}
}
