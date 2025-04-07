package Modelo;
import java.util.Random;
import java.util.ArrayList;
public class Tablero {

	// Hem instanciat les variables
	private ArrayList tablero;
	private int turno;
	
	// Hem definit el constructor
	public Tablero(ArrayList tablero, int turno ) {
		this.turno = 0;
		this.tablero = new ArrayList();
		tablero.ensureCapacity(50); //asegurar un tamaño (50)
	}
	
	// Geters y seters
	public ArrayList gettablero() {
		return tablero;
	}
    
    public void settablero(ArrayList tablero) {
    	this.tablero = tablero;
    }
    
    // ToString per mostra las casillas
    public String toString() {
        return "Casillas" + 50 ;
    }
	
    // Metodes de la classe Tablero
	private void GenerarTablero(ArrayList tablero) {
		Random rn = new Random();
		int tipoCasilla = 3; //cuando llegue al 0 se va a añadir una casilla random al tablero
		
		//generación de tablero
		for (int i = 0; i < 50; i++) {
			if (tipoCasilla != 0) {
				tipoCasilla--;
				tablero.add("norm");
			}else if (tipoCasilla == 0) {
				tipoCasilla = rn.nextInt(4) +1; //elegir cuantas casillas van a saltar hasta una nueva especial
				
			}
		}
	}
	
	private void OrigenTablero(ArrayList tablero) {
		//sirve para poder mover el jugador con el trineo o el agujero
		
		
		
	}
	
	private void MoverPinguino(ArrayList<Pinguino> ListaPinguinos, int Dado) {
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
