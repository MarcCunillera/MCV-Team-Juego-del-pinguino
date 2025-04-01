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

		int Evento = eventAL.nextInt(3)+1 ;
		
		// Cambiar Obligatoriamnte ( esta de momento el true )
		
		while (true) {
			
			if(AjHielo == 1) {
				
				//AjHielo.AgujeroHielo();
				
				System.out.println("Has caido dentro de un agujero de hielo !!!");
				
			}
			
			else if(Trineu == 2){
				
				//Trienu.Trineo();
				
				System.out.println("De trineo a trineo !!!");
				
			}
			
			else if(oso == 3) {
				
				System.out.println("Has sido atacado por un Oso !!!");
				
				System.out.println("Vuelves al principio del juego");
				
			}
			
		}
		
		
	}
	
	
	
	public void Trineo(int trineo) {
		
		
	}
	
	/*
	 * Este metodo afecta al jugador en el inventario ( Para mas de un 8 )
	 */
	
//	public void CasillaQuebradiza() {
//	
//	}
	
	
	public void Oso() {
	
		int JugadorAtacado;
		
		
	}
	
	
	public void MotosNieve() {
		
	}

	
}
