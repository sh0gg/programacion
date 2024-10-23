package ud2.ejercicioscondicionales;

import java.util.Scanner;

/**
 * Autor: David Besada
 * Programa para convertir un número entre 1 y 99 a texto.
 */

public class EP0214 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entre 1 y 99: ");
        int numero = sc.nextInt();

        if (numero < 1 || numero > 99) {
            System.out.println("El número está fuera de rango.");
        } else {
            System.out.println("El número " + numero + " en letras es: " + convertirNumeroATexto(numero));
        }
        sc.close();
    }

    public static String convertirNumeroATexto(int numero) {
        String[] unidades = { "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez",
                "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve" };
        String[] decenas = { "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
                "noventa" };

        if (numero < 20) {
            return unidades[numero];
        } else if (numero < 30) {
            if (numero == 20) {
                return "veinte";
            } else {
                return "veinti" + unidades[numero - 20];
            }
        } else {
            int unidad = numero % 10;
            int decena = numero / 10;
            if (unidad == 0) {
                return decenas[decena];
            } else {
                return decenas[decena] + " y " + unidades[unidad];
            }
        }
    }
}