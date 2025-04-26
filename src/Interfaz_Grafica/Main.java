package Interfaz_Grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("El Juego del Pingüino");
        showLoginScene();
    }

    private void showLoginScene() {
        VBox loginLayout = new VBox(10);
        loginLayout.setStyle("-fx-padding: 30; -fx-alignment: center;");

        Label title = new Label("EL JUEGO DEL PINGÜINO");
        title.setFont(new Font("Arial", 40));
        title.setTextFill(Color.RED);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Usuario...");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Contraseña...");

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Registro");

        HBox buttonBox = new HBox(10, loginButton, registerButton);
        buttonBox.setStyle("-fx-alignment: center;");

        loginLayout.getChildren().addAll(title, usernameField, passwordField, buttonBox);

        Scene scene = new Scene(loginLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        loginButton.setOnAction(e -> showGameBoardScene());
    }

    private void showGameBoardScene() {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);

        GridPane grid = new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Pane cell = new Pane();
                cell.setStyle("-fx-border-color: black; -fx-background-color: white;");
                cell.setPrefSize(80, 50);
                grid.add(cell, j, i);
            }
        }

        HBox topPlayers = new HBox(10);
        topPlayers.setStyle("-fx-padding: 10;");
        topPlayers.getChildren().addAll(
                createPlayerCircle(Color.BLUE),
                createPlayerCircle(Color.RED),
                createPlayerCircle(Color.GREEN),
                createPlayerCircle(Color.YELLOW)
        );

        VBox topLayout = new VBox(menuBar, topPlayers);

        HBox bottomLayout = new HBox(20);
        bottomLayout.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Label diceResult = new Label("Ha salido: ");
        Button rollDice = new Button("Dado");

        Label quickDice = new Label("Dado rápido: 0");
        Button useQuickDice = new Button("Usar");

        Label slowDice = new Label("Dado lento: 0");
        Button useSlowDice = new Button("Usar");

        Label fish = new Label("Peces: 0");
        Button useFish = new Button("Usar");

        Label snowball = new Label("Bolas de nieve: 0");
        Button useSnowball = new Button("Usar");

        bottomLayout.getChildren().addAll(
                diceResult, rollDice,
                quickDice, useQuickDice,
                slowDice, useSlowDice,
                fish, useFish,
                snowball, useSnowball
        );

        root.setTop(topLayout);
        root.setCenter(grid);
        root.setBottom(bottomLayout);

        Scene gameScene = new Scene(root, 1000, 600);
        primaryStage.setScene(gameScene);
        primaryStage.show();
    }

    private Circle createPlayerCircle(Color color) {
        Circle circle = new Circle(15);
        circle.setFill(color);
        return circle;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
