package ud4.ejercicios5febrero;

import java.util.Scanner;

public class MontanaRusa {
    public static void main(String[] args) {
        int[] montañaRusa1 = new int[]{4, 10, 3, 2};
        int[] montañaRusa2 = new int[]{10, 3, 2, 4};
        int[] montañaRusa3 = new int[]{4, 10, 3, 2};
        int[] montañaRusa4 = new int[]{1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1};

    }
    int contarPicos(int[] alturas) {
        int contadorPicos = 0;
        for (int i = 0; i < alturas.length; i++) {
            if (alturas[i] == alturas[0] && alturas[i] > alturas[alturas.length] && alturas[i] > alturas[i + 1]) {
                contadorPicos++;
            } else if  

                if (alturas[i] > alturas[i-1] && alturas[i] > alturas[i+1]) {
                contadorPicos++;
            }
        }
        return contadorPicos;
    }
}
