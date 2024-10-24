package ud2.ejercicioscondicionales;

import java.util.Scanner;

/**
 * Autor: David Besada
 * Programa para determinar si hay suficiente comida para los animales.
 */

public class EP0213 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la cantidad de comida diaria (en kg): ");
        double comidaDiaria = scanner.nextDouble();
        System.out.print("Introduce el número de animales: ");
        int numAnimales = scanner.nextInt();
        System.out.print("Introduce la cantidad de comida que come cada animal (en kg): ");
        double kilosPorAnimal = scanner.nextDouble();
        scanner.close();

        if (numAnimales > 0) {
            double comidaNecesaria = numAnimales * kilosPorAnimal;
            if (comidaDiaria >= comidaNecesaria) {
                System.out.println("Hay suficiente comida para alimentar a los animales.");
            } else {
                double racion = comidaDiaria / numAnimales;
                System.out.println("No hay suficiente comida. Cada animal recibirá " + racion + " kg.");
            }
        } else {
            System.out.println("El número de animales debe ser mayor que cero.");
        }

    }
}