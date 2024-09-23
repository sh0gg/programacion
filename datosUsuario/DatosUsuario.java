package datosUsuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatosUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pidiendo datos al usuario
        System.out.print("Escribe tu nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Escribe tu apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Escribe tu fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimientoStr = scanner.nextLine(); 

        System.out.print("Escribe tu email para contactar contigo: ");
        String webMail = scanner.nextLine();

        // Obteniendo fecha actual
        LocalDateTime ahora = LocalDateTime.now();
        int diaMes = ahora.getDayOfMonth();
        int numMes = ahora.getMonthValue();
        int numAno = ahora.getYear();
        int hora = ahora.getHour();
        int minu = ahora.getMinute();

        // Parsear la fecha de nacimiento a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

        // Calcular edad
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        // Crear un mapa para traducir los días de la semana
        Map<String, String> diasSemana = new HashMap<>();
        diasSemana.put("MONDAY", "Lunes");
        diasSemana.put("TUESDAY", "Martes");
        diasSemana.put("WEDNESDAY", "Miércoles");
        diasSemana.put("THURSDAY", "Jueves");
        diasSemana.put("FRIDAY", "Viernes");
        diasSemana.put("SATURDAY", "Sábado");
        diasSemana.put("SUNDAY", "Domingo");

        // Calcular el día de la semana en que nació
        String diaSemNacimientoIngles = fechaNacimiento.getDayOfWeek().toString();
        String diaSemNacimiento = diasSemana.get(diaSemNacimientoIngles);

        // Mostrar resultados
        System.out.println("Datos ingresados a las " + hora + ":" + minu + " de " + diaMes + "/" + numMes + "/" + numAno + ":");
        System.out.println("¡Hola " + nombre + " " + apellido + "!");
        System.out.println("Tienes " + edad + " años.");
        System.out.println("Naciste un " + diaSemNacimiento.toLowerCase() + ".");
        

        // Escribir los datos en un archivo de texto
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\xarro\\Programación\\datos_usuario.txt", true))) {
            writer.println("Datos ingresados a las " + hora + ":" + minu + " de " + diaMes + "/" + numMes + "/" + numAno + ":");
            writer.println("Nombre: " + nombre);
            writer.println("Apellido: " + apellido);
            writer.println("Edad:" + edad);
            writer.println("Fecha de nacimiento: " + fechaNacimiento);
            writer.println("Nació un: " + diaSemNacimiento );
            writer.println("Correo: " + webMail);
            writer.println("-------------------------"); // Separador para diferentes entradas
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Ruta del archivo CSV
        String filePath = "C:\\Users\\xarro\\Programación\\datos_usuario.csv";

        // Escribir los datos en un archivo CSV
        try {
            File file = new File(filePath);
            boolean isNewFile = !file.exists();  // Verifica si el archivo ya existe

            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                // Si el archivo no existía, escribe los encabezados
                if (isNewFile) {
                    writer.println("Nombre,Apellido,Edad,Fecha de Nacimiento,Día de Nacimiento,Correo,Hora,Minuto,Dia,Mes,Año");
                }

                // Escribir los datos separados por comas
                writer.printf("%s,%s,%d,%s,%s,%s,%d,%d,%d,%d,%d%n",
                        nombre, apellido, edad, fechaNacimiento, diaSemNacimiento, webMail, hora, minu, diaMes, numMes, numAno);

            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }

        scanner.close();
        
    }
}
