package ud4.stringsapuntes;

import java.util.Scanner;

public class ClaseCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Vamos a leer e identificar un caracter!");
        String linea;

        do {
            linea = scanner.nextLine();
        } while (linea.equals(" "));
        char ch = linea.charAt(0);
        scanner.close();

        System.out.println("Analizando " + ch + "...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("¿Es " + ch + " un dígito? " + Character.isDigit(ch));
        System.out.println("¿Es " + ch + " una letra? " + Character.isLetter(ch));
        System.out.println("¿Es " + ch + " un dígito o una letra? " + Character.isLetterOrDigit(ch));
        System.out.println("¿Es " + ch + " minúscula? " + Character.isLowerCase(ch));
        if (Character.isLowerCase(ch))
            System.out.println("Si fuese mayúscula sería: " + Character.toUpperCase(ch));
        System.out.println("¿Es " + ch + " mayúscula? " + Character.isUpperCase(ch));
        if (Character.isLowerCase(ch))
            System.out.println("Si fuese minúscula sería: " + Character.toLowerCase(ch));
        System.out.println("¿Es " + ch + " un emoji?: " + Character.isEmoji(ch));
        System.out.println("¿Es " + ch + " un espacio?: " + Character.isSpaceChar(ch));
        System.out.println("¿Es " + ch + " un espacio en blanco (tabulador, etc.)?: " + Character.isWhitespace(ch));
        System.out.println("El caracter " + ch + " es llamado: " + Character.getName(ch));

    }

}
