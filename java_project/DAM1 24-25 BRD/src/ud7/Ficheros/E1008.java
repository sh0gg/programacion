package ud7.Ficheros;

import java.io.*;
import java.util.Scanner;

public class E1008 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer el nombre del archivo original por consola
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el nombre del archivo a duplicar: ");
        String original = sc.nextLine(); // Leemos el nombre del archivo original

        sc.close(); // Cerramos el Scanner para evitar fugas de recursos
        
        // Verificamos si el archivo original existe
        File archivoOriginal = new File(original);
        if (!archivoOriginal.exists()) {
            System.out.println("Error: El archivo '" + original + "' no existe.");
            return; // Salimos del programa si el archivo no existe
        }
        
        // Creamos el nombre del archivo copia con el prefijo "copia_de_"
        String copia = "copia_de_" + original;

        // Usamos try-with-resources para abrir ambos flujos (lectura y escritura)
        try (
            BufferedReader br = new BufferedReader(new FileReader(original));  // Lector del archivo original
            BufferedWriter bw = new BufferedWriter(new FileWriter(copia))      // Escritor del archivo copia
        ) {

            String linea;

            // Leemos el archivo original línea por línea y lo escribimos en el archivo de copia
            while ((linea = br.readLine()) != null) {
                bw.write(linea);    // Escribimos la línea
                bw.newLine();       // Añadimos un salto de línea para mantener el formato
            }

            // Confirmación al usuario
            System.out.println("Archivo duplicado como: " + copia);

        } catch (IOException e) {
            // En caso de cualquier error de entrada/salida, mostramos el mensaje
            System.out.println("Error: " + e.getMessage());
        }
    }
}
