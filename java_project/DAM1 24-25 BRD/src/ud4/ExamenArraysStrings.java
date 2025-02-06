package ud4;

// Examen de Arrays y Strings en Java
// Autor: David Besada

import java.util.Arrays;
import java.util.Scanner;

public class ExamenArraysStrings {

    public static void main(String[] args) {
        // Ejecutar pruebas de las estructuras clave
        trabajarConArrays();
        trabajarConMatrices();
        trabajarConStrings();
    }

    // ================== 1. ARRAYS ==================
    public static void trabajarConArrays() {
        System.out.println("\n===== 1. ARRAYS =====");

        // Declaración e inicialización de un array
        int[] numeros = { 1, 2, 3, 4, 5 };
        System.out.println("Array inicial: " + Arrays.toString(numeros));

        // Recorrido con for tradicional
        System.out.print("Recorrido con for: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        // Recorrido con for-each
        System.out.print("Recorrido con for-each: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ordenación de un array
        int[] desordenado = { 5, 2, 9, 1, 3 };
        Arrays.sort(desordenado);
        System.out.println("Array ordenado: " + Arrays.toString(desordenado));

        // Búsqueda en un array (búsqueda binaria, requiere estar ordenado)
        int indice = Arrays.binarySearch(desordenado, 3);
        System.out.println("El número 3 está en la posición: " + indice);

        // Copia de un array
        int[] copia = Arrays.copyOf(numeros, numeros.length);
        System.out.println("Copia del array: " + Arrays.toString(copia));

        // Inserción en un array (requiere crear un nuevo array)
        int[] extendido = Arrays.copyOf(numeros, numeros.length + 1);
        extendido[extendido.length - 1] = 6;
        System.out.println("Array extendido con nuevo valor: " + Arrays.toString(extendido));
    }

    // ================== 2. MATRICES ==================
    public static void trabajarConMatrices() {
        System.out.println("\n===== 2. MATRICES =====");

        // Declaración e inicialización de una matriz
        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Recorrer una matriz
        System.out.println("Matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Sumar dos matrices
        int[][] matrizA = { { 1, 2 }, { 3, 4 } };
        int[][] matrizB = { { 5, 6 }, { 7, 8 } };
        int[][] suma = new int[2][2];

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        System.out.println("Suma de matrices:");
        for (int[] fila : suma) {
            System.out.println(Arrays.toString(fila));
        }

        // Matriz traspuesta
        int[][] traspuesta = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        System.out.println("Matriz traspuesta:");
        for (int[] fila : traspuesta) {
            System.out.println(Arrays.toString(fila));
        }
    }

    // ================== 3. STRINGS ==================
    public static void trabajarConStrings() {
        System.out.println("\n===== 3. STRINGS =====");

        String texto = "Hola Mundo";

        // Longitud de una cadena
        System.out.println("Longitud del texto: " + texto.length());

        // Concatenación
        String saludo = texto.concat(" desde Java");
        System.out.println("Concatenación: " + saludo);

        // Comparación de cadenas
        System.out.println("¿Hola es igual a hola?: " + "Hola".equals("hola"));
        System.out.println("¿Hola es igual a hola (ignorando mayúsculas)?: " + "Hola".equalsIgnoreCase("hola"));

        // Extraer caracteres y subcadenas
        System.out.println("Primer carácter: " + texto.charAt(0));
        System.out.println("Subcadena (0-4): " + texto.substring(0, 4));

        // Reemplazo de caracteres
        String reemplazo = texto.replace("o", "0");
        System.out.println("Reemplazo de 'o' por '0': " + reemplazo);

        // Conversión de String a Array de caracteres
        char[] caracteres = texto.toCharArray();
        System.out.println("Array de caracteres: " + Arrays.toString(caracteres));

        // Separación de palabras
        String frase = "Java es un lenguaje poderoso";
        String[] palabras = frase.split(" ");
        System.out.println("Palabras separadas: " + Arrays.toString(palabras));

        // Invertir una cadena
        String invertida = new StringBuilder(texto).reverse().toString();
        System.out.println("Texto invertido: " + invertida);

        // Verificar si una cadena es un palíndromo
        String palindromo = "anilina";
        boolean esPalindromo = new StringBuilder(palindromo).reverse().toString().equalsIgnoreCase(palindromo);
        System.out.println("¿'anilina' es un palíndromo?: " + esPalindromo);
    }
}
