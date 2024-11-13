package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el número de fallos (0 a 7): ");
        int fallos = sc.nextInt();

        sc.close();
        
        System.out.println("Dibujo del ahorcado:");
        switch (fallos) {
            case 7 -> System.out.println("______|");
            case 6 -> System.out.println("/ \\ |\n______|");
            case 5 -> System.out.println(" /|\\ |\n | |\n / \\ |\n______|");
            case 4 -> System.out.println("O |\n /|\\ |\n | |\n / \\ |\n______|");
            case 3 -> System.out.println("O |\n/| |\n | |\n______|");
            case 2 -> System.out.println("O |\n/| |\n | |\n______|");
            case 1 -> System.out.println("O |\n | |\n______|");
            case 0 -> System.out.println(" |\n |\n______|");
            default -> System.out.println("Número de fallos inválido. Debe estar entre 0 y 7.");
        }
    }
}
