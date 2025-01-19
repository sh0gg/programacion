package ud4.matrices;

import java.util.Arrays;

public class Ejemplo08_Matrices {
    public static void main(String[] args) {
        int[][] matriz;
        int[][] matriz2 = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };

        int[][] matriz3 = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };

        System.out.println("matriz2 == matriz3 es " + (matriz2 == matriz3));
        System.out.println("Arrays.equals(matriz2,matriz3) es " + Arrays.equals(matriz2, matriz3));
        System.out.println("Arrays.deepEquals(matriz2,matriz3) es " + Arrays.deepEquals(matriz2, matriz3));

        int a = 23;
        int b = 8;

        matriz = new int[a][b];

        matriz = generarAleatorio(a, b);

        mostrar(matriz);

        System.out.println("");
        System.out.println("");

        mostrar(matriz2);

        System.out.println("");
        System.out.println("");
        System.out.println(Arrays.deepToString(matriz));
        System.out.println("");
        System.out.println("");
        System.out.println(Arrays.deepToString(matriz2));
    }

    static void mostrar(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < t[i].length; j++) {
                System.out.print("[" + t[i][j] + "]" + " ");
            }

        }
    }

    static int[][] generarAleatorio(int numF, int numC) {

        int[][] m = new int[numF][numC];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 10);
            }

            return m;
        }
    }
}
