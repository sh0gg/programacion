import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImageSpamApp extends Application {

    private int imageCount = 0;
    private final Random random = new Random();
    private Label counterLabel;
    private final List<Stage> imageStages = new ArrayList<>();

    // Rutas locales de las imágenes
    private final String HOUSE1_PATH = "C:\\Users\\xarro\\Desktop\\House.jpg";
    private final String HOUSE2_PATH = "C:\\Users\\xarro\\Desktop\\house2.jpg";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage mainStage) {

        java.lang.OutOfMemoryError ex = new OutOfMemoryError();

        counterLabel = new Label("Imágenes abiertas: 0");

        Button spamButton = new Button("Abrir Imagen");
        Button closeAllButton = new Button("Cerrar Imágenes");
        Button spam100Button = new Button("Vamos a quemar el pc");

        // Acción para abrir una sola imagen
        spamButton.setOnAction(e -> {
            openRandomImageWindow();
            spamButton.requestFocus();
        });

        // Acción para cerrar todas las imágenes
        closeAllButton.setOnAction(e -> {
            closeAllImageWindows();
            closeAllButton.requestFocus();
        });

        // Acción para abrir 100 imágenes
        spam100Button.setOnAction(e -> {
            for (int i = 0; i != -1; i++) {
                openRandomImageWindow();
            }
            spam100Button.requestFocus();
        });

        VBox layout = new VBox(20, counterLabel, spamButton, spam100Button, closeAllButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 250, 250);
        mainStage.setTitle("Spammer de Imágenes");
        mainStage.setScene(scene);
        mainStage.setAlwaysOnTop(true);
        mainStage.setResizable(false);
        mainStage.show();
    }

    private void openRandomImageWindow() {
        imageCount++;
        counterLabel.setText("Imágenes abiertas: " + imageCount);

        Image image;
        try {
            // 1% probabilidad de usar House2.jpg
            String selectedPath = (random.nextInt(100) == 0) ? HOUSE2_PATH : HOUSE1_PATH;
            image = new Image(new FileInputStream(selectedPath));
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen.");
            return;
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        imageView.setPreserveRatio(false);

        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 400, 400);

        Stage imgStage = new Stage();
        imgStage.setScene(scene);
        imgStage.setTitle("Imagen #" + imageCount);
        imgStage.setResizable(false);

        int x = random.nextInt(1920 - 400);
        int y = random.nextInt(1080 - 400);
        imgStage.setX(x);
        imgStage.setY(y);

        imgStage.show();

        imageStages.add(imgStage);
    }

    private void closeAllImageWindows() {
        for (Stage stage : imageStages) {
            if (stage.isShowing()) {
                stage.close();
            }
        }
        imageStages.clear();
        imageCount = 0;
        counterLabel.setText("Imágenes abiertas: 0");
    }
}
