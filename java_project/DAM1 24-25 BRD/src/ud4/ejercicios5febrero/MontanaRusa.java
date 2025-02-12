package ud4.ejercicios5febrero;

import java.util.Scanner;

public class MontanaRusa {
    public static void main(String[] args) {
        int[] montanaRusa1 = new int[]{4, 10, 3, 2};
        int[] montanaRusa2 = new int[]{10, 3, 2, 4};
        int[] montanaRusa3 = new int[]{4, 10, 3, 2};
        int[] montanaRusa4 = new int[]{1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1};

        System.out.println(contarPicos(montanaRusa1));
        System.out.println(contarPicos(montanaRusa2));
        System.out.println(contarPicos(montanaRusa3));
        System.out.println(contarPicos(montanaRusa4));

    }
    public static int contarPicos(int[] alturas) {
            int contadorPicos = 0;
            for (int i = 0; i < alturas.length; i++) {
                if (alturas[i] == alturas[0] && alturas[i] > alturas[alturas.length] && alturas[i] > alturas[i + 1]) {
                    contadorPicos++;
                } else if (alturas[i] == alturas[alturas.length] && alturas[i] > alturas[0] && alturas[i] > alturas[i - 1] ) {
                    contadorPicos++;
                } else if (alturas[i] > alturas[i-1] && alturas[i] > alturas[i+1]) {
                    contadorPicos++;
                }
            }
            return contadorPicos;
    }
}
