package ud7.Ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E1007 {

    // Ruta base donde se guardará el archivo. Debe ajustarse a tu estructura de carpetas.
    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

    public static void main(String[] args) {
        // Nombre completo del archivo de salida
        String ruta = PATH + "Quijote.txt";

        // Usamos try-with-resources para asegurar el cierre automático del BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            
            // Primera línea del texto a escribir carácter por carácter
            String linea1 = "En un lugar de La Mancha,";
            
            // Recorremos la línea carácter por carácter y escribimos cada uno
            for (char c : linea1.toCharArray()) {
                bw.write(c); // Escribimos un carácter
            }
            // Escribimos un salto de línea al final de la primera línea
            bw.newLine();

            // Segunda línea escrita de una sola vez
            String linea2 = "de cuyo nombre no quiero acordarme";
            bw.write(linea2); // Escribimos la línea entera

        } catch (IOException e) {
            // Capturamos cualquier error de entrada/salida y mostramos el mensaje
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
