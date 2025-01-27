package ud4.ejercicios24enero;

import java.util.Arrays;
import java.util.Scanner;


// ESTE EJERCICIO ES INCORRECTO (CORREGIR)

public class AbadiasPirenaicas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Introduce las alturas de las montañas de Oeste a Este (introduce un número negativo para terminar):");

        int[] alturas = new int[1000];
        int cantidadMontañas = 0;

        // Leer alturas hasta encontrar un número negativo
        for (int i = 0; i < 1000; i++) {
            int altura = sc.nextInt();
            if (altura < 0) {
                break;
            }
            alturas[i] = altura;
            cantidadMontañas++;
        }

        sc.close();

        // Ajustar el tamaño del array a la cantidad real de montañas
        int[] alturasFinal = new int[cantidadMontañas];
        System.arraycopy(alturas, 0, alturasFinal, 0, cantidadMontañas);

        System.out.println("¡Se han introducido todos los datos!");
        System.out.println(" ");
        System.out.println(
                "Se pueden construir un total de " + totalAbadias(alturasFinal) + " de " + alturasFinal.length + ".");
        System.out.print("Serán en las montañas número... " + posicionesAbadias(arrayInverso(alturasFinal)));
    }

    // Método para contar las abadías
    private static int totalAbadias(int[] t) {
        int contador = 0;
        int alturaMaxima = Integer.MIN_VALUE; // Altura máxima inicial

        // Recorrer el array desde el final al principio
        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] > alturaMaxima) {
                contador++;
                alturaMaxima = t[i];
            }
        }

        return contador;
    }

    // Método para obtener las posiciones de las montañas donde pueden construirse
    // abadías
    private static String posicionesAbadias(int[] t) {
        String posiciones = ""; // Variable para almacenar las posiciones como texto
        int alturaMaxima = Integer.MIN_VALUE; // Altura máxima inicial

        // Recorrer el array desde el final al principio
        for (int i = t.length - 1; i >= 0; i--) {
            if (t[i] > alturaMaxima) {
                posiciones = (i + 1) + " " + posiciones; // Concatenar al principio de la cadena
                alturaMaxima = t[i];
            }
        }

        return posiciones.trim(); // Eliminar espacios extra al final
    }

    private static int[] arrayInverso(int[] t) {
        int[] auxiliar = new int[t.length - 1];
        int j = 0;

        for (int i = t.length - 1; i > 0; i--) {
            auxiliar[j] = t[i];
            j++;
        }

        return auxiliar;
    }
}