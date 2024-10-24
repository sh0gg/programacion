package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0219 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double PI = Math.PI;

        System.out.print("Introduzca los grados que tiene el ángulo: ");
        double grados = scanner.nextDouble();
        scanner.close();

        while (grados > 360) {
            grados = grados % 360;
        }

        double radianes = grados * PI / 180;

        System.out.printf("%.2f grados son %.2f radianes", grados, radianes);
    }
}
