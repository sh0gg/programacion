package ud2.ejerciciosbucles;

import java.util.Scanner;

public class EP0318{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        int a = sc.nextInt();
        
        System.out.print("Introduce el segundo número: ");
        int b = sc.nextInt();
        sc.close();
        
        System.out.println("El MCM es: " + calcularMCM(a, b));
    }
    
    public static int calcularMCM(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }
    
    public static int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
