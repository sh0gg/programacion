package ud2.ejerciciosbucles;

import java.util.Scanner;

public class EP0319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        int numero = sc.nextInt();
        sc.close();
        
        int raizEntera = 0;
        while ((raizEntera + 1) * (raizEntera + 1) <= numero) {
            raizEntera++;
        }
        
        int resto = numero - (raizEntera * raizEntera);
        System.out.println("La raíz entera es: " + raizEntera + " y el resto es: " + resto);
    }
}
