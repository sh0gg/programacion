package ud4.arraysejercicios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BuscandoLetras2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] t = {
                "Algoritmo",
                "Lenguaje de programación",
                "Entorno de desarrollo",
                "Compilación",
                "Ejecución",
                "Código fuente",
                "Bytecode",
                "Código objeto"
        };

        System.out.println("Vamos a mostrar un concepto aleatorio por pantalla:");
        String concepto = fraseAleatoria(t);
        System.out.println("Concepto elegido: " + concepto);

        while (true) {
            System.out.println("Introduce una letra para buscar (o una letra que no exista para salir):");
            char letra = scanner.next().charAt(0);

            int[] posiciones = buscarLetra(concepto, letra);

            if (posiciones.length == 0) {
                System.out.println("La letra '" + letra + "' no se encuentra en el concepto.");
                break;
            } else {
                System.out
                        .println("La letra '" + letra + "' aparece " + posiciones.length + " veces en las posiciones:");
                for (int pos : posiciones) {
                    System.out.print(pos + " ");
                }
                System.out.println();
            }
        }

        scanner.close();
    }

    // Método para elegir un término al azar del array
    static String fraseAleatoria(String[] t) {
        Random rand = new Random();
        int i = rand.nextInt(t.length);
        return t[i];
    }

    // Método para buscar posiciones de una letra en una cadena
    static int[] buscarLetra(String cadena, char letra) {
        ArrayList posiciones = new ArrayList<>();

        char[] tablaChar = cadena.toCharArray();
        for (int i = 0; i < tablaChar.length; i++) {
            if (tablaChar[i] == letra) {
                posiciones.add(i);
            }
        }

        // Convertir la lista a un array de enteros
        int[] resultado = new int[posiciones.size()];
        for (int i = 0; i < posiciones.size(); i++) {
            resultado[i] = (int) posiciones.get(i);
        }

        return resultado;
    }
}