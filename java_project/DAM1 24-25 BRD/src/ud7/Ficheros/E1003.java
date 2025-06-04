package ud7.Ficheros;

// Importamos las clases necesarias para trabajar con ficheros

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E1003 {
    public static void main(String[] args) {
        // Indicamos la ruta al archivo que queremos leer.
        // Usa una ruta relativa. Asegúrate de que "Main.java" exista en esa ruta.
        String ruta = "src/Main.java"; // Ruta relativa al archivo

        // try-with-resources: abre el recurso y lo cierra automáticamente al final del bloque
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            // Leemos el archivo línea por línea hasta que no haya más (readLine() devuelve null)
            while ((linea = br.readLine()) != null) {
                // Mostramos cada línea por pantalla
                System.out.println(linea);
            }

        // Capturamos cualquier error que pueda ocurrir al intentar acceder al archivo
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
