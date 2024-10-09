package ud1.ejercicios.parejas;

import java.util.Scanner;

public class RecetasIngredientes {

    public static void main(String[] args) {
       
        // Driver: David Besada Ramilo
        // Copilot: Carlos de la Torre Aboal
        
        Scanner scanner = new Scanner(System.in);

        int numPersonas;
        double kgManz = 1.5;
        double mlAgua = 330;
        double gAzuca = 120;
        double cuchLimon = 1;
        double pielNaran = 1;
        double ramiCanel = 1;
        final double numPersonasBase = 6;

        System.out.printf("===================================== %n");
        System.out.printf("¿Cómo hacer una compota de manzana? %n");
        System.out.printf("===================================== %n");
        System.out.printf("Pincha aquí para ir a la web de la receta https://www.recetasderechupete.com/compota-de-manzana-casera/12509/ %n");
        System.out.printf("¡Esta receta es para seis personas! %n");
        System.out.printf("Los ingredientes necesarios son: %n");
        System.out.printf("- 1kg y medio de tus manzanas favoritas %n");
        System.out.printf("- 330ml de agua %n");
        System.out.printf("- 120g de azúcar (blanco o moreno) %n");
        System.out.printf("- Una cucharadita de zumo de limón %n");
        System.out.printf("     Ingredientes opcionales %n");
        System.out.printf("- La piel de una naranja %n");
        System.out.printf("- Una ramita de canela %n");

        System.out.printf("===================================== %n");

        System.out.print("¿Para cuántos vas a hacer esta receta?   ");
        numPersonas = scanner.nextInt();

        double multManz = ( kgManz / numPersonasBase ) * numPersonas;
        double multAgua = ( mlAgua / numPersonasBase ) * numPersonas;
        double multAzuc = ( gAzuca / numPersonasBase ) * numPersonas;
        double multLimo = ( cuchLimon / numPersonasBase ) * numPersonas;
        double multNara = ( pielNaran / numPersonasBase ) * numPersonas;
        double multCane = ( ramiCanel / numPersonasBase ) * numPersonas;

        System.out.println("En caso de ser " + numPersonas + "... Las cantidades serían las siguientes.");
        System.out.printf("- %.2f kg de tus manzanas favoritas %n", multManz);
        System.out.printf("- %.2f ml de agua %n", multAgua);
        System.out.printf("- %.2f g de azúcar (blanco o moreno) %n", multAzuc);
        System.out.printf("- %.0f cucharadita de zumo de limón %n", multLimo);
        System.out.printf("     Ingredientes opcionales %n");
        System.out.printf("- La piel de %.0f naranja(s) %n", multNara);
        System.out.printf("- %.0f ramita(s) de canela %n", multCane);
    
        scanner.close();
    }
}
