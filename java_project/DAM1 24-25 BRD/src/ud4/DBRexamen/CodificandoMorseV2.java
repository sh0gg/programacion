package ud4.DBRexamen;

// Realizado por [Tu Nombre]
// Examen UD04 de Programación

public class CodificandoMorseV2 {

    public static void main(String[] args) {
        String[] mensajes = {"?", "!", "SI", "YA NACIO"};

        for (String mensaje : mensajes) {
            System.out.println("El mensaje \"" + mensaje + "\" dura " + calcularDuracionMorse(mensaje) + " pitidos.");
        }
    }

    public static int calcularDuracionMorse(String frase) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!?";
        String[] morse = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", "-.-.--", "..--.."
        };

        int duracionTotal = 0;

        String[] palabras = frase.split(" ");
        for (int p = 0; p < palabras.length; p++) {
            String palabra = palabras[p];
            for (int i = 0; i < palabra.length(); i++) {
                char c = palabra.charAt(i);
                int index = letras.indexOf(c);

                if (index != -1) {
                    String simbolo = morse[index];

                    // Sumar duración de cada símbolo (puntos y rayas)
                    for (char s : simbolo.toCharArray()) {
                        duracionTotal += (s == '.') ? 1 : 3;
                    }

                    // Espacio entre símbolos de una misma letra
                    if (i < palabra.length() - 1) {
                        duracionTotal += 1;
                    }
                }
            }

            // Espacio entre letras de una palabra (3 puntos)
            if (p < palabras.length - 1) {
                duracionTotal += 3;
            }
        }

        // Espacio entre palabras (5 puntos)
        if (frase.contains(" ")) {
            duracionTotal += 5;
        }

        return duracionTotal;
    }
}
