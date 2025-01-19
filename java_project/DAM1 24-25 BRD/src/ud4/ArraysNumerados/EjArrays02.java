package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];
        int suma = 0, contador = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
            if (i % 2 == 0) { // Solo suma posiciones pares
                suma += numeros[i];
                contador++;
            }
        }

        sc.close();

        double media = (double) suma / contador;
        
        System.out.println("La media de los números en posiciones pares es: " +
                media);
    }
}