package celsius;

import java.util.Scanner;

public class FahrenheitACelsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar la temperatura en grados Fahrenheit
        System.out.print("Introduce la temperatura en grados Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        // Convertir a grados Celsius
        double celsius = (5.0 / 9.0) * (fahrenheit - 32);

        // Mostrar el resultado
        System.out.printf("La temperatura en grados Celsius es: %.2f °C%n", celsius);

        // Cerrar el escáner
        scanner.close();
    }
}