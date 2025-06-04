package ud7.Ficheros;

// Importamos las clases necesarias para trabajar con ficheros
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E1002 {
    public static void main(String[] args) {
        // Ruta del archivo que queremos leer. Debe existir en la ruta indicada.
        // Si el archivo está en la raíz del proyecto, asegúrate de ajustar la ruta.
        String ruta = "src/Main.java"; // Ruta relativa al archivo

        // Intentamos abrir y leer el archivo línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            // Leemos el archivo hasta llegar al final (readLine() devuelve null)
            while ((linea = br.readLine()) != null) {
                // Imprimimos cada línea del archivo por consola
                System.out.println(linea);
            }

        // Si ocurre un error de entrada/salida, lo capturamos y mostramos un mensaje
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
