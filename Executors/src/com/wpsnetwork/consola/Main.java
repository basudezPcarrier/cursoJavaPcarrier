package com.wpsnetwork.consola;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.* ;

import javax.xml.ws.Service;

import org.omg.SendingContext.RunTime;

public class Main {
	
	
	/* EN JDK 5 se metio una nueva API de concurrencia. Intrucude clases en el paquete java.util.concurrence
	 * 
	 * La calse principal es Executors y de esta obtnemos los diferentes elementos.
	 * 		Esta clase utiliza un patron factory
	 * 
	 * La interfaz Callable es el equivalente al Runnable. Este Callable encapsula codigo 
	 * 
	 * La interfaz ExecutoService permite lanzar hilos. Tiene diferentes clases que 
	 * implementan esta interfaz:
	 * 		* SingleThreadExecutor
	 * 			-> los hilo se ejecutan en el mismo orden que se van añadiendo
	 * 		* SingleThreadScheduledExecutor
	 * 			-> ejecuta una unica tarea con un retardo o intervalo definido
	 * 		* CatchedThreadPool
	 * 			-> es capaz de reutilizar hilos creados anteriormente si existe
	 * 		* FixedThreadPool
	 * 			-> ejecuta a la vez un nº determinado de hilos
	 * 		* ScheduledThreatPool 
	 * 			-> crea un pool para ejecutar tareas con un retardo o intervalo definido
	 * 	
	 * 
	 * Otras clases
	 * 		Semaphore
	 * 		CyclicBarrier
	 * 		CountDownLaunch
	 * 	
	 * 		--> las vamos a ver en otro "projeto" llamado GestionProcesosConcurrentes
	 * */
	
	public static void main(String[] args) throws InterruptedException {

		// crear un Callable
		
		Callable<Integer> tarea = () -> 67+34 ;
		
		Callable<Integer> tarea2 = Executors.callable( () -> System.out.println("Fin de tarea") , 67 /*resultado a devolver (me lo estoy inventado*/ ) ;
		
		// ejecutar sincronamente el codigo (sin hilos)
		
		try {
		
			System.out.println("Resultado de tarea: " + tarea.call() );
			System.out.println("Resultado de tarea2 " + tarea2.call() );

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// hasta ahora eran llamadas sincronas, vamos a ver como crear hilos con varios ejemplos mas
		
		// ejemplo 1: utilizar Thread y crear un Thread a traves de la factoria que nos da Executors

		System.out.println("***** Ejemplo con thread y factoria de executor");
		
		Thread t = Executors.defaultThreadFactory().newThread( () -> System.out.println("Desde un hilo")) ;
		
		t.start();
		
		// opcion con SingleThreadExecutor
		
		ExecutorService ste = Executors.newSingleThreadExecutor() ;
		
		Future<Integer> valor = ste.submit(tarea) ;
		
		try {
			
			System.out.println( valor.get() ); /* el hilo se para en este piunto hasta que la tarea finaliza y obtenemos el valor de retorno*/
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Ejemplo 2: FixedThreadPool

		System.out.println("***** Ejemplo FixedThreadPool");
		
		ExecutorService ftp = Executors.newFixedThreadPool(5) ; // executa 5 hilos al mismo tiempo
		
		
		for(int i = 0 ; i <20 ; i++) {
			
			final int id = i ;

			Callable<Object> tarea_nueva = () -> 
			{
				System.out.println("Tarea " + id ) ;
				Thread.sleep(2000); 
				return null ;
			} ;
			
			
			Future<Object> resultado = ftp.submit( tarea_nueva) ;

		}

		try {
			
			ftp.awaitTermination(4000, TimeUnit.MILLISECONDS) ; // espera a que acaben todas las tareas en el tiempo indicado
			
//			ftp.shutdown(); // no acepta mas hilos, pero los que se estan ejecutando los termina
//							// es un poco raro porque los hilos ya los hemos "metido" en el for
//							// asi que se siguen ejecutando todos los que ya teniamos (en teoria podriamos
//							// añadir mas hilos con el ftp.submit)
//			
			ftp.shutdownNow() ; // para inmediatamente (no sigue con los hilos que tenia ya metidos
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		System.out.println("Acaba la aplicación");
		
		/* 		System.out.println("Acaba la aplicación");
		 * 		
		 * 		Si comento el try-catch y pongo el Syso de arriba, pinta el "Acaba la aplicacion" cuando
		 * 		puede y va escribiendo lo de los hilos entre medias
		 * 
		 * 
		 * 		Si ponemos el try catch, asegura que espera los 4000 milisegundos para mostrar el 
		 *  	mensaje de que acaba la aplicacion
		 * 
		 * */
		
		// Ejemplo 3: SingleThreadScheduledExecutor

		System.out.println("***** Ejemplo SingleThreadScheduledExecutor");
		
		ScheduledExecutorService sts = Executors.newSingleThreadScheduledExecutor() ;
		
		// sts.scheduleWithFixedDelay(command /*un callable*/, initialDelay /*cuanto esperar para empezar*/, delay, unit)
		
		sts.scheduleAtFixedRate(
				() -> System.out.println(LocalTime.now()), 
				0, // tiempo de esperar para inicial la tarea 
				1, // cada cuando hay que ejecutar la tarea
				TimeUnit.SECONDS) ;
		
		sts.awaitTermination(5000, TimeUnit.MILLISECONDS) ;
		
		sts.shutdown();
		
		System.out.println("Acaba la aplicación");
		
		
		// 
		// Ejemplo x: lanzar muchas tareas a la vez

		System.out.println("***** Ejemplo lanzar muchas tareas a la vezr");
		
		
		List<Callable<Object>> tareas = new ArrayList<>();
		
		tareas.add( Executors.callable(
				() -> System.out.println("Hilo 1")
				, null
				)) ;
				
		tareas.add( Executors.callable(
				() -> System.out.println("Hilo 2")
				, null
				)) ;
				
		tareas.add( Executors.callable(
				() -> System.out.println("Hilo 3")
				, null
				)) ;
		
		// pondremos tantos hilos como cores tenga el equipo
		ExecutorService ejecutor = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors()) ;
		
		List<Future<Object>> resultados = ejecutor.invokeAll(tareas) ;
		
		ejecutor.shutdown();
		ejecutor.awaitTermination(1, TimeUnit.MINUTES) ; // hay que ponerlo despues del shutdown para que efectivametne 
		                                                 // pare al minuto o antes (si lo shilos han terminado)
		                                                 // si lo ponemos en el orden contrario, siempre esperará un minuto
														 // aunque los hilos hubieran terminado
		
		System.out.println("Acaba la aplicación");
				
	}

}
