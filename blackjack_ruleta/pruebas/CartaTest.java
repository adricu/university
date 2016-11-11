package org.proyecto.packclases;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.proyecto.packclases.Carta.Palo;
import org.proyecto.packclases.Carta.Color;

public class CartaTest extends TestCase {
	
	Carta c1;
	Carta c2;
	Carta c3;
	Carta c4;
	Carta c5;

	@Before
	public void setUp() throws Exception {
		c1 = new Carta(Palo.PICAS,1);
		c2 = new Carta(Palo.CORAZONES,11);
		c3 = new Carta(Palo.DIAMANTES,12);
		c4 = new Carta(Palo.TREBOLES,13);
		c5 = new Carta(Palo.TREBOLES,7);
		
	}

	@Test
	public void testCarta() {
		Carta aux1 = new Carta(Palo.PICAS,5);
		assertNotNull(aux1);
	}

	@Test
	public void testGetPalo() {
		assertEquals(Palo.PICAS,c1.getPalo());
		assertEquals(Palo.CORAZONES,c2.getPalo());
		assertEquals(Palo.DIAMANTES,c3.getPalo());
		assertEquals(Palo.TREBOLES,c4.getPalo());
	}

	@Test
	public void testGetColor() {
		assertEquals(Color.NEGRO,c1.getColor());
		assertEquals(Color.ROJO,c2.getColor());
		assertEquals(Color.ROJO,c3.getColor());
		assertEquals(Color.NEGRO,c4.getColor());
	}

	@Test
	public void testGetNumCarta() {
		assertEquals(1,c1.getNumCarta());
		assertEquals(11,c2.getNumCarta());
		assertEquals(12,c3.getNumCarta());
		assertEquals(13,c4.getNumCarta());
		assertEquals(7,c5.getNumCarta());
	}

	@Test
	public void testEscribirNombre() {
		c1.escribirNombre();//se comprueba por pantalla que es A de picas negro
		c2.escribirNombre();//se comprueba por pantalla que es J de corazones rojo
		c3.escribirNombre();//se comprueba por pantalla que es Q de diamantes rojo
		c4.escribirNombre();//se comprueba por pantalla que es K de treboles negro
		c5.escribirNombre();//se comprueba por pantalla que es 7 de treboles y negro
	}

	@Test
	public void testGetValor() {
		
		assertEquals(11,c1.getValor()); // siempre devolvera 11 (AS), aunque puede cambiar su valor si en la suma de la mano le conviene
		assertEquals(10,c2.getValor());
		assertEquals(10,c3.getValor());
		assertEquals(10,c4.getValor());
		assertEquals(7,c5.getValor());
	}

	
}