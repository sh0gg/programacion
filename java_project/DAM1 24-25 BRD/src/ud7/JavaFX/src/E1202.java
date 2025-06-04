import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class E1202 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Haz clic aquí");

        StackPane root = new StackPane(); // Layout simple que centra el contenido
        root.getChildren().add(btn); // Añadimos el botón al layout

        Scene scene = new Scene(root, 300, 200); // Tamaño de la ventana

        primaryStage.setTitle("Botón en JavaFX");
        primaryStage.setScene(scene); // Asignamos la escena a la ventana
        primaryStage.show();
    }
}