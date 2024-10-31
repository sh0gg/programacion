package ud2.ejercicioscondicionales;


import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class EP0305 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.printf("¡Vamos a ver que tal calculas!%n");
       
        int respuesta = 1;
        int numero3 = 0;

        while (numero3 == respuesta) {

            int numero1 = random.nextInt(100);
            int numero2 = random.nextInt(100);
    
            numero3 = numero1 + numero2;

            System.out.printf("¡Suma %d con %d y escribe el resultado!%n", numero1, numero2);
            respuesta = scanner.nextInt();
            scanner.close();
            
        }

        scanner.close();
    }
    
}
