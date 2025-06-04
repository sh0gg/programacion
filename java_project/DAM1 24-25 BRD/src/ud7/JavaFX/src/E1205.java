import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E1205 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button btn = new Button("Sumar");
        Label resultado = new Label();

        btn.setOnAction(e -> {
            try {
                double a = Double.parseDouble(tf1.getText());
                double b = Double.parseDouble(tf2.getText());
                resultado.setText("Resultado: " + (a + b));
            } catch (NumberFormatException ex) {
                resultado.setText("Error: introduce números válidos.");
            }
        });

        VBox root = new VBox(10, tf1, tf2, btn, resultado);
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Calculadora simple");
        stage.setScene(scene);
        stage.show();
    }
}