package org.proyecto.packclases;

import junit.framework.TestCase;

import org.proyecto.packclases.Numero.AColumna;
import org.proyecto.packclases.Numero.ImparOPar;
import org.proyecto.packclases.Numero.Color;
import org.proyecto.packclases.Numero.PasaOFalta;

public class NumeroTest extends TestCase {

	
	public void testNumero() {
		Numero num = new Numero(2);
		assertEquals(2,num.getNum());
		
		num = new Numero(0);
		assertEquals(0,num.getNum());
	}

	public void testGetNum() {
		Numero num1 = new Numero(2);
		assertEquals(2,num1.getNum());
		
		Numero num2 = new Numero(16);
		assertEquals(16,num2.getNum());
	}

	public void testEnNumeroPar() {
		Numero num = new Numero(3);
		assertEquals(ImparOPar.IMPAR,num.enNumeroPar());
		
		num = new Numero(6);
		assertEquals(ImparOPar.PAR,num.enNumeroPar());
		
		num = new Numero(0);
		assertEquals(ImparOPar.CERO,num.enNumeroPar());
	}
	
	public void testNumeroPar() {
		Numero num = new Numero(3);
		assertEquals(false,num.numeroPar());
		
		num = new Numero(0);
		assertEquals(true,num.numeroPar());
		
		num = new Numero(2);
		assertEquals(true,num.numeroPar());
	}

	public void testRojoONegro() {
		Numero num = new Numero(2);
		assertEquals(Color.NEGRO, num.rojoONegro());
		
		num = new Numero(3);
		assertEquals(Color.ROJO, num.rojoONegro());
		
		num = new Numero(0);
		assertEquals(Color.CERO, num.rojoONegro());
	}

	public void testCalcularPasaOFalta() {
		Numero num = new Numero(0);
		assertEquals(PasaOFalta.CERO,num.calcularPasaOFalta());
		
		num = new Numero(2);
		assertEquals(PasaOFalta.FALTA,num.calcularPasaOFalta());
		
		num = new Numero(20);
		assertEquals(PasaOFalta.PASA,num.calcularPasaOFalta());
	}
	
	public void testCalcularColumna() {
		Numero num = new Numero(0);
		assertEquals(AColumna.CERO,num.calcularColumna());
		
		num = new Numero(1);
		assertEquals(AColumna.PRIMERA,num.calcularColumna());
		
		num = new Numero(2);
		assertEquals(AColumna.SEGUNDA,num.calcularColumna());
		
		num = new Numero(3);
		assertEquals(AColumna.TERCERA,num.calcularColumna());
	}

	public void testEscribir() {
		Numero num = new Numero(0);
		System.out.println("Deberia escribir: 0, Cero, Cero, Cero, Columna Cero.");
		System.out.println("Y escribe: " );
		num.escribir();
		
		num = new Numero(1);
		System.out.println("Deberia escribir: 1, Rojo, Impar, Falta, Primera Columna.");
		System.out.println("Y escribe: " );
		num.escribir();
		
		num = new Numero(2);
		System.out.println("Deberia escribir: 2, Negro, Par, Falta, Segunda Columna.");
		System.out.println("Y escribe: " );
		num.escribir();
		
		num = new Numero(21);
		System.out.println("Deberia escribir: 21, Rojo, Impar, Pasa, Tercera Columna.");
		System.out.println("Y escribe: " );
		num.escribir();
	}

}
