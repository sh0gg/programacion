package Mapa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aventura del Robot - Menú");

        Label label = new Label("Introduce tu nombre:");
        TextField nombreField = new TextField();

        Button btnJugar = new Button("Jugar");
        Button btnLeaderboard = new Button("Leaderboard");

        btnJugar.setOnAction(e -> {
            String nombre = nombreField.getText().trim();
            if (!nombre.isEmpty()) {
                Game game = new Game(nombre);
                try {
                    game.start(new Stage());
                    primaryStage.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnLeaderboard.setOnAction(e -> {
            Leaderboard.mostrarLeaderboard();
        });

        VBox layout = new VBox(10, label, nombreField, btnJugar, btnLeaderboard);
        layout.setStyle("-fx-padding: 20;");
        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
