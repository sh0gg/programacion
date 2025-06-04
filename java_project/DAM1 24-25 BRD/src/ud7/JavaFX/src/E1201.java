import javafx.application.Application;
import javafx.stage.Stage;

public class E1201 extends Application {

    // Método principal: lanza la aplicación JavaFX
    public static void main(String[] args) {
        launch(args); // Método que inicia JavaFX y llama a start()
    }

    // Este método se ejecuta al iniciar la app JavaFX
    @Override
    public void start(Stage primaryStage) {
        // Le damos un título a la ventana
        primaryStage.setTitle("Mi primera ventana JavaFX");

        // Mostramos la ventana (por defecto vacía)
        primaryStage.show();
    }
}
