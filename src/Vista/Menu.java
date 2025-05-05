package Vista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        showLogin(); // ✅ Esto muestra pantallaPrincipal.fxml (que es tu login)
    }

    public static void showLogin() throws Exception {
        Parent root = FXMLLoader.load(Menu.class.getResource("/Resources/pantallaPrincipal.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Iniciar Sesión");
        primaryStage.show();
    }

    public static void showMenuPrincipal() throws Exception {
        Parent root = FXMLLoader.load(Menu.class.getResource("/Resources/pantallaMenu.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Menú Principal");
        primaryStage.show();
    }

    public static void showJuego() throws Exception {
        Parent root = FXMLLoader.load(Menu.class.getResource("/Resources/pantallaJuego.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Nueva Partida");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


