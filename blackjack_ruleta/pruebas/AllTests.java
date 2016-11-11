package org.proyecto.packclases;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(FaltaOPasaTest.class);
		suite.addTestSuite(JugadorTest.class);
		suite.addTestSuite(BarajaTest.class);
		suite.addTestSuite(ManoTest.class);
		suite.addTestSuite(NumeroTest.class);
		suite.addTestSuite(ParOImparTest.class);
		suite.addTestSuite(CartaTest.class);
		suite.addTestSuite(DocenaTest.class);
		suite.addTestSuite(ListaApuestasTest.class);
		suite.addTestSuite(ApuestaBlackJackTest.class);
		suite.addTestSuite(ListaNumerosTest.class);
		suite.addTestSuite(RojoONegroTest.class);
		suite.addTestSuite(AUnNumeroTest.class);
		suite.addTestSuite(BancaTest.class);
		suite.addTestSuite(ColumnaTest.class);
		//$JUnit-END$
		return suite;
	}

}
