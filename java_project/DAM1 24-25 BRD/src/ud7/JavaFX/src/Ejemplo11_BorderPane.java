import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ejemplo11_BorderPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();

        TextArea textAreaFile = getTextArea("File");
        TextArea textAreaEdit = getTextArea("Edit");
        TextArea textAreaView = getTextArea("View");
        TextArea textAreaHelp = getTextArea("Help");

        MenuItem menu1 = new Menu("File");
        menu1.setOnAction(event -> root.setCenter(textAreaFile));
        MenuItem menu2 = new Menu("Edit");
        menu2.setOnAction(event -> root.setCenter(textAreaEdit));
        MenuItem menu3 = new Menu("View");
        menu3.setOnAction(event -> root.setCenter(textAreaView));
        MenuItem menu4 = new Menu("Help");
        menu4.setOnAction(event -> root.setCenter(textAreaHelp));


        Menu menuPrincipal = new Menu("Principal");
        menuPrincipal.getItems().addAll(menu1, menu2, menu3);

        MenuBar menuBar = new MenuBar(menuPrincipal);
        root.setTop(menuBar);


        Scene scene = new Scene(root,300,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejemplo 11: BorderPane con Menú y Colores de fondo");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private static TextArea getTextArea(String menu) {
        TextArea textArea = new TextArea("Has pulsado en \"" + menu + "\"");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        String color = getColor();

        // Aplicar estilos a la caja de texto
        textArea.setStyle(
                "-fx-control-inner-background: " + color + ";" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 14px;" +
                        "-fx-text-alignment: center;" +
                        "-fx-alignment: center;" +
                        "-fx-padding: 20;"
        );

        return textArea;
    }

    private static String getColor() {
        // Generar color aleatorio en formato RGB
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);

        String color = String.format("rgb(%d,%d,%d)", r, g, b);
        return color;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
