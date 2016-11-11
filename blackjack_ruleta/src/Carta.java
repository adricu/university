package org.proyecto.packclases;

public class Carta {
	
	enum Palo {CORAZONES,DIAMANTES, PICAS,TREBOLES}
	enum Color {ROJO,NEGRO}
	
	//atributos
	private Palo palo;
	private int numCarta;
	private Color color;
	
	//constructora
	public Carta(Palo pPalo, int pNumCarta) {
		if (pNumCarta < 14){
			this.palo = pPalo;
			this.numCarta = pNumCarta;
			if (pPalo == Palo.CORAZONES || pPalo == Palo.DIAMANTES){
				this.color = Color.ROJO;
			}
			else{
				this.color = Color.NEGRO;
			}
		}
		else{
			System.out.println("El numero de carta indicado debe ser menor o igual que 13");
		}
	
	}
	

	//getters
	public Palo getPalo() {
		return palo;
	}
	
	public Color getColor() {
		return color;
	}

	public int getNumCarta() {
		return numCarta;
	}
	
	//metodos
	
	/**@post escribe en consola la carta
	 */
	public void escribirNombre() {   
		
		String nombreDeCarta = null ;
		if (this.getNumCarta() == 1){
			nombreDeCarta = "A";
		}
		else{
			if(this.getNumCarta() == 11){
				nombreDeCarta = "J";
			}
			else{
				if(this.getNumCarta() == 12){
					nombreDeCarta = "Q";
				}
				else{
					if(this.getNumCarta() == 13){
						nombreDeCarta = "K";
					}
				}
			}
		}
		
		if(nombreDeCarta != null){
		System.out.println(nombreDeCarta+" de "+ this.getPalo()+" "+this.getColor());
		}
		else {
			System.out.println(this.getNumCarta()+" de "+ this.getPalo()+" "+this.getColor());	
		}

	}
	
	public int getValor(){
		int valor = this.getNumCarta();
		if(this.getNumCarta() == 1){
			valor = 11;
		}
		else {
			if (this.getNumCarta() > 10){
				valor = 10;	
			}
		}
		return valor;
	}
	
	//probandocongrafica
	public String devolverNamePng(){
		String rdo = null;
		Palo p = this.getPalo();
		if(p == Palo.TREBOLES ){
			rdo = "C";	
		}
		else{
			if(p == Palo.CORAZONES){
				rdo = "H";
			}
			else{
				if(p == Palo.PICAS){
					rdo = "S";
				}
				else{
					if(p == Palo.DIAMANTES){
						rdo = "D";
					}
				}
			}
		}
		
		rdo = rdo+Integer.toString(this.getNumCarta())+".jpg";
		
		return rdo;
	}
}
