package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class EP0220 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String nombreString = "admin";
        final String contraString = "abc123.,";
    

        System.out.print("Introduzca el nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Introduzca la contraseña: ");
        String contraseña = scanner.nextLine();
        scanner.close();

        if (usuario.equals(nombreString) && contraseña.equals(contraString)){
            System.out.println("Iniciando sesión...");
        }else{
            System.out.println("Usuario o contraseña incorrectos");
        }
    }
}
