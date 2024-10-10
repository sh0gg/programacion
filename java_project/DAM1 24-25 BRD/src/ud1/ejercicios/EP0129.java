package ud1.ejercicios;

import java.util.Scanner;

/* EP0129. Escribe un programa que tome como entrada un número entero e indique qué
cantidad hay que sumarle para que el resultado sea múltiplo de 7. Un ejemplo:
A 2 hay que sumarle 5 para que el resultado (2+5=7) sea múltiplo de 7.
A 13 hay que sumarle 1 para que el resultado (13+1=14) sea múltiplo de 7.
Si proporcionas el número 2 o el 13, la salida de la aplicación debe ser 5 o 1,
respectivamente.
Pista: El operador módulo puede ser muy útil para solucionar esta actividad.
*/

public class EP0129 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un número entero:");
        int numero = scanner.nextInt();

        int resto = numero % 7;
        int suma = (resto == 0) ? 0 : (7 - resto);

        System.out.println("A " + numero + " hay que sumarle " + suma + " para que sea múltiplo de 7.");

        scanner.close();
    }
}