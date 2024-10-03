package interesCompuesto;

import java.util.Scanner;

public class interesCompuesto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el importe en euros que deseas invertir: ");
        double importe = scanner.nextDouble();

        System.out.print("Introduce el número de años que durará la inversión: ");
        int años = scanner.nextInt();

        // System.out.print("Introduce el número de pagos por año: ");
        // int pagosPorAño = scanner.nextInt();
        
        int pagosPorAño = 1;

        // Tasa de interés fija
        double tasaInteres = 0.045; // 4.5%

        // Calcular el importe final usando la fórmula del interés compuesto
        double importeFinal = importe * Math.pow(1 + (tasaInteres / pagosPorAño), pagosPorAño * años);

        System.out.printf("El importe final después de %d años es: %.2f euros%n", años, importeFinal);

        scanner.close();
    }
}
