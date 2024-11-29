package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0416 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();
        
        sc.close();
        
        System.out.println("Divisores primos:");
        mostrarDivisoresPrimos(numero);
    }
    
    public static void mostrarDivisoresPrimos(int numero) {
        for (int i = 2; i <= numero; i++) {
            if (numero % i == 0 && esPrimo(i)) {
                System.out.println(i);
            }
        }
    }
    
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
