package ud4.ArraysNumerados;

import java.util.*;

public class CuadradosDiabolicosEsotericos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            int[][] cuadrado = new int[n][n];
            Set<Integer> numeros = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cuadrado[i][j] = sc.nextInt();
                    numeros.add(cuadrado[i][j]);
                }
            }
            sc.close();
            int CM = n * (n * n + 1) / 2;
            int CM2 = 4 * CM / n;
            if (!esDiabolico(cuadrado, n, CM)) {
                System.out.println("NO");
            } else if (esEsoterico(cuadrado, n, CM, CM2, numeros)) {
                System.out.println("ESOTERICO");
            } else {
                System.out.println("DIABOLICO");
            }
        }
    }

    private static boolean esDiabolico(int[][] cuadrado, int n, int CM) {
        for (int i = 0; i < n; i++) {
            int sumaFila = 0, sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
            }
            if (sumaFila != CM || sumaColumna != CM)
                return false;
        }
        int sumaDiag1 = 0, sumaDiag2 = 0;
        for (int i = 0; i < n; i++) {
            sumaDiag1 += cuadrado[i][i];
            sumaDiag2 += cuadrado[i][n - 1 - i];
        }
        return sumaDiag1 == CM && sumaDiag2 == CM;
    }

    private static boolean esEsoterico(int[][] cuadrado, int n, int CM, int CM2, Set<Integer> numeros) {
        if (numeros.size() != n * n)
            return false;
        for (int i = 1; i <= n * n; i++) {
            if (!numeros.contains(i))
                return false;
        }
        int sumaEsquinas = cuadrado[0][0] + cuadrado[0][n - 1] + cuadrado[n - 1][0] + cuadrado[n - 1][n - 1];
        if (sumaEsquinas != CM2)
            return false;
        if (n % 2 == 1) {
            int centro = cuadrado[n / 2][n / 2];
            if (4 * centro != CM2)
                return false;
            int sumaLados = cuadrado[0][n / 2] + cuadrado[n / 2][0] + cuadrado[n / 2][n - 1] +
                    cuadrado[n - 1][n / 2];
            if (sumaLados != CM2)
                return false;
        } else {
            int sumaCentro = cuadrado[n / 2 - 1][n / 2 - 1] + cuadrado[n / 2 - 1][n / 2] +
                    cuadrado[n / 2][n / 2 - 1] + cuadrado[n / 2][n / 2];
            if (sumaCentro != CM2)
                return false;
            int sumaLados = cuadrado[0][n / 2 - 1] + cuadrado[0][n / 2] +
                    cuadrado[n / 2 - 1][n - 1] + cuadrado[n / 2][n - 1] +
                    cuadrado[n - 1][n / 2 - 1] + cuadrado[n - 1][n / 2] +
                    cuadrado[n / 2 - 1][0] + cuadrado[n / 2][0];
            if (sumaLados != 2 * CM2)
                return false;
        }
        return true;
    }
}