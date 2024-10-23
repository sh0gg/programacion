package ud2.ejercicioscondicionales;

import java.util.Scanner;

/**
 * Autor: David Besada
 * Programa para calcular la letra del DNI.
 */

public class EP0212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de DNI (sin letra): ");
        int dni = sc.nextInt();

        char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
                'L', 'C', 'K', 'E' };
        int indice = dni % 23;
        System.out.println("La letra correspondiente al DNI es: " + letras[indice]);
        sc.close();
    }
}