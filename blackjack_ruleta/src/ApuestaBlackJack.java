package org.proyecto.packclases;

public class ApuestaBlackJack extends Apuesta {
	
	//constructora
	public ApuestaBlackJack(double cantidad) {
		super(cantidad);
		cuota = 2;
	}
	
	//metodos
	protected boolean comprobarSiGanada(int jugJugador){
		boolean rdo = true;
		int jugBanca = Banca.getBanca().sumaMano();
		if(jugJugador > 21 || jugBanca <=21 && jugJugador <=21
				&& jugBanca >= jugJugador) {
			rdo = false;
			System.out.println("Has perdido. Tu suma de cartas era "+jugJugador);
		}		
		return rdo;
	}

}
