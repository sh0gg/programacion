package ud7.FicherosBinarios;

import java.io.*;
import java.util.Arrays;

// Clase que representa a un socio
class Socio implements Serializable {
    private String nombre;
    private int edad;

    public Socio(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Socio{" + "nombre='" + nombre + '\'' + ", edad=" + edad + '}';
    }
}

public class E1108 {
    public static void main(String[] args) {
        Socio[] socios = {
            new Socio("Ana", 30),
            new Socio("Luis", 40),
            new Socio("Pedro", 35)
        };

        // Guardamos el array de socios
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("socios.dat"))) {
            out.writeObject(socios);
        } catch (IOException e) {
            System.out.println("Error al guardar socios: " + e.getMessage());
        }

        // Leemos y mostramos los socios
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("socios.dat"))) {
            Socio[] leidos = (Socio[]) in.readObject();
            System.out.println("Socios leídos del archivo:");
            Arrays.stream(leidos).forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer socios: " + e.getMessage());
        }
    }
}
