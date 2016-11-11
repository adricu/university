package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;
import org.proyecto.packclases.Numero.ADocena;

public class DocenaTest extends TestCase{


	@After
	public void tearDown() throws Exception {
		Jugador.getJugador().setDinero(0.0);
	}

	@Test
	public void testComprobarSiGanada() {
		Docena aux1 = new Docena(1,ADocena.PRIMERA);
		assertTrue(aux1.comprobarSiGanada(12));
				
		assertFalse(aux1.comprobarSiGanada(0));
		
		assertTrue(aux1.comprobarSiGanada(1));
		
		Docena aux2 = new Docena(34,ADocena.SEGUNDA);
		assertTrue(aux2.comprobarSiGanada(13));
		
		assertTrue(aux2.comprobarSiGanada(24));
		
		assertFalse(aux2.comprobarSiGanada(3));
		
		Docena aux3 = new Docena(12,ADocena.TERCERA);
		assertTrue(aux3.comprobarSiGanada(25));
		
		assertTrue(aux3.comprobarSiGanada(36));
		
		assertTrue(aux3.comprobarSiGanada(27));
		
		Docena aux5 = new Docena(10,ADocena.CERO);
		assertTrue(aux5.comprobarSiGanada(0));
		
	}

	@Test
	public void testCobrarApuesta() {
		Docena aux1 = new Docena(50,ADocena.PRIMERA);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(1);
		assertEquals(150.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());
	}

	@Test
	public void testDocena() {
		Docena aux1 = new Docena(10,ADocena.PRIMERA);
		assertNotNull(aux1);
		
		Docena aux2 = new Docena(1,ADocena.SEGUNDA);
		assertNotNull(aux2);
	}

	@Test
	public void testGetNumDocena() {
		Docena aux1 = new Docena(5,ADocena.PRIMERA);
		assertEquals(ADocena.PRIMERA,aux1.getNumDocena());
	}

	@Test
	public void testGetCuota() {
		Docena aux1 = new Docena(50,ADocena.PRIMERA);
		assertEquals(3.0,aux1.getCuota());
	}

}

