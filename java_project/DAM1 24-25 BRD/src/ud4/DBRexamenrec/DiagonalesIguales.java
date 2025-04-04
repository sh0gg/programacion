package ud4.DBRexamenrec;

public class DiagonalesIguales {
    static boolean diagonalesIguales(int[][] t) {

        // Ver si es nula
        if (t == null) {
            return false;
        }

        // Ver si está vacía
        int valor = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                valor =+ t[i][j];
            }
        }
        if (valor == 0) {
            return false;
        }

        // Ver si es cuadrada
        int filas = t.length;
        for (int[] fila : t) {
            if (fila.length != filas)
                return false;
        }

        // Ver si las diagonales coinciden
        // 0,0 -> esquinaSupIzq
        // x,y -> esquinaInfDer
        // x,0 -> esquinaSupDer
        // 0,y -> esquinaInfIzq

        int diagonalPrincipal = 0;
        int diagonalSecundaria = 0;
        for (int i = 0; i < t.length; i++) {
            int j = i;
                diagonalPrincipal += t[i][j];
        }
        for (int j = t.length - 1; j >= 0; j--) {
        for (int i = 0; i < t.length; i++) {
                diagonalSecundaria += t[i][j];
                j--;
            }
        }
        if (diagonalPrincipal == diagonalSecundaria) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matriz =   {{1,1,1},
                            {1,1,1},
                            {1,1,1}};
        System.out.println(diagonalesIguales(matriz));
        int[][] matriz2 =   {{1,2,1},
                             {2,1,2},
                             {1,2,1}};
        System.out.println(diagonalesIguales(matriz2));
        int[][] matriz3 =   {{3,2,1},
                             {2,1,3},
                             {3,2,3}};
        System.out.println(diagonalesIguales(matriz3));
        int[][] matriz4 =   {{7,2,1,1,7},
                             {2,7,3,7,4},
                             {2,7,7,1,4},
                             {2,7,3,7,4},
                             {7,2,7,1,7}};
        System.out.println(diagonalesIguales(matriz4));
    }
}
