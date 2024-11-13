package ud2.ejerciciosfunciones;

import java.util.Scanner;
import java.util.Random;

public class EP0418 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la cantidad de números aleatorios: ");
        int cantidad = sc.nextInt();
        
        System.out.print("Introduce el valor mínimo: ");
        int minimo = sc.nextInt();
        
        System.out.print("Introduce el valor máximo: ");
        int maximo = sc.nextInt();

        sc.close();
        
        mostrarNumerosAleatorios(cantidad, minimo, maximo);
    }
    
    public static void mostrarNumerosAleatorios(int cantidad, int minimo, int maximo) {
        Random rand = new Random();
        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = rand.nextInt((maximo - minimo) + 1) + minimo;
            System.out.println(numeroAleatorio);
        }
    }
}
