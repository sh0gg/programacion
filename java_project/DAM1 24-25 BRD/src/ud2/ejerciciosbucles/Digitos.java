package ud2.ejerciciosbucles;

import java.util.Scanner;

public class Digitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número entero: ");
        int numero = sc.nextInt();
        sc.close();
        
        System.out.println("Dígitos del número:");
        while (numero != 0) {
            System.out.println(numero % 10);
            numero /= 10;
        }
    }
}
