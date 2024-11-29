package ud2.ejerciciosbucles;

import java.util.Scanner;

public class EP0314 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número: ");
        int n = sc.nextInt();
        sc.close();
        int contadorPrimos = 0;

        for (int i = 2; i <= n; i++) {
            if (esPrimo(i)) {
                contadorPrimos++;
            }
        }

        System.out.println("Cantidad de números primos entre 1 y " + n + ": " + contadorPrimos);
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
