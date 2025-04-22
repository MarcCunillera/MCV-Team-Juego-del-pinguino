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
		//sirve para poder mover el jugador con el trineo o el agujero o el oso
		//PPinguino del cual es el turno
		Pinguino pingu = ListaPinguinos.get(turno);
		int posic = pingu.getPosicion();
		//Cogemos la casilla en la que se encuentra para poder extraer el d del tipo de casilla
		Casilla casillaAct = tablero.get(posic);
		int idTipo = casillaAct.getIDTipoCasilla();
		//boolean para saber si se puede sobornar al oso
		boolean soborno = false;
		
		switch (idTipo) {
		case 1: //oso
			if(!soborno) {
				pingu.setPosicion(0);
			} else {
				//sobornar
				
			}
			break;
		case 2: //agujero
			int agujAnt = 0;
			boolean encontradoA = false;
			//bucle para caer al agujero anterior
			for (int i = posic -1; i >= 0 && !encontradoA; i--) {
				if (tablero.get(i).getIDTipoCasilla() == 2) {
					encontradoA = true;
					agujAnt = i;
				}
			}
			//casos
			if(encontradoA) {
				System.out.println("El pingüino: " + pingu.getnombre() + " Ha caído al agujero y ha salid en la casilla nº " + agujAnt);
				pingu.setPosicion(agujAnt);
			}else {
				System.out.println("El pingüino: " + pingu.getnombre() + " Ha caído a un agujero sin salida, vuelve al inicio");
				pingu.setPosicion(0);
			}
			break;
		case 3: //trineo
			int trinPos = 0;
			boolean encontradoT = false;
			//bucle para avanzar al trineo siguiente
			for (int i = 0; i < tablero.size() && !encontradoT; i++) {
				if(tablero.get(i).getIDTipoCasilla() == 2) {
					encontradoT = true;
					trinPos = i;
				}
			}
			//casos
			if(encontradoT) {
				System.out.println("El pingüino: " + pingu.getnombre() + " Se ha subido al trineo y ha avanzado al siguiente en la casilla nº " + trinPos);
				pingu.setPosicion(trinPos);
			}else {
				System.out.println("El pingüino: " + pingu.getnombre() + " Se ha encontrado un trineo sin utilidad :(");
			}
			break;
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
