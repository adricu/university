package org.proyecto.packclases;

import org.proyecto.packclases.Numero.ADocena;

public class Docena extends Apuesta {

	//atributos
	private ADocena numDocena;

	//constructora
	public Docena(double cantidad,ADocena pNumDocena) {
		super(cantidad);
		this.numDocena = pNumDocena;
		cuota = 3;
	}

	//getters 
	public ADocena getNumDocena() {
		return numDocena;
	}
	
	//metodos
	protected boolean comprobarSiGanada(int numero) {
		boolean rdo = false;
		Numero num = new Numero(numero);
		if(this.getNumDocena() == num.calcularDocena()){
			rdo = true;
		}	
		return rdo;
	}
}
