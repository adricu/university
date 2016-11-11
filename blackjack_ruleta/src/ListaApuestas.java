package org.proyecto.packclases;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaApuestas {
	//atributos
	private ArrayList<Apuesta> lista;

	//constructora
	public ListaApuestas() {
		this.lista = new ArrayList<Apuesta>();
	}

	//getters
	private ArrayList<Apuesta> getLista() {
		return lista;
	}

	//metodos
	
	public void anadirApuesta(Apuesta ap){
		this.getLista().add(ap);
	}
	
	public int getTamano(){
		return this.getLista().size();
	}
	
	public void limpiarLista(){
		if(this.getTamano()>0){
			this.getLista().clear();	
		}
		else{
			System.out.println("La lista ya esta vacia");
		}
		
	}
	
	public double sumaDeLasApuestas(){
		double suma = 0;
		Apuesta apu = null;
		Iterator<Apuesta> itr = this.lista.iterator();
		
		while(itr.hasNext()){
			apu = itr.next();
			suma = suma + apu.getCantidad();
		}
		
		return suma;
	}
	
	public boolean reducirDineroJugador (double reduccion){		// rdo indica si se ha hecho la reduccion, y se lo manda a la Clase Ruleta
		boolean rdo = false;
		double dineroJugador = Jugador.getJugador().getDinero();
		
		if(reduccion <= dineroJugador ){
			Jugador.getJugador().setDinero(dineroJugador - reduccion );
			rdo = true;
		}
		else{
			System.out.println("El jugador no tiene tanto dinero");
		}
		  
		return rdo;
	}
		
	public void cobrarApuestas(Numero num){
		Iterator<Apuesta> itr = this.getLista().iterator();
		Apuesta apu = null;
		
		while(itr.hasNext()){
			apu = itr.next(); 
			apu.cobrarApuesta(num.getNum());
			
		}
	}
	

}
