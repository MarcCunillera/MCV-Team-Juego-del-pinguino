package Controlador;

import java.util.ArrayList;
import java.util.Random;
import Modelo.ObjetosInventario;

public class Casilla {
    private int idCasilla;
    private int idTipoCasilla;
    private String tipoCasilla;

    public Casilla(int idCasilla, int idTipoCasilla, String tipoCasilla) {
        this.idCasilla = idCasilla;
        this.idTipoCasilla = idTipoCasilla;
        this.tipoCasilla = tipoCasilla;
    }

    // Getters y Setters
    public int getIdCasilla() {
        return idCasilla;
    }

    public void setIdCasilla(int idCasilla) {
        this.idCasilla = idCasilla;
    }

    public int getIdTipoCasilla() {
        return idTipoCasilla;
    }

    public void setIdTipoCasilla(int idTipoCasilla) {
        this.idTipoCasilla = idTipoCasilla;
    }

    public String getTipoCasilla() {
        return tipoCasilla;
    }

    public void setTipoCasilla(String tipoCasilla) {
        this.tipoCasilla = tipoCasilla;
    }

    public static void asignarCasillas(int idCasilla, ArrayList<Casilla> tablero) {
        Random rn = new Random();
        int tipo = rn.nextInt(5);
        String nombreTipo;

        switch (tipo) {
            case 0: nombreTipo = "Normal"; break;
            case 1: nombreTipo = "Oso"; break;
            case 2: nombreTipo = "Agujero en el hielo"; break;
            case 3: nombreTipo = "Trineo"; break;
            case 4: nombreTipo = "Casilla Interrogante"; break;
            default: nombreTipo = "Normal"; break;
        }
        tablero.add(new Casilla(idCasilla, tipo, nombreTipo));
    }

    public ObjetosInventario casillaInterrogante() {
        Random rn = new Random();
        int evento = rn.nextInt(3) + 1;
        int idObj = 0;
        int cantidad = 0;
        String nomObj = "";

        switch (evento) {
            case 1:
                idObj = 1;
                nomObj = "Pez";
                cantidad = 1;
                break;
            case 2:
                idObj = 2;
                nomObj = "Bolas de Nieve";
                cantidad = rn.nextInt(3) + 1;
                break;
            case 3:
                if (rn.nextBoolean()) {
                    idObj = 3;
                    nomObj = "Dado Rápido";
                } else {
                    idObj = 4;
                    nomObj = "Dado Lento";
                }
                cantidad = 1;
                break;
        }
        return new ObjetosInventario(-1, idObj, nomObj, cantidad);
    }
}
