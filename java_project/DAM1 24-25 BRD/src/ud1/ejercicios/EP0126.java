package ud1.ejercicios;

import java.util.Scanner;

public class EP0126 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        double numero, raiz;
        // En este ejercicio usamos la clase Scanner sin importarla previamente.
        Scanner scanner = new Scanner(System.in);
        // Entrada de datos
        System.out.print("Introduce un número real: ");
        numero = scanner.nextDouble();
        // Proceso
        raiz = Math.sqrt(numero);
        // Salida
        System.out.println("Raíz cuadrada: " + raiz);
        scanner.close();    
    }
        
}
