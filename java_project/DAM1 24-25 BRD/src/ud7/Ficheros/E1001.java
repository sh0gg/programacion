package ud7.Ficheros;

import java.util.Scanner;

public class E1001 {
    public static Integer leerEntero() {
        Scanner sc = new Scanner(System.in);
        Integer numero = null;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Introduce un número entero: ");
                numero = sc.nextInt();
                valido = true;
            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero válido.");
                sc.nextLine(); // Limpiar el buffer del scanner
            }
        }

        return numero;
    }

    public static void main(String[] args) {
        int numero = leerEntero();
        System.out.println("Número introducido: " + numero);
    }
}
