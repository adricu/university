package org.proyecto.packclases;



import junit.framework.TestCase;


import org.proyecto.packclases.Carta.Palo;

public class ManoTest extends TestCase {
	
	Mano mano1;
	Carta carta1;
	Carta carta2;
	
	public void setUp()
	{
		mano1 = new Mano();
		carta1 = new Carta(Palo.DIAMANTES, 1);
		carta2 = new Carta(Palo.DIAMANTES, 12);
	}

	public void tearDown() 
	{
		mano1 = null;
		carta1 = null;
	}

	public void testAnadirCarta() {
		mano1.anadirCarta(carta1);
		mano1.anadirCarta(carta2);
		assertEquals(2,mano1.getTamano());
		mano1.anadirCarta(carta1);
		mano1.anadirCarta(carta2);
		assertEquals(2,mano1.getTamano()); // no deja anadir cartas que ya estan en la mano (asi lo muestra la consola)
		
	}
	
	public void testSuma() {
		mano1.anadirCarta(carta1);
		assertEquals(11,mano1.suma());
		
		Carta carta2 = new Carta(Palo.PICAS, 1);
		mano1.anadirCarta(carta2);
		assertEquals(12,mano1.suma());
		
		Carta carta3 = new Carta(Palo.PICAS, 5);
		mano1.anadirCarta(carta3);
		assertEquals(17,mano1.suma());
		
		Carta carta4 = new Carta(Palo.DIAMANTES, 4);
		mano1.anadirCarta(carta4);
		assertEquals(21,mano1.suma());
		
		//critico con 4 ases
		mano1.resetearMano();
		mano1.anadirCarta(new Carta(Palo.CORAZONES,1));
		assertEquals(11,mano1.suma());
		mano1.anadirCarta(new Carta(Palo.DIAMANTES,1));
		assertEquals(12,mano1.suma());
		mano1.anadirCarta(new Carta(Palo.TREBOLES,1));
		assertEquals(13,mano1.suma());
		mano1.anadirCarta(new Carta(Palo.PICAS,1));
		assertEquals(14,mano1.suma());
	}

}
