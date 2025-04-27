package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class PantallaPrincipalController {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private void handleLogin() {
        String usuario = userField.getText();
        String contrasena = passField.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            System.out.println("Debes rellenar usuario y contraseña.");
            return;
        }

        // Aquí validamos el login (podrías conectar a la base de datos)
        // Por simplicidad, vamos directo al juego
        System.out.println("Login exitoso. Cargando juego...");

        cargarPantallaJuego();
    }

    @FXML
    private void handleRegister() {
        String usuario = userField.getText();
        String contrasena = passField.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            System.out.println("Debes rellenar usuario y contraseña para registrarte.");
            return;
        }

        if (contrasena.length() > 8) {
            System.out.println("Contraseña demasiado larga (máximo 8 caracteres).");
            return;
        }

        // Aquí insertaríamos el nuevo jugador en la base de datos
        System.out.println("Registro exitoso. Usuario: " + usuario);

        cargarPantallaJuego();
    }

    private void cargarPantallaJuego() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Resources/pantallaJuego.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
