package Modelo;

import java.util.Random;

public class Pinguino {
    private int id;
    private String nombre;
    private int posicion;
    private Inventario inventario;

    // Constructor
    public Pinguino(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = 0; //Siempre empieza en 0
        this.inventario = new Inventario(); //Cada pingüino tiene su propio inventario
    }

    // Método para tirar un dado
    public int tirarDado(int dadoSeleccionado) {
        Random random = new Random();
        int resultado = 0;

        if (!dadoExiste(dadoSeleccionado)) {
            System.out.println("¡El dado seleccionado no existe en el inventario! Se lanza el dado normal (1-6).");
            resultado = random.nextInt(6) + 1;
            return resultado;
        }

        switch (dadoSeleccionado) {
            case 0: //Dado normal
                resultado = random.nextInt(6) + 1; // 1-6
                break;
            case 3: //Dado rápido
                resultado = random.nextInt(6) + 5; // 5-10
                inventario.eliminarObjeto(3);
                break;
            case 4: //Dado lento
                resultado = random.nextInt(3) + 1; // 1-3
                inventario.eliminarObjeto(4);
                break;
            default: //Cualquier otra opción usa dado normal
                resultado = random.nextInt(6) + 1;
                break;
        }
        return resultado;
    }

    //Método privado para comprobar si el dado existe en el inventario
    private boolean dadoExiste(int dadoSeleccionado) {
        if (dadoSeleccionado == 0) {
            return true; //El dado normal siempre existe
        }
        for (ObjetosInventario objeto : inventario.getInventario()) {
            if (objeto.getIDobjeto() == dadoSeleccionado && objeto.getCantidad() > 0) {
                return true;
            }
        }
        return false;
    }

    //Getters y Setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Pinguino [ID=" + id + ", Nombre=" + nombre + ", Posición=" + posicion + ", Inventario=" + inventario + "]";
    }
}
