import java.util.Arrays;

public class ArraysEstadisticas {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int[] numeros1 = { 2, 4, 6, 7, 4, 7, 9, 2, 5, 6, 7 };
        int[] numeros2 = { 2, 4, 6, 7, 4, 9, 2, 5, 6, 7 };
        // Proceso y salida
        imprimeEstadisticas(numeros1);
        imprimeEstadisticas(numeros2);
    }

    static void imprimeEstadisticas(int[] numeros) {
        System.out.println("ARRAY ORIGINAL: " + Arrays.toString(numeros));
        System.out.println("---------------------------------------------");
        System.out.println("Longitud: " + numeros.length);
        System.out.println("Suma: " + suma(numeros));
        System.out.println("Máximo: " + maximo(numeros));
        System.out.println("Mínimo: " + minimo(numeros));
        System.out.println("Media: " + media(numeros));
        System.out.println("Mediana: " + mediana(numeros));
        System.out.println("Moda: " + moda(numeros));
        Arrays.sort(numeros);
        System.out.println("ARRAY ORDENADO: " + Arrays.toString(numeros));
        System.out.println("---------------------------------------------\n\n");
    }

    // Suma de elementos
    static int suma(int[] numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    // Mínimo
    static int minimo(int[] numeros) {
        int minimo = Integer.MAX_VALUE;
        for (int num : numeros) {
            if (num < minimo) {
                minimo = num;
            }
        }
        return minimo;
    }

    // Máximo
    static int maximo(int[] numeros) {
        int maximo = Integer.MIN_VALUE;
        for (int num : numeros) {
            if (num > maximo) {
                maximo = num;
            }
        }
        return maximo;
    }

    // Media
    static double media(int[] numeros) {
        return (double) suma(numeros) / numeros.length;
    }

    // Mediana
    static double mediana(int[] numeros) {
        int[] ordenados = Arrays.copyOf(numeros, numeros.length);
        Arrays.sort(ordenados);
        int n = ordenados.length;
        if (n % 2 == 0) {
            return (ordenados[n / 2 - 1] + ordenados[n / 2]) / 2.0;
        } else {
            return ordenados[n / 2];
        }
    }

    // Moda
    static int moda(int[] numeros) {
        int[] frecuencias = new int[maximo(numeros) + 1];
        for (int num : numeros) {
            frecuencias[num]++;
        }

        int maxFrecuencia = 0;
        int moda = -1;
        boolean multiple = false;

        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                maxFrecuencia = frecuencias[i];
                moda = i;
                multiple = false;
            } else if (frecuencias[i] == maxFrecuencia && maxFrecuencia > 1) {
                multiple = true;
            }
        }

        return multiple ? -1 : moda;
    }

}
