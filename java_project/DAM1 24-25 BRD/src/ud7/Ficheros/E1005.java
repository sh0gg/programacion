package ud7.Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E1005 {
    public static void main(String[] args) {
        String ruta = "Numeros.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            double suma = 0;

            while ((linea = br.readLine()) != null) {
                Scanner sc = new Scanner(linea);
                while (sc.hasNextDouble()) {
                    suma += sc.nextDouble();
                }
            }

            System.out.println("Suma total: " + suma);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
