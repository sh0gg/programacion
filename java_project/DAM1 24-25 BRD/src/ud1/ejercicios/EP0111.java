package ud1.ejercicios;

/*
EP0111. Un economista te ha encargado un programa para realizar cálculos con el IVA. La
aplicación debe solicitar la base imponible y el IVA que se debe aplicar. Muestra en pantalla
el importe correspondiente al IVA y al total. 
*/

import java.util.Scanner;

public class EP0111 {
    public static void main(String[] args) {

        double baseImponible;
        double ivaImporte;
        int ivaInt;
        

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el precio del artículo que quieres comprar:");
        baseImponible = scanner.nextDouble();

        System.out.println("¿De cuánto es el IVA de este producto? (No escribas % solo el número)");
        ivaInt = scanner.nextInt();

        ivaImporte = ((ivaInt * 0.01) * baseImponible);

        double importeFinal = baseImponible + ivaImporte;

        System.out.println("El precio final es de " + importeFinal + " euros, siendo " + ivaImporte + " euros la cantidad de IVA que pagas" );


        scanner.close();
    }
}
