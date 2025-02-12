package ud4.elreto;

public class TorresPerezosas {
    public static void main(String[] args) {
        char[][] tablero1 = {
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
        char[][] tablero2 = {
                {'.', '.', '.'},
                {'X', '.', '.'},
                {'.', '.', '.'}
        };
        char[][] tablero3 = {
                {'.', '.', '.'},
                {'X', 'X', '.'},
                {'.', '.', '.'}
        };
        char[][] tablero4 = {
                {'.', 'X', '.'},
                {'.', '.', '.'},
                {'.', 'X', '.'}
        };

        System.out.println(caminosDistintos(tablero1)); // Salida esperada: 6
        System.out.println(caminosDistintos(tablero2)); // Salida esperada: 3
    }

    private static int caminosDistintos(char[][] tablero) {
        int filas = tablero.length;
        int columnas = tablero[0].length;
        int[][] dp = new int[filas][columnas];

        // Si la casilla inicial está bloqueada, no hay caminos posibles
        if (tablero[0][0] == 'X') {
            return 0;
        }

        // Inicializar la primera casilla
        dp[0][0] = 1;

        // Inicializar la primera columna
        for (int i = 1; i < filas; i++) {
            if (tablero[i][0] == 'X') {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Inicializar la primera fila
        for (int j = 1; j < columnas; j++) {
            if (tablero[0][j] == 'X') {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Llenar la matriz dp
        for (int i = 1; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                if (tablero[i][j] == 'X') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // El número de caminos distintos hacia la esquina inferior derecha
        return dp[filas - 1][columnas - 1];
    }
}
