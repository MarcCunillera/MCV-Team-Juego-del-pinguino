package Controlador;

import Modelo.ObjetosInventario;
import java.util.ArrayList;
import java.util.Random;

public class Casilla {
    private int idCasilla;
    private int idTipoCasilla;
    private String tipoCasilla;
    
    //control de casillas
    private static int contOso = 0;
    private static int contAgujero = 0;
    private static int contTrineo = 0;
    private static int contCasillaInterrogante = 0;

    public Casilla(int idCasilla, int idTipoCasilla, String tipoCasilla) {
        this.idCasilla = idCasilla;
        this.idTipoCasilla = idTipoCasilla;
        this.tipoCasilla = tipoCasilla;
    }

    public int getIdCasilla() { 
    	return idCasilla; 
    }
    public void setIdCasilla(int idCasilla) { 
    	this.idCasilla = idCasilla; 
    }
    public int getIDTipoCasilla() { 
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
        int tipo = rn.nextInt(6);
        String nombreTipo;
        
        //Si ya hay 4 osos, evitar generar más osos
        while (contOso >= 4 && tipo == 1) {
            tipo = rn.nextInt(4); //Generar un tipo diferente entre 0 y 3 (sin oso)
        }

        // Si ya hay 5 agujeros, evitar generar más agujeros
        while (contAgujero >= 5 && tipo == 2) {
            tipo = rn.nextInt(4); //Generar un tipo diferente entre 0 y 3 (sin agujero)
        }

        // Si ya hay 5 trineos, evitar generar más trineos
        while (contTrineo >= 5 && tipo == 3) {
            tipo = rn.nextInt(4); // Generar un tipo diferente entre 0 y 3 (sin trineo)
        }

        // Si ya hay 10 casillas interrogantes, evitar generar más casillas interrogantes
        while (contCasillaInterrogante >= 10 && tipo == 4) {
            tipo = rn.nextInt(4); //Generar un tipo diferente entre 0 y 3 (sin casilla interrogante)
        }
        
        //elegir el tipo
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
            case 1: idObj = 1; nomObj = "Pez"; cantidad = 1; break;
            case 2: idObj = 2; nomObj = "Bolas de Nieve"; cantidad = rn.nextInt(3) + 1; break;
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
