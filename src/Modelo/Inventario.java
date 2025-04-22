package Modelo;

import java.util.ArrayList;
import Controlador.*;

public class Inventario {
	private ArrayList<Casilla> inventario;
	private int IDobjeto;
	private String nombreObjeto;
	private int cantObjeto;
	
	
	
	//constructor de la clase
	public Inventario(ArrayList<Casilla> inventario, int IDobjeto, String nombreObjeto, int cantObjeto) {
		this.inventario = new ArrayList<>(11);
		this.IDobjeto = IDobjeto;
		this.nombreObjeto = nombreObjeto;
		this.cantObjeto = cantObjeto;
	}
	
	//métodos get
	public ArrayList<Casilla> getInventario(){
		return inventario;
	}
	
	public int getIDobjeto() {
		return IDobjeto;
	}
	
	public String getNombreObjeto() {
		return nombreObjeto;
	}
	
	public int getCantObjeto() {
		return cantObjeto;
	}
	
	//métodos set

	public void setInventario(ArrayList<Casilla> inventario) {
		this.inventario = inventario;
	}
	
	public void setIDobjeto(int IDobjeto) {
		this.IDobjeto = IDobjeto;
	}
	
	public void setnombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}
	
	public void setCantObjeto(int cantObjeto) {
		this.cantObjeto = cantObjeto;
	}
	
	//método toString
	public String toString() {
		return "Inventario completo: " + inventario;
	}
}
