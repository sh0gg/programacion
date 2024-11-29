package ud2.ejerciciosbucles;

import java.util.Scanner;

public class EP0315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el número de filas del triángulo de Pascal: ");
        int filas = sc.nextInt();
        sc.close();
        
        for (int n = 0; n < filas; n++) {
            for (int i = 0; i <= n; i++) {
                System.out.print(coeficienteBinomial(n, i) + " ");
            }
            System.out.println();
        }
    }
    
    public static int coeficienteBinomial(int n, int k) {
        int resultado = 1;
        for (int i = 0; i < k; i++) {
            resultado = resultado * (n - i) / (i + 1);
        }
        return resultado;
    }
}
