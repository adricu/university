package org.proyecto.packclases;

import org.proyecto.packclases.Numero.AColumna;

public class Columna extends Apuesta {

	//atributos
	private AColumna numColumna;

	//constructora
	public Columna(double cantidad,AColumna pNumColumna) {
		super(cantidad);
		this.numColumna = pNumColumna;
		cuota = 3;
	}

	//getters 
	public AColumna getNumColumna() {
		return numColumna;
	}
	
	//metodos
	protected boolean comprobarSiGanada(int numero) {
		boolean rdo = false;
		Numero num = new Numero(numero);
		if(this.getNumColumna() == num.calcularColumna()){
			rdo = true;
		}	
		return rdo;
	}
}
