package ud4;

import java.util.ArrayList;

// Examen de Arrays y Strings en Java
// Cheatsheet 12/02/2024
// Autor: David Besada

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class ExamenArraysStrings {

    public static void main(String[] args) {
        // Ejecutar pruebas de las estructuras clave
        trabajarConArrays();
        trabajarConMatrices();
        trabajarConStrings();
        trabajarConCollections();
        trabajarConCharacter();
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

        // MATRICES EN JAVA - FORMAS DE RECORRER

        int[][] matriz2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // ---------------------------------------------
        // 1. RECORRER FILA POR FILA (ORDEN NATURAL)
        // Recorre desde la fila 0 hasta la última
        // y dentro de cada fila, de la columna 0 a la última

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println(); // salto de línea después de cada fila
        }
        // Salida:
        // 1 2 3
        // 4 5 6
        // 7 8 9

        // ---------------------------------------------
        // 2. RECORRER COLUMNA POR COLUMNA
        // Cambia el orden de los bucles: primero columnas, luego filas

        for (int j = 0; j < matriz2[0].length; j++) {
            for (int i = 0; i < matriz2.length; i++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
        // Salida:
        // 1 4 7
        // 2 5 8
        // 3 6 9

        // ---------------------------------------------
        // 3. RECORRER FILAS EN ORDEN INVERSO (DE ABAJO HACIA ARRIBA)

        for (int i = matriz2.length - 1; i >= 0; i--) {
            for (int j = 0; j < matriz2[i].length; j++) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
        // Salida: 
        // 7 8 9
        // 4 5 6
        // 1 2 3

        // ---------------------------------------------
        // 4. RECORRER COLUMNAS EN ORDEN INVERSO (DE DERECHA A IZQUIERDA)

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = matriz2[i].length - 1; j >= 0; j--) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
        // Salida:
        // 3 2 1
        // 6 5 4
        // 9 8 7

        // ---------------------------------------------
        // 5. RECORRER TODA LA MATRIZ EN ORDEN INVERSO TOTAL
        // (de la última fila y última columna hacia el principio)

        for (int i = matriz2.length - 1; i >= 0; i--) {
            for (int j = matriz2[i].length - 1; j >= 0; j--) {
                System.out.print(matriz2[i][j] + " ");
            }
            System.out.println();
        }
        // Salida:
        // 9 8 7
        // 6 5 4
        // 3 2 1

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

    // ================== 4. COLLECTIONS ==================
    public static void trabajarConCollections() {
        System.out.println("\n===== 4. COLLECTIONS =====");

        // Uso de ArrayList (Lista dinámica)
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");
        System.out.println("ArrayList inicial: " + lista);

        // Ordenar la lista
        Collections.sort(lista);
        System.out.println("ArrayList ordenado: " + lista);

        // Buscar un elemento
        int indice = Collections.binarySearch(lista, "Python");
        System.out.println("Índice de 'Python': " + indice);

        // LinkedList (Lista doblemente enlazada)
        LinkedList<Integer> numeros = new LinkedList<>();
        numeros.add(10);
        numeros.addFirst(5);
        numeros.addLast(20);
        System.out.println("LinkedList: " + numeros);

        // Uso de HashSet (Conjunto, no permite duplicados)
        HashSet<Integer> conjunto = new HashSet<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(2); // No se añade porque ya existe
        System.out.println("HashSet (sin duplicados): " + conjunto);

        // Uso de HashMap (Clave-Valor)
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Alice", 25);
        mapa.put("Bob", 30);
        mapa.put("Charlie", 22);
        System.out.println("HashMap (pares clave-valor): " + mapa);

        // Acceder a un valor por su clave
        System.out.println("Edad de Alice: " + mapa.get("Alice"));

        // Eliminar un elemento
        mapa.remove("Bob");
        System.out.println("HashMap tras eliminar a Bob: " + mapa);
    }

    // ================== 5. CHARACTER ==================
    public static void trabajarConCharacter() {
        System.out.println("\n===== 5. CHARACTER =====");

        char letra = 'A';

        // Verificar si es letra
        System.out.println("¿'A' es letra?: " + Character.isLetter(letra));

        // Verificar si es dígito
        System.out.println("¿'7' es un dígito?: " + Character.isDigit('7'));

        // Convertir a minúscula
        System.out.println("Minúscula de 'A': " + Character.toLowerCase(letra));

        // Convertir a mayúscula
        System.out.println("Mayúscula de 'b': " + Character.toUpperCase('b'));

        // Verificar si es espacio en blanco
        System.out.println("¿' ' es espacio?: " + Character.isWhitespace(' '));

        // Verificar si es letra o dígito
        System.out.println("¿'#' es letra o dígito?: " + Character.isLetterOrDigit('#'));
    }
}
