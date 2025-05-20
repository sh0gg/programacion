package ud7.Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class E1004 {
    public static void main(String[] args) {
        String ruta = "NumerosReales.txt";

        try (Scanner sc = new Scanner(new File(ruta))) {
            double suma = 0.0;
            int contador = 0;

            while (sc.hasNextDouble()) {
                suma += sc.nextDouble();
                contador++;
            }

            double media = (contador > 0) ? suma / contador : 0;
            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo.");
        }
    }
}
