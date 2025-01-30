package ud4.stringsapuntes;

import java.util.Arrays;
import java.util.Scanner;

public class E0610 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a darle la vuelta a una cadena!!");
        String frase = sc.nextLine();
        sc.close();

        // frase de ejemplo: "Dábale arroz a la zorra el abad"

        String[] palabras = frase.split(" ");
        System.out.println(Arrays.toString(palabras));

        palabras = invertir(frase).split(" ");
        System.out.println(Arrays.toString(palabras));

        char[] letras = sinEspacios(frase).toCharArray();
        System.out.println(Arrays.toString(letras));
        System.out.println(String.valueOf(letras));

        letras = sinEspacios(invertir(frase)).toCharArray();
        System.out.println(Arrays.toString(letras));
        System.out.println(String.valueOf(letras));


        System.out.println(sinEspacios(frase) + " y " + sinEspacios(invertir(frase)));

        if (esPalindromo(frase)) {
            System.out.println("¡¡WOW!! ¡¡ESTA CADENA ES UN PALÍNDROMO!!");
        } else {
            System.out.println("¡No es un palíndromo!");
        }

    }

    private static boolean esPalindromo(String frase) {
        String fraseSinEspacios = sinEspacios(frase);
        String fraseInvertidaSinEspacios = sinEspacios(invertir(frase));
        return fraseSinEspacios.equalsIgnoreCase(fraseInvertidaSinEspacios);
    }

    static String invertir(String frase) {
        String fraseInvertida = "";
        for (int i = frase.length() - 1; i >= 0; i--) {
            char letra = quitarTildes(frase.charAt(i));
                fraseInvertida += letra;
        }
        return fraseInvertida;
    }

    static String sinEspacios(String frase) {
        String fraseSinEspacios = "";
        for (int i = 0; i < frase.length(); i++) {
            char letra = quitarTildes(frase.charAt(i));
            if (letra != ' ') {
                fraseSinEspacios += letra;
            }
        }
        return fraseSinEspacios;
    }

    private static char quitarTildes(char letra) {
        switch (letra) {
            case 'á':
                letra = 'a';
                break;
            case 'é':
                letra = 'e';
                break;
            case 'í':
                letra = 'i';
                break;
            case 'ó':
                letra = 'o';
                break;
            case 'ú':
                letra = 'u';
                break;
            case 'Á':
                letra = 'A';
                break;
            case 'É':
                letra = 'E';
                break;
            case 'Í':
                letra = 'I';
                break;
            case 'Ó':
                letra = 'O';
                break;
            case 'Ú':
                letra = 'U';
                break;

        }
        return letra;
    }


}
