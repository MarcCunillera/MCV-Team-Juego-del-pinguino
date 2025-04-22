package Controlador;

import java.util.ArrayList;
import java.util.Random;
import Modelo.*;
import Modelo.Pinguino;

public class Casilla {
	
	private int idCasilla;
	private int idTipoCasilla;
	private String TipoCasilla;
	
	
	public Casilla (int idCasilla, int idTipoCasilla, String TipoCasilla) {
		
		this.idCasilla = idCasilla;
		this.idTipoCasilla = idTipoCasilla;
		this.TipoCasilla = TipoCasilla;
		
	}
	
	/*
	 * Cambiar el tipo ID de la casilla interrogante cuanbdo se sepa que tipo de
	 * casilla va a ser
	 */
	
	//Getters y setters
		public int getidCasilla() {
			
			return idCasilla;
			
		}
		public void getidCasilla(int idCasilla) {
			
			this.idCasilla = idCasilla;
			
		}
		
		
		public String getTipoCasilla() {
			
			return TipoCasilla;
			
		}
		public void getTipoCasilla(String TipoCasilla) {
			
			this.TipoCasilla = TipoCasilla;
			
		}
		public int getIDCasilla() {
			
			return idCasilla;
			
		}
		public void setIDCasilla(int idCasilla) {
			
			this.idCasilla = idCasilla;
			
		}
		
		public int getIDTipoCasilla() {
			return idTipoCasilla;
		}
		
		public void setIDTipoCasilla(int idTipoCasilla) {
			this.idTipoCasilla = idTipoCasilla;
		}
	
	
	//método para asignar id de tipo de casilla
	public static void asignarCasillas(int idCasilla, ArrayList<Casilla> tablero) {
		Random rn = new Random();
		int tipo = rn.nextInt(13);
		int contOsos = 0;
		int contTrineos = 0;
		int contAguj = 0;
		
		int idTipo = 0;
		String nombreTipo = "";
		
		switch (tipo) {
		case 0:
			//casilla normal
			idTipo = 0;
			nombreTipo = "Normal";
			break;
		case 1:
			//oso
			idTipo = 1;
			nombreTipo = "oso";
			contOsos++;
			break;
		case 2:
			//agujero en el hielo
			idTipo = 2;
			nombreTipo = "agujero en el hielo";
			contAguj++;
			break;
		case 3:
			//trineo
			idTipo = 3;
			nombreTipo = "trineo";
			contTrineos++;
			break;
		case 4:
			//evento aleatorio
			//obtener un pez, obtener 1-3 bolas de nieve, dado rapido (probabilidad baja), dado lento (probabilidad alta)
			idTipo = 4;
			nombreTipo = "Evento aleatório";
			break;
		default:
			//casilla normal
			idTipo = 0;
			nombreTipo = "Normal";
			break;
		}
		
		Casilla nuevaCasilla = new Casilla(idCasilla, idTipo, nombreTipo); //generar la casilla
		tablero.add(nuevaCasilla); //añadir la casilla al tablero
	}


	public void RetornoJugador() {
		
	}
	
	public void AgujeroHielo() {
		
	}
	
	/**
	 * Metodos de los tipos de Casillas y Objetos
	 */
	
	public void CasillaInterogante(Pinguino pingu) {
		
		Random eventAL = new Random();
		
		/**
		 * Creacion de la variables con su respectivo valor que tiene cada uno
		 */
		
		int DadoRapido = 1;
		int DadoLento = 2;
		int peces = 3 ;
		int Bolasnieve = 4;
		String evntxt = "";

		int Evento = eventAL.nextInt(3)+1 ;
		
		/**
		 * En este switch case tenemos los eventos en general que estaran en cada casilla
		 */
		
		switch(Evento) {
		
		 case 1: 
			 
			 evntxt = "Te ha tocado los peces";
			 
			 break;
			 
		 case 2: 
			 
			 evntxt = "Te ha tocado las bolas de Nieve !!!";
		
			 break;
			 
		 case 3:
			 
			 int Dados = 0;
			 
			 int DadoAleatorio = eventAL.nextInt(25)+1 ;
			 
			 if (0 >= 25) {
				 
				 pingu.
				 
				 evntxt = "Te ha tocado un Dado Rapido !!!";

			 }
			 
			 else if (0 >= 10) {
				 
				 evntxt = "Te ha tocado un Dado Lento !!!";
				 
			 }
			 
			 break;
			 
		}
		
	}
	
	
	
	public void Trineo(int trineo) {
		
		
	}
	

	public void Oso(Pinguino pingujug) {
	    
	    System.out.println("¿Quieres sobornar al Oso o aceptar la penalización?");
	    
	    if (pingujug.inventario.getPez() == 2)
	        System.out.println("El Oso ha sido sobornado con los 2 peces.");
	    } 
	    
	    else {
	    	
	        pingujug.getPosicion(0);
	        System.out.println("El oso te ha atacado (vuelves al principio del juego).");
	    }
	
	}
	
	
	
	/*
	 * La letra ( norm ) es una casilla normal
	 * 
	 * La palabra ( evn ) para las casillas con los eventos normales
	 * 
	 * La palabra ( espc ) para las casillas con los eventos normales
	 * 
	 */
	
}
