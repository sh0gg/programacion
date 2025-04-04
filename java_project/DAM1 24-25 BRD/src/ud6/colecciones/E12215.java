package ud6.colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E12215 {

    static Map<Producto, Integer> stock = new HashMap<>();

    static void add(Producto producto, Integer cantidad) {
        stock.put(producto, cantidad);
    }

    static void delete(Producto producto) {
        stock.remove(producto);
    }

    static void edit(Producto producto, Integer cantidad) {
        stock.remove(producto);
        stock.put(producto, cantidad);
    }

    static void cargarRepuestos() {
        //TODO: CARGAR FICHERO stock.json
    }

    static void guardarRepuestos() {
        //TODO: GUARDAR FICHERO stock.json
    }

    static void showMenu() {
        System.out.println("¿Qué te gustaría hacer?");
        System.out.println("1. Lista de stock");
        System.out.println("2. Añadir un nuevo repuesto");
        System.out.println("3. Eliminar un repuesto");
        System.out.println("4. Editar stock");
        System.out.println("5. Salir");
    }

    public class Producto {
        protected String codigo;
        protected String nombre;

        Producto(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return nombre + " - " + codigo;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarRepuestos();

        int respuesta = 0;
        System.out.println("¡Bienvenido a la app de MegaRepuestos!");

        while (respuesta != 5) {
            String codigo;
            Integer cantidad;

            showMenu();

            respuesta = sc.nextInt();

            switch (respuesta) {
                case 1:
                    System.out.println(stock);
                    break;
                case 2:
                    System.out.println("Introduce el código del repuesto que quieras crear:");
                    codigo = sc.next();
                    System.out.println("Introduce la cantidad de stock:");
                    cantidad = sc.nextInt();
                    add(codigo,cantidad);
                    break;
                case 3:
                    System.out.println("Introduce el código del repuesto que quieras eliminar:");
                    codigo = sc.next();
                    delete(codigo);
                    break;
                case 4:
                    System.out.println("¿De qué repuesto quieres modificar el stock?");
                    codigo = sc.next();
                    System.out.println("¿Cuál es el nuevo stock?");
                    cantidad = sc.nextInt();
                    edit(codigo,cantidad);
                    break;
                case 5:
                    System.out.println("¡Un placer hacer negocios! *Cerrando programa*");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        }

        guardarRepuestos();

    }
}
