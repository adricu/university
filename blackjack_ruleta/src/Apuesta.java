package org.proyecto.packclases;

public abstract class Apuesta {
	
	//atributos
	protected double cantidad;
	protected double cuota;

	
	//constructora
	protected Apuesta(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	//getters
	public double getCuota() {
		return cuota;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	//metodos
	protected abstract boolean comprobarSiGanada(int num);

	public void cobrarApuesta(int numero){
		if (this.comprobarSiGanada(numero)){
			Jugador.getJugador().setDinero(Jugador.getJugador().getDinero()+ getCuota()*this.getCantidad());
		}
		
	}
	//para arreglarlo copiar este codigo en toas las apuestas y poner este abstracto.

	
}
