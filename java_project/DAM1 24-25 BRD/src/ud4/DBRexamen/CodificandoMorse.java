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
    }

    public static int numPuntosMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] letrasMorse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..",
                "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--..",
                "-.-.--", "..--.."};
        int duracion = 0;
        int numGuiones = 0;
        int numPuntos = 0;

        char[] mensaje = frase.toCharArray();

        for (char c : mensaje) {
            int pos = letras.indexOf(c);
            char[] palabra = letrasMorse[pos].toCharArray();
            for (int i = 0; i < palabra.length; i++) {
                if (palabra[i] == '-') {
                    numGuiones++;
                }
                if (palabra[i] == '.') {
                    numPuntos++;
                }

            }
            int pausaSimbolo = palabra.length - 2;
            int pausaLetra = 0;
            int pausaPalabra = 0;
            if (mensaje.length > 2) {
                for (int i = 0; i < mensaje.length; i++) {
                pausaLetra++;
                if (mensaje[i] == ' ') {
                    pausaPalabra++;
                }
                }
            }

            //me rindo con este :shrug:


            duracion = numGuiones + numPuntos + pausaSimbolo + pausaLetra + pausaPalabra;
        }
        return duracion;
    } }
