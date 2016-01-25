package com.wpsnetwork.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wpsnetwork.entidades.Operaciones;

public class OperacionesTest {

	@Test
	public void testSuma() {
		int r = Operaciones.suma(1 , 2) ;
		assertEquals("Suma Falla", 3 , 3);
	}
	

}
