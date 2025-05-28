package ud7.pruebaExamen.inventario;

import java.io.*;
import java.util.*;

/**
 * @author [Tu Nombre Completo]
 * Programa para gestionar inventario con fichero binario.
 */
public class AppInventario {

    private static final String FICHERO = "inventario.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Todos los Productos");
            System.out.println("3. Buscar Producto por Código");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    agregarProducto(sc);
                    break;
                case "2":
                    listarProductos();
                    break;
                case "3":
                    buscarProducto(sc);
                    break;
                case "4":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Intenta de nuevo.");
            }
        }
        sc.close();
    }

    private static void agregarProducto(Scanner sc) {
        try {
            System.out.print("Código: ");
            int codigo = Integer.parseInt(sc.nextLine());

            // Verificar código no duplicado
            if (existeCodigo(codigo)) {
                System.out.println("Error: Código ya existe.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                return;
            }

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());

            Producto p = new Producto(codigo, nombre, cantidad, precio);

            // Guardar producto
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(FICHERO, true))) {
                // Si el fichero no está vacío, para evitar cabecera corrupta, se usa otro método
                // por simplicidad, vamos a leer, agregar y guardar toda la lista

                // Mejor usar método alternativo para append (leer lista, agregar, guardar)

                agregarYGuardarProducto(p);
            }

            System.out.println("Producto agregado.");

        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada numérica inválida.");
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    private static void agregarYGuardarProducto(Producto nuevo) throws IOException {
        List<Producto> productos = leerTodosProductos();
        productos.add(nuevo);
        productos.sort(Comparator.comparingInt(Producto::getCodigo));
        // Guardar todos los productos
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (Producto p : productos) {
                oos.writeObject(p);
            }
        }
    }

    private static List<Producto> leerTodosProductos() {
        List<Producto> lista = new ArrayList<>();
        File fichero = new File(FICHERO);
        if (!fichero.exists()) {
            return lista; // Vacía si no existe
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                Producto p = (Producto) ois.readObject();
                lista.add(p);
            }
        } catch (EOFException e) {
            // Fin de fichero esperado
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
        }
        return lista;
    }

    private static boolean existeCodigo(int codigo) {
        List<Producto> productos = leerTodosProductos();
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    private static void listarProductos() {
        List<Producto> productos = leerTodosProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        productos.sort(Comparator.comparingInt(Producto::getCodigo));
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    private static void buscarProducto(Scanner sc) {
        try {
            System.out.print("Introduce el código del producto a buscar: ");
            int codigo = Integer.parseInt(sc.nextLine());

            List<Producto> productos = leerTodosProductos();
            boolean encontrado = false;
            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    System.out.println("Producto encontrado:");
                    System.out.println(p);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró producto con código " + codigo);
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Código inválido.");
        }
    }
}
