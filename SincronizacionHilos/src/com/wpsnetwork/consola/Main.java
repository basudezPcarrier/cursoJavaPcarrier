package com.wpsnetwork.consola;

import org.omg.Messaging.SyncScopeHelper;

public class Main {

	private static Object bandera = new Object();  
	
	/* La clase Object tiene dos semaforos
	 * 		
	 * 		Como Objetc es la clase padre de todos los objectos, esos objetos 
	 * 		heredaran esos semaforos
	 * 
	 * 
	 * */
	
	
	public static void main(String[] args) throws InterruptedException {

		
		/* Hilos en paralelo e interacción entre ellos
		 * 
		 * 
		 * 
		 * */		

		// primer runnable y primer hilo

		Runnable tarea = () -> {
			
			for(int i = 0 ; i< 10 ; i++){
				
				
				// synchronized (bandera) { // en vez de un objeto "control", se puede sincronizar el elemento que ocasiona el problema, en nuestro caso el System.out
				synchronized (System.out) {
							escribir("Tarea 1: ");
					escribir( i + "\n");
				}
				
			}
			
		};
		
		new Thread(tarea).start();
		
		// creamos otro runnable y otro hilo
		
		Runnable tarea2 = () -> {
			
			for(int i = 0 ; i< 10 ; i++){
				
				// synchronized (bandera) {
				synchronized (System.out) {
					escribir("Tarea 2: ");
					escribir( i + "\n");
				}

			}
			
		};
		
		new Thread(tarea2).start();
		
		// hasta aqui (sin poner lo del sincronize), no tenemos control de los 
		// hilos. Si ejecutamos seguramednte se entremezclen algunps prints
		//
		// al meterle el sincronized, el primero que lo ejecute "bloquea" la bandera o elemento bloqueado
		// y ya no se pisan
		//
		// otra opcion es irnos al elemento bloquedado (en este caso el metodo "escribir" y marcarlos
		// como sincronized. 
		
		/* Recordar los metodos de cadena StringBuffer y StringBuilder
		 *		StringBuffer 	-> esta sincrnonizado
		 *		StringBuilder 	-> NO esta sincronizado 
		 * 
		 * */
		
		Thread hiloGuardarFichero = new Thread(
				
				() -> {
					
					try {
						Thread.sleep(5000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				);
		
		hiloGuardarFichero.start();
		System.out.println("Guardando fichero...");
		
		hiloGuardarFichero.join();  // el hilo principal se bloquea en este punto hasta que finaliza el hilo al que hemos hecho join
		
		System.out.println("Fichero guardado");
		

	}
	
	private synchronized static void escribir (String mensaje){
		System.out.print(mensaje);
		System.out.flush();
	}
	
}
