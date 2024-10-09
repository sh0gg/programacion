package ud1.ejercicios.parejas;

import java.util.Scanner;

public class UnidadesMedida {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Driver: Carlos de la Torre Aboal
        // Copilot: David Besada Ramilo
        double medida;
        double campoFutbolm2 = 105 * 70;
        double campoBasketm2 = 28 * 15;
        double campoTenism2 = 23.77 * 10.97;
        double retiro = 125;
        double hectarea = 10000;

        double campoFutbol = campoFutbolm2 / hectarea;
        double campoBasket = campoBasketm2 / hectarea;
        double campoTenis = campoTenism2 / hectarea;

        System.out.print("Introduce medida en hectáreas: ");
        medida = scanner.nextDouble();
        double medidaCampoFutbol = medida / campoFutbol;
        double medidaCampoBasket = medida / campoBasket;
        double medidaCampoTenis = medida / campoTenis;
        double medidaRetiro = medida / retiro;

        System.out.printf("Si tenemos %.2f hectáreas... %n", medida);
        System.out.printf("Serían %.2f campos de futbol %n", medidaCampoFutbol);
        System.out.printf("Serían %.2f campos de basket %n", medidaCampoBasket);
        System.out.printf("Serían %.2f campos de tenis %n", medidaCampoTenis);
        System.out.printf("Serían %.2f parques del Retiro %n", medidaRetiro);

        scanner.close();

    }
}
