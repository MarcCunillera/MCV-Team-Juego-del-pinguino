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
			//Casilla interrogante
			idTipo = 4;
			nombreTipo = "Casilla Interrogante";
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
	

	//Metodos de los tipos de Casillas y Objetos
	public ObjetosInventario casillaInterogante() {
		Random rn = new Random();
		int Evento = rn.nextInt(3)+1;
		int idObj = 0;
		int cantidad = 0;
		String nomObj = "";
		
		//Pez (ID = 1), 1-3 Bolas de nieve (ID = 2), dado rápido(baja / ID = 3), dado lento (alta / ID = 4)
		switch(Evento) {
		case 1: //pez
			System.out.println("Ha tocado pescados!");
			idObj = 1;
			nomObj = "Pez";
			cantidad = 1;
			break;
		case 2: //bolas nieve
			System.out.println("Bolas de nieve");
			idObj = 2;
			nomObj = "Bolas de Nieve";
			cantidad = rn.nextInt(3)+1;
			break;
		case 3: //dados
			System.out.println("Dado");
			int dadosProb = rn.nextInt(10)+1;
			
			if (dadosProb > 7) {
				idObj = 3;
				nomObj = "Dado Rápido";
				cantidad = 1;
			} else {
				idObj = 4;
				nomObj = "Dado Lento";
			}
			cantidad = 1;
			break;
		}
		return new ObjetosInventario(-1, idObj, nomObj, cantidad);
	}
	
	public void Trineo(int trineo) {
		
		
	}
	

	public void Oso(Pinguino pingu) {
	    
	    System.out.println("¿Quieres sobornar al Oso ?");
	    
	    if (pingu.inventario.getPez() == 2) {
	    	
	        System.out.println("El Oso ha sido sobornado con los 2 peces.");
	    } else {
	    	
	    	pingu.getPosicion(0);
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
	

