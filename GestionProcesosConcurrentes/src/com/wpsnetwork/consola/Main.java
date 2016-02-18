package com.wpsnetwork.consola;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
	
	// variables para CountDownLaunch
	
	private static CountDownLatch latch = new CountDownLatch(2) ;
	private static CyclicBarrier barrera = new CyclicBarrier(3) ;
	
	private static Future<Integer> resultado1 ; 
	private static Future<Integer> resultado2 ; 
	private static Future<Integer> resultado3 ; 
	private static Future<Integer> resultado4 ; 
	
	static private Callable <Integer> tarea1 = () -> {
		Thread.sleep(2000) ; // esperamos 2 segundos
		int valor = new Random().nextInt() ;
		latch.countDown(); // desbloquear un elemento del latch (estamos quitando 1 al contador interno del latch)
		System.out.println("Tarea 1: " + valor );
		return valor ;
	} ;
	
	static private Callable <Integer> tarea2 = () -> {
		Thread.sleep(3000) ; // esperamos 3 segundos
		int valor = new Random().nextInt() ;
		latch.countDown(); // desbloquear un elemento del latch (estamos quitando 1 al contador interno del latch)
		System.out.println("Tarea 2: " + valor );
		return valor ;
	} ;
	
	static private Callable <Integer> tarea3 = () -> {
		Thread.sleep(6000) ; // esperamos 3 segundos
		int valor = new Random().nextInt() ;
		// aqui hemos quitado el CountDownLatch y vamos a utilizar el ciclicBarrier
		
		barrera.await() ; // decrementa el valor interno el CyclicBarrier
		
		System.out.println("Tarea 3: " + valor );
		return valor ;
	} ;
	
	// esta es la que va a hacer la suma de 1 y 2
	
	static private Callable <Integer> tarea4 = () -> {
		
		// espera a que las tareas 1 y 2 acaben
		// 		OJO!! 	en general no sé que son las tareas 1 y 2, simplemente esta esperando a que la
		// 				variable latch llegue a cero
		
		latch.await(); // espera a que las tareas 1 y 2 acaben  
		
		int v1 = resultado1.get() ; // obtener el restultado de la tarea 1
		int v2 = resultado2.get() ; // obtener el restultado de la tarea 2
		
		int valor = v1 + v2 ;
		System.out.println("Tarea 4: " + valor );
		
		barrera.await(); // disnimuye el cyclicBarrier  

		return valor ;
	} ;

	static private Callable <Integer> tarea5 = () -> {
		
		barrera.await(); // espera a que las tareas 4 y 3 terminen  
		
		int v1 = resultado3.get() ; // obtener el restultado de la tarea 3
		int v2 = resultado4.get() ; // obtener el restultado de la tarea 4
		
		int valor = v1 + v2 ;
		System.out.println("Tarea 5: " + valor );
		
		return valor ;
	} ;	
	
	// fin de variables para CountDownLaunch
	
	
	public static void main(String[] args) {
		
		try {
			
			semaforo.acquire();

			// semaforo.acquire(); 	// se para porque estamos bloqueados y por tanto no puede obtener el bloqueo 
						            // si en el constructor del semaforo le digo que sean 5 en vez de 1 p.e., 
									// entonces si podriamos hacerlo
			
			// mi trozo de codigo a ejecutar
			
			
			
			// liberar el semaforo
			
			semaforo.release();
			
			// ejecutar el ejemplo del CountDownLatch
			
			ExecutorService pool = Executors.newFixedThreadPool(5) ;
			resultado1 = pool.submit(tarea1) ;
			resultado2 = pool.submit(tarea2) ;
			resultado3 = pool.submit(tarea3) ;
			resultado4 = pool.submit(tarea4) ;
			
			Future<Integer>  resultado5 = pool.submit(tarea5) ;
			
			System.out.println("Final");
			// in ejecutar el ejemplo del CountDownLatch
		
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
		
		
		// ejemplo CountDownLaunch
		
		System.out.println("****** Ejemplo CountDownLaunch");
		
	}

}
