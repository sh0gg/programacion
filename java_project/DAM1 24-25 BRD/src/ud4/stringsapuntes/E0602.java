package ud4.stringsapuntes;

import java.util.Scanner;

public class E0602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Vamos a comparar cadenas de caracteres! ¿Cuál es más larga?");
        
        System.out.print("Introduce la primera cadena: ");
        String cadena1 = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Introduce la segunda cadena: ");
        String cadena2 = scanner.nextLine();

        scanner.close();

        System.out.println("La cadena más larga es: " + compareLenght(cadena1, cadena2));
    
    }

    private static String compareLenght(String cadena1, String cadena2) {
        String cadenaMayor = "";
        if (cadena1.length() == cadena2.length()) {
            cadenaMayor = cadena1 + " y " + cadena2 + ", ambas tienen la misma longitud con " + cadena1.length() + " caracteres.";
        } else if (cadena1.length() > cadena2.length()) {
            cadenaMayor = cadena1 + " es la más larga con " + cadena1.length() + " caracteres.";
        } else {
            cadenaMayor = cadena2 + " es la más larga con " + cadena2.length() + " caracteres.";
        }
        return cadenaMayor;
    }
}
