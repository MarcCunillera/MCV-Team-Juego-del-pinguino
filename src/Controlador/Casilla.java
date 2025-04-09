package Controlador;

import java.util.ArrayList;
import java.util.Random;
import Modelo.*;
import Prueba.Inventario;

public class Casilla {
	
	private int idCasilla;
	private int idTipoCasilla;
	private String TipoCasilla;
	
	
	public Casilla (int idCasilla, int idTipoCasilla, String TipoCasilla) {
		
		this.idCasilla = idCasilla;
		this.idTipoCasilla = idTipoCasilla;
		this.TipoCasilla = TipoCasilla;
		
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

	public void RetornoJugador() {
		
	}
	
	public void AgujeroHielo() {
		
	}
	
	/*
	 * Metodos de los tipos de Casillas y Objetos
	 */
	
	public void CasillaInterogante(int Casilla ) {
		
		Random eventAL = new Random();
		
		int AjHielo = 1;
		int Trineu = 2;
		int oso = 3 ;

		int Evento = eventAL.nextInt(3)+1 ;
		
		
		if(Evento == AjHielo) {
			
			//AjHielo.AgujeroHielo();
			
			System.out.println("Has caido dentro de un agujero de hielo !!!");
			
		}
		
		else if(Evento == Trineu){
			
			//Trienu.Trineo();
			
			System.out.println("De trineo a trineo !!!");
			
		}
		
		else if(Evento == oso) {
			
			//oso.Oso();
			
			System.out.println("Has sido atacado por un Oso !!!");
			
			System.out.println("Vuelves al principio del juego");
			
		}
		
		
	}
	
	
	
	public void Trineo(int trineo) {
		
		
	}

	
	public void Oso(int CasillaN1) {
	
		int JugadorAtacado;
		int Xjugador;
		int CPU;
		int oso;
		
		System.out.println("Quieres Sobornar al Oso o aceptar la penalizacion ???");
		
		Inventario soborno;
		
		soborno = new Inventario();
		
		if(oso == soborno.vistaInventario) {
			
			System.out.println("El Oso ha sido sobornado con los ( 2 peces )");
			
		}
		
		else {
			
			Xjugador.RetornoJugador();
			System.out.println("El oso te ha atacado ( vuelves al principio del juego )");
		
		}
		
		return Xjugador;
		
		
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
