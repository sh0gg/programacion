package ud1.ejercicios;

import java.util.Scanner;
/*EP0116. Solicita al usuario tres distancias:
La primera, medida en milímetros.
La segunda, medida en centímetros.
La última, medida en metros.

Diseña un programa que muestre la suma de las tres longitudes introducidas (medida en
centimetros).
 */

public class EP0116 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mmLenght;
        double cmLenght;
        double mLenght;
        double totalLenght;

        System.out.println("======================");
        System.out.println("¡Vamos a sumar medidas!");
        System.out.println("======================");
        System.out.println("Introduce medida en milímetros:");
        mmLenght = scanner.nextDouble();

        System.out.println("Introduce medida en centímetros:");
        cmLenght = scanner.nextDouble();

        System.out.println("Introduce medida en metros:");
        mLenght = scanner.nextDouble();

        totalLenght = (mmLenght * 0.0120) + cmLenght + (mLenght * 100);

        System.out.println("¡Sumando todas las medidas introducidas, obtenémos: " + totalLenght + "cm!");

        scanner.close();
    }
}
