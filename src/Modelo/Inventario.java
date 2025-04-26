package Modelo;

import java.util.ArrayList;
import Controlador.*;

public class Inventario {
	private ArrayList<ObjetosInventario> inventario;
	
	//constructor de la clase
	public Inventario() {
		this.inventario = new ArrayList <>(11);
		this.generarInventario();
	}
	
	//Método para generar el inventario
	private void generarInventario() {
		for (int i = 0; i < 11; i++) { //tamaño de 11 casillas
			inventario.add(new ObjetosInventario(i, 0, "Vacío", 0));
		}
	}
	
	//Método para modificar el contenido del inventario
	public void modificarInventario(ObjetosInventario objetoNuevo) {
		boolean encontrado = false;
		
	}
	
	//Getters y setters
	public ArrayList<ObjetosInventario> getInventario() {

		return inventario;
	}

	public void setInventario(ArrayList<ObjetosInventario> inventario) {
		this.inventario = inventario;
	}
	
	//toString
	@Override
	public String toString() {
		return "Inventario [inventario=" + inventario + "]";
	}
	
}
