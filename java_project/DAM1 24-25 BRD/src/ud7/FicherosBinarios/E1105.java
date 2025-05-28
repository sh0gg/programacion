package ud7.FicherosBinarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class E1105 {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("datos_array.dat"))) {
            int[] numeros = (int[]) in.readObject();

            System.out.println("Array leído:");
            for (int num : numeros) {
                System.out.println(num);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el array: " + e.getMessage());
        }
    }
}
