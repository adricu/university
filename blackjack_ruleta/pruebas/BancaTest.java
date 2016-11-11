package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.proyecto.packclases.Carta.Palo;

public class BancaTest extends TestCase {


	@Before
	public void setUp() throws Exception {
		Jugador.getJugador().resetearMano();
		Banca.getBanca().resetearMano();
	}

	@Test
	public void testGetBanca() {
		assertNotNull(Banca.getBanca());
	}

	@Test
	public void testPedirCarta() {
		Banca.getBanca().resetearMano();
		//con 1 carta 
		Carta c1 = Banca.getBanca().pedirCarta(false); //me devuelve un objeto que no es null, anade ese objeto a la mano
													   //y no muestra nada por pantalla (false)
		assertNotNull(c1);
		
		Carta c2 = Banca.getBanca().getCartaDeLaMano(0);
		
		assertEquals(c1.getPalo(),c2.getPalo());
		assertEquals(c1.getNumCarta(),c2.getNumCarta());
		assertEquals(c1.getColor(),c2.getColor());
		
		//con 2 cartas en la mano
		c1 = Banca.getBanca().pedirCarta(false);
		c2 = Banca.getBanca().getCartaDeLaMano(1);
		assertEquals(c1.getPalo(),c2.getPalo());
		assertEquals(c1.getNumCarta(),c2.getNumCarta());
		assertEquals(c1.getColor(),c2.getColor());
	}

	
	/**Lo que hace este metodo es: si el jugador no se ha pasado y la suma de la banca es inferior a 17, pide otra carta.
	 * De otro modo se plantara */
	@Test
	public void testConsiderarJugada() {
		Jugador.getJugador().anadirCartaMano(new Carta(Palo.CORAZONES,1));
		Jugador.getJugador().anadirCartaMano(new Carta(Palo.CORAZONES,11));
		int jugJugador = Jugador.getJugador().sumaMano();
		
		Banca.getBanca().considerarJugada(jugJugador);
		assertTrue(Banca.getBanca().sumaMano() >= 16);
		assertTrue(Banca.getBanca().tamanoMano() > 1);
		
		Banca.getBanca().resetearMano();
		Banca.getBanca().considerarJugada(22);
		assertTrue(Banca.getBanca().tamanoMano() == 0);
		
		
		
		
	}

}
