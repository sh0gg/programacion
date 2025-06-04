package ud7.Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E1004 {
    public static void main(String[] args) {
        // Especificamos el nombre del archivo que contiene los números reales
        String ruta = "NumerosReales.txt";

        // Usamos try-with-resources para asegurar el cierre automático del Scanner
        try (Scanner sc = new Scanner(new File(ruta))) {
            double suma = 0.0;      // Variable para acumular la suma de los números
            int contador = 0;       // Contador para saber cuántos números se han leído

            // Leemos el archivo mientras haya números de tipo double
            while (sc.hasNextDouble()) {
                suma += sc.nextDouble(); // Sumamos el siguiente número
                contador++;              // Aumentamos el contador
            }

            // Calculamos la media si se han leído valores
            double media = (contador > 0) ? suma / contador : 0;

            // Mostramos los resultados por consola
            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);

        // Capturamos el error si el archivo no existe
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo.");
        }
    }
}
