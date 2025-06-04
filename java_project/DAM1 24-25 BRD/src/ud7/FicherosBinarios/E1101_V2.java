package ud7.FicherosBinarios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E1101_V2 {
    public static void main(String[] args) {
        // Ruta al archivo binario de salida
        String ruta = "datos_array.dat";

        // Creamos un array con los valores a guardar
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};

        // try-with-resources para escribir el array completo como un objeto
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {

            // writeObject puede guardar arrays si son serializables
            out.writeObject(numeros); // int[] es serializable automáticamente

            System.out.println("Array de enteros guardado en " + ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
