package ud2.ejerciciosexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExcepcionTiposEntrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce un número entero: ");
            int numero = scanner.nextInt();
            System.out.println("El número introducido es: " + numero);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero, no letras u otros caracteres.");
        } finally {
            scanner.close();
        }
    }
}