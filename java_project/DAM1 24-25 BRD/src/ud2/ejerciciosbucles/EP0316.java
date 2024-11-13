package ud2.ejerciciosbucles;

import java.util.Scanner;

public class EP0316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la altura del triángulo: ");
        int n = sc.nextInt();
        sc.close();
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
