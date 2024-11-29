package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0412 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Introduce y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Introduce x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Introduce y2: ");
        double y2 = sc.nextDouble();

        sc.close();
        
        double distancia = calcularDistancia(x1, y1, x2, y2);
        System.out.printf("La distancia euclídea es: %.2f%n", distancia);
    }
    
    public static double calcularDistancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
