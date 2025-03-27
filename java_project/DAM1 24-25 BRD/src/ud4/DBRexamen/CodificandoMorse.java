package ud4.DBRexamen;

// Realizado por David Besada Ramilo
// Examen UD04 de Programación

import java.util.Arrays;

public class CodificandoMorse {
    public static void main(String[] args) {
        String mensaje1 = "?";
        String mensaje2 = "!";
        String mensaje3 = "SI";
        String mensaje4 = "YA NACIO";

        System.out.println("Codificando Morse");
        System.out.println("Primer mensaje \"" + mensaje1 + "\" dura " + numPuntosMorse(mensaje1) + " pitidos.");
        System.out.println("Segundo mensaje \"" + mensaje2 + "\" dura " + numPuntosMorse(mensaje2) + " pitidos.");
        System.out.println("Tercer mensaje \"" + mensaje3 + "\" dura " + numPuntosMorse(mensaje3) + " pitidos.");
        System.out.println("Cuarto mensaje \"" + mensaje4 + "\" dura " + numPuntosMorse(mensaje4) + " pitidos.");

        System.out.println("Codifica \"YA NACIO\" a Morse: " + codificaMorse("YA NACIO"));
        System.out.println("Codifica \"SI\" a Morse: " + codificaMorse("SI"));
        System.out.println("Codifica \"?\" a Morse: " + codificaMorse("?"));
        System.out.println("Codifica \"!\" a Morse: " + codificaMorse("!"));
    }

    public static int numPuntosMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String vacio = " ";
        String[] letrasMorse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--..",
                "-.-.--", "..--.."};

        int totalPuntos = 0;

        String[] palabras = frase.trim().split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                int pos = letras.indexOf(letra);
                if (pos != -1) {
                    String morse = letrasMorse[pos];

// Sumar puntos por símbolos (puntos y rayas)

                    for (int k = 0; k < morse.length(); k++) {
                        char simbolo = morse.charAt(k);
                        if (simbolo == '.') totalPuntos += 1;
                        else if (simbolo == '-') totalPuntos += 3;

// entre símbolos de la misma letra hay 1 punto de pausa, menos al final

                        if (k < morse.length() - 1) totalPuntos += 1;
                    }
                }

// Entre letras de la misma palabra: +3 puntos, menos si es la última letra

                if (j < palabra.length() - 1) totalPuntos += 3;
            }

// Entre palabras: +5 puntos, menos si es la última palabra

            if (i < palabras.length - 1) totalPuntos += 5;
        }

        return totalPuntos;
    }

    public static String codificaMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] letrasMorse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--..", "-.-.--", "..--.."};

        StringBuilder morseFinal = new StringBuilder();

        String[] palabras = frase.trim().split(" ");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];

            for (int j = 0; j < palabra.length(); j++) {
                char letra = palabra.charAt(j);
                int pos = letras.indexOf(letra);
                if (pos != -1) {
                    String morse = letrasMorse[pos];

// Añadir los símbolos con 1 espacio entre cada uno

                    for (int k = 0; k < morse.length(); k++) {
                        morseFinal.append(morse.charAt(k) == '-' ? "..." : ".");
                        if (k < morse.length() - 1) {
                            morseFinal.append(" "); // pausa entre símbolos (1 punto)
                        }
                    }
                }

// Entre letras de la misma palabra: 3 espacios (pausa de 3 puntos)

                if (j < palabra.length() - 1) {
                    morseFinal.append(" ");
                }
            }

// Entre palabras: 5 espacios (pausa de 5 puntos)

            if (i < palabras.length - 1) {
                morseFinal.append(" ");
            }
        }

        return morseFinal.toString();
    }

}

