package ud5.practicas.rol;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class AppCombateSingular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = cargarPersonajes();  // Cargar personajes desde JSON

        if (personajes.isEmpty()) {
            System.out.println("No hay personajes disponibles. Crea algunos primero.");
            return;
        }

        // Mostrar lista de personajes
        System.out.println("\n--- Personajes Disponibles ---");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println((i + 1) + ". " + personajes.get(i).toString());
        }

        // Seleccionar personajes para el combate
        System.out.print("\nElige el número del primer personaje: ");
        int index1 = scanner.nextInt() - 1;
        System.out.print("Elige el número del segundo personaje: ");
        int index2 = scanner.nextInt() - 1;

        if (index1 < 0 || index1 >= personajes.size() || index2 < 0 || index2 >= personajes.size() || index1 == index2) {
            System.out.println("Selección inválida.");
            return;
        }

        Personaje p1 = personajes.get(index1);
        Personaje p2 = personajes.get(index2);

        // Mostrar fichas antes del combate
        System.out.println("\n--- INICIO DEL COMBATE ---");
        p1.mostrar();
        p2.mostrar();

        // Determinar quién empieza
        Personaje atacante, defensor;
        if (p1.getAgilidad() > p2.getAgilidad()) {
            atacante = p1;
            defensor = p2;
        } else if (p2.getAgilidad() > p1.getAgilidad()) {
            atacante = p2;
            defensor = p1;
        } else {
            atacante = (Math.random() > 0.5) ? p1 : p2;
            defensor = (atacante == p1) ? p2 : p1;
        }

        // Turnos de combate
        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n" + atacante.toString() + " ataca a " + defensor.toString());
            int dano = atacante.atacar(defensor);
            System.out.println("Daño infligido: " + dano);

            if (!defensor.estaVivo()) {
                System.out.println(defensor.toString() + " ha muerto!");
                break;
            }

            // Cambio de turno
            Personaje temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        System.out.println("\n--- FIN DEL COMBATE ---");
        p1.mostrar();
        p2.mostrar();

        scanner.close();
    }

    // Método para cargar personajes desde un archivo JSON
    private static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("ud5/practicas/rol/personajes.json");
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
            reader.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo de personajes.");
        }
        return personajes;
    }
}
