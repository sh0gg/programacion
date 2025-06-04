import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class E1207 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextArea area = new TextArea();
        area.setPromptText("Escribe aquí tu texto...");

        StackPane root = new StackPane(area);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Área de texto");
        stage.setScene(scene);
        stage.show();
    }
}
