package org.proyecto.packclases;

public class AUnNumero extends Apuesta {
	
	private int numero;
	
	//constructora
	public AUnNumero(double pCantidad, int pNumero) {
		super(pCantidad);
		this.numero = pNumero;
		cuota = 36;
	}
	
	//getter
	public int getNumero() {
		return numero;
	}

	protected boolean comprobarSiGanada(int numero) {
		boolean rdo = false;
		Numero num = new Numero(numero);
		
		if(this.getNumero() == num.getNum()){
			rdo = true;
		}
		return rdo;
	}
}
