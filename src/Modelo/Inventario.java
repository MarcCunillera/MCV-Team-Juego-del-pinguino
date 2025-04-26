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
		 //Buscar si el objeto ya existe
	    for (ObjetosInventario objeto : inventario) {
	        if (objeto.getIDobjeto() == objetoNuevo.getIDobjeto() && objeto.getIDobjeto() != 0) {
	            if (puedeAgregar(objeto, objetoNuevo)) {
	                objeto.setCantidad(objeto.getCantidad() + objetoNuevo.getCantidad());
	                System.out.println("Se agregó " + objetoNuevo.getCantidad() + " unidades a " + objetoNuevo.getNombreObjeto());
	            } else {
	                System.out.println("No se puede agregar más de 6 unidades de " + objetoNuevo.getNombreObjeto());
	            }
	            encontrado = true;
	            break;
	        }
	    }

	    //Si no existe, agregarlo después del último objeto
	    if (!encontrado) {
	        if (objetoNuevo.getCantidad() > 6) {
	            objetoNuevo.setCantidad(6); // Limitar la cantidad si es un nuevo objeto
	        }
	        int ultimaPosicion = -1;
	        for (int i = 0; i < inventario.size(); i++) {
	            if (inventario.get(i).getIDobjeto() != 0) {
	                ultimaPosicion = i;
	            }
	        }

	        if (ultimaPosicion + 1 < inventario.size()) {
	            ObjetosInventario casilla = inventario.get(ultimaPosicion + 1);
	            casilla.setIDobjeto(objetoNuevo.getIDobjeto());
	            casilla.setNombreObjeto(objetoNuevo.getNombreObjeto());
	            casilla.setCantidad(objetoNuevo.getCantidad());
	            System.out.println("Nuevo objeto añadido: " + objetoNuevo.getNombreObjeto() + " x" + objetoNuevo.getCantidad());
	        } else {
	            System.out.println("Inventario lleno, no se puede agregar más objetos.");
	        }
	    }
	}
	
	//método privado para comprobar que se pueda añadir un objeto
	private boolean puedeAgregar(ObjetosInventario objetoActual, ObjetosInventario objetoNuevo) {
	    return (objetoActual.getCantidad() + objetoNuevo.getCantidad()) <= 6;
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
