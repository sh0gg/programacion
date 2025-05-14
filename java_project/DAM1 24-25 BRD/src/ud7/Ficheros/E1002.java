package ud7.Ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E1002 {
    public static void main(String[] args) {
        String ruta = "src/Main.java"; // Ruta relativa al archivo

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}