package org.proyecto.packclases;

import org.proyecto.packclases.Numero.PasaOFalta;


public class FaltaOPasa extends Apuesta {

	//atributo
	private PasaOFalta pasaOFalta;
	
	//constructora
	public FaltaOPasa(double cantApuesta,PasaOFalta pTipo) {
		super(cantApuesta);
		this.pasaOFalta = pTipo;
		cuota = 2;
	}

	//getter
	public PasaOFalta getPasaOFalta() {
		return pasaOFalta;
	}
	
	
	//metodos
	protected boolean comprobarSiGanada(int numero){
		boolean rdo = false;
		Numero num = new Numero(numero);
		if(num.calcularPasaOFalta() == this.getPasaOFalta()){
			rdo = true;
		}
		return rdo;
	}
}
