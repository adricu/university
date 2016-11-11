package org.proyecto.packclases;


import junit.framework.TestCase;
import org.junit.Test;

public class ListaNumerosTest extends TestCase {

	@Test
	public void testListaNumeros() {
		assertNotNull(ListaNumeros.getListaNumeros());

	}

	@Test
	public void testSacarNumeroAlAzar() {
		Numero num;
		int i =0;
		while(i < 300){
			num = ListaNumeros.getListaNumeros().sacarNumeroAlAzar();
			num.escribir();
			i++;
		}
		
	}

}
