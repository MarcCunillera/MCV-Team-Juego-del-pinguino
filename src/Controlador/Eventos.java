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
		
		
		if(AjHielo == 1) {
			
			//AjHielo.AgujeroHielo();
			
			System.out.println("Has caido dentro de un agujero de hielo !!!");
			
		}
		
		else if(Trineu == 2){
			
			//Trienu.Trineo();
			
			System.out.println("De trineo a trineo !!!");
			
		}
		
		else if(oso == 3) {
			
			//oso.Oso();
			
			System.out.println("Has sido atacado por un Oso !!!");
			
			System.out.println("Vuelves al principio del juego");
			
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
	
	
//	public void Oso(int CasillaN1) {
//	
//		int JugadorAtacado;
//		int Xjugador;
//		int CPU;
//		int oso;
//		
//		System.out.println("Quieres Sobornar al Oso o aceptar la penalizacion ???");
//		
//		Inventario soborno;
//		
//		soborno = new Inventario();
//		
//		if(oso == soborno.vistaInventario) {
//			
//			System.out.println("El Oso ha sido sobornado con los ( 2 peces )");
//			
//		}
//		
//		if else(oso == Xjugador) {
//			
//			Xjugador.RetornoJugador();
//			System.out.println("El oso te ha atacado ( vuelves al principio del juego )");
//			
//		}
//		
//		else {
//			
//			Xjugador.RetornoJugador();
//			
//		}
//			
//		
//		return Xjugador;
//		
//		
//	}
	
	
//	public void MotosNieve() {
//		
//	}

	
}
