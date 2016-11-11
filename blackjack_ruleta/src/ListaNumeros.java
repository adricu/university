package org.proyecto.packclases;

import java.util.ArrayList;

public class ListaNumeros {
	
	//atributos
	
	private static ListaNumeros miListaNumeros = new ListaNumeros();
	private ArrayList<Numero> lista;
	
	//constructora
	private ListaNumeros() {
		this.lista = new ArrayList<Numero>();
		int i = 0;
		Numero num;
		while (i<=36){
			num = new Numero(i);
			this.lista.add(num);
			i++;
		}
		
		
	}
	
	//getter

	public static ListaNumeros getListaNumeros() {
		return miListaNumeros;
	}
	
	private ArrayList<Numero> getLista() {
		return lista;
	}
	
	//metodos
	
	public Numero sacarNumeroAlAzar(){
		int randomAux;
		randomAux = (int) Math.ceil(Math.random()*37)-1;
		return this.getLista().get(randomAux);
		
	}	

}
