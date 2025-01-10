package ud4.arraysejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Autor: David Besada Ramilo
 * Gestiona una encuesta sobre sueldos y muestra estadísticas.
 */

public class EP0514_Sueldos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList sueldos = new ArrayList<>();

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
            System.out.println("No se han registrado sueldos.");
        } else {
            double suma = 0;
            double max = (double) sueldos.get(0);
            double min = (double) sueldos.get(0);

            for (double sueldo : sueldos) {
                suma += sueldo;
                if (sueldo > max)
                    max = sueldo;
                if (sueldo < min)
                    min = sueldo;
            }

            double promedio = suma / sueldos.size();

            System.out.println("\nResultados de la encuesta:");
            System.out.println("Número de encuestados: " + sueldos.size());
            System.out.println("Sueldo promedio: " + promedio);
            System.out.println("Sueldo máximo: " + max);
            System.out.println("Sueldo mínimo: " + min);
        }

        scanner.close();
    }
}

