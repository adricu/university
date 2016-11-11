package org.proyecto.packclases;

import org.proyecto.packclases.Numero.ImparOPar;

public class ParOImpar extends Apuesta {

	//atributos
	private ImparOPar imparOPar;
		
	//constructora
	public ParOImpar(double cantApuesta,ImparOPar pTipo) {
		super(cantApuesta);
		this.imparOPar = pTipo;
		cuota = 2;
	}

	//getter
	public ImparOPar getImparOPar() {
		return imparOPar;
	}
	
	//metodos
	protected boolean comprobarSiGanada(int numero) {
		boolean rdo = false;
		Numero num = new Numero(numero);
		if(num.enNumeroPar()== this.getImparOPar()){
			rdo = true;
		}
		return rdo;
	}
}
