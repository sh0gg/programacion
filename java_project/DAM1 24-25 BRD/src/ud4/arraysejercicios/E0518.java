package ud4.arraysejercicios;

import java.util.Scanner;

public class E0518 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        System.out.println("Introduce valores para la matriz");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Valores de la matriz[" + i + "][" + j + "]:");
                matriz[i][j] = sc.nextInt();
            }
        }
        if (esMagica(matriz)) {
            System.out.println("La matriz es mágica");
        } else {
            System.out.println("La matriz no es mágica");
        }
    }

    public static boolean esMagica(int[][] t) {
        if (t == null || t.length == 0 || t[0].length != t.length) {
            return false;
        }

        Integer constanteMagica = null;
        for (int i = 0; i < t.length; i++) {
            int suma = 0;
            for (int j = 0; j < t[i].length; j++) {
                suma += t[i][j];
            }
            if (constanteMagica == null) {
                constanteMagica = suma;
            } else if (constanteMagica != suma) {
                return false;
            }
        }

        for (int i = 0; i < t.length; i++) {
            int suma = 0;
            for (int j = 0; j < t[i].length; j++) {
                suma += t[i][j];
            }
            if (constanteMagica != suma) {
                return false;
            }
        }

        return true;
    }
}
