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

<<<<<<< Updated upstream
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
	
	
=======
    //Método para sobornar al oso
    public boolean sobornarOso(Pinguino pingu) {
        Inventario inventario = pingu.getInventario();
        
        //Verificar si tiene un pez
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == 1 && obj.getCantidad() > 0) { // Pez
                inventario.eliminarObjeto(1);  // Eliminar un pez
                System.out.println("Has sobornado al oso con un pez. ¡Sigues jugando!");
                return true;
            }
        }
        
        //Si no tiene un pez, verificar el inventario
        System.out.println("No tienes peces para sobornar al oso.");
        
        //Si tiene más de la mitad del inventario lleno
        int cantidadLleno = 0;
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getCantidad() > 0) {
                cantidadLleno++;
            }
        }

        //Si tiene más de la mitad del inventario lleno, le quitamos la mitad de los objetos
        if (cantidadLleno > inventario.getInventario().size() / 2) {
            for (ObjetosInventario obj : inventario.getInventario()) {
                if (obj.getCantidad() > 0) {
                    int cantidadEliminar = obj.getCantidad() / 2;
                    obj.setCantidad(obj.getCantidad() - cantidadEliminar);
                    System.out.println("Se ha eliminado la mitad de unidades del objeto: " + obj.getNombreObjeto());
                }
            }
        } else {
            //Si no tiene más de la mitad del inventario ocupado, lo enviamos a la primera casilla
            pingu.setPosicion(0);
            System.out.println("No tienes suficientes objetos en tu inventario. Te envían a la primera casilla.");
        }
        
        return false;
    }
>>>>>>> Stashed changes
}
