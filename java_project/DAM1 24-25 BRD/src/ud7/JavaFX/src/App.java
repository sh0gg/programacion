import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class App extends Application {

    private int clickCount = 0; // contador global
    private final Random random = new Random();

    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label warning = new Label("¡Esto es un virus! ¿Qué vas a hacer al respecto?");
        Label counterLabel = new Label("Clics totales: 0");

        Button btn1 = new Button("Vale");
        Button btn2 = new Button("Okay");

        btn1.setOnAction(e -> createNewWindow("La cagaste", "y mucho", counterLabel));
        btn2.setOnAction(e -> createNewWindow("porque clickaste", "La recagaste", counterLabel));

        VBox buttonsBox = new VBox(10, btn1, btn2);
        buttonsBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20, warning, buttonsBox, counterLabel);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 200);
        stage.setTitle("Soy un virus");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void createNewWindow(String title, String buttonText, Label counterLabel) {
        clickCount++;
        counterLabel.setText("Clics totales: " + clickCount);

        Button newBtn = new Button(buttonText);
        VBox layout = new VBox(20, newBtn, new Label("Clics totales: " + clickCount));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 150);
        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle(title);
        newStage.setResizable(false);

        // Posición aleatoria en pantalla
        int x = random.nextInt(1920 - 300); // ancho pantalla - ancho ventana
        int y = random.nextInt(1080 - 150); // alto pantalla - alto ventana
        newStage.setX(x);
        newStage.setY(y);

        newStage.show();

        // Recursividad: botón también crea otra ventana
        newBtn.setOnAction(e -> createNewWindow(title, buttonText, counterLabel));
    }
}
