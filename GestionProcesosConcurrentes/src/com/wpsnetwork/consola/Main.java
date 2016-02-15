package com.wpsnetwork.consola;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* 
 * Clase Semaphore
 * 		-> permite entrar dentro del bloqueo a un nº determinado de accesos
 * 
 * Clase CountDownLaunch
 * 		-> se bloquea hasta que no finaliza un nº determinado de hilos
 * 
 * Clase CyclicBarrier
 * 		-> sólo deja ejecutarse un nº determinado de tareas
 * 
 * Clase LuckSupport
 * 		-> es similar al Thread.notiffy y Thread.wait que vimos en el projecto de hilos --> park (bloquea) y unpark (desbloquea) 
 * 
 * 
 * */

public class Main {
	
	private static Semaphore semaforo = new Semaphore(1) ; // permite bloquear a la vez una cantidad de hilos  
	
	static int contador = 0 ;
	
	
	public static void main(String[] args) {
		
		try {
			
			semaforo.acquire();

			// semaforo.acquire(); 	// se para porque estamos bloqueados y por tanto no puede obtener el bloqueo 
						            // si en el constructor del semaforo le digo que sean 5 en vez de 1 p.e., 
									// entonces si podriamos hacerlo
			
			// mi trozo de codigo a ejecutar
			
			
			
			// liberar el semaforo
			
			semaforo.release();
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// LockSupport 
		
		System.out.println("Ejemplo de LockSupport");
		
		PriorityQueue<String> colaMensaje = new PriorityQueue<>(); 
		
		// hilo que vacia la cola
		Runnable tareaConsumidor = () -> {
			
			while (true){
				
				LockSupport.park(); // para la ejecucion del hilo hasta que se desbloquee
				
				System.out.println("Mensaje: " + colaMensaje.poll());
				
			}
			
		} ;
		
		Thread hiloConsumidor = new Thread( tareaConsumidor ) ;
		
		// hilo que llena la cola
		Runnable tareaProductora = () -> {
			
			colaMensaje.add("Este es el mensaje " + ++contador );
			LockSupport.unpark(hiloConsumidor); 
		} ;
		
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(tareaProductora, 0, 2, TimeUnit.SECONDS) ;
		
	}

}
