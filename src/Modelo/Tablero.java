package Modelo;
import java.util.Random;
import java.util.ArrayList;
public class Tablero {

	// Hem instanciat les variables
	private int casillas;
	private ArrayList tablero;
	
	// Hem definit el constructor
	public Tablero(int casillas) {
		this.casillas = 50;
		this.tablero = tablero;
	}
	
	// Geters y seters
	public int getcasillas() {
        return casillas;
    }
	public ArrayList gettablero() {
		return tablero;
	}

    public void setcasillas(int casillas) {
        this.casillas = casillas;
    }
    
    public void settablero(ArrayList tablero) {
    	this.tablero = tablero;
    }
    
    // ToString per mostra las casillas
    public String toString() {
        return "Casillas" + 50 ;
    }
	
    // Metodes de la classe Tablero
	private void GenerarTablero(int casillas, ArrayList tablero) {
		Random rn = new Random();
		int tipoCasilla = 5; //cuando llegue al 0 se va a añadir una casilla random al tablero
		tablero.ensureCapacity(casillas); //asegurar un tamaño
		
		//generación de tablero
		for (int i = 0; i < casillas; i++) {
			if (tipoCasilla != 0) {
				tipoCasilla--;
			}else if (tipoCasilla == 0) {
				tipoCasilla = rn.nextInt(5) +1; //elegir cuantas casillas van a saltar hasta una nueva especial
				
			}
		}
	}
	
	private void OrigenTablero() {
		
	}
	
	private void DestinoTablero() {
		
	}
	
}
