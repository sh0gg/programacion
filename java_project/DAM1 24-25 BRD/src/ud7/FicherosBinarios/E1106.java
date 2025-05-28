package ud7.FicherosBinarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class E1106 {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cancionPirata.dat"))) {
            String estrofa = (String) in.readObject();
            System.out.println("Estrofa recuperada:");
            System.out.println(estrofa);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar la estrofa: " + e.getMessage());
        }
    }
}
