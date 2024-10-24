package ud1.dbrexamen;


// Mi nombre es David Besada Ramilo

import java.util.Scanner;

public class AreaPerimetro {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        double pi = Math.PI;
        double radio;
        double base;
        double largo;
        double ancho;
        double perimetro;
        double distancia = 21097.0;
        double area;
        double metrosSobrantes;
        double valorVueltas;

        System.out.println("Vamos a calcular cuantas vueltas son necesarias para correr una media maratón...");
        System.out.println("... en una pista de las siguientes dimensiones:");
        System.out.println("Introduce un largo para la pista");
        largo = scanner.nextDouble();
        System.out.println("Introduce un ancho para la pista:");
        ancho = scanner.nextDouble();

        radio = ancho / 2;
        base = largo - ancho;

        perimetro = (2 * base) + (2 * pi * radio);

        area = (pi * Math.pow(radio, 2)) + (base * ancho);

        valorVueltas = distancia / perimetro;

        int numeroVueltas = (int) valorVueltas;

        metrosSobrantes = distancia - ( numeroVueltas * perimetro);

        System.out.printf("Serán un total de %d vueltas y sobrarán %.0f metros tras completar la media maratón %n", numeroVueltas, metrosSobrantes);
        System.out.printf("El área del terreno es de %.2f metros cuadrados %n", area);
        System.out.printf("El perímetro del terreno es de %.2f metros %n", perimetro);

        scanner.close();
    }
}
