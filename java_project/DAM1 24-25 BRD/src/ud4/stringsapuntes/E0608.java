package ud4.stringsapuntes;

import java.util.Scanner;

public class E0608 {
    public static void main(String[] args) {
        final String PREFIJO = "Javalín, javalón";
        final String SUFIJO = "javalén, len, len";

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase normal o en dialecto: "
        + "que comience por \"" + PREFIJO + "\""
        + "o termine en \"" + SUFIJO + "\".");
        String frase = sc.nextLine();
        sc.close();

        if (frase.startsWith(PREFIJO)) {
            System.out.println("La frase está escrita en el idioma de Javalandia");
            String traduccion = frase.substring(PREFIJO.length()).strip();
            System.out.println("Traducción: " + traduccion);
        } else if (frase.endsWith(SUFIJO)) {
            System.out.println("La frase está escrita en el dialecto de Javalandia");
            String traduccion = frase.substring(0, frase.length() - PREFIJO.length()).strip();
            System.out.println("Traduccion: " + traduccion);
        }

    }
}
