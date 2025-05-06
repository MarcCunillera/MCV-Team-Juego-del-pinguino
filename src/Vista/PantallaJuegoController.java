package Vista;

import java.sql.Connection;

import Controlador.bbdd;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;

public class PantallaJuegoController {

    @FXML
    private Text dadoResultText;

    @FXML
    private Button dado;

    @FXML
    private MenuItem newGame;

    @FXML
    private MenuItem saveGame;

    @FXML
    private MenuItem loadGame;

    @FXML
    private MenuItem quitGame;

    @FXML
    private Text rapido_t;

    @FXML
    private Text lento_t;

    @FXML
    private Text peces_t;

    @FXML
    private Text nieve_t;

    @FXML
    private Text eventos;
    
    private Connection conn;

    @FXML
    private void handleDado() {
        int resultado = (int) (Math.random() * 6) + 1;
        dadoResultText.setText("Ha salido: " + resultado);
        // Aquí deberías mover al pingüino en el tablero según el resultado
        System.out.println("Dado lanzado, resultado: " + resultado);
    }

    @FXML
    private void initialize() {
        // Puedes inicializar aquí datos iniciales del tablero o partida
    }

    @FXML
    private void handleNewGame() {
        System.out.println("Nueva partida iniciada.");
        conn = bbdd.conectarBaseDatos();
        if (conn != null) {
            int idPartida = bbdd.crearNuevaPartida(conn);
            System.out.println("Partida creada amb ID: " + idPartida);
        }
    }

    @FXML
    private void handleSaveGame() {

    }

    @FXML
    private void handleLoadGame() {
        System.out.println("Cargando partida...");
        // Cargar estado desde la base de datos
    }

    @FXML
    private void handleQuitGame() {
        System.out.println("Saliendo de la partida...");
        System.exit(0);
    }
}

