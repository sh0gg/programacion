package ud4.stringsapuntes;

import java.util.Scanner;

public class E0611 {

    public static void main(String[] args) {

        final String CONJUNTO_1 = "eikmpqrstuv";
        final String CONJUNTO_2 = "pviumterkqs";

        Scanner entrada = new Scanner(System.in);
        String texto = entrada.nextLine();

        System.out.println(codifica(CONJUNTO_1.toCharArray(), CONJUNTO_2.toCharArray(), texto));

        System.out.println(codifica(CONJUNTO_1, CONJUNTO_2, texto));


    }

    static String codifica(char[] conjunto1, char[] conjunto2, String texto) {
        // Falla: algunas letras se sustituyen dos veces
        texto = texto.toLowerCase();
        for (int i = 0; i < conjunto1.length; i++) {
            texto = texto.replace(conjunto1[i], conjunto2[i]);
        }
        return texto;
    }

    static String codifica(String conjunto1, String conjunto2, String texto) {
        String fraseCodificada = "";
        for (int i = 0; i < texto.length(); i++) {
            char letraActual = Character.toLowerCase(texto.charAt(i));
            int posicion = conjunto1.indexOf(letraActual);
            if (posicion == -1) {
                fraseCodificada += letraActual;
            } else {
                fraseCodificada += conjunto2.charAt(posicion);
            }
        }
        return fraseCodificada;
    }

//    static char codifica(char[] conjunto1, char[] conjunto2, char texto) {
//        return texto;
//    }

//    static char codifica(String[] conjunto1, String[] conjunto2, char texto) {
//        return texto;
//    }
}
