package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la cantidad de números: ");
        int n = sc.nextInt();

        sc.close();

        double[] numeros = new double[n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = sc.nextDouble();
            suma += numeros[i];
        }
        
        double media = suma / n;
        System.out.println("La media de los números es: " + media);
    }
}
