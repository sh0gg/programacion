import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class E1206 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        ListView<String> lista = new ListView<>();
        lista.getItems().addAll("Lunes", "Martes", "Miércoles", "Jueves", "Viernes");

        StackPane root = new StackPane(lista);
        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Lista de días");
        stage.setScene(scene);
        stage.show();
    }
}