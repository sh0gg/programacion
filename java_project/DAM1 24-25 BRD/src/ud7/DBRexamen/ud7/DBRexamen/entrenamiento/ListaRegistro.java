package ud7.DBRexamen.entrenamiento;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN PROG UD7 - DAM1
// FECHA: 28/05/2025

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ListaRegistro {
    private static final String FICHERO = "ud7/DBRexamen/entrenamiento/entrenamiento.dat";
    private static ObservableList<Registrar.Registro> listaRegistros;
    private ListView<Registrar.Registro> listView;


    public static void agregarYGuardarRegistro(Registrar.Registro nuevo) throws IOException {
        List<Registrar.Registro> registros = leerTodosRegistros();
        registros.add(nuevo);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (Registrar.Registro reg : registros) {
                oos.writeObject(reg);
            }
        }
    }

    private static List<Registrar.Registro> leerTodosRegistros() {
        List<Registrar.Registro> lista = new ArrayList<>();
        File fichero = new File(FICHERO);
        if (!fichero.exists()) {
            return lista; // Vacía si no existe
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                Registrar.Registro reg = (Registrar.Registro) ois.readObject();
                lista.add(reg);
            }
        } catch (EOFException e) {
            // Fin de fichero esperado
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los registros: " + e.getMessage());
        }
        return lista;
    }

    public static void mostrarRegistros() throws FileNotFoundException {

            if (!Files.exists(Paths.get(FICHERO))) {
                throw new FileNotFoundException("Archivo de registros no encontrado.");
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
                while (true) {
                    Registrar.Registro reg = (Registrar.Registro) ois.readObject();
                    listaRegistros.add(reg);
                }
            } catch (EOFException e) {
                // Fin del fichero, normal
            } catch (IOException | ClassNotFoundException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Faltan datos");
                alert.showAndWait();
            }

    }
}


    // espagueti obviar

    /*

            Button btnJugarSeed = new Button("Jugar este mapa");
            btnJugarSeed.setOnAction(event -> {
                String seleccion = listView.getSelectionModel().getSelectedItem();
                if (seleccion != null) {
                    String seed = seedMap.get(seleccion);
                    Game game = new Game("Jugador", seed);
                    try {
                        game.start(new Stage());
                        ((Stage) btnJugarSeed.getScene().getWindow()).close(); // ⬅️ CIERRA EL LEADERBOARD
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            VBox content = new VBox(10,
                    new Label("🏆 Mejores partidas (haz clic en una y luego en 'Jugar este mapa'):"), listView,
                    btnJugarSeed);
            content.setPrefSize(500, 400);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Leaderboard");
            alert.setHeaderText("Seed - Nombre (Fecha) - Tiempo");
            alert.getDialogPane().setContent(content);
            alert.showAndWait();

        } catch (IOException e) {
            Alert error = new Alert(Alert.AlertType.ERROR, "No se pudo leer la lista de registros.");
            error.show();
        }
    }

} */

