package Vista;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Modelo.*; // Imaginando que Tablero, Jugador, Inventario, etc. están en Modelo
import Controlador.*; // Para eventos, casillas especiales, etc.


public class Juego {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tablero tablero = new Tablero(); // Usa el constructor vacío que tienes
        List<Pinguino> jugadores = new ArrayList<>();
        int turnoActual = 0;

        System.out.println("||--------____Bienvenido al juego del pingüino____--------||");

        int eleccion;
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1- Nueva partida");
            System.out.println("2- Cargar partida");
            System.out.println("3- Salir");
            System.out.print("Elige una opción: ");
            eleccion = sc.nextInt();

            switch (eleccion) {
                case 1:
                    System.out.println("Creando nueva partida...");
                    jugadores.clear();

                    System.out.print("Introduce número de jugadores: ");
                    int numJugadores = sc.nextInt();

                    for (int i = 0; i < numJugadores; i++) {
                        System.out.print("Nombre del jugador " + (i + 1) + ": ");
                        String nombre = sc.next();
                        jugadores.add(new Pinguino(0,nombre));
                    }

                    tablero.GenerarTablero(); // Usamos método de Tablero (supuesto)
                    jugar(sc, tablero, jugadores);
                    break;

                case 2:
                    System.out.println("Cargando partida...");
                    tablero = bbdd.cargarTablero();
                    jugadores = bbdd.cargarJugadores();
                    jugar(sc, tablero, jugadores);
                    break;

                case 3:
                    System.out.println("Hasta pronto :)");
                    break;

                default:
                    System.out.println("Opción no válida, vuelve a intentarlo.");
                    break;
            }

        } while (eleccion != 3);

        sc.close();
    }

    private static void jugar(Scanner sc, Tablero tablero, List<Pinguino> jugadores) {
        boolean partidaActiva = true;
        Random random = new Random();
        int turnoActual = 0;

        while (partidaActiva) {
            Pinguino jugador = jugadores.get(turnoActual);

            System.out.println("\nTurno de " + jugador.getNombre());
            System.out.println("1- Tirar dado");
            System.out.println("2- Guardar partida y salir");
            System.out.print("Elige una acción: ");
            int accion = sc.nextInt();

            switch (accion) {
                case 1:
                    int tirada = random.nextInt(6) + 1;
                    System.out.println("Has sacado un " + tirada);

                    // Movimiento: actualizar la posición del pingüino
                    int nuevaPosicion = jugador.getPosicion() + tirada;
                    if (nuevaPosicion >= tablero.getNumeroCasillas()) {
                        nuevaPosicion = tablero.getNumeroCasillas() - 1;
                    }
                    jugador.setPosicion(nuevaPosicion);

                    // Evaluar casilla actual
                    Casilla casillaActual = tablero.getCasilla(nuevaPosicion);
                    System.out.println("Estás en una casilla de tipo: " + casillaActual.getTipoCasilla());

                    // Opcionalmente activar un evento si quieres
                    Eventos.activarEvento(casillaActual, jugador);

                    break;

                case 2:
                    System.out.println("Guardando partida...");
                    bbdd.guardarTablero(tablero);
                    bbdd.guardarJugadores(jugadores);
                    partidaActiva = false;
                    break;

                default:
                    System.out.println("Acción inválida.");
                    break;
            }

            turnoActual = (turnoActual + 1) % jugadores.size();
        }
    }
}
