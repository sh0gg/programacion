package ud2.DBRexamen;

// Ejercicio hecho por David Besada

import java.util.Scanner;

public class MenuFiguras {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menu();
        int respuesta = leerInt();

        int respuPestaFallida = 0;

        if (respuesta == 0) {
            System.out.println("Fin del programa");
            return;
        }

        // COMPLETAMENTE INUTIL, NO TE PREOCUPES POR ESTO PROFE, ME RENDÍ

        while (respuesta < 0 || respuesta > 2) {
            respuestaFallida = respuestaFallida + 1;

            if (respuestaFallida > 2) {
                System.out.println("Fin del programa");
                return;
            }

            System.out.println("Opción inválida.");
            System.out.println("");
            menu();
        }

        if (respuesta == 1) {
            System.out.println("Vamos a dibujar un triángulo");
            System.out.println("¿Qué base tendrá tu triángulo? (Entre 2 y 20)");
            int base = leerInt();
            System.out.println("¿Qué altura tendrá tu triángulo? (Entre 2 y 20)");
            int altura = leerInt();
            triangulo(base, altura);
        }

        if (respuesta == 2) {
            System.out.println("Vamos a dibujar un rectángulo");
            System.out.println("¿Qué base tendrá tu rectángulo? (Entre 2 y 20)");
            int base = leerInt();
            System.out.println("¿Qué altura tendrá tu rectángulo? (Entre 2 y 20)");
            int altura = leerInt();
            rectangulo(base, altura);
        }

        System.out.println("Fin del programa");

    }

    public static void menu() {
        System.out.println("1. Triángulo");
        System.out.println("2. Rectángulo");
        System.out.println("0. SALIR");
    }

    public static void triangulo(int base, int altura) {
        if (base < 2 || base > 20) {
            System.out.println("Valores inválidos");
            return;
        }
        // me quedé en blanco
    }

    public static void rectangulo(int base, int altura) {
        if (base < 2 || base > 20) {
            System.out.println("Valores inválidos");
            return;
        }
        // me quedé en blanco
    }

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
