
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E1209 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckBox cb1 = new CheckBox("Leer");
        CheckBox cb2 = new CheckBox("Escribir");
        CheckBox cb3 = new CheckBox("Programar");

        Button btn = new Button("Mostrar aficiones");
        Label resultado = new Label();

        btn.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("Aficiones: ");
            if (cb1.isSelected()) sb.append("Leer ");
            if (cb2.isSelected()) sb.append("Escribir ");
            if (cb3.isSelected()) sb.append("Programar ");
            resultado.setText(sb.toString());
        });

        VBox root = new VBox(10, cb1, cb2, cb3, btn, resultado);
        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Aficiones con CheckBoxes");
        stage.setScene(scene);
        stage.show();
    }
}