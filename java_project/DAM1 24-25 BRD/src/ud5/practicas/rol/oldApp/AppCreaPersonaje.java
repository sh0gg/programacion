package ud5.practicas.rol.oldApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import ud5.practicas.rol.Personaje;

import java.lang.reflect.Type;

public class AppCreaPersonaje {
    private static final String FILE_PATH = "ud5/practicas/rol/personajes.json"; // Archivo donde guardamos los personajes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = cargarPersonajes(); // Cargar personajes existentes

        try {
            System.out.print("Introduce el nombre del personaje: ");
            String nombre = scanner.nextLine();

            System.out.print("Introduce la raza (HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL): ");
            String raza = scanner.nextLine().toUpperCase();

            // Crear nuevo personaje
            Personaje nuevoPersonaje = new Personaje(nombre, raza);
            personajes.add(nuevoPersonaje); // Agregarlo a la lista de personajes

            System.out.println("Personaje creado: " + nuevoPersonaje);

            // Guardar la lista completa en el archivo JSON
            guardarPersonajes(personajes);

            System.out.println("Personaje guardado en " + FILE_PATH);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    // Método para cargar los personajes desde el archivo JSON
    private static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
            reader.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
        }
        return personajes;
    }

    // Método para guardar la lista de personajes en JSON
    private static void guardarPersonajes(List<Personaje> personajes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            gson.toJson(personajes, file);
        } catch (IOException e) {
            System.out.println("Error al guardar los personajes.");
        }
    }
}
