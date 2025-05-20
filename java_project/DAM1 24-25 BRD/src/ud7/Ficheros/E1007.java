package ud7.Ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E1007 {

    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

    public static void main(String[] args) {
        String ruta = PATH + "Quijote.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            String linea1 = "En un lugar de La Mancha,";
            for (char c : linea1.toCharArray()) {
                bw.write(c);
            }
            bw.newLine();

            String linea2 = "de cuyo nombre no quiero acordarme";
            bw.write(linea2);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
