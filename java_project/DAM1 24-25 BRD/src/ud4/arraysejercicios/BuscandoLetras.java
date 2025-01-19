package ud4.arraysejercicios;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscandoLetras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] t = { "Algoritmo", "Lenguaje de programación", "Entorno de desarrollo", "Compilación", "Ejecución",
                "Código fuente", "Bytecode", "Código objeto" };

        System.out.println("Vamos a mostrar un concepto aleatorio por pantalla:");
        System.out.println(fraseAleatoria(t));
        int[] posiciones;
        do {
        System.out.println("Ahora vamos a buscar una letra dentro de este concepto:");
        char letra = scanner.next().charAt(0);

        posiciones = buscarLetra(fraseAleatoria(t), letra);
        System.out.println("Se encuentra en las posiciones " + Arrays.toString(posiciones));
        } while (posiciones.length != 0);

        System.out.println("La última letra no aparecía en la frase. FIN."); 
        scanner.close();
    }

    static String fraseAleatoria(String[] t) {
        Random rand = new Random();
        int i = rand.nextInt(t.length);
        return t[i];
    }

    static int[] buscarLetra(String cadena, char letra) {
        char[] tablaChar = cadena.toCharArray();

        int[] posiciones = new int[0];

        System.out.println(Arrays.toString(tablaChar));

        for (int i = 0; i < tablaChar.length; i++) {
            if (tablaChar[i] == letra) {
                posiciones = Arrays.copyOf(posiciones, posiciones.length + 1);
                posiciones[posiciones.length + 1] = i;
            }
        }
        return posiciones;
    }

}
