package Controlador;

import Modelo.*;
import java.util.Random;

public class Eventos {
    private int idEvento;
    private int dadoRapido;
    private int dadoLento;
    private int pez;
    private int nieve;

    // Constructor
    public Eventos(int idEvento, int dadoRapido, int dadoLento, int pez, int nieve) {
        this.idEvento = idEvento;
        this.dadoRapido = dadoRapido;
        this.dadoLento = dadoLento;
        this.pez = pez;
        this.nieve = nieve;
    }

    // Getters y setters
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

    // Método para usar un dado especial
    public int interaccionDado(Pinguino pingu) {
        Random random = new Random();
        Inventario inventario = pingu.getInventario();

        // Buscar si el pingüino tiene un dado rápido
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == 3 && obj.getCantidad() > 0) { // ID 3 = dado rápido
                inventario.eliminarObjeto(3);
                int tirada = random.nextInt(6) + 5; // 5 a 10
                System.out.println("¡Has usado un Dado Rápido! Has sacado un " + tirada);
                return tirada;
            } else if (obj.getIDobjeto() == 4 && obj.getCantidad() > 0) { // ID 4 = dado lento
                inventario.eliminarObjeto(4);
                int tirada = random.nextInt(3) + 1; // 1 a 3
                System.out.println("Has usado un Dado Lento. Has sacado un " + tirada);
                return tirada;
            }
        }
        
        // Si no hay dados especiales, tirar dado normal
        int tiradaNormal = random.nextInt(6) + 1;
        System.out.println("Has tirado un Dado Normal y has sacado un " + tiradaNormal);
        return tiradaNormal;
    }

    // Método para sobornar al oso
    public boolean sobornarOso(Pinguino pingu) {
        Inventario inventario = pingu.getInventario();
        
        for (ObjetosInventario obj : inventario.getInventario()) {
            if (obj.getIDobjeto() == 1 && obj.getCantidad() > 0) { // ID 1 = pez
                inventario.eliminarObjeto(1); // gastar un pez
                System.out.println("Has sobornado al oso con un pez. ¡Sigues jugando!");
                return true; // soborno exitoso
            }
        }
        
        System.out.println("No tienes peces para sobornar al oso. ¡Retrocedes!");
        return false; // no hay peces
    }
}
