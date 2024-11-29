package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la cantidad de números pares a mostrar: ");
        int n = sc.nextInt();

        sc.close();
        
        mostrarPares(n);
    }
    
    public static void mostrarPares(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i * 2);
        }
    }
}

