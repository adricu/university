package org.proyecto.packclases;

import org.proyecto.packclases.Numero.Color;

public class RojoONegro extends Apuesta {
	
	//atributos
	private Color color;

	//constructora
	public RojoONegro(double cantidad, Color pColor) {
		super(cantidad);
		this.color = pColor;
		cuota = 2;
	}

	//getters 
	public Color getColor() {
		return color;
	}
	
	//metodos
	protected boolean comprobarSiGanada(int numero){
		boolean rdo = false;
		Numero num = new Numero(numero);
		
		if(num.rojoONegro() == this.getColor()){
			rdo = true;
		}
		return rdo;
	}
}
