package Controlador;
import java.util.ArrayList;
import java.util.Random;
import Modelo.*;
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
	public void asignarCasillas(Random rn, ArrayList<Casilla> tablero, int idCasilla) {
		int tipo = rn.nextInt(5);
		
		int idTipo;
		String nombreTipo;
		
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
			break;
		case 2:
			//agujero en el hielo
			idTipo = 2;
			nombreTipo = "agujero en el hielo";
			break;
		case 3:
			//trineo
			idTipo = 3;
			nombreTipo = "trineo";
			break;
		case 4:
			//evento aleatorio
			//obtener un pez, obtener 1-3 bolas de nieve, dado rapido (probabilidad baja), dado lento (probabilidad alta)
			idTipo = 4;
			nombreTipo = "Evento aleatório";
			break;
		}
	}
	
	public int eventoAl() {
		return 1;
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
	
	
	public String getTipoCasilla() {
		
		return TipoCasilla;
		
	}
	public void getTipoCasilla(String TipoCasilla) {
		
		this.TipoCasilla = TipoCasilla;
		
	}
	
	
	public void InteracionEvento () {
		
		
	}
	
//	public void GuerraJugadores() {
//		
//	}
	
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
