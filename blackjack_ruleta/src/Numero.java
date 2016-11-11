package org.proyecto.packclases;

public class Numero {
	
	enum ImparOPar {PAR , IMPAR , CERO} 
	enum Color {NEGRO , ROJO , CERO}
	enum PasaOFalta {PASA , FALTA , CERO}
	enum AColumna {PRIMERA,SEGUNDA,TERCERA, CERO}
	enum ADocena {PRIMERA,SEGUNDA,TERCERA, CERO}
	
	//atributos
	private int num;
	
	public Numero(int num) {
		this.num = num;
		
	}
	
	//getters
	public int getNum() {
		return num;
	}

	
	//metodos
	public ImparOPar enNumeroPar(){
		ImparOPar rdo = ImparOPar.CERO;
		int n = this.getNum();
		if (n == 0){
			rdo = ImparOPar.CERO;
		}
		else{
			if( (this.getNum() % 2) == 0){
			 rdo = ImparOPar.PAR;
			}
			else{
				rdo = ImparOPar.IMPAR;
			}
		}
		return rdo;
	}
	
	public boolean numeroPar(){
		boolean rdo = false;
		
		if ((this.getNum()% 2) == 0){
			rdo=true;
		}
		return rdo;
	}
	
	public Color rojoONegro(){
		Color rdo = null;
		int n = this.getNum();
		
		if(n == 0){
			rdo = Color.CERO;
			
		}
		else{
			if(this.numeroPar() && n != 12 && n != 14 &&n != 16
					&&n != 18 &&n != 30	&& n != 32 && n != 34 && n != 36){
				rdo = Color.NEGRO;					
			}
			else{
				rdo = Color.ROJO;
			}
			
		}
		return rdo;
	}

	public PasaOFalta calcularPasaOFalta(){
		PasaOFalta rdo = PasaOFalta.CERO ;
		
		if(this.getNum() != 0){	
			if(this.getNum() >=1 && this.getNum()<= 18){
			rdo = PasaOFalta.FALTA;						
			}
			else{
				if(this.getNum() >=19 && this.getNum()<= 36){
				rdo = PasaOFalta.PASA;
				}
			}
		}
		return rdo;
	}
	
	public AColumna calcularColumna(){
		AColumna rdo = AColumna.CERO;
		
		if(this.getNum() != 0) 
			if(this.getNum() % 3 == 1){
				rdo = AColumna.PRIMERA;
			}
			else{
				if(this.getNum() % 3 == 2){
					rdo = AColumna.SEGUNDA;
				}
				else{
					if(this.getNum() % 3 == 3 || this.getNum() % 3 == 0){
						rdo = AColumna.TERCERA;
					}
				}
				
			}
		return rdo;
		}
	
	public ADocena calcularDocena(){
		ADocena rdo = ADocena.CERO;
		
		if(this.getNum() != 0) 
			if(this.getNum() > 0 && this.getNum() <= 12){
				rdo = ADocena.PRIMERA;
			}
			else{
				if(this.getNum() > 12 && this.getNum() <= 24){
					rdo = ADocena.SEGUNDA;
				}
				else{
					if(this.getNum() > 24 && this.getNum() <= 36){
						rdo = ADocena.TERCERA;
					}
				}
				
			}
		return rdo;
		}
		
			
		
	
	public void escribir(){
		String parONo = "IMPAR";
		if(this.getNum() == 0){
			parONo = "CERO";
		}else if(this.numeroPar()){
			parONo = "PAR";
		}
		System.out.println(this.getNum() +" "+ this.rojoONegro() +" "+parONo+" "+ this.calcularPasaOFalta()+","+ this.calcularColumna()+" COLUMNA"+","+ this.calcularDocena()+" DOCENA");
	}

	
	

}
