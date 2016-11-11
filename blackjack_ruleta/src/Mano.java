package org.proyecto.packclases;

import java.util.ArrayList;
import java.util.Iterator;

public class Mano {
	
	//atributos
	private ArrayList <Carta> mano;
	
	//constructora
	public Mano(){
		this.mano = new ArrayList<Carta>();
	}
	
	//getters
	private ArrayList<Carta> getMano() {
		return mano;
	}
	
	private Iterator<Carta> getIterador(){
		return this.getMano().iterator();
	}
	
	//metodos
	
	public void anadirCarta(Carta pCarta){
		if (!this.getMano().contains(pCarta)){
			this.getMano().add(pCarta);
		}
		else{
			System.out.println("No puede haber dos cartas iguales, y menos anadirla a la mano");
		}
	}
	
	
	
	public int suma(){
		int numeroAses = 0;
		Carta cart = null;
		int suma = 0;
		Iterator<Carta> itr = this.getIterador();
		
		while (itr.hasNext()){
			cart = itr.next();
			suma = suma + cart.getValor();
			if(cart.getNumCarta() == 1){
				numeroAses++;
				
			}
		}
		while (suma > 21 && numeroAses > 0){   /**si quedan ases y la suma es mayor q 21,
		 										que le reste 10 (asi solo suma 1) */
			suma = suma - 10;
			numeroAses--;
			
		}
		
		return suma ;
	}
	
	public void imprimirMano() {
		Iterator<Carta> itr = this.getMano().iterator();
		Carta cart = null;
		
		while (itr.hasNext()){
			cart = itr.next();
			cart.escribirNombre();
		}
		
	}
	
	public void resetearMano(){
		this.getMano().clear();
	}
	
	//para pruebas y grafica
	public int getTamano(){
		return this.getMano().size();
	}
	
	//para pruebas	
	public Carta getCarta(int pos){
		return this.getMano().get(pos);
	}

}
