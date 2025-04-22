package Modelo;
import java.util.Random;
import java.util.ArrayList;
import Controlador.*;
public class Tablero {

	// Hem instanciat les variables
	private ArrayList<Casilla> tablero;
	private int turno;
	
	// Hem definit el constructor
	public Tablero(ArrayList tablero, int turno ) {
		this.tablero = new ArrayList(50);
		this.turno = 0;
	}
	
	// Geters y seters
	public ArrayList<Casilla> gettablero() {
		return tablero;
	}
    
    // ToString per mostra las casillas
    public String toString() {
        return "Casillas" + 50 ;
    }
	
    // Metodes de la classe Tablero
	public void GenerarTablero() {
		//generación de tablero
		for (int i = 1; i < 51; i++) {
			Casilla.asignarCasillas(i, tablero); //llamar al método para generar el tablero
		}
	}
	
	public void OrigenTablero(ArrayList<Casilla> tablero, ArrayList<Pinguino> ListaPinguinos) {
		//sirve para poder mover el jugador con el trineo o el agujero
		Pinguino pingu = ListaPinguinos.get(turno);
		int posic = pingu.getPosicion();
		boolean EventoesAgujero = false;
		boolean agujero = false;
		int posicAgujero;
		
		if (EventoesAgujero) {
			for (int i = posic; i < posic && i > 0; i--) {
				
			}
		} else {
			for (int i = posic; i < tablero.size(); i++) {
				
			}
		}
		
		
	}
	
	public void MoverPinguino(ArrayList<Pinguino> ListaPinguinos, int Dado) {
		//posición del jugador al tirar el dado
		
		Pinguino pingu = ListaPinguinos.get(turno); //obtener turno
		if(ListaPinguinos.isEmpty()) {
			System.out.println("No hay pinguinos");
		}else {
			
			//obtener resultado dado
			int resul = pingu.TirarDado(Dado);
			System.out.println(pingu.getnombre() + " Con ID: " + pingu.getID() + " Ha sacado un: " + resul);
			
			
			//avanzar turno
			turno = (turno + 1) % ListaPinguinos.size();
		}
		
	}
	
}
