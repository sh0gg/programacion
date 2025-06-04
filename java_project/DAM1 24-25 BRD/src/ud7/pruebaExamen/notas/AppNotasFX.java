package ud7.pruebaExamen.notas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

/**
 * @author [Tu Nombre Completo]
 * Versión gráfica para cálculo de promedios.
 */
public class AppNotasFX extends Application {

    private TextArea textoResultados;

    @Override
    public void start(Stage stage) {
        textoResultados = new TextArea();
        textoResultados.setEditable(false);

        Button btnCalcular = new Button("Calcular Promedios");

        btnCalcular.setOnAction(e -> {
            calcularPromedios();
        });

        VBox root = new VBox(10, btnCalcular, textoResultados);
        root.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Notas y Promedios");
        stage.setScene(scene);
        stage.show();
    }

    private void calcularPromedios() {
        File ficheroEntrada = new File("notas.txt");
        File ficheroSalida = new File("promedios.txt");

        if (!ficheroEntrada.exists()) {
            textoResultados.setText("El fichero notas.txt no existe.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {

            String linea;
            boolean hayDatos = false;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                hayDatos = true;

                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    sb.append("Formato incorrecto: ").append(linea).append("\n");
                    continue;
                }

                String nombre = partes[0].trim();
                if (nombre.isEmpty()) {
                    sb.append("Nombre vacío en línea: ").append(linea).append("\n");
                    continue;
                }

                try {
                    double suma = 0;
                    int count = 0;
                    for (int i = 1; i < partes.length; i++) {
                        double nota = Double.parseDouble(partes[i].trim());
                        suma += nota;
                        count++;
                    }
                    double promedio = suma / count;
                    String resultado = nombre + ": " + promedio;
                    sb.append(resultado).append("\n");
                    bw.write(resultado);
                    bw.newLine();

                } catch (NumberFormatException e) {
                    sb.append("Error en notas: ").append(linea).append("\n");
                }
            }

            if (!hayDatos) {
                sb.append("El fichero está vacío.");
            }

            textoResultados.setText(sb.toString());

        } catch (IOException e) {
            textoResultados.setText("Error E/S: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
