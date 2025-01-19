package ud4.ArraysNumerados;

public class EjArrays14 {
    public static int[][] calcularTraspuesta(int[][] matriz) {

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] traspuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                traspuesta[j][i] = matriz[i][j];
            }
        }

        return traspuesta;

    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] traspuesta = calcularTraspuesta(matriz);
        System.out.println("Matriz traspuesta:");

        for (int[] fila : traspuesta) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
        
    }
}
