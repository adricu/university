package org.proyecto.packclases;

import java.util.ArrayList;

import  org.proyecto.packclases.Carta.Palo;

public class Baraja {
	
	//atributos
	private static Baraja miBaraja = new Baraja();
	private ArrayList <Carta> cartas;
	
	//constructora
	
	/**Lo que se hace con esto es meter todas las cartas en la baraja, 1 por 1 y en orden. Al ser MAE
	 * solo lo hacemos una vez o cuando la reseteamos */
	private Baraja() {
		Carta carta = null;
		Palo palo = Palo.CORAZONES;
		int i = 1;
		this.cartas = new ArrayList<Carta>();
		
		while(palo != null){
			while(i != 14){
				carta = new Carta(palo , i);
				this.cartas.add(carta);
				i++;
				
			}
			i = 1;
			if (Palo.CORAZONES == palo){
				palo = Palo.DIAMANTES;
			}
			else {
				if (palo == Palo.DIAMANTES){
					palo = Palo.PICAS;
				}
				else {
					if(palo == Palo.PICAS){
						palo = Palo.TREBOLES;
						
					}
					else {
						palo = null;
					}
				}
			}
		}
		
	}
	
	//getters
	public static Baraja getBaraja(){
		return miBaraja;
	}
	
	private ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	//metodos
	
	/**cuando un jugador pide carta se ejecuta esto. Le manda la carta y la 
	elimina de la baraja*/
	public Carta darCarta(){
		Carta cartaAux = this.getCartas().get(0);
		this.getCartas().remove(0);
		
		return cartaAux;
	}
	
	/**  en principio tenemos una baraja ordenada y una baraja q esta vacia (barajAux) . 
	 * mientras quede al menos 1 carta saca un numero al azar entre 1 y el numero de cartas restantes.
	 * [  randomAux = (int) Math.ceil(Math.random()*numCartasRest)  -1;  ]   y le restas 1 pa q sea entre 0 y n¼carts-1
	 * entonces lo que vamos aciendo es cogiendo cartas al azar de la baraja q esta ordenada, y las vamos metiendo en la que esta vac’a. 
	 * Y as’ conseguimos una baraja desordenada */
	public void barajear() {
		ArrayList<Carta> barajAux = new ArrayList<Carta>();
		int randomAux;
		int numCartasRest = this.getCartas().size();
		Carta cartAux = null;
		
		
		while(numCartasRest > 0){
			randomAux = (int) Math.ceil(Math.random()*numCartasRest)-1;
			cartAux = this.getCartas().get(randomAux);
			
			barajAux.add(cartAux);
			this.getCartas().remove(randomAux);
			
			numCartasRest--;
		}	
		
		Baraja.getBaraja().cartas = barajAux;
		System.out.println("Barajeado");
		
		
		
	}
	
	/**tambien las ordena en plan 1,2,3,4,5,6...Q y por palos en el arrraylist*/
	public void resetearBaraja(){  
		Baraja.miBaraja = new Baraja();
	}
	
	public int cuantasQuedan(){
		return Baraja.getBaraja().getCartas().size();
	}
	
	//pruebas
	public Carta getCartaPorIndice(int indice){
		return this.getCartas().get(indice);
	}

	

}
