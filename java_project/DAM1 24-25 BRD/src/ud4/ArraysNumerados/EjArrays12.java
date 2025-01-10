package ud4.ArraysNumerados;

public class EjArrays12 {

    public static boolean esMatrizIdentidad(int[][] matriz) {

        if (matriz.length != matriz[0].length) {
            return false; // Debe ser cuadrada
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j && matriz[i][j] != 1) {
                    return false; // Elementos en diagonal deben ser 1
                }
                if (i != j && matriz[i][j] != 0) {
                    return false; // Elementos fuera de la diagonal deben ser 0
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {

        int[][] matriz = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        System.out.println("¿Es matriz identidad? " +
                esMatrizIdentidad(matriz));
                
    }
}
