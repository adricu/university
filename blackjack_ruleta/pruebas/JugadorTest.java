package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.proyecto.packclases.Carta.Palo;
import org.proyecto.packclases.Numero.AColumna;
import org.proyecto.packclases.Numero.Color;
import org.proyecto.packclases.Numero.ImparOPar;

public class JugadorTest extends TestCase {
	
	Apuesta apu1;
	Apuesta apu2;
	Apuesta apu3;
	Apuesta apu4;
	Apuesta apu5;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Jugador.getJugador().limpiarListaApuestas();
		Jugador.getJugador().resetearMano();
	}

	@Before
	public void setUp() throws Exception {
		apu1 = new RojoONegro(10.0, Color.ROJO);
		apu2 = new ParOImpar(12.0, ImparOPar.IMPAR);
		apu3 = new Columna(1.0, AColumna.PRIMERA);
		apu4 = new AUnNumero(16.0, 0);
		apu5 = new RojoONegro(12.0, Color.NEGRO);
		Jugador.getJugador().realizarApuestaBlackJack(10.0);
	}

	@After
	public void tearDown(){
		Jugador.getJugador().limpiarListaApuestas();
		Jugador.getJugador().resetearMano();
	}


	@Test
	public void testJugador() {
		assertNotNull(Jugador.getJugador());
	}

	@Test
	public void testGetMano() {
		Jugador.getJugador().anadirCartaMano(new Carta(Palo.CORAZONES, 1));
		assertNotNull(Jugador.getJugador().getCartaDeLaMano(0));
	}

	@Test
	public void testPedirCarta() {
		assertEquals(Jugador.getJugador().tamanoMano(),0);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Jugador.getJugador().tamanoMano(),1);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Jugador.getJugador().tamanoMano(),2);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Jugador.getJugador().tamanoMano(),3);
		Jugador.getJugador().pedirCarta(true);
		assertEquals(Jugador.getJugador().tamanoMano(),4);

	}

	@Test
	public void testGetApBlackjack() {
		assertNotNull(Jugador.getJugador().getApBlackjack());
	}

	@Test
	public void testGetDinero() {
		Jugador.getJugador().setDinero(1.0);
		assertEquals(Jugador.getJugador().getDinero(), 1.0);
	}
	
	//a partir de aqui se puede copiar de la clase listaDeApuestaas
	@Test
	public void testReducirDinero() {
		boolean hechaONoReduccion;
		Jugador.getJugador().setDinero(100);
		Jugador.getJugador().anadirApuesta(apu1);
		Jugador.getJugador().anadirApuesta(apu2);
		hechaONoReduccion = Jugador.getJugador().reducirDinero(22.0);
		
		if(hechaONoReduccion){  //aqui va a ser true porque tiene el dinero suficiente
			assertEquals(Jugador.getJugador().getDinero(), 100.0 - 22.0);
		}
		else{
			assertFalse(Jugador.getJugador().getDinero() == 100.0 - 22.0);
		}
		Jugador.getJugador().anadirApuesta(new RojoONegro(200.0,Color.NEGRO));
		
		Jugador.getJugador().setDinero(100);
		hechaONoReduccion = Jugador.getJugador().reducirDinero(22.0);
		if(hechaONoReduccion){ //aqui va aser false porque no tiene tanto dinero
			assertEquals(Jugador.getJugador().getDinero(), 100.0 -22.0);
		}
		else{
			assertFalse(Jugador.getJugador().getDinero() == 100.0 - 22.0);
			assertEquals(Jugador.getJugador().getDinero(), 100.0);
		}	}

	@Test
	public void testCobrarApuestas() {
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),0);
		Jugador.getJugador().anadirApuesta(apu1);
		Jugador.getJugador().anadirApuesta(apu2);
		Jugador.getJugador().anadirApuesta(apu3);
		Jugador.getJugador().anadirApuesta(apu4);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(), 4);
		Jugador.getJugador().setDinero(0);
		Jugador.getJugador().cobrarApuestas(new Numero(1));
		assertEquals(Jugador.getJugador().getDinero(), (10.0+12.0) *2.0 + 1.0*3.0);
		Jugador.getJugador().setDinero(0);
		Jugador.getJugador().cobrarApuestas(new Numero(0));
		assertEquals(Jugador.getJugador().getDinero(), 16.0*36.0);
	}

	@Test
	public void testLimpiarListaApuestas() {
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),0);
		Jugador.getJugador().anadirApuesta(apu1);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),1);
		Jugador.getJugador().anadirApuesta(apu2);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),2);
		Jugador.getJugador().anadirApuesta(apu3);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),3);
		Jugador.getJugador().anadirApuesta(apu4);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),4);
		Jugador.getJugador().limpiarListaApuestas();
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),0);
	}

	@Test
	public void testAnadirApuesta() {
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),0);
		Jugador.getJugador().anadirApuesta(apu1);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),1);
		Jugador.getJugador().anadirApuesta(apu2);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),2);
		Jugador.getJugador().anadirApuesta(apu3);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),3);
		Jugador.getJugador().anadirApuesta(apu4);
		assertEquals(Jugador.getJugador().getNumeroDeApuestas(),4);
	}


}
