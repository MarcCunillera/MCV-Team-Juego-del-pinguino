package Modelo;

import java.util.Random;
import java.util.ArrayList;

public class Pinguino extends Usuarios{
    private String nombre;
    private int posicion;
    private Inventario inventario;
    private int dadoSeleccionado;
    
    public static ArrayList<Pinguino> ListaPinguinos = new ArrayList<>();

    public Pinguino(int id, String nombre, int posicion) {
        super(id);
        this.nombre = nombre;
        this.posicion = 0;
        this.inventario = new Inventario();
        
        ListaPinguinos.add(this);
    }
    
    //metodo para tirar dado normal
    public int tirarDadoNormal() {
        Random random = new Random();
        int resultado = random.nextInt(6) +1;
        return resultado;
    }
    
    //método para verificar si los dados especiales existen
    private boolean dadoExiste(int dadoSeleccionado) {
        if (dadoSeleccionado == 0) return true;
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == dadoSeleccionado && obj.getCantidad() > 0) {
                return true;
            }
        }
        return false;
    }
    
    //método para tirar dado lento
    public int tirarDadoRapido() {
    	dadoSeleccionado = 3; //revisar
    	Random random = new Random();
        int resultado = 0;

        if (!dadoExiste(dadoSeleccionado)) {
            System.out.println("Dado no encontrado, tirando dado normal...");
            resultado = random.nextInt(6) + 1;
            return resultado;
        } else {
        	resultado = random.nextInt(6) +1;
        	resultado = resultado + 4;
        	inventario.eliminarObjeto(3);
        }
        return resultado;
    }
    
    //método para tirar dado rápido
    public int tirarDadoLento() {
    	dadoSeleccionado = 4; //revisar
    	Random random = new Random();
        int resultado = 0;

        if (!dadoExiste(dadoSeleccionado)) {
            System.out.println("Dado no encontrado, tirando dado normal...");
            resultado = random.nextInt(6) + 1;
            return resultado;
        } else {
        	resultado = random.nextInt(3) + 1;
        	inventario.eliminarObjeto(4);
        }
        return resultado;
    }
    
    //getters y setters
    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    public int getPosicion() { 
    	return posicion; 
    }
    public void setPosicion(int posicion) { 
    	this.posicion = posicion; 
    }
    public Inventario getInventario() { 
    	return inventario; 
    }
    public void setInventario(Inventario inventario) { 
    	this.inventario = inventario; 
    }

	public static ArrayList<Pinguino> getListaPinguinos() {
		return ListaPinguinos;
	}

	public void setListaPinguinos(ArrayList<Pinguino> listaPinguinos) {
		ListaPinguinos = listaPinguinos;
	}

	@Override
	public String toString() {
		return "Pinguino [nombre=" + nombre + ", posicion=" + posicion + ", inventario=" + inventario
				+ ", ListaPinguinos=" + ListaPinguinos + "]";
	}
}
