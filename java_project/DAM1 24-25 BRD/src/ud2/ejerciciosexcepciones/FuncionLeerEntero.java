package ud2.ejerciciosexcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionLeerEntero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = leerEntero(scanner);
        System.out.println("El número introducido es: " + numero);
        scanner.close();
    }

    public static int leerEntero(Scanner scanner) {
        System.out.print("Introduce un número entero: ");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número entero, no letras u otros caracteres.");
            scanner.next(); // Limpia la entrada no válida
            return leerEntero(scanner); // Llama a la función de forma recursiva
        }
    }
}
