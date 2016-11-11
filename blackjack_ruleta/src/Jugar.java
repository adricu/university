package org.proyecto.packclases;

import java.util.Scanner;


public class Jugar {
	
	/**Esta dividido en 2 para que el setDinero(100) no se haga cada
	 *  vez que llamemos al Main.main desde BlacJack o Ruleta */
	public static void main (String[] pArgs){
		Jugador.getJugador().setDinero(100);
		System.out.println("Bienvenido a nuestro casino.");
		System.out.println("Para probar simplemente el juego, sin apostar dinero, meta como cantidad a apostar 0.");
		mainGrande(pArgs, Jugador.getJugador().getDinero());
	
	}
	
	public static void mainGrande (String[] args, double dineroAcumulado){
		String stringAux;
		
		Jugador.getJugador().setDinero(dineroAcumulado);
		System.out.println("");
		System.out.println("Su dinero actual es "+Jugador.getJugador().getDinero()+" €");
		System.out.println("Elija juego:");	
		System.out.println("");
		System.out.println("Para jugar al BlackJack(consola) pulse 1");
		System.out.println("Para jugar al Ruleta (consola) pulse 2");
		
		
		Scanner reader = new Scanner(System.in);
		stringAux = reader.next();
		
		while(!stringAux.equals("1") && !stringAux.equals("2")){
			System.out.println("Caracter incorrecto. Introduzca 1 o 2");
			stringAux = reader.next();
		}
		
		if (stringAux.equals("1")){
			BlackJack.main(args);			
		}
		else{
			if(stringAux.equals("2")){
				Ruleta.main(args);
			}
		}
	}

	public static String preguntaDeSiNo(String pregunta){
		System.out.println(pregunta);
		Scanner reader = new Scanner(System.in);
		String respuesta = reader.next();
		
		while(!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("si")  && !respuesta.equalsIgnoreCase("no") && !respuesta.equalsIgnoreCase("n")){
			System.out.println("Caracteres incorrecto. Introduzca Si o No");
			respuesta = reader.next();
		}
		
		return respuesta;
	}
	
	//programa que comprueba si un string es numerico. Utiliza excepcion
	public static boolean esNumerico (String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}



