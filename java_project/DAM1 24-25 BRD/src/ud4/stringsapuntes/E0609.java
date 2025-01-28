package ud4.stringsapuntes;

import java.util.Scanner;

public class E0609 {
    public static void main(String[] args) {
        String frase = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca palabras separadas por ENTER para componer una frase. Escribe \"fin\" para terminar.");
        String palabra = sc.nextLine();
        while (!palabra.toUpperCase().equals("FIN")) {
            if (!palabra.isEmpty()) {
                frase += palabra + " ";
            }
            palabra = sc.nextLine();
        }

        frase = frase.stripTrailing();

        System.out.println(frase);
    }
}
