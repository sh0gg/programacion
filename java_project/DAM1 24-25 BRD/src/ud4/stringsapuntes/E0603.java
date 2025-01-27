package ud4.stringsapuntes;

import java.util.Scanner;

public class E0603 {
    public static void main(String[] args) {
        int MAX_INTENTOS = 3;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bienvendo jugador 1. Introduce la contraseña: ");
        String passwd = scanner.nextLine();

        // Ocultación de la contraseña
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");            
        }

        System.out.print("Bienvenido jugador 2. Vamos a intentar adivinar la contraseña: ");
        String intento = scanner.nextLine();
        int contador = 0;

        while (!intento.equalsIgnoreCase(passwd) && contador < MAX_INTENTOS) {
            contador++;
            System.out.println("La contraseña no es correcta, prueba de nuevo.");
            intento = scanner.nextLine();
        }

        scanner.close();
        
        if (intento.equals(passwd)) {
            System.out.println("¡Enhorabuena, has ganado!");
        } else {
            System.out.println("¡Has perdido! Una pena... Better luck next time!");
        }
       
    }
}
