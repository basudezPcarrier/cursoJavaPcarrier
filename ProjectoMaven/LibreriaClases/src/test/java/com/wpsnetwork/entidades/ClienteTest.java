package com.wpsnetwork.entidades;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClienteTest  {
	
	Cliente c = null ;

	@Before
	public void setUp() throws Exception {
		c = new Cliente (1 , "Pepe") ;
	}
	
	@Test
	public void testGetCodigo(){
		assertEquals("El getter del codigo falla " , 1 , c.getCodigo() );
	}

	@Test
	public void testSetCodigo(){
		c.setCodigo(2); 
		assertEquals("El getter del codigo falla " , 2 , c.getCodigo() );
	}
	
	@Test
	public void testGetNombre(){
		assertEquals("El getter del nombre falla " , "Pepe" , c.getNombre() );
	}

	@Test
	public void testsetNombre(){
		c.setNombre("Paco");
		assertEquals("El getter del nombre falla " , "Paco" , c.getNombre() );
	}
	
	
	
	
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//	
//	@After
//	public void tearDown() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
