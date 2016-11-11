package org.proyecto.packclases;

import junit.framework.TestCase;
import org.junit.Test;

public class ApuestaBlackJackTest extends TestCase {

	ApuestaBlackJack aux1;
	public void setUp() {
		Jugador.getJugador().realizarApuestaBlackJack(14.0);
		aux1 = new ApuestaBlackJack(50.0);
	}
	
	public void tearDown(){
		Jugador.getJugador().setDinero(0.0);
	}
	
	
	@Test
	public void testGetCantidad() {
		double cantidad = 14;
		assertEquals(cantidad,Jugador.getJugador().getApBlackjack().getCantidad());
	}

	@Test
	public void testGetCuota() {
		double cuota = 2;
		assertEquals(cuota,aux1.getCuota());
	}

	@Test
	public void testApuestaBlackJack() {
		ApuestaBlackJack aux1 = new ApuestaBlackJack(5);
		assertNotNull(aux1);
		
		ApuestaBlackJack aux2 = new ApuestaBlackJack(95);
		assertNotNull(aux2);
	}

	@Test
	public void testCobrarApuesta() {
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(21); //como la suma de la banca es 0, la banca pierde
		assertEquals(100.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().resetearMano();
		Jugador.getJugador().setDinero(0);
		Banca.getBanca().pedirCarta(false);
		aux1.cobrarApuesta(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());
		Jugador.getJugador().setDinero(0);
			
	}

}