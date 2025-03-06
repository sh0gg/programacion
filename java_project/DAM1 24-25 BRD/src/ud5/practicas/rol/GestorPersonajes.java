package ud5.practicas.rol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GestorPersonajes {
    private static final String FILE_PATH = "personajes.json";

    public static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
        } catch (IOException e) {
            System.out.println("Archivo de personajes no encontrado. Se creará uno nuevo.");
        }
        return personajes;
    }

    public static void guardarPersonajes(List<Personaje> personajes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            gson.toJson(personajes, file);
        } catch (IOException e) {
            System.out.println("Error al guardar los personajes.");
        }
    }
}
