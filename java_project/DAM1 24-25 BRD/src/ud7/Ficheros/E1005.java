package ud7.Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E1005 {
    public static void main(String[] args) {
        // Nombre del archivo que contiene números reales (uno o varios por línea)
        String ruta = "Numeros.txt";

        // try-with-resources para asegurar el cierre de los recursos
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;         // Para almacenar cada línea leída
            double suma = 0;      // Acumulador para la suma de números

            // Leemos el archivo línea a línea
            while ((linea = br.readLine()) != null) {
                // Creamos un Scanner para procesar cada línea individualmente
                Scanner sc = new Scanner(linea);

                // Mientras haya números reales en la línea, los vamos sumando
                while (sc.hasNextDouble()) {
                    suma += sc.nextDouble();
                }

                // Cerramos el scanner de línea (buena práctica)
                sc.close();
            }

            // Mostramos la suma total de todos los números encontrados
            System.out.println("Suma total: " + suma);

        // Capturamos cualquier error de lectura del archivo
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
