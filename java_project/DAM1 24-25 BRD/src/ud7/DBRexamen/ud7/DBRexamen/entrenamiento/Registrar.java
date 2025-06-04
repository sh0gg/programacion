package ud7.DBRexamen.entrenamiento;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN PROG UD7 - DAM1
// FECHA: 28/05/2025

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class Registrar extends Application {
    public class Registro{
        private String nombre;
        private LocalDate fecha;
        private double km;

        public Registro(String nombre, LocalDate fecha, double km) {
            this.nombre = nombre;
            this.fecha = fecha;
            this.km = km;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public double getKm() {
            return km;
        }

        public void setKm(double km) {
            this.km = km;
        }
    }

    private String nombre;
    private LocalDate fecha;
    private double km;
    private Stage primaryStage;
    private static final String FICHERO = "ud7/DBRexamen/entrenamiento/entrenamiento.dat";

    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Añadir registro");

        Label nameLabel = new Label("Introduce tu nombre:");
        TextField nombreField = new TextField();
        nombreField.setPromptText("Tu nombre aquí...");

        Label dateLabel = new Label("Fecha del entrenamiento:");
        DatePicker fechaField = new DatePicker();
        fechaField.setPromptText("Elije la fecha del entrenamiento");

        Label kmLabel = new Label("Introduce los kilómetros recorridos:");
        TextField kmField = new TextField();
        kmField.setPromptText("Introduce los kilometros...");

        Button btnGuardar = new Button("Guardar");
        btnGuardar.setPrefSize(100, 20);

        btnGuardar.setOnAction(e -> {
            nombre = nombreField.getText().trim();
            fecha = fechaField.getValue();
            km = Double.parseDouble(kmField.getText());

            if (!nombre.isEmpty()) {
                if (!fecha.isBefore(LocalDate.now())) {
                    if (!kmField.getText().isEmpty()) {
                        Registro registro = new Registro(nombre, fecha, km);
                        try (ObjectOutputStream oos = new ObjectOutputStream(
                                new FileOutputStream(FICHERO, true))) {
                            ListaRegistro.agregarYGuardarRegistro(registro);
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            } else {
                Alert alert  = new Alert(Alert.AlertType.WARNING, "Faltan datos");
                alert.showAndWait();
            }

        });

        VBox layout = new VBox(15, nameLabel, nombreField, dateLabel, fechaField, kmLabel, kmField, btnGuardar);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new

                Insets(25));
        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #f3cdcd, #fb5959);");

        Scene scene = new Scene(layout, 350, 300);
        stage.setScene(scene);
        stage.show();
    }
}
