package Mapa.oldGame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

public class Mapa extends Application {

    int filas = 12;
    int columnas = 16;

    char[][] mapa;
    boolean[][] visitado;
    List<int[]> caminoSeguro = new ArrayList<>();

    GridPane gridpane = new GridPane();
    int robotX = 0, robotY = 0;
    Stage primaryStage;
    final int NUM_BOMBAS = 20;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("La aventura del robot 🤖");

        initMapa();
        renderMap();

        Scene scene = new Scene(gridpane);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case A: mover("izq"); break;
                case D: mover("der"); break;
                case S: mover("abj"); break;
                case W: mover("arr"); break;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void mover(String dir) {
        int nuevaX = robotX;
        int nuevaY = robotY;

        switch (dir) {
            case "izq": nuevaX--; break;
            case "der": nuevaX++; break;
            case "arr": nuevaY--; break;
            case "abj": nuevaY++; break;
        }

        if (nuevaY >= 0 && nuevaY < filas &&
                nuevaX >= 0 && nuevaX < columnas &&
                mapa[nuevaY][nuevaX] != '1') {

            if (mapa[nuevaY][nuevaX] == 'X') {
                mostrarAlerta("¡Victoria!", "🏅 ¡Has llegado a la meta!");
                return;
            } else if (mapa[nuevaY][nuevaX] == 'B') {
                mostrarAlerta("¡Perdiste!", "💥 Pisaste una bomba.");
                return;
            }

            mapa[robotY][robotX] = '0';
            mapa[nuevaY][nuevaX] = 'R';
            robotX = nuevaX;
            robotY = nuevaY;

            renderMap();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(mensaje);
        alert.setContentText("¿Quieres volver a jugar?");
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            resetJuego();
        } else {
            primaryStage.close();
        }
    }

    private void resetJuego() {
        initMapa();
        renderMap();
    }

    private void initMapa() {
        generarMapaAleatorio();
    }

    private void generarMapaAleatorio() {
        mapa = new char[filas][columnas];
        visitado = new boolean[filas][columnas];
        caminoSeguro.clear();

        // Iniciar todo como muro
        for (int i = 0; i < filas; i++) {
            Arrays.fill(mapa[i], '1');
        }

        // Crear camino seguro único del inicio a la meta
        dfsCrearCaminoUnico(0, 0);

        // Marcar ese camino como libre
        for (int[] paso : caminoSeguro) {
            mapa[paso[0]][paso[1]] = '0';
            visitado[paso[0]][paso[1]] = true;
        }

        // Expandir con caminos falsos
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mapa[i][j] == '1' && rand.nextDouble() < 0.25) {
                    mapa[i][j] = '0'; // camino falso
                }
            }
        }

        // Posiciones del robot y la meta
        mapa[0][0] = 'R';
        robotX = 0;
        robotY = 0;
        mapa[filas - 1][columnas - 2] = 'X';

        // Colocar bombas en caminos falsos
        colocarBombas();
    }

    private boolean dfsCrearCaminoUnico(int y, int x) {
        if (y < 0 || y >= filas || x < 0 || x >= columnas || visitado[y][x]) return false;

        visitado[y][x] = true;
        caminoSeguro.add(new int[]{y, x});

        if (y == filas - 1 && x == columnas - 2) return true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        shuffleArray(dirs);

        for (int[] d : dirs) {
            if (dfsCrearCaminoUnico(y + d[0], x + d[1])) return true;
        }

        caminoSeguro.remove(caminoSeguro.size() - 1); // retrocede si no funciona
        return false;
    }

    private void shuffleArray(int[][] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void colocarBombas() {
        Random rand = new Random();
        int bombasPuestas = 0;

        Set<String> caminoSeguroSet = new HashSet<>();
        for (int[] paso : caminoSeguro) {
            caminoSeguroSet.add(paso[0] + "," + paso[1]);
        }

        while (bombasPuestas < NUM_BOMBAS) {
            int y = rand.nextInt(filas);
            int x = rand.nextInt(columnas);

            if (mapa[y][x] == '0' &&
                    !caminoSeguroSet.contains(y + "," + x) &&
                    !(y == 0 && x == 0) &&
                    !(y == filas - 1 && x == columnas - 2)) {
                mapa[y][x] = 'B';
                bombasPuestas++;
            }
        }
    }

    private void renderMap() {
        gridpane.getChildren().clear();

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                Label lblCasilla = new Label();
                lblCasilla.setPrefSize(40, 40);
                lblCasilla.setAlignment(Pos.CENTER);
                lblCasilla.setStyle("-fx-border-width: 1; -fx-border-color: black;");

                switch (mapa[i][j]) {
                    case '1':
                        lblCasilla.setStyle("-fx-background-color: black; -fx-border-color: black;");
                        break;
                    case '0':
                        lblCasilla.setText("");
                        lblCasilla.setStyle("-fx-background-color: white;");
                        break;
                    case 'R':
                        lblCasilla.setText("🤖");
                        lblCasilla.setStyle("-fx-background-color: white;");
                        break;
                    case 'X':
                        lblCasilla.setText("🏅");
                        lblCasilla.setStyle("-fx-background-color: white;");
                        break;
                    case 'B':
                        lblCasilla.setText("💣");
                        lblCasilla.setStyle("-fx-background-color: white; -fx-text-fill: red; -fx-font-size: 20px;");
                        break;
                }

                gridpane.add(lblCasilla, j, i);
            }
        }
    }
}
