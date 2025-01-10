package ud4.arraysejercicios;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Autor: David Besada Ramilo
 * Gestiona una encuesta sobre sueldos y muestra estadísticas.
 */

public class EP0514_Sueldos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> sueldos = new ArrayList<>();
        double suma = 0;

        System.out.println("Encuesta de nivel adquisitivo:");
        System.out.println("Introduce los sueldos de los habitantes (introduce -1 para finalizar):");

        while (true) {
            System.out.print("Sueldo: ");
            double sueldo = scanner.nextDouble();

            if (sueldo == -1) {
                break;
            }

            if (sueldo < 0) {
                System.out.println("Por favor, introduce un sueldo válido o -1 para finalizar.");
                continue;
            }

            sueldos.add(sueldo);
        }

        if (sueldos.isEmpty()) {
            scanner.close();
            System.out.println("No se introdujeron sueldos.");
            return;
        }

        // Ordenar sueldos de forma decreciente
        Collections.sort(sueldos, Collections.reverseOrder());

        double max = sueldos.get(0);
        double min = sueldos.get(sueldos.size() - 1);
        double media = suma / sueldos.size();

        int porEncimaMedia = 0, porDebajoMedia = 0;
        for (double sueldo : sueldos) {
            if (sueldo > media)
                porEncimaMedia++;
            else if (sueldo < media)
                porDebajoMedia++;
        }

        // Mostrar resultados
        System.out.println("Sueldos ordenados de forma decreciente:");
        for (double sueldo : sueldos) {
            System.out.print(sueldo + " ");
        }
        System.out.println("\nSueldo máximo: " + max);
        System.out.println("Sueldo mínimo: " + min);
        System.out.println("Media de sueldos: " + media);
        System.out.println("Sueldos por encima de la media: " + porEncimaMedia);
        System.out.println("Sueldos por debajo de la media: " + porDebajoMedia);
    

        scanner.close();
    }
}
