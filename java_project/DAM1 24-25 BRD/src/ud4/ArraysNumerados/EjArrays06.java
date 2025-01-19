package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int[] numeros = new int[10];
        int sumaPositivos = 0, sumaNegativos = 0, cuentaPositivos = 0,
                cuentaNegativos = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
            if (numeros[i] > 0) {
                sumaPositivos += numeros[i];
                cuentaPositivos++;
            } else if (numeros[i] < 0) {
                sumaNegativos += numeros[i];
                cuentaNegativos++;
            }
        }

        sc.close();

        double mediaPositivos = cuentaPositivos > 0 ? (double) sumaPositivos /
                cuentaPositivos : 0;

        double mediaNegativos = cuentaNegativos > 0 ? (double) sumaNegativos /
                cuentaNegativos : 0;
                
        System.out.println("Media de valores positivos: " + mediaPositivos);
        System.out.println("Media de valores negativos: " + mediaNegativos);
    }
}