package ud2.ejercicioscondicionales;

import java.util.Scanner;
import java.util.Random;

public class EP0221 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rdm = new Random();

        final int MIN = 5;
        final int MAX = 30;

        int random = rdm.nextInt((MAX - MIN) + 1) + MIN; 
        /* (MAX - MIN) = Genera un número entre 0 y MAX-1
         * (MAX - MIN) + 1 = Genera un número entre 0 y MAX
         * + MIN = Se ajusta el valor mínimo del rango */

        long tiempoInicio = System.currentTimeMillis(); // Capturar tiempo de inicio en milisegundos
        System.out.printf("Pulse ENTER en %d segundos", random);
        scanner.nextLine();
        scanner.close();

        long tiempoFin = System.currentTimeMillis(); // Capturar tiempo de fin en milisegundos
        long tiempoTotal = (tiempoFin - tiempoInicio) / 1000;

        if (tiempoTotal == random){ 
            System.out.printf("\nEnhorabuena. \nAcertaste el momento correcto");
        }else if(random > tiempoTotal){
            System.out.printf("\nFallaste. \nTe adelantaste %d segundos.", random - tiempoTotal);
        }else{
            System.out.printf("\nFallaste. \nTe retrasaste %d segundos.", tiempoTotal - random);
        }
    }
}