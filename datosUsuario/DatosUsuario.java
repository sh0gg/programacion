package datosUsuario;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatosUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("E ti de quen ves sendo?: ");
        String nombre = scanner.nextLine();
        System.out.print("E tes cantos anos?: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("E como carallo vou contactar contigho? Por mail?: ");
        String webMail = scanner.nextLine();

        LocalDateTime ahora = LocalDateTime.now();
        int diaMes = ahora.getDayOfMonth();
        int numMes = ahora.getMonthValue();
        int numAno = ahora.getYear();
        int hora = ahora.getHour();
        int minu = ahora.getMinute();

        System.out.println("Datos ingresados a las " + hora + ":" + minu + " de " + diaMes + "/" + numMes + "/" + numAno + " :");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Correo: " + webMail);

        // Escribir los datos en un archivo de texto
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\xarro\\Programación\\datos_usuario.txt", true))) {
            writer.println("Datos ingresados a las " + hora + ":" + minu + " de " + diaMes + "/" + numMes + "/" + numAno + ":");
            writer.println("Nombre: " + nombre);
            writer.println("Edad: " + edad);
            writer.println("Correo: " + webMail);
            writer.println("-------------------------"); // Separador para diferentes entradas
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
