package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.Test;
import org.proyecto.packclases.Numero.PasaOFalta;

public class FaltaOPasaTest extends TestCase {

	@Test
	public void testFaltaOPasa() {
		FaltaOPasa aux1 = new FaltaOPasa(10,PasaOFalta.PASA);
		assertNotNull(aux1);
		
		FaltaOPasa aux2 = new FaltaOPasa(10,PasaOFalta.PASA);
		assertNotNull(aux2);
	}
	
	@Test
	public void testGetPasaOFalta() {
		FaltaOPasa aux1 = new FaltaOPasa(10,PasaOFalta.FALTA);
		assertEquals(aux1.getPasaOFalta(), PasaOFalta.FALTA);
	}
	
	@Test
	public void testGetCuota() {
		FaltaOPasa aux1 = new FaltaOPasa(10,PasaOFalta.PASA);
		assertEquals(2.0, aux1.getCuota());
	}
	
	@Test
	public void testComprobarSiGanada() {
		FaltaOPasa aux1 = new FaltaOPasa(10,PasaOFalta.FALTA);
		assertTrue(aux1.comprobarSiGanada(3));
		
		FaltaOPasa aux2 = new FaltaOPasa(10,PasaOFalta.PASA);
		assertTrue(aux2.comprobarSiGanada(25));
		
		FaltaOPasa aux3 = new FaltaOPasa(10,PasaOFalta.PASA);
		assertFalse(aux3.comprobarSiGanada(1));
	}

	@Test
	public void testCobrarApuesta() {
		FaltaOPasa aux1 = new FaltaOPasa(50,PasaOFalta.PASA);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(36);
		assertEquals(100.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());
		aux1 = new FaltaOPasa(50,PasaOFalta.FALTA);
		aux1.cobrarApuesta(1);
		assertEquals(100.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
		
	}


}