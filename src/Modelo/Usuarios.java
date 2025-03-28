package Modelo;

public class Usuarios {

	private int ID;
	
	// Hem definit el constructor
	public Usuarios (int ID) {
		this.ID = ID;
	}
	
	// Geters y seters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
 // ToString per mostra el ID del Usuari
    public String toString() {
        return "ID: " + ID ; 
    }

}
