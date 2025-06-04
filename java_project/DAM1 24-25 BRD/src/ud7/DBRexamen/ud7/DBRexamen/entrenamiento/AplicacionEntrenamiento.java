package ud7.DBRexamen.entrenamiento;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN PROG UD7 - DAM1
// FECHA: 28/05/2025

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class AplicacionEntrenamiento extends Application {

    @Override
    public void start(Stage primaryStage) {
        mostrarMenuPrincipal(primaryStage);
    }

    public static void mostrarMenuPrincipal(Stage stage) {
        stage.setTitle("Gestión de entrenamientos");

        // Título estilizado
        Label titulo = new Label("Gestor de entrenamientos");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button btnRegistrar = new Button("Anotar registro de entrenamiento");

        Button btnVerRegistro = new Button("Mostrar registros");

        btnRegistrar.setPrefWidth(200);
        btnVerRegistro.setPrefWidth(200);

        btnRegistrar.setOnAction(e -> {
            Registrar reg = new Registrar();
            try {
                reg.start(new Stage());
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    });

        btnVerRegistro.setOnAction(e -> {
            try {
                ListaRegistro.mostrarRegistros();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

    VBox layout = new VBox(15, titulo, btnRegistrar, btnVerRegistro);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new

    Insets(25));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #f3cdcd, #fb5959);");

    Scene scene = new Scene(layout, 350, 300);
        stage.setScene(scene);
        stage.show();

}
}
