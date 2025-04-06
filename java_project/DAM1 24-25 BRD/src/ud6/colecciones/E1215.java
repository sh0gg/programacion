package ud6.colecciones;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class E1215 {

    static Map<Producto, Integer> stock = new HashMap<>();
    private static final String FILE_PATH = "stock.json";

    static void add(Producto producto, Integer cantidad) {
        stock.put(producto, cantidad);
    }

    static void delete(String codigo) {
        stock.keySet().removeIf(p -> p.getCodigo().equals(codigo));
    }

    static void edit(String codigo, Integer cantidad) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            stock.put(producto, cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : stock.keySet()) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    static void cargarRepuestos() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type tipo = new TypeToken<Map<Producto, Integer>>() {}.getType();
            stock = gson.fromJson(reader, tipo);
            if (stock == null) stock = new HashMap<>();
        } catch (IOException e) {
            System.out.println("Archivo de stock no encontrado. Se creará uno nuevo.");
        }
    }

    static void guardarRepuestos() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(stock, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el stock.");
        }
    }

    static void showMenu() {
        System.out.println("\n¿Qué te gustaría hacer?");
        System.out.println("1. Lista de stock");
        System.out.println("2. Añadir un nuevo repuesto");
        System.out.println("3. Eliminar un repuesto");
        System.out.println("4. Editar stock");
        System.out.println("5. Salir");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarRepuestos();

        int respuesta = 0;
        System.out.println("¡Bienvenido a la app de MegaRepuestos!");

        while (respuesta != 5) {
            showMenu();
            respuesta = sc.nextInt();
            sc.nextLine(); // consumir salto de línea

            String codigo, nombre;
            Integer cantidad;

            switch (respuesta) {
                case 1:
                    if (stock.isEmpty()) {
                        System.out.println("No hay productos en stock.");
                    } else {
                        for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
                            System.out.println(entry.getKey() + " -> Cantidad: " + entry.getValue());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduce el código del repuesto:");
                    codigo = sc.nextLine();
                    System.out.println("Introduce el nombre del repuesto:");
                    nombre = sc.nextLine();
                    System.out.println("Introduce la cantidad de stock:");
                    cantidad = sc.nextInt();
                    add(new Producto(codigo, nombre), cantidad);
                    break;
                case 3:
                    System.out.println("Introduce el código del repuesto que quieras eliminar:");
                    codigo = sc.nextLine();
                    delete(codigo);
                    break;
                case 4:
                    System.out.println("¿De qué repuesto quieres modificar el stock? (código):");
                    codigo = sc.nextLine();
                    System.out.println("¿Cuál es el nuevo stock?");
                    cantidad = sc.nextInt();
                    edit(codigo, cantidad);
                    break;
                case 5:
                    System.out.println("¡Un placer hacer negocios! *Cerrando programa*");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        guardarRepuestos();
        sc.close();
    }
}
