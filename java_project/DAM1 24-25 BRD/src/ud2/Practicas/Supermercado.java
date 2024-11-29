package ud2.Practicas;

import java.util.Scanner;

public class Supermercado {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char atenderOtroCliente;

        do {
            procesarCompra();
            atenderOtroCliente = preguntarSiRepetir();
        } while (atenderOtroCliente == 's');

        System.out.println("¡Gracias por usar nuestro sistema de supermercado!");
        scanner.close();
    }

    // Función principal para procesar la compra de un cliente
    public static void procesarCompra() {
        double totalCompra = 0;
        double precio;
        int cantidad;
        int contadorArticulos = 0;

        // Registro de artículos individuales
        String listaArticulos = ""; // Almacena los detalles de cada artículo

        do {
            System.out.print("Introduce el precio del producto (0 o negativo para terminar): ");
            precio = leerDouble();

            if (precio > 0) {
                System.out.print("Introduce la cantidad del producto: ");
                cantidad = leerInt();

                contadorArticulos++;
                double subtotal = precio * cantidad;
                totalCompra += subtotal;

                // Registrar detalles del artículo
                listaArticulos += String.format("Artículo %d: %.2f € x %d unidades = %.2f €%n",
                        contadorArticulos, precio, cantidad, subtotal);
            }
        } while (precio > 0);

        System.out.println("\nResumen de la compra:");
        System.out.println(listaArticulos);
        System.out.printf("Total de la compra: %.2f €%n", totalCompra);

        procesarPago(totalCompra);
    }

    // Función para procesar el pago
    public static void procesarPago(double totalCompra) {
        char metodoPago = '\0';

        while (metodoPago != 't' && metodoPago != 'e') {
            System.out.print("¿Método de pago (t)arjeta o (e)fectivo)? ");
            metodoPago = scanner.nextLine().toLowerCase().charAt(0);

            if (metodoPago == 't') {
                System.out.println("Pago realizado con tarjeta. Compra finalizada.");
            } else if (metodoPago == 'e') {
                calcularCambio(totalCompra);
            } else {
                System.out.println("Método de pago no válido. Inténtalo de nuevo.");
            }
        }
    }

    // Función para calcular y mostrar el cambio
    public static void calcularCambio(double totalCompra) {
        double importePagado = 0;

        while (importePagado < totalCompra) {
            System.out.print("Introduce el importe entregado: ");
            importePagado = leerDouble();

            if (importePagado < totalCompra) {
                System.out.println("El importe entregado es insuficiente. Inténtalo de nuevo.");
            }
        }

        double cambio = importePagado - totalCompra;
        System.out.printf("Cambio a devolver: %.2f €%n", cambio);
        desglosarCambio(cambio);
    }

    // Función para desglosar el cambio
    public static void desglosarCambio(double cambio) {
        // Valores de billetes y monedas
        final int FIVE_HUNDRED = 500;
        final int TWO_HUNDRED = 200;
        final int ONE_HUNDRED = 100;
        final int FIFTY = 50;
        final int TWENTY = 20;
        final int TEN = 10;
        final int FIVE = 5;
        final int TWO = 2;
        final int ONE = 1;

        // Céntimos
        final int FIFTY_CENTS = 50;
        final int TWENTY_CENTS = 20;
        final int TEN_CENTS = 10;
        final int FIVE_CENTS = 5;
        final int TWO_CENTS = 2;
        final int ONE_CENT = 1;

        int integer = (int) Math.floor(cambio); // Parte entera (euros)
        int decimals = (int) Math.floor((cambio - integer) * 100); // Parte decimal (céntimos)

        System.out.printf("Billetes de 500€: %d%n", integer / FIVE_HUNDRED);
        integer %= FIVE_HUNDRED;

        System.out.printf("Billetes de 200€: %d%n", integer / TWO_HUNDRED);
        integer %= TWO_HUNDRED;

        System.out.printf("Billetes de 100€: %d%n", integer / ONE_HUNDRED);
        integer %= ONE_HUNDRED;

        System.out.printf("Billetes de 50€: %d%n", integer / FIFTY);
        integer %= FIFTY;

        System.out.printf("Billetes de 20€: %d%n", integer / TWENTY);
        integer %= TWENTY;

        System.out.printf("Billetes de 10€: %d%n", integer / TEN);
        integer %= TEN;

        System.out.printf("Billetes de 5€: %d%n", integer / FIVE);
        integer %= FIVE;

        System.out.printf("Monedas de 2€: %d%n", integer / TWO);
        integer %= TWO;

        System.out.printf("Monedas de 1€: %d%n", integer / ONE);
        integer %= ONE;

        System.out.printf("Monedas de 50 céntimos: %d%n", decimals / FIFTY_CENTS);
        decimals %= FIFTY_CENTS;

        System.out.printf("Monedas de 20 céntimos: %d%n", decimals / TWENTY_CENTS);
        decimals %= TWENTY_CENTS;

        System.out.printf("Monedas de 10 céntimos: %d%n", decimals / TEN_CENTS);
        decimals %= TEN_CENTS;

        System.out.printf("Monedas de 5 céntimos: %d%n", decimals / FIVE_CENTS);
        decimals %= FIVE_CENTS;

        System.out.printf("Monedas de 2 céntimos: %d%n", decimals / TWO_CENTS);
        decimals %= TWO_CENTS;

        System.out.printf("Monedas de 1 céntimo: %d%n", decimals / ONE_CENT);
    }

    // Función para preguntar si se desea repetir el proceso
    public static char preguntarSiRepetir() {
        char respuesta = '\0';
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("¿Atender a otro cliente? (s/n): ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("No puedes dejar la respuesta vacía.");
                }
                if (input.length() > 1 || (input.charAt(0) != 's' && input.charAt(0) != 'n')) {
                    throw new IllegalArgumentException("Introduce 's' para sí o 'n' para no.");
                }
                respuesta = input.charAt(0);
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return respuesta;
    }

    // Función para leer un double controlando excepciones y entradas vacías
    public static double leerDouble() {
        double resultado = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("No puedes dejar el valor vacío.");
                }
                resultado = Double.parseDouble(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número válido: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }

    // Función para leer un entero controlando excepciones y entradas vacías
    public static int leerInt() {
        int resultado = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("No puedes dejar el valor vacío.");
                }
                resultado = Integer.parseInt(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número entero válido: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
}
