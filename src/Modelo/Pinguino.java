package Modelo;

public class Pinguino extends Usuarios {
	
	// Hem instanciat les variables
	private String color;
	private String nombre;
	
	// Hem definit el constructor
	public Pinguino ( int ID, String color, String nombre) {
		super(ID);
		this.color = color;
		this.nombre = nombre;
	}

	// Geters y seters
    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }
    
    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    
    // ToString per mostra el color i el nom
    public String toString() {
        return super.toString() + ", Color: " + color + "Nombre" + nombre;
    }
    
    // Metodes de la classe pinguino
    public void TirarDado() {
    	
    }
    
    public void UsarBolasNieve() {
    	
    }
    
    public void AlimentarFoca() {
    	
    }

}
