package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;
import org.proyecto.packclases.Numero.AColumna;

public class ColumnaTest extends TestCase{


	@After
	public void tearDown() throws Exception {
		Jugador.getJugador().setDinero(0.0);
	}

	@Test
	public void testComprobarSiGanada() {
		
		Columna aux1 = new Columna(10,AColumna.PRIMERA);
		assertTrue(aux1.comprobarSiGanada(1));
		
		Columna aux2 = new Columna(10,AColumna.SEGUNDA);
		assertTrue(aux2.comprobarSiGanada(2));
		
		Columna aux3 = new Columna(10,AColumna.TERCERA);
		assertTrue(aux3.comprobarSiGanada(3));
		
		Columna aux4 = new Columna(10,AColumna.TERCERA);
		assertFalse(aux4.comprobarSiGanada(4));
		
		Columna aux5 = new Columna(10,AColumna.CERO);
		assertTrue(aux5.comprobarSiGanada(0));
		
	}

	@Test
	public void testCobrarApuesta() {
		Columna aux1 = new Columna(50,AColumna.PRIMERA);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(1);
		assertEquals(150.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());
	}

	@Test
	public void testColumna() {
		Columna aux1 = new Columna(10,AColumna.PRIMERA);
		assertNotNull(aux1);
		
		Columna aux2 = new Columna(1,AColumna.SEGUNDA);
		assertNotNull(aux2);
	}

	@Test
	public void testGetNumColumna() {
		Columna aux1 = new Columna(5,AColumna.PRIMERA);
		assertEquals(AColumna.PRIMERA,aux1.getNumColumna());
	}

	@Test
	public void testGetCuota() {
		Columna aux1 = new Columna(50,AColumna.PRIMERA);
		assertEquals(3.0,aux1.getCuota());
	}

}
