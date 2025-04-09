package Controlador;
import java.util.Random;
import Modelo.Inventario;
public class Eventos {

	/*
	 * Creacion de la variable privada
	 */
	
	private int idEvento;
	
	/*
	 * Constructor de las Clase Evento
	 */
	
	public Eventos(int idEvento) {
		
		this.idEvento = idEvento;
		
	}
	
	/*
	 * Getter y Setter del Id Evento
	 */
	
	public int getidEvento() {
		
		return idEvento;
			
	}
	public void setidEvento(int idEvento) {
		
		this.idEvento = idEvento;
		
	}
	


	
}
