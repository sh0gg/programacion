package ud1.ejercicios;


import java.util.Scanner;

public class base {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuáles son tus iniciales?");
        String iniciales = scanner.nextLine();
        System.out.println("¡Hola Mundo! Mi nombre es " + iniciales);

        scanner.close();
    }
    
}
