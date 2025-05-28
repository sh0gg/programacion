package ud7.pruebaExamen.inventario;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

/**
 * @author [Tu Nombre Completo]
 * Interfaz gráfica para gestionar inventario con fichero binario.
 */
public class AppInventarioFX extends Application {

    private static final String FICHERO = "inventario.dat";

    private ObservableList<Producto> listaProductos;
    private ListView<Producto> listView;

    private TextField tfCodigo;
    private TextField tfNombre;
    private TextField tfCantidad;
    private TextField tfPrecio;
    private TextField tfBuscarCodigo;
    private TextArea taMensaje;

    @Override
    public void start(Stage stage) {

        // Campos para agregar producto
        tfCodigo = new TextField();
        tfNombre = new TextField();
        tfCantidad = new TextField();
        tfPrecio = new TextField();

        // Campo para buscar producto
        tfBuscarCodigo = new TextField();

        // Área para mensajes y resultados
        taMensaje = new TextArea();
        taMensaje.setEditable(false);
        taMensaje.setPrefHeight(100);

        // Lista de productos
        listaProductos = FXCollections.observableArrayList();
        listView = new ListView<>(listaProductos);
        listView.setPrefHeight(150);

        // Cargar productos del fichero al iniciar
        cargarProductos();

        // Layout para agregar producto
        GridPane gpAgregar = new GridPane();
        gpAgregar.setHgap(10);
        gpAgregar.setVgap(10);
        gpAgregar.setPadding(new Insets(10));
        gpAgregar.add(new Label("Código:"), 0, 0);
        gpAgregar.add(tfCodigo, 1, 0);
        gpAgregar.add(new Label("Nombre:"), 0, 1);
        gpAgregar.add(tfNombre, 1, 1);
        gpAgregar.add(new Label("Cantidad:"), 0, 2);
        gpAgregar.add(tfCantidad, 1, 2);
        gpAgregar.add(new Label("Precio:"), 0, 3);
        gpAgregar.add(tfPrecio, 1, 3);
        Button btnAgregar = new Button("Agregar Producto");
        gpAgregar.add(btnAgregar, 1, 4);

        // Layout para buscar producto
        HBox hbBuscar = new HBox(10);
        hbBuscar.setPadding(new Insets(10));
        hbBuscar.getChildren().addAll(new Label("Buscar Código:"), tfBuscarCodigo);
        Button btnBuscar = new Button("Buscar");
        hbBuscar.getChildren().add(btnBuscar);

        // Layout principal vertical
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Inventario de Productos"),
                gpAgregar,
                btnAgregar,
                new Label("Lista de Productos:"),
                listView,
                hbBuscar,
                btnBuscar,
                new Label("Mensajes:"),
                taMensaje
        );

        // Eventos botones
        btnAgregar.setOnAction(e -> agregarProducto());
        btnBuscar.setOnAction(e -> buscarProducto());

        // Crear escena y mostrar
        Scene scene = new Scene(root, 450, 600);
        stage.setTitle("Inventario - JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    private void cargarProductos() {
        listaProductos.clear();
        File fichero = new File(FICHERO);
        if (!fichero.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                Producto p = (Producto) ois.readObject();
                listaProductos.add(p);
            }
        } catch (EOFException e) {
            // Fin del fichero, normal
        } catch (IOException | ClassNotFoundException e) {
            taMensaje.setText("Error al cargar productos: " + e.getMessage());
        }
        ordenarLista();
    }

    private void guardarProductos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (Producto p : listaProductos) {
                oos.writeObject(p);
            }
            taMensaje.setText("Productos guardados correctamente.");
        } catch (IOException e) {
            taMensaje.setText("Error al guardar productos: " + e.getMessage());
        }
    }

    private void agregarProducto() {
        try {
            int codigo = Integer.parseInt(tfCodigo.getText().trim());
            String nombre = tfNombre.getText().trim();
            int cantidad = Integer.parseInt(tfCantidad.getText().trim());
            double precio = Double.parseDouble(tfPrecio.getText().trim());

            if (nombre.isEmpty()) {
                taMensaje.setText("Error: El nombre no puede estar vacío.");
                return;
            }

            // Verificar código duplicado
            for (Producto p : listaProductos) {
                if (p.getCodigo() == codigo) {
                    taMensaje.setText("Error: Código ya existe.");
                    return;
                }
            }

            Producto nuevo = new Producto(codigo, nombre, cantidad, precio);
            listaProductos.add(nuevo);
            ordenarLista();
            guardarProductos();

            taMensaje.setText("Producto agregado correctamente.");

            // Limpiar campos
            tfCodigo.clear();
            tfNombre.clear();
            tfCantidad.clear();
            tfPrecio.clear();

        } catch (NumberFormatException e) {
            taMensaje.setText("Error: Datos numéricos inválidos.");
        }
    }

    private void buscarProducto() {
        taMensaje.clear();
        try {
            int codigo = Integer.parseInt(tfBuscarCodigo.getText().trim());
            for (Producto p : listaProductos) {
                if (p.getCodigo() == codigo) {
                    taMensaje.setText("Producto encontrado:\n" + p.toString());
                    return;
                }
            }
            taMensaje.setText("No se encontró producto con código " + codigo);
        } catch (NumberFormatException e) {
            taMensaje.setText("Error: Código inválido.");
        }
    }

    private void ordenarLista() {
        FXCollections.sort(listaProductos, Comparator.comparingInt(Producto::getCodigo));
    }

    public static void main(String[] args) {
        launch();
    }
}

