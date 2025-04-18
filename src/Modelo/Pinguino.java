package Modelo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pinguino extends Usuarios {
	
	// Hem instanciat les variables
	private String color;
	private String nombre;
	private int posicion;
	
	//lista estatica para almacenar pinguinos
	public ArrayList<Pinguino> ListaPinguinos = new ArrayList<>();
	
	// Hem definit el constructor
	public Pinguino ( int ID, String color, String nombre, int posicion) {
		super(ID);
		this.color = color;
		this.nombre = nombre;
		this.posicion = 0;
		
		ListaPinguinos.add(this); //añadir los pinguinos dentro de la lista
	}
	

	// Geters y seters
	public ArrayList<Pinguino> getListaPinguinos(){
		return ListaPinguinos;
	}
	
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
    
    public int getPosicion() {
    	return posicion;
    }
    
    public void setPosicion(int posicion) {
    	this.posicion = posicion;
    }
    
    // ToString per mostra el color i el nom
    public String toString() {
        return super.toString() + ", Color: " + color + "Nombre" + nombre;
    }
    
    // Metodes de la classe pinguino
    public int TirarDado(int Dado) {
    	Scanner sc = new Scanner(System.in);
    	Random rn = new Random();
    	
    	System.out.println("Elige el tipo de dado:");
    	System.out.println("1- Dado normal");
    	System.out.println("2- Dado rápido");
    	System.out.println("3- Dado lento");
    	int tipoDado = sc.nextInt();
    	
    	//comprobador
    	while (tipoDado < 1 || tipoDado > 3) {
    		System.out.print("El tipo no es válido (1 - 3): ");
    		tipoDado = sc.nextInt();
    	}
    	
    	//casos
    	switch(tipoDado) {
    	case 1:
    		System.out.println("Has elegido dado Normal");
    		
    		break;
    	case 2: 
    		System.out.println("Has elegido dado Rápido");
    		
    		break;
    	case 3:
    		System.out.println("Has elegido dado Lento");
    		
    		break;
    	}
    	return Dado;
    }
    
    public void UsarBolasNieve() {
    	
    	
    }
    
    public void AlimentarFoca() {
    	
    	
    }
    
    public void inventario() {
    	this.getID();
    	this.getPez();
    	
    	
    }

}
