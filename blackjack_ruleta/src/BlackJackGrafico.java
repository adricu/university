package org.proyecto.packclases;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
*/

public class BlackJackGrafico  extends javax.swing.JFrame{
	
		private JButton plantarse;
		private JButton pedirCarta;
		private JLabel bCarta1;
		private JLabel bCarta2;
		private JLabel bCarta3;
		private JLabel bCarta4;
		private JLabel bCarta5;
		private JLabel bCarta6;
		private JLabel bCarta7;
		
		private JLabel jCarta1;
		private JLabel jCarta2;
		private JLabel jCarta3;
		private JLabel jCarta4;
		private JLabel jCarta5;
		private JLabel jCarta6;
		private JLabel jCarta7;
		
		private JLabel jSuma;
		private JLabel dineroJugador;
		private JButton jugarOtraVez;
		/**
		* Auto-generated main method to display this JFrame
		*/
		
		public static void main(String[] args){
			Jugador.getJugador().setDinero(100);
			main2(args);
			
		}
		
		private static void main2 (String[] args){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					BlackJackGrafico inst = new BlackJackGrafico();
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				}
			});
		}
		

		
		public BlackJackGrafico() {
			super();
			Baraja.getBaraja().resetearBaraja();
			Baraja.getBaraja().barajear();
			initGUI();
		}
		
		private void initGUI() {
			try {
				setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				getContentPane().setLayout(null);
				 
				realizarApuesta();
				
				/**BOTONES*/
				
				//JUGAR
				{
					jugarOtraVez = new JButton();
					getContentPane().add(jugarOtraVez);
					jugarOtraVez.setText("Jugar");
					jugarOtraVez.setBounds(558, 511, 114, 25);
					jugarOtraVez.setVisible(false);
					jugarOtraVez.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							if(jugarOtraVez.isEnabled()){
								jugarOtraVezMouseClicked(evt);
								
							}
							
						}
					});
				}

				//PEDIR
				{
					pedirCarta = new JButton();
					getContentPane().add(pedirCarta);
					FlowLayout pedirCartaLayout = new FlowLayout();
					pedirCartaLayout.setAlignment(FlowLayout.LEFT);
					pedirCarta.setText("Pedir");
					pedirCarta.setLayout(null);
					pedirCarta.setBounds(348, 511, 79, 25);
					pedirCarta.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							if(pedirCarta.isEnabled()){
								pedirCartaMouseClicked(evt);
							}
							
						}
					});
				}
				
				//PLANTARSE
				{
					plantarse = new JButton();
					getContentPane().add(plantarse);
					FlowLayout plantarseLayout = new FlowLayout();
					plantarseLayout.setAlignment(FlowLayout.LEFT);
					plantarse.setText("Plantarse");
					plantarse.setLayout(null);
					plantarse.setBounds(438, 511, 99, 25);
					plantarse.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							if(plantarse.isEnabled()){
								plantarseMouseClicked(evt);
							}
							
						}
					});
				}

				/**LABELS*/
				
				//banca
				{
					bCarta1 = new JLabel();
					getContentPane().add(bCarta1);
					bCarta1.setBounds(38, 19, 72, 97);
					Banca.getBanca().pedirCarta(false);
					bCarta1.setIcon(new ImageIcon(getClass().getResource("oculta.jpg")));
				}
				{
					bCarta2 = new JLabel();
					getContentPane().add(bCarta2);
					bCarta2.setBounds(138, 19, 72, 97);
					Carta cart2 = Banca.getBanca().pedirCarta(false);
					bCarta2.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
				}
				{
					bCarta3 = new JLabel();
					getContentPane().add(bCarta3);
					bCarta3.setBounds(238, 19, 72, 97);
				}
				{
					bCarta4 = new JLabel();
					getContentPane().add(bCarta4);
					bCarta4.setBounds(338, 19, 72, 97);
				}
				{
					bCarta5 = new JLabel();
					getContentPane().add(bCarta5);
					bCarta5.setBounds(438, 19, 72, 97);
				}
				{
					bCarta6 = new JLabel();
					getContentPane().add(bCarta6);
					bCarta6.setBounds(538, 19, 72, 97);
				}
				{
					bCarta7 = new JLabel();
					getContentPane().add(bCarta7);
					bCarta7.setBounds(88, 115, 72, 97);
				}
			
				//jugador
				{
					jCarta1 = new JLabel();
					getContentPane().add(jCarta1);
					jCarta1.setBounds(38, 300, 72, 97);
					Carta cart = Jugador.getJugador().pedirCarta(true);
					jCarta1.setIcon(new ImageIcon(getClass().getResource(cart.devolverNamePng())));
				}
				{
					jCarta2 = new JLabel();
					getContentPane().add(jCarta2);
					jCarta2.setBounds(138, 300, 72, 97);
					Carta cart = Jugador.getJugador().pedirCarta(true);
					jCarta2.setIcon(new ImageIcon(getClass().getResource(cart.devolverNamePng())));
				}
				{
					jCarta3 = new JLabel();
					getContentPane().add(jCarta3);
					jCarta3.setBounds(238, 300, 72, 97);
				}
				{
					jCarta4 = new JLabel();
					getContentPane().add(jCarta4);
					jCarta4.setBounds(338, 300, 72, 97);
				}
				{
					jCarta5 = new JLabel();
					getContentPane().add(jCarta5);
					jCarta5.setBounds(438, 300, 72, 97);	
				}
				{
					jCarta6 = new JLabel();
					getContentPane().add(jCarta6);
					jCarta6.setBounds(538, 300, 72, 97);	
				}
				{
					jCarta7 = new JLabel();
					getContentPane().add(jCarta7);
					jCarta7.setBounds(88, 396, 72, 97);	
				}
				{
					dineroJugador = new JLabel();
					getContentPane().add(dineroJugador);
					dineroJugador.setBounds(581, 445, 68, 22);
					dineroJugador.setText(String.valueOf(Jugador.getJugador().getDinero())+" Û");
				}
				{
					jSuma = new JLabel();
					getContentPane().add(jSuma);
					jSuma.setBounds(474, 445, 68, 22);
					jSuma.setText("Suma:  "+ String.valueOf(Jugador.getJugador().sumaMano()));
				}

				/*-----------------------------------**/
				pack();
				setSize(700, 600);  //TAMA„O VENTANA EN PIXELES
			} catch (Exception e) {
			    //add your error handling code here
				e.printStackTrace();
			}
		}
		
		private void pedirCartaMouseClicked(MouseEvent evt) { //EVENTO AL CLICAR EN EL BOTON DE PEDIR
			
			Carta cart1 = Jugador.getJugador().pedirCarta(false);
			jSuma.setText("Suma:  "+ String.valueOf(Jugador.getJugador().sumaMano()));
			int aux = Jugador.getJugador().tamanoMano();
			if(aux == 3) {
				jCarta3.setIcon(new ImageIcon(getClass().getResource(cart1.devolverNamePng())));
			}
			else if(aux == 4){
				jCarta4.setIcon(new ImageIcon(getClass().getResource(cart1.devolverNamePng())));		
			}
			else if(aux == 5){
				jCarta5.setIcon(new ImageIcon(getClass().getResource(cart1.devolverNamePng())));
			}
			else if(aux == 6){
				jCarta6.setIcon(new ImageIcon(getClass().getResource(cart1.devolverNamePng())));
			}
			else if(aux == 7){
				jCarta7.setIcon(new ImageIcon(getClass().getResource(cart1.devolverNamePng())));
			}
			
			if(Jugador.getJugador().sumaMano() >= 21){
				pedirCarta.setEnabled(false);
				plantarseMouseClicked(evt);
				plantarse.setEnabled(false);
				
			}
			
			
			//TODO add your code for pedirCarta.mouseClicked
		}
		
		private void plantarseMouseClicked(MouseEvent evt) { //EVENTO AL CLICAR EN EL BOTON DE PLANTARSE
			pedirCarta.setEnabled(false);
			plantarse.setEnabled(false);
			jugarOtraVez.setVisible(true);
			int jugJugador = Jugador.getJugador().sumaMano();
			Banca.getBanca().considerarJugada(jugJugador);
			Carta quitarOculta = Banca.getBanca().getCartaDeLaMano(0);
			bCarta1.setIcon(new ImageIcon(getClass().getResource(quitarOculta.devolverNamePng())));
			
			int tamMano = Banca.getBanca().tamanoMano();
			if (tamMano > 2){
				int aux = 2;
				while (aux < tamMano){
					Carta cart2 = Banca.getBanca().getCartaDeLaMano(aux);
					if(aux == 2){
						bCarta3.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
					}
					else if(aux == 3){
						bCarta4.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
					}
					else if(aux==4){
						bCarta5.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
					}
					else if(aux==5){
						bCarta6.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
					}
					else if(aux==6){
						bCarta7.setIcon(new ImageIcon(getClass().getResource(cart2.devolverNamePng())));
					}
					aux++;
				}
			}
			
			//se hace la comprobacion de quien ha ganado. Si gana el jugador se cobra la apuesta
			double dineroInicial = Jugador.getJugador().getDinero();
			Jugador.getJugador().getApBlackjack().cobrarApuesta(jugJugador);
			double ganancia = Jugador.getJugador().getDinero()-dineroInicial;
			if(ganancia > 0){
				JOptionPane.showMessageDialog(null,"HAS GANADO "+((Jugador.getJugador().getDinero() - dineroInicial) / 2)+" Û", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
				Jugador.getJugador().realizarApuestaBlackJack(0);
				
				System.out.println("Has ganado "+ (Jugador.getJugador().getDinero()-dineroInicial));
			}
			else{
				JOptionPane.showMessageDialog(null,"HAS PERDIDO", "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
				if(Jugador.getJugador().getDinero() <= 0){
					jugarOtraVez.setEnabled(false);
					JOptionPane.showMessageDialog(null,"YA NO TE QUEDA DINERO", "AVISO", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
		private void jugarOtraVezMouseClicked(MouseEvent evt) {
			main2(null);
			Jugador.getJugador().resetearMano();
			Banca.getBanca().resetearMano();
			this.dispose();
	
		}
		
		private void realizarApuesta(){
			String sTexto = "asdf";
			boolean seHaHechoLaReduccion = false;
			double cuantoApuesta;
			
			while(!Jugar.esNumerico(sTexto) || !seHaHechoLaReduccion){ 	//mientras no sea numerico,pregunta
				sTexto = JOptionPane.showInputDialog(null,"Ingrese la cantidad que desea apostar","APUESTA",JOptionPane.QUESTION_MESSAGE);
				
				if(Jugar.esNumerico(sTexto)){
					cuantoApuesta = (double) Integer.parseInt(sTexto);
					if(cuantoApuesta < 0){
						sTexto = "asdf";
						JOptionPane.showMessageDialog(null,"Error.Debe de introducir un numero mayor o igual que 0", "ERROR" ,JOptionPane.ERROR_MESSAGE);
					}
					else{
					//realizacion de la apuesta
					Jugador.getJugador().realizarApuestaBlackJack(cuantoApuesta);
					seHaHechoLaReduccion = Jugador.getJugador().reducirDinero(cuantoApuesta);
					if (!seHaHechoLaReduccion){
						JOptionPane.showMessageDialog(null,"No tiene tanto dinero", "ERROR" ,JOptionPane.ERROR_MESSAGE);
					}
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Error.Debe de introducir un numero mayor o igual que 0", "ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
	}
