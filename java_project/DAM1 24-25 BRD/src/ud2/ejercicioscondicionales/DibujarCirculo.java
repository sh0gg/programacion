package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class DibujarCirculo {
    public static void main(String[] args) {

        System.out.println("¡Vamos a dibujar un circulo!");
        System.out.println("Dime el radio que quieras para el circulo: ");

        Scanner scanner = new Scanner(System.in);

        int radio = scanner.nextInt();
        int diametro = radio * 2;

        for (int y = 0; y <= diametro; y++) {
            for (int x = 0; x <= diametro; x++) {

                double distancia = Math.sqrt(Math.pow(x - radio, 2) + Math.pow(y - radio, 2));

                if (distancia <= radio) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();

    }
}
