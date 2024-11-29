package ud2.ejerciciosbucles;

import java.util.Scanner;

public class MayorMenorNNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        
        while (true) {
            System.out.print("Introduce un número (0 o negativo para terminar): ");
            int numero = sc.nextInt();
            
            if (numero <= 0) {
                sc.close();
                break;
            }
            
            if (numero > mayor) {
                mayor = numero;
            }
            if (numero < menor) {
                menor = numero;
            }
        }

        System.out.println("El número mayor es: " + mayor);
        System.out.println("El número menor es: " + menor);
    }
}
