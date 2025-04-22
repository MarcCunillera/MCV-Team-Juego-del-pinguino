package Controlador;
import java.util.Random;
import Modelo.Inventario;
public class Eventos {

	/*
	 * Creacion de la variable privada
	 */
	
	private int idEvento;
	private int DadoRapido;
	private int DadoLento;
	private int pez;
	private int nieve;
	
	/*
	 * Constructor de las Clase Evento
	 */
	
	public Eventos(int idEvento, int dadoRapido,  int dadoLento, int pez, int nieve) {
		
		this.idEvento = idEvento;
		this.DadoRapido = dadoRapido;
		this.DadoLento = dadoLento;
		this.pez = pez;
		this.nieve = nieve;
	}
	
	/*
	 * Getter y Setter del Id Evento
	 */
	

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getDadoRapido() {
		return DadoRapido;
	}

	public void setDadoRapido(int dadoRapido) {
		DadoRapido = dadoRapido;
	}

	public int getDadoLento() {
		return DadoLento;
	}

	public void setDadoLento(int dadoLento) {
		DadoLento = dadoLento;
	}

	public int getPez() {
		return pez;
	}

	public void setPez(int pez) {
		this.pez = pez;
	}

	public int getNieve() {
		return nieve;
	}

	public void setNieve(int nieve) {
		this.nieve = nieve;
	}
	
	public void InteraccionDado() {
	
	}
	
	
}
