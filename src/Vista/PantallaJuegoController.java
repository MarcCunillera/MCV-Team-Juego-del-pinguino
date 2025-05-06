package Vista;

import java.util.Random;
import java.util.ArrayList;
import Controlador.*;
import Modelo.*;
import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PantallaJuegoController {

    // Menu items
    @FXML private MenuItem newGame;
    @FXML private MenuItem saveGame;
    @FXML private MenuItem loadGame;
    @FXML private MenuItem quitGame;

    // Buttons
    @FXML private Button dado;
    @FXML private Button rapido;
    @FXML private Button lento;
    @FXML private Button peces;
    @FXML private Button nieve;

    // Texts
    @FXML private Text dadoResultText;
    @FXML private Text rapido_t;
    @FXML private Text lento_t;
    @FXML private Text peces_t;
    @FXML private Text nieve_t;
    @FXML private Text eventos;

    // Game board and player pieces
    @FXML private GridPane tablero;
    @FXML private Circle P1;
    @FXML private Circle P2;
    @FXML private Circle P3;
    @FXML private Circle P4;
    
    //ONLY FOR TESTING!!!
    private int p1Position = 0; // Tracks current position (from 0 to 49 in a 5x10 grid)
    private final int COLUMNS = 5;
    
    private int turno = 0;
    private ArrayList<Pinguino> pingus = new ArrayList<>();
    private Connection con;
    private int idPartida;
    
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @FXML
    private void initialize() {
        // This method is called automatically after the FXML is loaded
        // You can set initial values or add listeners here
        eventos.setText("¡El juego ha comenzado!");
        
        //añadir la lista de pinguinos
        //pingus = Pinguino.getListaPinguinos();
        pingus.add(new Pinguino(1, "Pinguino 1", 0));
        pingus.add(new Pinguino(2, "Pinguino 1", 0));
        pingus.add(new Pinguino(3, "Pinguino 1", 0));
        pingus.add(new Pinguino(4, "Pinguino 1", 0));
    }
    

    // Button and menu actions

    @FXML
    private void handleNewGame() {
        System.out.println("New game.");
        // TODO
    }

    @FXML
    private void handleSaveGame() {
        System.out.println("Saved game.");
        // TODO
        for(Pinguino pingu: pingus) {
        	bbdd.actualizarParticipacion(con, idPartida, pingu.getNombre(), pingu.getPosicion());
        }
    }

    @FXML
    private void handleLoadGame() {
        System.out.println("Loaded game.");
        // TODO
    }

    @FXML
    private void handleQuitGame() {
        System.out.println("Exit...");
        // TODO
    }
    
    //método para elegir de forma visual la ficha a mover
    private Circle getPinguinCircle(int index) {
        switch (index) {
            case 0: return P1;
            case 1: return P2;
            case 2: return P3;
            case 3: return P4;
            default: return P1; // Valor por defecto por si ocurre algo inesperado
        }
    }
    
    //metodo para hacer update de la posicion del pinguino
    private void updatePenguinPosition(int index) {
        Pinguino pingu = pingus.get(index);
        Circle pinguCircle = getPinguinCircle(index);
        
        int row = pingu.getPosicion() / 5; //5 X 10 grid
        int col = pingu.getPosicion() % 5;
        
        GridPane.setRowIndex(pinguCircle, row);
        GridPane.setColumnIndex(pinguCircle, col);
        
        turno = (turno + 1) % pingus.size(); //Asegura que el turno vaya de uno en uno
    }

    @FXML
    private void handleDado(ActionEvent event) {
        Pinguino pinguActual = pingus.get(turno);
        int resulDado = pinguActual.tirarDadoNormal();
        
        dadoResultText.setText("Ha salido" + resulDado);
        
        //mover el pinguino
        if((pinguActual.getPosicion() + resulDado) > 49) { //si la posicion a cambiar es superior al limite del tablero
        	pinguActual.setPosicion(49);
        } else {
        	pinguActual.setPosicion(pinguActual.getPosicion() + resulDado);
        }
        
        //Actualizar el tablero de forma visual
        updatePenguinPosition(turno);
        int nuevaPosicion = pinguActual.getPosicion();
        
        if (nuevaPosicion >= 49) {
            eventos.setText("¡El pingüino " + pinguActual.getNombre() + " ha ganado!");
        }
        
    }

    @FXML
    private void handleRapido() {
        System.out.println("Fast.");
        // TODO
        Pinguino pinguActual = pingus.get(turno);
        
        //llamamos al metodo tirar dado rápido
        int resulRapido = pinguActual.tirarDadoRapido();
        
        //mostrar texto
        eventos.setText("Resultado dado Rapido" + resulRapido);
        
        //mover el pinguino
        if((pinguActual.getPosicion() + resulRapido) > 49) { //si la posicion a cambiar es superior al limite del tablero
        	pinguActual.setPosicion(49);
        } else {
        	pinguActual.setPosicion(pinguActual.getPosicion() + resulRapido);
        }
        
        updatePenguinPosition(turno);
    }

    @FXML
    private void handleLento() {
        System.out.println("Slow.");
        // TODO
        Pinguino pinguActual = pingus.get(turno);
        
        //llamar a la función para tirar dado lento
        int resulLento = pinguActual.tirarDadoLento();
        eventos.setText("Resultado dado Lento" + resulLento);
        
        //mover al pinguino
      //mover el pinguino
        if((pinguActual.getPosicion() + resulLento) > 49) { //si la posicion a cambiar es superior al limite del tablero
        	pinguActual.setPosicion(49);
        } else {
        	pinguActual.setPosicion(pinguActual.getPosicion() + resulLento);
        }
    }

    @FXML
    private void handlePeces() {
        System.out.println("Fish.");
        // TODO
    }

    @FXML
    private void handleNieve() {
        System.out.println("Snow.");
        // TODO
    }
}

