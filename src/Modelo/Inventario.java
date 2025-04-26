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
	
	 // Método para modificar el inventario
    public void modificarInventario(ObjetosInventario objetoNuevo) {
        boolean encontrado = false;
        //buscar si el objeto ya existe
        for (ObjetosInventario obj : inventario) {
            if (obj.getIDobjeto() == objetoNuevo.getIDobjeto() && obj.getCantidad() > 0) {
                if (obj.getCantidad() + objetoNuevo.getCantidad() <= 6) {
                    obj.setCantidad(obj.getCantidad() + objetoNuevo.getCantidad());
                } else {
                    obj.setCantidad(6);
                }
                encontrado = true;
                break;
            }
        }
        
        //buscar si el objeto ya existe
        if (!encontrado) {
            for (ObjetosInventario obj : inventario) {
                if (obj.getCantidad() == 0) { // espacio vacío
                    obj.setIDobjeto(objetoNuevo.getIDobjeto());
                    obj.setNombreObjeto(objetoNuevo.getNombreObjeto());
                    obj.setCantidad(Math.min(objetoNuevo.getCantidad(), 6));
                    break;
                }
            }
        }
    }

    // Método para validar que no se pase de 6 unidades
    private void validarMaximos(ObjetosInventario objeto) {
        if (objeto.getCantidad() > 6) {
            objeto.setCantidad(6);
        }
    }
    
    // Método para eliminar un objeto del inventario por su ID
    public void eliminarObjeto(int idObjeto) {
        for (ObjetosInventario objeto : inventario) {
            if (objeto.getIDobjeto() == idObjeto && objeto.getCantidad() > 0) {
                // Reducir la cantidad si más de 1 objeto
                if (objeto.getCantidad() > 1) {
                    objeto.setCantidad(objeto.getCantidad() - 1);
                } else {
                    // Eliminar el objeto del inventario si la cantidad es 1
                    inventario.remove(objeto);
                }
                System.out.println("Se ha eliminado 1 unidad de " + objeto.getNombreObjeto());
                break;
            }
        }
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
