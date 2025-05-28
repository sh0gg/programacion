import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E1204 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField input = new TextField();
        Button btn = new Button("Mostrar saludo");

        btn.setOnAction(e -> {
            String nombre = input.getText();
            System.out.println("¡Hola, " + nombre + "!");
        });

        VBox layout = new VBox(10, input, btn); // VBox con separación de 10px
        Scene scene = new Scene(layout, 300, 200);

        stage.setTitle("Saludo personalizado");
        stage.setScene(scene);
        stage.show();
    }
}