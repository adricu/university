package org.proyecto.packclases;

public class Banca {
	//atributos
	private static Banca miBanca = new Banca();
	private Mano mano;
	
	
	//constructora
	private Banca() {
		this.mano = new Mano();

	}

	//getters
	private Mano getMano() {
		return mano;
	}
	
	public static Banca getBanca() {
		return miBanca;
	}

	
	//metodos
	/**Pide una carta y se le anade a la mano. */
	public Carta pedirCarta(boolean ensenar){
		Carta cartaAux = null;
		cartaAux = Baraja.getBaraja().darCarta();
		this.getMano().anadirCarta(cartaAux);
		if(ensenar){
			cartaAux.escribirNombre();
		}
		
		return cartaAux;
		
	}
	
	public void considerarJugada(int jugJugador) {
		if (jugJugador <= 21){
			int manoBanca = this.getMano().suma();
			while(manoBanca <= 16){
				Banca.getBanca().pedirCarta(false);
				manoBanca = this.getMano().suma();
				
			}
		}
	}
	
	public int sumaMano(){
		return this.getMano().suma();
	}
	
	public void resetearMano(){
		this.getMano().resetearMano();
	}
	
	public void imprimirMano(){
		this.getMano().imprimirMano();
	}
	
	//para pruebas y grafica
	public int tamanoMano(){
		return this.getMano().getTamano();
	}
	
	public Carta getCartaDeLaMano(int num){
		return this.getMano().getCarta(num);
	}
		
}
