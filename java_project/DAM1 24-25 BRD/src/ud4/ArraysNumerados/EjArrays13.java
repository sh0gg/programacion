package ud4.ArraysNumerados;

public class EjArrays13 {

    public static boolean esDiagonal(int[][] matriz) {

        if (matriz.length != matriz[0].length) {
            return false; // Debe ser cuadrada
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i != j && matriz[i][j] != 0) {
                    return false; // Elementos fuera de la diagonal principal deben ser 0
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 5, 0, 0 },
                { 0, 3, 0 },
                { 0, 0, 7 }
        };
        System.out.println("¿Es matriz diagonal? " + esDiagonal(matriz));
    
    }
}
