package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class CajaTexto {

    public static void Caja(String palabra, String simbolo) {
        int anchoCaja = palabra.length() + 4;

        for (int i = 0; i < anchoCaja / simbolo.length(); i++) {
            System.out.print(simbolo);
        }
        System.out.println();

        System.out.println(simbolo + " " + palabra + " " + simbolo);

        for (int i = 0; i < anchoCaja / simbolo.length(); i++) {
            System.out.print(simbolo);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = scanner.nextLine();

        System.out.print("Introduce qué símbolo formará la caja: ");
        String simbolo = scanner.nextLine();
        System.out.println();
        scanner.close();

        Caja(palabra, simbolo);
    }
}
