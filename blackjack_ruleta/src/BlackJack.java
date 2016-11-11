package org.proyecto.packclases;

import java.util.Scanner;

public class BlackJack{

public static void main (String[] args){
	
	System.out.println("BLACKJACK");
	//reglas del juego
	imprimirReglasDelJuego();
	
	//EJECUCION DEL JUEGO
	mainGrande(args);
	
	//se pregunta si se quiere volver a la seleccion de juego. Si se responde que no el programa acaba
	String stringAux = Jugar.preguntaDeSiNo("¿Desea volver al casino?");
	if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
		System.out.println("");				
		System.out.println("");

		//se llama a este para que no se reinicie el dinero que tiene el jugador. Si se llama al Jugar.main, el dinero se resetearia a 100
		Jugar.mainGrande(args, Jugador.getJugador().getDinero());
	}
	
}

private static void mainGrande(String[] args){
	//variables auxiliares
	String stringAux;
	double cuantoApuesta = 0;
	double dineroInicial = Jugador.getJugador().getDinero();
	
//pregunta de cuanto se quiere apostar,se realiza la apuesta si las condiciones se cumplen.
//Y comprueba si se ha hecho la reduccion del dinero al Jugador
	String sTexto = "asdf";
	boolean seHaHechoLaReduccion = false;
	while(!seHaHechoLaReduccion || !Jugar.esNumerico(sTexto)){ 	//mientras no sea numerico,pregunta
		
		System.out.println("Introduzca la cantidad que desea apostar");
		Scanner reader = new Scanner(System.in);
		sTexto = reader.next();
		if(Jugar.esNumerico(sTexto)){
			cuantoApuesta = (double) Integer.parseInt(sTexto);
			if(cuantoApuesta < 0){
				sTexto = "asdf";
				System.out.println("Valor incorrecto. Introduzca un valor numerico mayor o igual que 0");
				
			}
			else{
			//realizacion de la apuesta
			Jugador.getJugador().realizarApuestaBlackJack(cuantoApuesta);
			seHaHechoLaReduccion = Jugador.getJugador().reducirDinero(cuantoApuesta);
			}
		}
		else{
			System.out.println("Valor incorrecto. Introduzca un valor numerico mayor o igual que 0");
		}
	}
		
	System.out.println("");
	
	//inicio del juego
	if(Baraja.getBaraja().cuantasQuedan() < 30){
		Baraja.getBaraja().resetearBaraja();
	}
	Baraja.getBaraja().barajear();
	System.out.println("Repartiendo cartas");
	System.out.println("");
	
	System.out.println("Cartas del jugador");
		Jugador.getJugador().pedirCarta(true);
		Jugador.getJugador().pedirCarta(true);
		
		System.out.println("");
		
	System.out.println("Cartas de la banca");
		Banca.getBanca().pedirCarta(false);
		Banca.getBanca().pedirCarta(true);
		System.out.println("");
		
		boolean salir = false;
		while(!salir){
			//Pregunta al jugador haber si quiere otra carta mediante el programa que esta en la clase Main, si se responde q no se sale del while
			
			stringAux = Jugar.preguntaDeSiNo("Desea otra carta?. Introduzca si o no ");
			
			
			if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
				Jugador.getJugador().pedirCarta(true);
				System.out.println("Suma: "+Jugador.getJugador().sumaMano());
				System.out.println("");
			}
			else{
				salir = true;
			}
			
			//si el jugador se ha pasado tambien se sale y se ha perdido
			if(Jugador.getJugador().sumaMano()>21){
				salir = true;
			}	
		}
		//se efectua la suma de la mano del jugador
		int jugJugador = Jugador.getJugador().sumaMano() ;
		Banca.getBanca().considerarJugada(jugJugador);
		
		// se ensenan las cartas de la banca por pantalla
		System.out.println("Cartas de la banca:");
		Banca.getBanca().imprimirMano();
		System.out.println("");
		
		//se hace la comprobacion de quien ha ganado. Si gana el jugador se cobra la apuesta
		Jugador.getJugador().getApBlackjack().cobrarApuesta(jugJugador);
		double ganancia = Jugador.getJugador().getDinero()-dineroInicial;
		if(ganancia > 0){
			System.out.println("Has ganado "+ (Jugador.getJugador().getDinero()-dineroInicial));
		}
		System.out.println("");
		System.out.println("Por lo tanto tienes "+Jugador.getJugador().getDinero()+" €");
		
		// se pregunta aver si se quiere jugar otra vez, manteniendo las ganancias o las peridads
		stringAux = Jugar.preguntaDeSiNo("¿Jugar otra partida?");
		if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
			System.out.println("");				
			System.out.println("");
			
			// se vacia las manos de la banca y la del jugador
			Jugador.getJugador().resetearMano();
			Banca.getBanca().resetearMano();
			
			//reinicio del programa (recursivo)
			mainGrande(args);
			
		}
		else{
			System.out.println("Gracias por jugar");
			// se vacian las manos de la banca y la del jugador
			Jugador.getJugador().resetearMano();
			Banca.getBanca().resetearMano();
		}

}

private static void imprimirReglasDelJuego() {
	String stringAux;
	stringAux = Jugar.preguntaDeSiNo("¿Desea ver las reglas del juego?. Introduzca Si (s) o No (n) ");
	
	
	if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
		System.out.println("La banca reparte 2 cartas a cada jugador, (valores: as = 1 u 11, figuras = 10,");
		System.out.println("numŽricas su valor natural) el jugador tiene la posibilidad de plantarse (quedarse");
		System.out.println("con las cartas que tiene) o pedir carta, sin pasarse del 21 ya que pierde autom‡ticamente;");
		System.out.println("gana finalmente el que tenga el nœmero m‡s alto, cercano al 21, o saque un blackjack.");
		System.out.println("En caso de empate, gana la banca.");
	}
	System.out.println("");
}


}
