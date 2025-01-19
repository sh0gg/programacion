package ud4.ArraysNumerados;

public class EjArrays15 {
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones.");
        }

        int[][] suma = new int[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return suma;

    }

    public static void main(String[] args) {

        int[][] matriz1 = { { 1, 2 }, { 3, 4 } };
        int[][] matriz2 = { { 5, 6 }, { 7, 8 } };
        int[][] resultado = sumarMatrices(matriz1, matriz2);

        System.out.println("Resultado de la suma:");
        
        for (int[] fila : resultado) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}