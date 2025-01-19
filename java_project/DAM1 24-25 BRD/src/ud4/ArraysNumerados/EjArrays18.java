package ud4.ArraysNumerados;

public class EjArrays18 {
    public static boolean esOrtogonal(int[][] matriz) {

        if (matriz.length != matriz[0].length) {
            return false; // Debe ser cuadrada
        }

        int[][] traspuesta = calcularTraspuesta(matriz);
        int[][] producto = multiplicarMatrices(matriz, traspuesta);

        for (int i = 0; i < producto.length; i++) {
            for (int j = 0; j < producto[i].length; j++) {
                if ((i == j && producto[i][j] != 1) || (i != j && producto[i][j] != 0)) {
                    return false; // Debe ser identidad
                }
            }
        }

        return true;

    }

    private static int[][] calcularTraspuesta(int[][] matriz) {

        int[][] traspuesta = new int[matriz[0].length][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        return traspuesta;

    }

    private static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {

        int[][] producto = new int[matriz1.length][matriz2[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                for (int k = 0; k < matriz1[0].length; k++) {
                    producto[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return producto;

    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        
        System.out.println("¿Es matriz ortogonal? " + esOrtogonal(matriz));
    }
}
