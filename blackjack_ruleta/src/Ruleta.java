package org.proyecto.packclases;

import java.util.Scanner;

import org.proyecto.packclases.Numero.AColumna;
import org.proyecto.packclases.Numero.ADocena;
import org.proyecto.packclases.Numero.Color;
import org.proyecto.packclases.Numero.ImparOPar;
import org.proyecto.packclases.Numero.PasaOFalta;

public class Ruleta {
	
	public static void main (String[] args){
		System.out.println("RULETA");
		//reglas del juego
		imprimirReglas();
		System.out.println("");
		
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
		Numero numeroPremiado;
		 																//una lista vacia, sino una con todos los n¼s 
		double dineroInicial = Jugador.getJugador().getDinero();
		stringAux = "S";			//esta inicializacion esta para que entre por primera vez al while, porque queremos que entre
		
		//el primer while esta por si se quiere hacer mas de una apuesta, que por eso se pregunta al final stringAux = Jugar.pregun... 
		while(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
			double dineroDespuesDeApuestas = Jugador.getJugador().getDinero();
			String sTexto = "asdf";
			while(!Jugar.esNumerico(sTexto)){							//esto esta para asegurarnos de que no se mete un 
															   //valor incorrecto por el scanner, es decir tiene que ser numerico. Cuando es incorrecto
													 			//el while obliga otra vez a preguntar al scanner */
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
						if(cuantoApuesta <= dineroDespuesDeApuestas){
							System.out.println("");
							System.out.println("Para apostar a un numero , pulse 0");
							System.out.println("Para apostar a la 1era COLUMNA, pulse 1");
							System.out.println("Para apostar a la 2a COLUMNA, pulse 2");
							System.out.println("Para apostar a la 3a COLUMNA , pulse 3");
							System.out.println("Para apostar a ROJO, pulse 4");
							System.out.println("Para apostar a NEGRO, pulse 5");
							System.out.println("Para apostar a FALTA, pulse 6");
							System.out.println("Para apostar a PASA, pulse 7");
							System.out.println("Para apostar a PAR, pulse 8");
							System.out.println("Para apostar a IMPAR, pulse 9");
							System.out.println("Para apostar a 1era DOCENA, pulse 11");
							System.out.println("Para apostar a 2a DOCENA, pulse 12");
							System.out.println("Para apostar a 3a DOCENA, pulse 13");
							
						}
					}
					
				}
				else{
					System.out.println("Valor incorrecto. Introduzca un valor numerico mayor o igual que 0");
				}
			}
			
			//efectua la apuesta, resta el dinero de la apuesta al jugador y pregunta aver si se quiere hacer mas apuestas
			
			if(Jugador.getJugador().reducirDinero(cuantoApuesta)){  //devuelve un boolean que indica 
																	//si se a hecho la reduccion, y hace la apuesta si es true
				realizarApuesta(cuantoApuesta);
				stringAux = Jugar.preguntaDeSiNo("¿Desea hacer mas apuestas?");
			}
				
		}
		
		//se saca un numero al azar de clase Numero y se escribe
		numeroPremiado = ListaNumeros.getListaNumeros().sacarNumeroAlAzar();
		System.out.println("El numero premiado es:");
		numeroPremiado.escribir();
		
		System.out.println("");
		
		//cobra todas las apuestas ganadoras, de haberlas
		Jugador.getJugador().cobrarApuestas(numeroPremiado);
		
		//saca por consola la situacion del jugador y limpia la lista de apuestas
		double balanceApuestas = Jugador.getJugador().getDinero()-dineroInicial;
		if(balanceApuestas < 0){
			System.out.println("Has perdido "+ (-balanceApuestas)+" €");
		}
		else{
			if(balanceApuestas > 0){
				System.out.println("Has ganado "+ (balanceApuestas)+" €");
			}
			else{
				System.out.println("No has ganado ni perdido");
			}
		}
		
		System.out.println("");
		System.out.println("Por lo tanto tienes "+Jugador.getJugador().getDinero()+" €");
		Jugador.getJugador().limpiarListaApuestas();
		
		
		stringAux = Jugar.preguntaDeSiNo("¿Jugar otra partida?");
		if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
			System.out.println("");				/**Muy warro pero esk no se puede limpiar la consola, o no se como */
			System.out.println("");
		
			mainGrande(args);
		}
		else{
			System.out.println("Gracias por jugar");
		}
		
	}
	
	
	private static void realizarApuesta(double cuantoApuesta){
		//var aexiliares
		Apuesta apu = null;
		String caracter;
		
		//pide caracter por teclado
		Scanner reader = new Scanner(System.in);
		caracter = reader.next();
		
		// con este while se asegura que el caracter introducido es correcto (del 0 al 9)
		while(!caracter.equals("0") && !caracter.equals("1") && !caracter.equals("2") && !caracter.equals("3") && !caracter.equals("4") 
				&& !caracter.equals("5") &&!caracter.equals("6") && !caracter.equals("7") && !caracter.equals("8") && !caracter.equals("9") && !caracter.equals("11")
				 && !caracter.equals("12") && !caracter.equals("13")){
			System.out.println("Caracter incorrecto. Introduzca 0,1,2,3,4,5,6,7,8 o 9");
			caracter = reader.next();
		}
		
		//se crea una apuesta dependiendo q valor haya introducido el usuario
		if (caracter.equals("4")){
			apu = new RojoONegro(cuantoApuesta, Color.ROJO);
			
		}
		else{
			if (caracter.equals("11")){
				apu = new Docena(cuantoApuesta, ADocena.PRIMERA);
				
			}
			else{
				if (caracter.equals("12")){
					apu = new Docena(cuantoApuesta, ADocena.SEGUNDA);
					
				}
				else{
					if (caracter.equals("13")){
						apu = new Docena(cuantoApuesta, ADocena.TERCERA);
						
					}
					else{
				}
			}
			if(caracter.equals("5")){
				apu = new RojoONegro(cuantoApuesta, Color.NEGRO);
			}
			else{
				if(caracter.equals("6")){
					apu = new FaltaOPasa(cuantoApuesta, PasaOFalta.FALTA);
				}
				else{
					if(caracter.equals("7")){
						apu = new FaltaOPasa(cuantoApuesta, PasaOFalta.PASA);
					}
					else{
						if(caracter.equals("9")){
							apu = new ParOImpar(cuantoApuesta, ImparOPar.IMPAR);
						}
						else{
							if(caracter.equals("8")){
								apu = new ParOImpar(cuantoApuesta, ImparOPar.PAR);
							}
							else{
								if(caracter.equals("1")){
									apu = new Columna(cuantoApuesta, AColumna.PRIMERA);
								}
								else{
									if(caracter.equals("2")){
										apu = new Columna(cuantoApuesta, AColumna.SEGUNDA);
									}
									else{
										if(caracter.equals("3")){
											apu = new Columna(cuantoApuesta, AColumna.TERCERA);
										}
										else{
											if(caracter.equals("0")){
												String sTexto = "asdf";
												int numApuesta;
												while(!Jugar.esNumerico(sTexto)){							
													System.out.println("Introduzca el numero al que quiere apostar");
													Scanner reader2 = new Scanner(System.in);
													sTexto = reader2.next();
													if(Jugar.esNumerico(sTexto)){
														numApuesta = Integer.parseInt(sTexto);
														if(numApuesta > 36 || numApuesta < 0){
															sTexto = "asdf";
															System.out.println("Valor incorrecto. Introduzca un valor numerico mayor o igual que 0 y menor o igual que 36");
															
														}
														apu = new AUnNumero(cuantoApuesta,numApuesta );
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
			
	}
}
	}
		Jugador.getJugador().anadirApuesta(apu);					
	}
	
	private static void imprimirReglas(){
		String stringAux; 
		stringAux = Jugar.preguntaDeSiNo("¿Desea ver las reglas del juego?. Introduzca Si (s) o No (n) ");
		
		if(stringAux.equalsIgnoreCase("s") || stringAux.equalsIgnoreCase("Si")){
			System.out.println("Se te va a dar la oportunidad de seleccionar la cantidad de dinero" +
								" que deseas apostar, y las diferentes opciones de apuesta.");
			System.out.println("Si ganas la apuesta se recompensa con la cantidad que has apostado, mas esa " +
					"misma cantidad multiplicada por un coeficiente.");
			System.out.println("Los coeficientes son: para las apuestas a un numero 36,a las columnas 2 y a todas las demas 1.");
					
			
		}
	}
	

}
