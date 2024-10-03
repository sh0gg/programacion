package ud1.ejercicios;

/*
EP0111. Un economista te ha encargado un programa para realizar cálculos con el IVA. La
aplicación debe solicitar la base imponible y el IVA que se debe aplicar. Muestra en pantalla
el importe correspondiente al IVA y al total. 
*/

import java.util.Scanner;

public class EP0111 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el precio del artículo que quieres comprar:");
        double price = scanner.nextDouble();

        System.out.println("¿De cuanto es el IVA de este producto? (No escribas % solo el numero)");
        int ivaInt = scanner.nextInt();

        double iva = (ivaInt * 0.01);

        double finalPrice = price + (iva * price);

        System.out.println(finalPrice);


        scanner.close();
    }
}
