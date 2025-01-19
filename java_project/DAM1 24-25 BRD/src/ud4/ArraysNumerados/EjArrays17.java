package ud4.ArraysNumerados;

public class EjArrays17 {
    public static boolean esSimetrica(int[][] matriz) {

        if (matriz.length != matriz[0].length) {
            return false; // Debe ser cuadrada
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = i + 1; j < matriz[i].length; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false; // Elementos opuestos no son iguales
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 1, 2, 3 },
                { 2, 4, 5 },
                { 3, 5, 6 }
        };
        
        System.out.println("¿Es matriz simétrica? " + esSimetrica(matriz));
    }
}