package org.proyecto.packclases;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AUnNumeroTest extends TestCase{

	AUnNumero aux1;
	AUnNumero aux2;
	AUnNumero aux3;
	Numero num;
	
	@Before
	public void setUp() throws Exception {
		aux1 = new AUnNumero(3, 3);
		aux2 = new AUnNumero(3, 0);
		aux3 = new AUnNumero(10,1);
	}

	@After
	public void tearDown() throws Exception {
		Jugador.getJugador().setDinero(0.0);
	}

	@Test
	public void testComprobarSiGanada() {
		AUnNumero aux1 = new AUnNumero(10,3);
		assertTrue(aux1.comprobarSiGanada(3));
		
		AUnNumero aux2 = new AUnNumero(10,2);
		assertTrue(aux2.comprobarSiGanada(2));
		
		AUnNumero aux3 = new AUnNumero(10,1);
		assertTrue(aux3.comprobarSiGanada(1));
	}

	@Test
	public void testCobrarApuesta() {
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(3);
		assertEquals(108.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());
	}

	@Test
	public void testAUnNumero() {
		assertNotNull(aux1);
		assertNotNull(aux2);
	}

	@Test
	public void testGetCuota() {
		
		assertEquals(36.0,aux1.getCuota());
	}

	@Test
	public void testGetNumero() {
		assertEquals(3,aux1.getNumero());
		assertEquals(0,aux2.getNumero());
	}

}