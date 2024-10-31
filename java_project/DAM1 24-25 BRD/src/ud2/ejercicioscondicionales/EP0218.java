package ud2.ejercicioscondicionales;

import java.util.Scanner;
import java.util.Random;

public class EP0218 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MAX = 100;

        int num1 = random.nextInt(MAX);
        int num2 = random.nextInt(MAX);

        System.out.printf("\nNúmero 1 = %d", num1);
        System.out.printf("\nNúmero 2 = %d", num2);

        System.out.print("\nIntroduzca la suma de los números anteriores: ");
        int suma = scanner.nextInt();
        scanner.close();

        int resultado = num1 + num2;

        if (suma == resultado) {
            System.out.println("El número es correcto");
        } else {
            System.out.println("El número introducido es incorrecta");
            System.out.println("Resultado: " + resultado);
        }
    }

}
