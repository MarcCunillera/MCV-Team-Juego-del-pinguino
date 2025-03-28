package Modelo;

public class Tablero {

	// Hem instanciat les variables
	private int casillas;
	
	// Hem definit el constructor
	public Tablero(int casillas) {
		this.casillas = 50;
	}
	
	// Geters y seters
	public int getcasillas() {
        return casillas;
    }

    public void setcasillas(int casillas) {
        this.casillas = casillas;
    }
    
    // ToString per mostra las casillas
    public String toString() {
        return "Casillas" + 50 ;
    }
	
    // Metodes de la classe Tablero
	private void GenerarTablero() {
		
	}
	
	private void OrigenTablero() {
		
	}
	
	private void DestinoTablero() {
		
	}
	
}
