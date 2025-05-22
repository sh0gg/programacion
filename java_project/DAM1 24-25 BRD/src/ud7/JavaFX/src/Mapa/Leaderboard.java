package Mapa;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.json.*;

public class Leaderboard {

    private static final String JSON_PATH = "java_project/DAM1 24-25 BRD/src/ud7/JavaFX/src/Mapa/leaderboard.json";

    public static void guardarResultado(String nombre, String tiempo) {
        List<JSONObject> datos = new ArrayList<>();

        // Leer archivo existente
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(JSON_PATH)));
            JSONArray jsonArray = new JSONArray(contenido);
            for (int i = 0; i < jsonArray.length(); i++) {
                datos.add(jsonArray.getJSONObject(i));
            }
        } catch (IOException | JSONException ignored) {}

        // Añadir nuevo resultado
        JSONObject entrada = new JSONObject();
        entrada.put("nombre", nombre);
        entrada.put("fecha", new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        entrada.put("tiempo", tiempo);
        datos.add(entrada);

        // Guardar
        try (FileWriter file = new FileWriter(JSON_PATH)) {
            file.write(new JSONArray(datos).toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarLeaderboard() {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(JSON_PATH)));
            JSONArray jsonArray = new JSONArray(contenido);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                sb.append(String.format("%s (%s) - %s\n",
                        obj.getString("nombre"),
                        obj.getString("fecha"),
                        obj.getString("tiempo")));
            }

            TextArea textArea = new TextArea(sb.toString());
            textArea.setEditable(false);
            textArea.setWrapText(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Leaderboard");
            alert.setHeaderText("🏆 Mejores partidas");
            alert.getDialogPane().setContent(textArea);
            alert.showAndWait();

        } catch (IOException | JSONException e) {
            Alert error = new Alert(Alert.AlertType.ERROR, "No se pudo leer el leaderboard.");
            error.show();
        }
    }
}
