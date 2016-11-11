package org.proyecto.packclases;

import junit.framework.TestCase;

import org.proyecto.packclases.Numero.Color;


public class RojoONegroTest extends TestCase {
	
	RojoONegro aux1;
	RojoONegro aux2;
	
	public void testComprobarSiGanada() {
		aux1 = new RojoONegro(0,Color.NEGRO);
		assertTrue(aux1.comprobarSiGanada(2));
		
		aux1 = new RojoONegro(0,Color.ROJO);
		assertTrue(aux1.comprobarSiGanada(1));

		aux1 = new RojoONegro(0,Color.CERO);
		assertTrue(aux1.comprobarSiGanada(0));
	}

	public void testRojoONegro() {
		aux1 = new RojoONegro(0,Color.NEGRO);
		assertNotNull(aux1);
	}

	public void testGetColor() {
		aux1 = new RojoONegro(0,Color.NEGRO);
		assertEquals(Color.NEGRO,aux1.getColor());
		
		aux2 = new RojoONegro(0,Color.ROJO);
		assertEquals(Color.ROJO,aux2.getColor());
		
		RojoONegro aux3 = new RojoONegro(0,Color.CERO);
		assertEquals(Color.CERO,aux3.getColor());
	}

	public void testGetCuota() {
		aux1 = new RojoONegro(2,Color.NEGRO);
		assertEquals(2.0,aux1.getCuota());
	}

	public void testCobrarApuesta() {
		aux1 = new RojoONegro(50,Color.NEGRO);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(2);
		
		aux1 = new RojoONegro(50,Color.ROJO);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(1);
		assertEquals(100.0,Jugador.getJugador().getDinero());
		
		aux1 = new RojoONegro(50,Color.NEGRO);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(1);
		assertEquals(0.0,Jugador.getJugador().getDinero());
		
		
	}
}
