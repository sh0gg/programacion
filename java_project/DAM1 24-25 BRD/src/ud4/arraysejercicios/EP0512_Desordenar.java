package ud4.arraysejercicios;

/**
* Autor: David Besada Ramilo
* Desordena los elementos de un array de forma aleatoria.
*/

import java.util.Random;

public class EP0512_Desordenar {

    public static void desordenar(int[] t) {
        Random rand = new Random();
        for (int i = t.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] t = { 1, 2, 3, 4, 5 };
        System.out.println("Array original:");
        for (int num : t) {
            System.out.print(num + " ");
        }
        desordenar(t);
        System.out.println("\nArray desordenado:");
        for (int num : t) {
            System.out.print(num + " ");
        }
    }
}
