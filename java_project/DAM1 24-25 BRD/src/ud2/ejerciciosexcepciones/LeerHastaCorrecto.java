package ud2.ejerciciosexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerHastaCorrecto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean entradaValida = false;
        int numero = 0;

        while (!entradaValida) {
            System.out.print("Introduce un número entero: ");
            try {
                numero = scanner.nextInt();
                entradaValida = true;
                System.out.println("El número introducido es: " + numero);
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero, no letras u otros caracteres.");
                scanner.next(); // Limpia la entrada no válida
            }
        }
        scanner.close();
    }
}
