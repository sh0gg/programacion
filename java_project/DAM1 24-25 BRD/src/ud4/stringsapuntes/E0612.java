package ud4.stringsapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class E0612 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Vamos a comprobar si dos palabras son anagramas:");
        System.out.print("Palabra 1: ");
        String palabra1 = entrada.nextLine();
        System.out.print("Palabra 2: ");
        String palabra2 = entrada.nextLine();

        if (palabra1.length() == palabra2.length()) {
            char[] t1 = (palabra1.toLowerCase()).toCharArray();
            char[] t2 = (palabra2.toLowerCase()).toCharArray();

            Arrays.sort(t1);
            Arrays.sort(t2);

            if (Arrays.equals(t1, t2)) {
                System.out.println(palabra1 + " y " + palabra2 + " son anagramas");
            } else {
                System.out.println("No son anagramas");
            }
        } else {
            System.out.println("No son anagramas");
        }

    }
}
