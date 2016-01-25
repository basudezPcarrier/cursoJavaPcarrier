package com.wpsnetwork.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wpsnetwork.entidades.Cliente;

public class ClienteTest {
	
	
	private static Cliente cliente ;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// solo se llama una sola vez, al inicial el conjunto de test
		// p.e. sirve para crear objetos necesarios para el test
		System.out.println("Empiezo los test");
		cliente = null ;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// solo se lama una vez, al finalizar el conjunto de test
		// p.e. para cerrar ficheros o librar memoria
		cliente = null ;
		System.out.println("Termino los test");
	}

	@Before
	public void setUp() throws Exception {
		// se llama antes de cada test
		
		/* En el ejemplo partimos de un objeto conocido que sera 
		 * el que utilicemos para testear
		 * 
		 * */
		
		cliente = new Cliente (1 , "Paco" , 30) ;
	}

	@After
	public void tearDown() throws Exception {
		// se llama despues de cada test
	}

	@Test
	public void testGetId() {
		
		assertEquals("Error en get Id", 1, cliente.getId());
		
	}

	@Test
	public void testSetId() {
		
		cliente.setId(10); ;
		assertEquals("Error en set Id", 1000, cliente.getId());
		
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		cliente.setNombre("Oyeeee"); ;
		assertEquals("Error en set nombre", "Oyeeee", cliente.getNombre());
	}

	@Test
	public void testGetEdad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEdad() {
		fail("Not yet implemented");
	}
	
	
	// testeando el constructor...vamos a mirar que los haya puesto bien
	@Test
	public void testClienteIntStringInt() {
		int codigo = cliente.getId() ;
		int edad = cliente.getEdad() ;
		String nombre = cliente.getNombre() ;
		
		assertTrue("Fallo en el constructor con parametros", codigo == 1 );
		
				
	}

}
