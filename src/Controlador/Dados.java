package Controlador;

public class Dados {
	
	private int DadoRapido;
	private int DadoNormal;
	private int DadoLento;
	
	public Dados(int dadoRapido, int dadoNormal, int dadoLento) {
		DadoRapido = dadoRapido;
		DadoNormal = dadoNormal;
		DadoLento = dadoLento;
	}

	public int getDadoRapido() {
		return DadoRapido;
	}

	public void setDadoRapido(int dadoRapido) {
		DadoRapido = dadoRapido;
	}

	public int getDadoNormal() {
		return DadoNormal;
	}

	public void setDadoNormal(int dadoNormal) {
		DadoNormal = dadoNormal;
	}

	public int getDadoLento() {
		return DadoLento;
	}

	public void setDadoLento(int dadoLento) {
		DadoLento = dadoLento;
	}
}
