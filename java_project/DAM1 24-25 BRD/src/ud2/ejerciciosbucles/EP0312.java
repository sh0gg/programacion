package ud2.ejerciciosbucles;
import java.util.Scanner;

public class EP0312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce un número binario: ");
        String binario = sc.next();
        sc.close();
        
        int decimal = 0;
        for (int i = 0; i < binario.length(); i++) {
            int bit = Character.getNumericValue(binario.charAt(binario.length() - 1 - i));
            decimal += bit * Math.pow(2, i);
        }
        
        System.out.println("El número decimal es: " + decimal);
    }
}
