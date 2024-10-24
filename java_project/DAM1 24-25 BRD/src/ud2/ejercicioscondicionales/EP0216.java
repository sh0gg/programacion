/* Utiliza el operador ternario para calcular el valor absoluto de un número que se solicita al usuario por teclado */

package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0216 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca un número: ");
        int numero = scanner.nextInt();
        scanner.close();

        int valorAbsoluto = (numero > 0) ? numero : -numero;

        System.out.println("Valor absoluto: " + valorAbsoluto); 
    }
}
