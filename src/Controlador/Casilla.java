package Controlador;

public class Casilla {

	/*
	 * Creacion de las variables
	 */
	
	private int idCasilla;
	private int TipoCasilla;
	private int JugadoresCasilla;
	
	/*
	 * Constructor de la Clase de Casilla
	 */
	
	
	public Casilla (int idCasilla, int TipoCasilla, int JugadoresCasilla) {
		
		this.idCasilla = idCasilla;
		this.TipoCasilla = TipoCasilla;
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
	
	
	public int getTipoCasilla() {
		
		return TipoCasilla;
		
	}
	public void getTipoCasilla(int TipoCasilla) {
		
		this.TipoCasilla = TipoCasilla;
		
	}
	
	
	public int getJugadoresCasilla() {
		
		return JugadoresCasilla;
		
	}
	public void getJugadoresCasilla(int JugadoresCasilla) {
		
		this.JugadoresCasilla = JugadoresCasilla;
		
	}

	
	public void InteracionEvento () {
		
		
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
