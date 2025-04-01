package Controlador;
import java.util.Random;
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
	
	public void AgujeroHielo() {
		
	}
	
	/*
	 * Metodos de los tipos de Casillas y Objetos
	 */
	
	public void CasillaInterogante(int Casilla ) {
		
		Random eventAL = new Random();
		
		int AjHielo = 1;
		int Trineu = 2;
		int oso = 3 ;
		int Motnieve = 4 ;
				
		
	}
	
	
	
	public void Trineo(int trineo) {
		
		
	}
	
	
	public void CasillaQuebradiza() {
	
	}
	
	
	public void Oso() {
	
	}
	
	
	public void MotosNieve() {
		
	}

	
}
