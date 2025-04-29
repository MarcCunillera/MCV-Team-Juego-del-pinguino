package Vista;

import Modelo.*;
import Controlador.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🚀 1. CONECTAR BASE DE DATOS
        Connection con = bbdd.conectarBaseDatos();

        System.out.println("Bienvenido al Juego del Pingüino 🐧");
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Iniciar nueva partida");
        System.out.println("2. Cargar partida existente");
        System.out.println("3. Salir");

        int opcion = sc.nextInt();
        sc.nextLine(); // Consumir salto de línea

        if (opcion == 3) {
            System.out.println("Saliendo del juego. ¡Hasta pronto!");
            cerrarConexion(con);
            System.exit(0);
        }

        // ⚡ Variables comunes
        Tablero tableroJuego = new Tablero();
        ArrayList<Casilla> tablero = tableroJuego.getTablero();
        Eventos evento = new Eventos(1, 1, 1, 1, 1);
        ArrayList<Pinguino> listaPinguinos = new ArrayList<>();
        
        int idPartida = -1;

        if (opcion == 1) {
            // 🚀 INICIAR NUEVA PARTIDA

            // Crear nueva partida
            idPartida = crearNuevaPartida(con);

            System.out.println("¿Cuántos pingüinos quieres crear? (min 2 - max 5)");
            int numPinguinos = sc.nextInt();
            while (numPinguinos < 2 || numPinguinos > 5) {
                System.out.println("Número no válido. Intenta de nuevo:");
                numPinguinos = sc.nextInt();
            }
            sc.nextLine(); // Consumir salto de línea

            for (int i = 0; i < numPinguinos; i++) {
                System.out.println("Introduce el nombre del pingüino/jugador " + (i + 1) + ":");
                String nombre = sc.nextLine();

                System.out.println("Introduce una contraseña para " + nombre + " (máximo 8 caracteres):");
                String contrasena = sc.nextLine();
                while (contrasena.length() > 8) {
                    System.out.println("La contraseña es demasiado larga, vuelve a escribirla:");
                    contrasena = sc.nextLine();
                }

                crearJugador(con, nombre, contrasena);
                int idJugador = obtenerIdJugador(con, nombre);
                crearParticipacion(con, idPartida, idJugador);

                Pinguino pingu = new Pinguino(i, nombre);
                listaPinguinos.add(pingu);
            }

        } else if (opcion == 2) {
            // 🚀 CARGAR PARTIDA EXISTENTE

            System.out.println("Introduce el número de la partida que quieres cargar:");
            int numPartida = sc.nextInt();
            sc.nextLine();

            idPartida = obtenerIdPartida(con, numPartida);
            if (idPartida == -1) {
                System.out.println("Partida no encontrada. Saliendo...");
                cerrarConexion(con);
                System.exit(0);
            }

            try {
                String sql = "SELECT j.Nickname, p.Peces FROM Participaciones p " +
                             "JOIN Jugadores j ON p.ID_jugador = j.ID_jugador " +
                             "WHERE p.ID_Partida = " + idPartida;
                ResultSet rs = bbdd.select(con, sql);

                while (rs.next()) {
                    String nombre = rs.getString("Nickname");
                    int peces = rs.getInt("Peces");

                    Pinguino pingu = new Pinguino(0, nombre);
                    pingu.setPosicion(peces);
                    listaPinguinos.add(pingu);
                }

                if (listaPinguinos.isEmpty()) {
                    System.out.println("No hay jugadores en esta partida.");
                    cerrarConexion(con);
                    System.exit(0);
                }
            } catch (SQLException e) {
                System.out.println("Error cargando los jugadores.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Opción no válida. Saliendo...");
            cerrarConexion(con);
            System.exit(0);
        }

        System.out.println("\n--- ¡Comienza la partida! ---\n");

        // 🚀 Bucle principal del juego
        boolean partidaActiva = true;
        while (partidaActiva) {
            Pinguino pinguActual = listaPinguinos.get(tableroJuego.getTurno());

            System.out.println("\nTurno de: " + pinguActual.getNombre() + " (Posición actual: " + pinguActual.getPosicion() + ")");
            System.out.println("¿Qué dado quieres lanzar? (0 = normal, 3 = rápido, 4 = lento) o (-1 para salir y guardar): ");
            int dadoSeleccionado = sc.nextInt();

            // 👇 NUEVO: opción de salir
            if (dadoSeleccionado == -1) {
                System.out.println("Guardando partida y saliendo...");
                partidaActiva = false;
                break;
            }

            if (listaPinguinos.isEmpty()) {
                System.out.println("No hay pingüinos para mover.");
                break;
            } else {
                tableroJuego.MoverPinguino(listaPinguinos, dadoSeleccionado);

                Pinguino pinguDespues = listaPinguinos.get(tableroJuego.getTurno() == 0 ? listaPinguinos.size() - 1 : tableroJuego.getTurno() - 1);
                int nuevaPosicion = pinguDespues.getPosicion();
                Casilla casillaActual = tablero.get(nuevaPosicion);
                int tipoCasilla = casillaActual.getIDTipoCasilla();

                switch (tipoCasilla) {
                    case 1:
                        System.out.println("¡Oh no! " + pinguDespues.getNombre() + " se encontró un Oso 🐻 y vuelve al inicio");
                        evento.sobornarOso(pinguDespues);
                        break;
                    case 2:
                        System.out.println("¡Peligro! " + pinguDespues.getNombre() + " cayó en un agujero 🧊");
                        tableroJuego.OrigenTablero(listaPinguinos);
                        break;
                    case 3:
                        System.out.println("¡Genial! " + pinguDespues.getNombre() + " encontró un Trineo 🛷");
                        tableroJuego.OrigenTablero(listaPinguinos);
                        break;
                    case 4:
                        System.out.println("¡Sorpresa! Casilla Interrogante ❓ para " + pinguDespues.getNombre());
                        ObjetosInventario objetoGanado = casillaActual.casillaInterrogante();
                        pinguDespues.getInventario().modificarInventario(objetoGanado);
                        System.out.println("Has obtenido: " + objetoGanado.getNombreObjeto() + " x" + objetoGanado.getCantidad());
                        break;
                    default:
                        System.out.println("Casilla normal, todo tranquilo.");
                        break;
                }

                actualizarParticipacion(con, idPartida, pinguDespues.getNombre(), nuevaPosicion);

                if (nuevaPosicion >= 49) {
                    System.out.println("\n🎉 ¡El pingüino " + pinguDespues.getNombre() + " ha ganado la partida! 🏆");
                    partidaActiva = false;
                }
            }
        }

        cerrarConexion(con);
    }

    private static void cerrarConexion(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int crearNuevaPartida(Connection con) {
        int idPartida = -1;
        try {
            String sql = "INSERT INTO Partidas (ID_Partida, Num_Partida, Hora, DataPartida) " +
                         "VALUES (partidas_seq.NEXTVAL, partidas_seq.CURRVAL, CURRENT_TIMESTAMP, CURRENT_DATE)";
            bbdd.insert(con, sql);

            ResultSet rs = bbdd.select(con, "SELECT MAX(ID_Partida) AS ID FROM Partidas");
            if (rs.next()) {
                idPartida = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idPartida;
    }

    private static void crearJugador(Connection con, String nombre, String contrasena) {
        String sql = "INSERT INTO Jugadores (ID_jugador, Nickname, Contrasena, N_partidas) " +
                     "VALUES (jugadores_seq.NEXTVAL, '" + nombre + "', '" + contrasena + "', 0)";
        bbdd.insert(con, sql);
    }

    private static int obtenerIdJugador(Connection con, String nombre) {
        int id = -1;
        try {
            ResultSet rs = bbdd.select(con, "SELECT ID_jugador FROM Jugadores WHERE Nickname = '" + nombre + "'");
            if (rs.next()) {
                id = rs.getInt("ID_jugador");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private static void crearParticipacion(Connection con, int idPartida, int idJugador) {
        String sql = "INSERT INTO Participaciones (ID_Participacion, ID_Partida, ID_jugador, Dado_Lento, Dado_Rapido, Peces, Bolas_Nive) " +
                     "VALUES (participaciones_seq.NEXTVAL, " + idPartida + ", " + idJugador + ", 0, 0, 0, 0)";
        bbdd.insert(con, sql);
    }

    private static int obtenerIdPartida(Connection con, int numPartida) {
        int id = -1;
        try {
            ResultSet rs = bbdd.select(con, "SELECT ID_Partida FROM Partidas WHERE Num_Partida = " + numPartida);
            if (rs.next()) {
                id = rs.getInt("ID_Partida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    private static void actualizarParticipacion(Connection con, int idPartida, String nombre, int nuevaPosicion) {
        int idJugador = obtenerIdJugador(con, nombre);
        if (idJugador != -1) {
            String sql = "UPDATE Participaciones SET Peces = " + nuevaPosicion +
                         " WHERE ID_Partida = " + idPartida + " AND ID_jugador = " + idJugador;
            bbdd.update(con, sql);
        }
    }
}


