package ud4.ArraysNumerados;

import java.util.Random;

public class EjArrays09 {
    public static void main(String[] args) {

        int[] numeros = new int[20];
        Random random = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(100); // Números aleatorios entre 0 y 99
        }

        System.out.println("Números aleatorios generados:");
        
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
    }
}
