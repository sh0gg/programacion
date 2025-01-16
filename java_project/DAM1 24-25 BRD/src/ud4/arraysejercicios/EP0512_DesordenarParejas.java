package ud4.arraysejercicios;

/**
 * Autor: David Besada Ramilo
 * Desordena los elementos de un array de Strings de forma aleatoria.
 */

import java.util.Random;

public class EP0512_DesordenarParejas {

    public static void desordenar(String[] t) {
        Random rand = new Random();
        for (int i = t.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }

    public static void main(String[] args) {
        String[] t = { "Pareja 1", "Pareja 2", "Pareja 3", "Pareja 4", "Pareja 5", "Pareja 6", "Pareja 7", "Pareja 8", "Pareja 9", "Pareja 10"};
        System.out.println("Array original:");
        for (String str : t) {
            System.out.print(str + " ");
        }
        desordenar(t);
        System.out.println("\nArray desordenado:");
        for (int i = 0; i < t.length; i++) {
            if (i == t.length - 1) {
                System.out.print(t[i] + ".");
            } else {
                System.out.print(t[i] + ", "); // Coma para los demás
            }
        }
    }
}

