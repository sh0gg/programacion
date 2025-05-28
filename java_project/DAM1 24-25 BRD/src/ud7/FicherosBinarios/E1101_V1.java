package ud7.FicherosBinarios;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E1101_V1 {
    public static void main(String[] args) {
        // Ruta al archivo binario de salida
        String ruta = "datos.dat";

        // try-with-resources para cerrar automáticamente el flujo
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(ruta))) {

            // Escribimos 10 números enteros en el archivo binario uno a uno
            for (int i = 1; i <= 10; i++) {
                out.writeInt(i); // writeInt escribe el valor binario de un entero
            }

            System.out.println("Se han escrito 10 enteros en " + ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

