package Controlador;

public class Objetos {
	
	/*
	 * Atributos de los Ojectos de los Juegos
	 */

	private int Pez;
	private int Nieve;
	private int DadoRapido;
	private int DadoLento;
	private int DadoNormal;
	
	/*
	 * Constructor de la Clase Objetos
	 */
	
	public Objetos(int Pez,int Nieve,int DadoRapido, int DadoLento, int DadoNormal) {
		
		this.Pez = Pez;
		this.Nieve = Nieve;
		this.DadoRapido = DadoRapido;
		this.DadoLento = DadoLento;
		this.DadoNormal = DadoNormal;
		
	}
	
	/*
	 * Getters y Setters de los objetos
	 */
	
	public int getPez(){
		
		return Pez;
		
	}
	
	public void setPez(int Pez) {
		
		this.Pez = Pez;
		
	}
	
	public int getNieve(){
		
		return Nieve;
		
	}
	
	public void getNieve(int Nieve) {
		
		this.Nieve = Nieve;
		
	}
	
	
	public int getDadoRapido(){
		
		return DadoRapido;
		
	}
	
	public void setDadoRapido(int DadoRapido) {
		
		this.DadoRapido = DadoRapido;
		
	}
	
	
	public int getDadoLento(){
		
		return DadoLento;
		
	}
	
	public void setDadoLento(int DadoLento) {
		
		this.DadoLento = DadoLento;
		
	}
	
	
	public int getDadoNormal(){
		
		return DadoNormal;
		
	}
	
	public void setDadoNormal(int DadoNormal) {
		
		this.DadoNormal = DadoNormal;
		
	}
	


	

}
