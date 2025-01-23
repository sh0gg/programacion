package ud4.stringsapuntes;

import java.util.Scanner;

public class E0604 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce una frase: ");
        String frase = scanner.nextLine();
        scanner.close();

        System.out.println("La frase tiene " + contarEspacios(frase) + " espacios.");

    }
    static int contarEspacios(String cadena) {
        int contarEspacios = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isSpaceChar(cadena.charAt(i))) {
                contarEspacios++;
            }
        }
        return contarEspacios;
    }
}
