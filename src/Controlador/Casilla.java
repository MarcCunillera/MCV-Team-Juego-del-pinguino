package Controlador;

import java.util.ArrayList;
import java.util.Random;

public class Casilla {

	/*
	 * Creacion de las variables
	 */
	
	private int idCasilla;
	private ArrayList TipoCasilla;
	private int JugadoresCasilla;
	
	/*
	 * Constructor de la Clase de Casilla
	 */
	
	
	public Casilla (int idCasilla, ArrayList TipoCasilla, int JugadoresCasilla) {
		
		this.idCasilla = idCasilla;
		this.TipoCasilla = new ArrayList<>();
		TipoCasilla.ensureCapacity(3);
		this.JugadoresCasilla = JugadoresCasilla;
		
	}
	
	/*
	 * Getter y los Setters de cada Variable
	 */
	
	public int getidCasilla() {
		
		return idCasilla;
		
	}
	public void getidCasilla(int idCasilla) {
		
		this.idCasilla = idCasilla;
		
	}
	
	
	public ArrayList getTipoCasilla() {
		
		return TipoCasilla;
		
	}
	public void getTipoCasilla(ArrayList TipoCasilla) {
		
		this.TipoCasilla = TipoCasilla;
		
	}
	
	
	public int getJugadoresCasilla() {
		
		return JugadoresCasilla;
		
	}
	public void getJugadoresCasilla(int JugadoresCasilla) {
		
		this.JugadoresCasilla = JugadoresCasilla;
		
	}
	
	public static int InteracionEvento(int eventoAleatorio) {
		
		Dados Dado = new Dados(0,0,0);
		
		int opciones [] = new int [5];
		opciones[1] = Dado.getDadoRapido();
		opciones[2] = Dado.getDadoNormal();
		opciones[3] = Dado.getDadoLento();
		
		Objetos Objeto = new Objetos(0,0);
		
		opciones[4] = Objeto.getNieve();
		opciones[5] = Objeto.getPez();
		
		Random rd = new Random();
		
		int InteracionAleatoria = rd.nextInt(opciones.length)+1;
		
		int resultado = opciones[InteracionAleatoria];
		System.out.println("Sorpresaa!!! El evento aleatorio a sido: " + resultado);
		
		return eventoAleatorio;
	}
	
	public void GuerraJugadores() {
		
	}
	
	public void RetornoJugador() {
		
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
