package org.proyecto.packclases;


import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarajaTest extends TestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Baraja.getBaraja().resetearBaraja();
	}

	@Before
	public void setUp() {
		Baraja.getBaraja().resetearBaraja();
		Baraja.getBaraja().barajear();
	}

	@After
	public void tearDown(){
		Baraja.getBaraja().resetearBaraja();
		Baraja.getBaraja().barajear();
	}

	@Test
	public void testBaraja() {
		assertNotNull(Baraja.getBaraja());
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 52);
	}


	@Test
	public void testDarCarta() {
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 51);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 47);
		
		
	}

	@Test
	public void testBarajear() {
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 52);
		assertFalse(Baraja.getBaraja().getCartaPorIndice(0).getNumCarta() == 1);  //hay veces que pueda dar fallo (ya que es random), pero lo normal es que no
		Baraja.getBaraja().barajear();
		assertFalse(Baraja.getBaraja().getCartaPorIndice(1).getNumCarta() == 2); //hay veces que pueda dar fallo (ya que es random), pero lo normal es que no
		
	}

	
	public void testResetearBaraja() {
		Baraja.getBaraja().resetearBaraja();
		assertTrue(Baraja.getBaraja().getCartaPorIndice(0).getNumCarta() == 1);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(1).getNumCarta() == 2);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(2).getNumCarta() == 3);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(3).getNumCarta() == 4);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(29).getNumCarta() == 4);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(51).getNumCarta() == 13);
		assertTrue(Baraja.getBaraja().cuantasQuedan() == 52);
		
	}
	
	public void testGetCartaPorIndice() {
		Baraja.getBaraja().resetearBaraja();
		assertTrue(Baraja.getBaraja().getCartaPorIndice(0).getNumCarta() == 1);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(1).getNumCarta() == 2);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(2).getNumCarta() == 3);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(3).getNumCarta() == 4);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(29).getNumCarta() == 4);
		assertTrue(Baraja.getBaraja().getCartaPorIndice(51).getNumCarta() == 13);
		
	}
	
	public void testCuantasQuedaN() {
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 51);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Baraja.getBaraja().cuantasQuedan(), 47);
		
		
	}
	
	
}
