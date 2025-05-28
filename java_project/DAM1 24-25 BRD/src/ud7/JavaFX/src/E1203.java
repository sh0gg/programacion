import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class E1203 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button btn = new Button("Saludar");

        btn.setOnAction(e -> System.out.println("¡Hola desde JavaFX!")); // Evento al hacer clic

        StackPane root = new StackPane(btn);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Evento de botón");
        stage.setScene(scene);
        stage.show();
    }
}