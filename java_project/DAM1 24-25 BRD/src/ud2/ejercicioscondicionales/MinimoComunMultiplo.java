package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class MinimoComunMultiplo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Vamos a calcular el mínimo común múltiplo de dos números!");
        System.out.printf("Dame un número: ");
        int a = scanner.nextInt();
        System.out.printf("Dame un segundo número: ");
        int b = scanner.nextInt();

        System.out.printf("Usaremos los números %d y %d... %n", a, b);
        scanner.close();

        if ( b < a ) {
            int c = a;
            a = b;
            b = c;
        }
 
        int aBase = a;
        int bBase = b;
        int multiplosA = 1;
        int multiplosB = 1;

        if (aBase < bBase) {
            while (a != b) {
                a = aBase + a;
              //  System.out.printf("Agreguémos multipos a %d : %d %n", aBase, a);
                if (a > b) {
                   // System.out.printf("%d es mayor que %d, vamos a agregar múltiplos de %d %n", a, b, bBase);
                   // System.out.printf("Agreguémos multipos a %d : %d %n", bBase, b);
                    b = bBase + b;
                    
                   // System.out.printf("%d es diferente de %d, continuemos... %n", a, b);
                }
                
            }
        }
        System.out.printf("%d es igual a %d... ¡GENIAL! %n", a, b);

        // System.out.printf("%d es igual a %d... ¡GENIAL! %n", a, b);
        int mcm = a;
        System.out.printf("El MCM de %d y %d es %d %n", aBase, bBase, mcm );
        System.out.printf("Hemos tenido que calcular %d múltiplos de %d y %d múltiplos de %d %n", multiplosA, aBase, multiplosB, bBase);
    
    }

}
