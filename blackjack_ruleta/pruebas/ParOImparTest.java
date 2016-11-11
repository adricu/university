package org.proyecto.packclases;

import junit.framework.TestCase;
import org.proyecto.packclases.Numero.ImparOPar;

public class ParOImparTest extends TestCase  {

	ParOImpar aux1;
	ParOImpar aux2;

	public void testComprobarSiGanada() {
		ParOImpar aux1 = new ParOImpar(0,ImparOPar.PAR);
		assertTrue(aux1.comprobarSiGanada(2));
	
		aux1 = new ParOImpar(10,ImparOPar.IMPAR);
		assertTrue(aux1.comprobarSiGanada(1));
		
		aux1 = new ParOImpar(10230,ImparOPar.CERO);
		assertTrue(aux1.comprobarSiGanada(0));
		
		aux1 = new ParOImpar(10230,ImparOPar.PAR);
		assertFalse(aux1.comprobarSiGanada(3));
		
		aux1 = new ParOImpar(10230,ImparOPar.IMPAR);
		assertFalse(aux1.comprobarSiGanada(4));
	}


	public void testCobrarApuesta() {
		aux1 = new ParOImpar(50,ImparOPar.IMPAR);
		Jugador.getJugador().setDinero(0);
		aux1.cobrarApuesta(31);
		assertEquals(100.0,Jugador.getJugador().getDinero());
		
		aux1 = new ParOImpar(50,ImparOPar.PAR);
		aux1.cobrarApuesta(30);
		
		aux1 = new ParOImpar(50,ImparOPar.PAR);
		aux1.cobrarApuesta(31);
		
		assertEquals(200.0,Jugador.getJugador().getDinero());
		
		Jugador.getJugador().setDinero(0);
		assertEquals(0.0,Jugador.getJugador().getDinero());	
	}


	public void testParOImpar() {
		ParOImpar aux1 = new ParOImpar(0,ImparOPar.PAR);
		assertNotNull(aux1);
	}


	public void testGetCuota() {
		ParOImpar aux1 = new ParOImpar(0,ImparOPar.PAR);
		double cuota = 2;
		assertEquals(cuota,aux1.getCuota());
	}


	public void testGetImparOPar() {
		ParOImpar aux1 = new ParOImpar(0,ImparOPar.PAR);
		assertEquals(ImparOPar.PAR,aux1.getImparOPar());
		
		aux1 = new ParOImpar(0,ImparOPar.IMPAR);
		assertEquals(ImparOPar.IMPAR,aux1.getImparOPar());
		
		aux1 = new ParOImpar(0,ImparOPar.CERO);
		assertEquals(ImparOPar.CERO,aux1.getImparOPar());
	}

}
