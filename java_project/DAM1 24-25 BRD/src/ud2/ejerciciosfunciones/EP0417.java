package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int a = sc.nextInt();
        
        System.out.print("Introduce el segundo número: ");
        int b = sc.nextInt();

        sc.close();
        
        if (sonAmigos(a, b)) {
            System.out.println("Los números son amigos.");
        } else {
            System.out.println("Los números no son amigos.");
        }
    }
    
    public static boolean sonAmigos(int a, int b) {
        return sumaDivisoresPropios(a) == b && sumaDivisoresPropios(b) == a;
    }
    
    public static int sumaDivisoresPropios(int numero) {
        int suma = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma;
    }
}

