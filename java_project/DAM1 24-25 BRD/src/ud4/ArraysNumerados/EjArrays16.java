package ud4.ArraysNumerados;

public class EjArrays16 {
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {

        if (matriz1[0].length != matriz2.length) {
            throw new IllegalArgumentException(
                    "El número de columnas de laprimera matriz debe ser igual al número de filas de la segunda matriz.");
        }

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

        int[][] matriz1 = { { 1, 2 }, { 3, 4 } };
        int[][] matriz2 = { { 5, 6 }, { 7, 8 } };
        int[][] resultado = multiplicarMatrices(matriz1, matriz2);

        System.out.println("Resultado del producto:");
        
        for (int[] fila : resultado) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}
