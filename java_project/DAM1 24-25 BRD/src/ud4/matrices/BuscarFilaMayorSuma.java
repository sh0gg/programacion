package ud4.matrices;
/* BuscarFilaMayorSuma. Escribe un método en Java que reciba una matriz de enteros y
determine y devuelva en un array la fila que tiene la mayor suma de sus elementos. */

import java.util.Scanner;

public class BuscarFilaMayorSuma {
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
        Integer sumaMayor = null;
        int filaMayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            int contador = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
                contador++;
            }
            if (sumaMayor == null) {
                sumaMayor = suma;
                filaMayor = contador;
            } else if (sumaMayor < suma) {
                sumaMayor = suma;
                filaMayor = contador;
            }
        }
        System.out.println("La fila mayor será la número " + filaMayor + " con una suma de " + sumaMayor);
    }
}
