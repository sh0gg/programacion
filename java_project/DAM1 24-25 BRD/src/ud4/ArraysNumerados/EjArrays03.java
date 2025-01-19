package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Número de alumnos: ");

        int n = sc.nextInt();
        double[] notas = new double[n];
        double suma = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Introduce la nota del alumno " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
            suma += notas[i];
        }

        sc.close();

        double media = suma / n;

        System.out.println("Nota media del grupo: " + media);
        System.out.println("Notas superiores a la media:");
        
        for (int i = 0; i < n; i++) {
            if (notas[i] > media) {
                System.out.println("Alumno " + (i + 1) + " con nota: " +
                        notas[i]);
            }
        }
    }
}