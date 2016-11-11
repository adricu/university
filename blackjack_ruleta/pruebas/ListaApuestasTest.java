package org.proyecto.packclases;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.proyecto.packclases.Numero.AColumna;
import org.proyecto.packclases.Numero.ADocena;
import org.proyecto.packclases.Numero.Color;
import org.proyecto.packclases.Numero.ImparOPar;

public class ListaApuestasTest extends TestCase {

	Apuesta apu1;
	Apuesta apu2;
	Apuesta apu3;
	Apuesta apu4;
	Apuesta apu5;
	Apuesta apu6;
	ListaApuestas lista1;

	@Before
	public void setUp() throws Exception {
		lista1 = new ListaApuestas();
		apu1 = new RojoONegro(10.0, Color.ROJO);
		apu2 = new ParOImpar(12.0, ImparOPar.IMPAR);
		apu3 = new Columna(1.0, AColumna.PRIMERA);
		apu4 = new AUnNumero(16.0, 0);
		apu5 = new Docena(30, ADocena.SEGUNDA);
		apu6 = new Docena(30, ADocena.TERCERA);
	}

	@After
	public void tearDown(){
		Jugador.getJugador().setDinero(0.0);
		lista1.limpiarLista();
	}

	@Test
	public void testListaApuestas() {
		assertNotNull(lista1);
	}

	@Test
	public void testAnadirApuesta() {   //si se quiere se pueden anadir 2 apuestas iguales o tambien contrarias
		assertEquals(lista1.getTamano(),0);
		lista1.anadirApuesta(apu1);
		assertEquals(lista1.getTamano(),1);
		lista1.anadirApuesta(apu2);
		assertEquals(lista1.getTamano(),2);
		lista1.anadirApuesta(apu3);
		assertEquals(lista1.getTamano(),3);
		lista1.anadirApuesta(apu4);
		assertEquals(lista1.getTamano(),4);
		lista1.anadirApuesta(apu1);
		assertEquals(lista1.getTamano(),5);
	}

	@Test
	public void testGetTamano() {
		assertEquals(lista1.getTamano(),0);
		lista1.anadirApuesta(apu1);
		assertEquals(lista1.getTamano(),1);
		lista1.anadirApuesta(apu2);
		assertEquals(lista1.getTamano(),2);
		lista1.anadirApuesta(apu3);
		assertEquals(lista1.getTamano(),3);
		lista1.anadirApuesta(apu4);
		assertEquals(lista1.getTamano(),4);
	}

	@Test
	public void testLimpiarLista() {
		assertEquals(lista1.getTamano(),0);
		lista1.anadirApuesta(apu1);
		assertEquals(lista1.getTamano(),1);
		lista1.anadirApuesta(apu2);
		assertEquals(lista1.getTamano(),2);
		lista1.anadirApuesta(apu3);
		assertEquals(lista1.getTamano(),3);
		lista1.anadirApuesta(apu4);
		assertEquals(lista1.getTamano(),4);
		lista1.limpiarLista();
		assertEquals(lista1.getTamano(),0);
	}

	@Test
	public void testSumaDeLasApuestas() {
		assertEquals(lista1.getTamano(),0);
		lista1.anadirApuesta(apu1);
		lista1.anadirApuesta(apu2);
		assertEquals(lista1.sumaDeLasApuestas(),22.0);
		lista1.anadirApuesta(apu3);
		assertEquals(lista1.sumaDeLasApuestas(),23.0);
		lista1.anadirApuesta(apu4);
		assertEquals(lista1.sumaDeLasApuestas(),39.0);
	}

	@Test
	public void testReducirDineroJugador() {
		boolean hechaONoReduccion;
		Jugador.getJugador().setDinero(100);
		lista1.anadirApuesta(apu1);
		lista1.anadirApuesta(apu2);
		hechaONoReduccion = lista1.reducirDineroJugador(lista1.sumaDeLasApuestas());
		assertTrue(hechaONoReduccion);//aqui va a ser true porque tiene el dinero suficiente
		assertEquals(Jugador.getJugador().getDinero(), 78.0);
		
		lista1.anadirApuesta(new RojoONegro(200.0,Color.NEGRO));
		
		Jugador.getJugador().setDinero(100);
		hechaONoReduccion = lista1.reducirDineroJugador(lista1.sumaDeLasApuestas());
		assertFalse(hechaONoReduccion);//aqui va aser false porque no tiene tanto dinero y asi lo muestra por consola
		assertFalse(Jugador.getJugador().getDinero() == 100 - lista1.sumaDeLasApuestas());
		assertEquals(Jugador.getJugador().getDinero(), 100.0);
		
	}

	@Test
	public void testCobrarApuestas() {
		assertEquals(lista1.getTamano(),0);
		lista1.anadirApuesta(apu1);
		lista1.anadirApuesta(apu2);
		lista1.anadirApuesta(apu3);
		lista1.anadirApuesta(apu4);
		lista1.anadirApuesta(apu5);
		lista1.anadirApuesta(apu6);
		assertEquals(lista1.getTamano(),6);
		Jugador.getJugador().setDinero(0);
		lista1.cobrarApuestas(new Numero(1));
		assertEquals(Jugador.getJugador().getDinero(), (10.0+12.0) * 2.0 + 1.0 * 3.0);
		Jugador.getJugador().setDinero(0);
		lista1.cobrarApuestas(new Numero(0));
		assertEquals(Jugador.getJugador().getDinero(), 16.0*36.0);
	}

}
