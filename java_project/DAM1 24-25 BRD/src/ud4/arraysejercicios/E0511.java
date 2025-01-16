package ud4.arraysejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class E0511 {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a la cámara secreta!");
        System.out.println("¿Cómo de dificil quieres tu reto? (Número de digitos de la combinación a encontrar)");
        int dificultad = scanner.nextInt();

        int[] combinacion = generarCombinacion(dificultad);

        // Lectura adelantada
        int[] intento = leerIntento(dificultad);

        while (!Arrays.equals(combinacion, intento)) {
            mostrarPistas(combinacion, intento);
            intento = leerIntento(dificultad);
        } 

        System.out.println("¡Enhorabuena! ¡Has conseguido entrar a la cámara secreta!");

    }

    static void mostrarPistas(int[] tSecreto, int[] tUsuario) {
        for (int i = 0; i < tUsuario.length; i++) {
            if (tSecreto[i] == tUsuario[i]) {
                System.out.println("= ");
            } else if (tSecreto[i] > tUsuario[i]) {
                System.out.println("> ");
            } else {
                System.out.println("< ");
            }
            System.out.println("");
        }

    }

    static int[] leerIntento(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] combinacion = new int[n];
        System.out.println("Introduce los " + n + " digitos de la combinación.");
        for (int i = 0; i < combinacion.length; i++) {
            combinacion[i] = scanner.nextInt();
        }
        scanner.close();
        return combinacion;
    }

    static int[] generarCombinacion(int n) {
        Random rnd = new Random();
        int[] clave = new int[n];
        for (int i = 0; i < clave.length; i++) {
            clave[i] = rnd.nextInt(5) + 1;}
        return clave;
    }

    
}
