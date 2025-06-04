import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E1208 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        RadioButton r1 = new RadioButton("Opción A");
        RadioButton r2 = new RadioButton("Opción B");
        RadioButton r3 = new RadioButton("Opción C");

        ToggleGroup grupo = new ToggleGroup(); // Agrupamos para que solo se pueda seleccionar uno
        r1.setToggleGroup(grupo);
        r2.setToggleGroup(grupo);
        r3.setToggleGroup(grupo);

        Button btn = new Button("Mostrar selección");
        Label resultado = new Label();

        btn.setOnAction(e -> {
            RadioButton seleccionado = (RadioButton) grupo.getSelectedToggle();
            if (seleccionado != null) {
                resultado.setText("Seleccionado: " + seleccionado.getText());
            } else {
                resultado.setText("No hay opción seleccionada.");
            }
        });

        VBox root = new VBox(10, r1, r2, r3, btn, resultado);
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Opciones con RadioButtons");
        stage.setScene(scene);
        stage.show();
    }
}