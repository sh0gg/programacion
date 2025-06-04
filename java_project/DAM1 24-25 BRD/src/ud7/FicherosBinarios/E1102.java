package ud7.FicherosBinarios;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E1102 {
    public static void main(String[] args) {
        String estrofa = """
            Con diez cañones por banda,
            viento en popa a toda vela,
            no corta el mar, sino vuela
            un velero bergantín.
            """;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cancionPirata.dat"))) {
            out.writeObject(estrofa); // Guardamos la cadena completa como un objeto serializado
            System.out.println("Estrofa guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la estrofa: " + e.getMessage());
        }
    }
}
