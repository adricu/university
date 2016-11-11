package org.proyecto.packclases;

public class Jugador {

	//atributos
	private static Jugador miJugador = new Jugador();
	private Mano mano;
	private ApuestaBlackJack apBlackjack;
	private double dinero;
	private ListaApuestas listaApuestas;
	
	


	//constructora
	private Jugador(){
		this.listaApuestas = new ListaApuestas();
		this.mano = new Mano();
		this.dinero = 0.0;
	}

	//getters y setter
	private Mano getMano() {
		return mano;
	}

	private ListaApuestas getListaDeApuestas() {
		return listaApuestas;
	}
	
	public static Jugador getJugador() {
		return miJugador;
	}

	public ApuestaBlackJack getApBlackjack() {
		return apBlackjack;
	}

	public double getDinero() {
		return dinero;
	}
	
	public void setDinero(double pDinero) {
		this.dinero = pDinero;
	}
	
	//metodos
	public void realizarApuestaBlackJack(double cantidad){
		this.apBlackjack = new ApuestaBlackJack(cantidad);
	}
	
	public boolean reducirDinero(double pReduccion){
		return this.getListaDeApuestas().reducirDineroJugador(pReduccion);
	}
	
	public void cobrarApuestas(Numero pNumeroPremiado){
		this.getListaDeApuestas().cobrarApuestas(pNumeroPremiado);
	}

	public void anadirApuesta(Apuesta pApuesta){
		this.getListaDeApuestas().anadirApuesta(pApuesta);
	}
	
	/**Pide una carta y se le anade a la mano. */
	public Carta pedirCarta(boolean ensenar){
		Carta cartaAux = null;
		cartaAux = Baraja.getBaraja().darCarta();
		this.getMano().anadirCarta(cartaAux);
		if(ensenar){
			cartaAux.escribirNombre();
		}
		//funcion debido a la grafica
		return cartaAux;
		}
	
	public void limpiarListaApuestas(){
		this.getListaDeApuestas().limpiarLista();
	}
	
	public int sumaMano(){
		return this.getMano().suma();
	}
	
	public void resetearMano(){
		this.getMano().resetearMano();
	}
	

	//para grafica, y tambien pruebas
	public int tamanoMano(){
		return this.getMano().getTamano();
	}
	
	//para pruebas
	public void anadirCartaMano(Carta cart){
		this.getMano().anadirCarta(cart);
	}
	
	public Carta getCartaDeLaMano(int num){
		return this.getMano().getCarta(num);
	}
	
	public int getNumeroDeApuestas(){
		return this.getListaDeApuestas().getTamano();
	}
	
}
