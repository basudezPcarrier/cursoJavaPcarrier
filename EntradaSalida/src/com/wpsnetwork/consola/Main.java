package com.wpsnetwork.consola;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.print.attribute.standard.PrinterResolution;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		/* Acceso a bajo nivel con bytes
		 *  
		 * 
		 * */
		
		System.out.println("******** Ejemplo escribir fichero");
		
		Path fichero = Paths.get("ficheroBinario.txt") ;
		
		// crear un flujo de salida para escribir en el fichero
		//   -> 
		
		try {
			
			OutputStream out = new FileOutputStream( fichero.toFile()) ;
			
			out.write( new byte[]{'h','o','l','a'} ); // le pasamos caracteres zqui xq el caracter se puede convertir
			out.close(); // recordad que hay que cerrar estas cosas siempre!!
			
			System.out.println("Fichero escrito: " + fichero.getFileName() );
			
			// leer el fichero que acabamos de crear

			System.out.println("******** Ejemplo leer fichero");

			InputStream in = new FileInputStream( fichero.toFile()) ;
			
			byte[] arrayLeido = new byte[4] ;  // estamos haciendo un poco de trampa xq sabemos que tenemos 4 bytes
			in.read(arrayLeido) ;
			
			in.close(); // recordad que hay que cerrar estas cosas siempre!!

			System.out.println( "Resultado sin convertir los chars: " + Arrays.toString(arrayLeido));
			
			char[] arrayChars = new char[ arrayLeido.length ] ;
			
			for( int i = 0 ; i < arrayLeido.length ; i++ ){
				arrayChars[i] = (char) arrayLeido[i] ;
			}
			
			System.out.println( "Resultado tras convertir los chars: " + Arrays.toString(arrayChars));
			
			System.out.println("******** Ejemplo escribir fichero con FileOutputStream");
			
			// crear el fichero
			
			OutputStream out2 = new BufferedOutputStream( new FileOutputStream("ficheroBinarioLargo.txt")) ;
			
			// rellenar el ichero
			
			byte[] buffer = new byte[1024] ;
			Arrays.fill(buffer, (byte) 'a');
			
			for (int i = 0 ; i < 10 ; i++){
				out2.write(buffer, 0 , 1024);
			}
			
			// forzar el sistema operativo al disco haciendo un flush
			
			out2.flush(); 
			
			// cerrar el fichero
			out2.close();

			// System.out.println("Fichero escrito: " + ((Path) out2).getFileName() );
			
			System.out.println("******** Ejemplo leer fichero con FileInputStream");
						
			Path ficheroBinarioLargo = Paths.get("ficheroBinarioLargo.txt") ;
			InputStream in2 = new BufferedInputStream( new FileInputStream("ficheroBinarioLargo.txt")) ;
			
			// crear un array para luego poner ahi lo que hemos leido del fichero en la variable buffer
			
			byte[] bufferLeido = new byte[ (int) Files.size(ficheroBinarioLargo) ] ;
			
			// recorrer el buffer leido 
			
			int bytesAcumulados =0 ;
			int bytesLeidos ;
			
			while( (bytesLeidos = in2.read(buffer)) > 0 ){
				
				for(int i = 0 ; i < buffer.length ; i ++ ) {
					bufferLeido[bytesAcumulados + i] = buffer[i] ;
				}
				
				bytesAcumulados = bytesAcumulados + bytesLeidos ; 
				
			}

			char[] bufferChars = new char[ bufferLeido.length ] ;
			
			for( int i = 0 ; i < bufferLeido.length ; i++ ){
				bufferChars[i] = (char) bufferLeido[i] ;
			}
			
			System.out.println("Escribir el buffer leido: " + Arrays.toString(bufferChars));
			
			// cerrar el canal...
			
			in2.close(); 
			
			// Ejemplos con tipos primitivos a nivel de bytes 
			//
			// cuidado que vamos a ir enlanzando cosas 

			System.out.println("******** Ejemplo escribir con tipos primitivos a nivel de bytes");
			
			DataOutputStream out3 = new DataOutputStream( 
					                new BufferedOutputStream( 
					                new FileOutputStream( ficheroBinarioLargo.toString()))) ;
			
			out3.writeInt(5);
			out3.writeDouble(2.123);
			out3.writeUTF("cadena que escribo...") ;
			out3.flush();
			out3.close();
			
			System.out.println("******** Ejemplo leer con tipos primitivos a nivel de bytes");

			DataInputStream in3 = new DataInputStream( 
	                new BufferedInputStream( 
	                new FileInputStream( ficheroBinarioLargo.toString()))) ;

			System.out.println(in3.readInt());
			System.out.println(in3.readDouble());
			System.out.println(in3.readUTF()) ;
			
			in3.close();
			
			System.out.println("******** Ejemplo escribir a nivel de texto ");

			// escribir a nivel de texto
			
			Path ficheroCaracteres = Paths.get("ficheroCaracteres.txt" ) ; 
			
			PrintWriter out4 = new PrintWriter( new BufferedWriter( new FileWriter(ficheroCaracteres.toFile()))) ;
			
			out4.println("Cadena que estoy escribiendo");
			out4.println("Segunda cadena que estoy escribiendo más numero " + 2.012);
			
			out4.close();

			System.out.println("******** Ejemplo leer a nivel de texto ");

			// leer a nivel de texto
			
			BufferedReader in4 = new BufferedReader( new FileReader( ficheroCaracteres.toFile())) ;
			
//			System.out.println("Primera vez que llamo al readline: " + in4.readLine());
//			System.out.println("Segunda vez que llamo al readline: " + in4.readLine());
//			System.out.println("Tercera vez que llamo al readline: " + in4.readLine());
			
			// utilizar un bucle para leer
			
			String cadena;
			while( (cadena = in4.readLine()) !=null ){
				System.out.println(cadena);
			}
			
			in4.close(); 
			
			// trabajar con objets
			
			System.out.println("******** Ejemplo leer utilizando objetos -> ObjectInputStream");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // fichero hay que pasarlo a toFile porque es Path y FileOutputStream quiere un objeto File
		
	}

}
