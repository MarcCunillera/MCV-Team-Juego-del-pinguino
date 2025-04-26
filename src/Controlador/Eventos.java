package Controlador;

import Modelo.*;
import java.util.Random;

public class Eventos {
    private int idEvento;
    private int dadoRapido;
    private int dadoLento;
    private int pez;
    private int nieve;

    //Constructor
    public Eventos(int idEvento, int dadoRapido, int dadoLento, int pez, int nieve) {
        this.idEvento = idEvento;
        this.dadoRapido = dadoRapido;
        this.dadoLento = dadoLento;
        this.pez = pez;
        this.nieve = nieve;
    }

    //Getters y setters
    public int getIdEvento() { return idEvento; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }
    public int getDadoRapido() { return dadoRapido; }
    public void setDadoRapido(int dadoRapido) { this.dadoRapido = dadoRapido; }
    public int getDadoLento() { return dadoLento; }
    public void setDadoLento(int dadoLento) { this.dadoLento = dadoLento; }
    public int getPez() { return pez; }
    public void setPez(int pez) { this.pez = pez; }
    public int getNieve() { return nieve; }
    public void setNieve(int nieve) { this.nieve = nieve; }

    //Método para sobornar al oso
    public boolean sobornarOso(Pinguino pingu) {
        Inventario inventario = pingu.getInventario();
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == 1 && obj.getCantidad() > 0) { // Pez
                inventario.eliminarObjeto(1);
                System.out.println("Has sobornado al oso con un pez. ¡Sigues jugando!");
                return true;
            }
        }
        System.out.println("No tienes peces para sobornar al oso.");
        return false;
    }
}
