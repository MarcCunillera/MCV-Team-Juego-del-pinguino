package Vista;

import Modelo.*;
import Controlador.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Tablero tableroJuego = new Tablero();  //generar el tablero
        ArrayList<Casilla> tablero = tableroJuego.getTablero();

        // Crear pingüinos
        ArrayList<Pinguino> listaPinguinos = new ArrayList<>();
        System.out.println("¿Cuántos pingüinos quieres crear?");
        int numPinguinos = sc.nextInt();
        sc.nextLine(); //Consumir el salto de línea

        for (int i = 0; i < numPinguinos; i++) {
            System.out.println("Introduce el nombre del pingüino " + (i + 1) + ":");
            String nombre = sc.nextLine();
            Pinguino pingu = new Pinguino(i, nombre);
            listaPinguinos.add(pingu);
        }

        System.out.println("\n--- ¡Comienza la partida! ---\n");

        boolean partidaActiva = true;
        while (partidaActiva) {
            Pinguino pinguActual = listaPinguinos.get(tableroJuego.getTurno());

            System.out.println("\nTurno de: " + pinguActual.getNombre() + " (Posición actual: " + pinguActual.getPosicion() + ")");
            System.out.println("¿Qué dado quieres lanzar? (0 = normal, 3 = rápido, 4 = lento): ");
            int dadoSeleccionado = sc.nextInt();

            if (listaPinguinos.isEmpty()) {
                System.out.println("No hay pingüinos para mover.");
                break;
            } else {
                //Mover pingüino con el método del tablero (usando tu método MoverPinguino)
                tableroJuego.MoverPinguino(listaPinguinos, dadoSeleccionado);

                //Ahora revisamos la casilla donde cayó (después de mover)
                Pinguino pinguDespues = listaPinguinos.get(tableroJuego.getTurno() == 0 ? listaPinguinos.size() - 1 : tableroJuego.getTurno() - 1);
                int posicionActual = pinguDespues.getPosicion();
                Casilla casillaActual = tablero.get(posicionActual);
                int tipoCasilla = casillaActual.getIDTipoCasilla();

                switch (tipoCasilla) {
                    case 1: //Oso
                        System.out.println("¡Oh no! " + pinguDespues.getNombre() + " se encontró un Oso 🐻 y vuelve al inicio.");
                        pinguDespues.setPosicion(0);
                        break;
                    case 2: //Agujero en el hielo
                        System.out.println("¡Peligro! " + pinguDespues.getNombre() + " cayó en un agujero 🧊.");
                        tableroJuego.OrigenTablero(listaPinguinos);
                        break;
                    case 3: //Trineo
                        System.out.println("¡Genial! " + pinguDespues.getNombre() + " encontró un Trineo 🛷.");
                        tableroJuego.OrigenTablero(listaPinguinos);
                        break;
                    case 4: //Casilla Interrogante
                        System.out.println("¡Sorpresa! Casilla Interrogante ❓ para " + pinguDespues.getNombre());
                        ObjetosInventario objetoGanado = casillaActual.casillaInterrogante();
                        pinguDespues.getInventario().modificarInventario(objetoGanado);
                        System.out.println("Has obtenido: " + objetoGanado.getNombreObjeto() + " x" + objetoGanado.getCantidad());
                        break;
                    default:
                        System.out.println("Casilla normal, todo tranquilo.");
                        break;
                }

                //Comprobar si ganó
                if (pinguDespues.getPosicion() >= 49) {
                    System.out.println("\n🎉 ¡El pingüino " + pinguDespues.getNombre() + " ha llegado al final y ha ganado! 🏆");
                    partidaActiva = false;
                }
            }
        }

    }
}
