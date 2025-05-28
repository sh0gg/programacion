package ud7.FicherosBinarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class E1104 {
    public static void main(String[] args) {
        try (DataInputStream in = new DataInputStream(new FileInputStream("datos.dat"))) {
            while (true) {
                int num = in.readInt(); // Leemos enteros hasta EOF
                System.out.println("Número leído: " + num);
            }
        } catch (IOException e) {
            System.out.println("Fin de archivo o error: " + e.getMessage());
        }
    }
}
