package ud1.ejercicios;

/*
 * Crea un programa que pida la base y la altura de un triángulo y muestre su área.
Área Triángulo = (base * altura) / 2

 */
import java.util.Scanner;

public class EP0112 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double base;
        double altura;
        double area;


        System.out.println("Vamos a calcular el área de un triángulo:");
        System.out.println("Dime la altura del triángulo:");

        altura = scanner.nextDouble();
        
        System.out.println("Dime el base del triángulo:");

        base = scanner.nextDouble();

        System.out.println("¡Vamos a calcular el área de un triángulo de " + altura + "cm de altura y " + base + "cm de base!");

        area = (base * altura) / 2;

        System.out.println("El triángulo tiene un área de " + area + "cm^2");

        scanner.close();
    }
}