package Modelo;

import java.util.Random;

public class Pinguino {
    private int id;
    private String nombre;
    private int posicion;
    private Inventario inventario;

    public Pinguino(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.posicion = 0;
        this.inventario = new Inventario();
    }

    public int tirarDado(int dadoSeleccionado) {
        Random random = new Random();
        int resultado = 0;

        if (!dadoExiste(dadoSeleccionado)) {
            System.out.println("Dado no encontrado, tirando dado normal...");
            resultado = random.nextInt(6) + 1;
            return resultado;
        }

        switch (dadoSeleccionado) {
            case 0:
                resultado = random.nextInt(6) + 1;
                break;
            case 3:
                resultado = random.nextInt(6) + 5;
                inventario.eliminarObjeto(3);
                break;
            case 4:
                resultado = random.nextInt(3) + 1;
                inventario.eliminarObjeto(4);
                break;
            default:
                resultado = random.nextInt(6) + 1;
                break;
        }
        return resultado;
    }

    private boolean dadoExiste(int dadoSeleccionado) {
        if (dadoSeleccionado == 0) return true;
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == dadoSeleccionado && obj.getCantidad() > 0) {
                return true;
            }
        }
        return false;
    }

    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPosicion() { return posicion; }
    public void setPosicion(int posicion) { this.posicion = posicion; }
    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) { this.inventario = inventario; }

    @Override
    public String toString() {
        return "Pinguino [ID=" + id + ", Nombre=" + nombre + ", Posición=" + posicion + ", Inventario=" + inventario + "]";
    }
}
