package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matriz = new int[3][3];
        int suma = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Introduce el valor para [" + i + "][" + j +
                        "]: ");
                matriz[i][j] = sc.nextInt();
                suma += matriz[i][j];
            }
        }

        sc.close();
        
        System.out.println("La suma de todos los elementos de la matriz es: " +
                suma);
    }
}
