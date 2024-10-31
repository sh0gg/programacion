package ud1.ejercicios;


import java.util.Scanner;

public class absoluto {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();

    
    int absoluto = ( numero > 0) 
        ? numero 
        : (- numero) ;

        System.out.printf("El número en absoluto es %d", absoluto );


        scanner.close();
    }
    
}
