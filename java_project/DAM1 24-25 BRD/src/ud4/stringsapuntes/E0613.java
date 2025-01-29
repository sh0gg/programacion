package ud4.stringsapuntes;

import java.util.Scanner;

public class E0613 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe tu frase: ");
        String texto = entrada.nextLine();
        entrada.close();

        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        int[] veces = new int[abecedario.length()];

        for (int i = 0; i < texto.length(); i++) {
            char letra = Character.toLowerCase(texto.charAt(i));
            letra = quitarTildes(letra);
            int pos = abecedario.indexOf(letra);
            if (pos != -1) {
                veces[pos]++;
            }
        }

        System.out.println("La frase: " + texto);
        System.out.println("Resultado: ");
        for (int i = 0; i < veces.length; i++) {
            if (veces[i] > 0) {
                System.out.print(abecedario.charAt(i) + ": " + veces[i]);
                if (veces[i] > 1) {
                    System.out.println(" veces");
                } else {
                    System.out.println(" vez");
                }

            }
        }

    }

    static char quitarTildes(char letra) {
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
