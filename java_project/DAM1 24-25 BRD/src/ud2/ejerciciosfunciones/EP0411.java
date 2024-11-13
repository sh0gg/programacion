package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0411 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el radio de la esfera: ");
        double radio = sc.nextDouble();

        sc.close();
        
        double superficie = calcularSuperficie(radio);
        double volumen = calcularVolumen(radio);
        
        System.out.printf("Superficie: %.2f%n", superficie);
        System.out.printf("Volumen: %.2f%n", volumen);
    }
    
    public static double calcularSuperficie(double radio) {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
    
    public static double calcularVolumen(double radio) {
        return (4.0 / 3) * Math.PI * Math.pow(radio, 3);
    }
}
