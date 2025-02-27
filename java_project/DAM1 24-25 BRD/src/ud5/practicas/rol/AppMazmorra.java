package ud5.practicas.rol.oldApp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ud5.practicas.rol.Personaje;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AppMazmorra {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "ud5/practicas/rol/personajes.json";

    public static void main(String[] args) {
        List<Personaje> personajes = cargarPersonajes();  // Cargar personajes desde JSON

        if (personajes.isEmpty()) {
            System.out.println("No hay personajes disponibles. Crea algunos primero.");
            return;
        }

        System.out.println("📜 Personajes disponibles:");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println((i + 1) + ". " + personajes.get(i).toString());
        }

        System.out.print("\nElige un personaje (1-" + personajes.size() + "): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        if (opcion < 1 || opcion > personajes.size()) {
            System.out.println("❌ Opción no válida.");
            return;
        }

        Personaje jugador = personajes.get(opcion - 1);
        System.out.println("\n🏰 ¡Bienvenido a la Mazmorra, " + jugador.toString() + "! 🏰\n");

        boolean explorando = true;
        while (explorando && jugador.estaVivo()) {
            System.out.println("\n📜 ¿Qué quieres hacer?");
            System.out.println("1. Avanzar en la mazmorra");
            System.out.println("2. Revisar tu estado");
            System.out.println("3. Salir de la mazmorra");

            int eleccion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (eleccion) {
                case 1:
                    eventoMazmorra(jugador);
                    break;
                case 2:
                    jugador.mostrar();
                    break;
                case 3:
                    explorando = false;
                    System.out.println("\n🏆 ¡Has escapado de la mazmorra con vida! 🏆");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        }

        if (!jugador.estaVivo()) {
            System.out.println("\n💀 Has muerto en la mazmorra... 💀");
        }
    }

    private static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
            reader.close();
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo de personajes.");
        }
        return personajes;
    }

    private static void eventoMazmorra(Personaje jugador) {
        int evento = rand.nextInt(3);

        if (evento == 0) {
            // Encuentro con un monstruo
            Personaje monstruo = generarMonstruo();
            System.out.println("\n👹 ¡Un " + monstruo.toString() + " aparece en tu camino!");
            combate(jugador, monstruo);
        } else if (evento == 1) {
            // Acertijo/Puzzle
            acertijo(jugador);
        } else {
            // Recompensa aleatoria
            int cura = rand.nextInt(20) + 10;
            jugador.curar();
            System.out.println("\n🧪 ¡Has encontrado una poción! Recuperas " + cura + " puntos de vida.");
        }
    }

    private static Personaje generarMonstruo() {
        String[] monstruos = {"Goblin", "Esqueleto", "Orco", "Troll", "Demonio"};
        String[] jefes = {"Lich", "Demogorgon", "Dragón", "Titán", "Señor de la Oscuridad"};

        boolean esJefe = rand.nextInt(100) < 20; // 20% de probabilidad de generar un jefe
        String nombre = esJefe ? jefes[rand.nextInt(jefes.length)] : monstruos[rand.nextInt(monstruos.length)];

        int multiplicador = esJefe ? 3 : 1; // Los jefes son 3 veces más fuertes

        try {
            return new Personaje(
                    nombre,
                    "MONSTRUO",
                    (rand.nextInt(50) + 10) * multiplicador, // Fuerza
                    (rand.nextInt(50) + 10) * multiplicador, // Agilidad
                    (rand.nextInt(50) + 10) * multiplicador, // Constitución
                    (rand.nextInt(50) + 10) * multiplicador, // Inteligencia
                    (rand.nextInt(50) + 10) * multiplicador, // Intuición
                    (rand.nextInt(50) + 10) * multiplicador  // Presencia
            );
        } catch (Exception e) {
            System.out.println("Error al generar el monstruo: " + e.getMessage());
            return null;
        }
    }


    private static void combate(Personaje jugador, Personaje monstruo) {
        while (jugador.estaVivo() && monstruo.estaVivo()) {
            System.out.println("\n⚔️ " + jugador.toString() + " ataca a " + monstruo.toString());
            int dano = jugador.atacar(monstruo);
            System.out.println("💥 Daño infligido: " + dano);

            if (!monstruo.estaVivo()) {
                System.out.println("\n🎉 ¡Has derrotado al " + monstruo.toString() + " y ganado experiencia!");
                jugador.sumarExperiencia(500);
                return;
            }

            System.out.println("\n☠️ " + monstruo.toString() + " ataca a " + jugador.toString());
            dano = monstruo.atacar(jugador);
            System.out.println("💀 Daño recibido: " + dano);

            if (!jugador.estaVivo()) {
                System.out.println("\n💀 El monstruo te ha derrotado...");
            }
        }
    }

    private static void acertijo(Personaje jugador) {
        System.out.println("\n🧩 ¡Has encontrado un acertijo mágico!");
        String pregunta = "¿Cuánto es 7 + 5?";
        String respuesta = "12";

        System.out.println(pregunta);
        String respuestaUsuario = scanner.nextLine();

        if (respuestaUsuario.equals(respuesta)) {
            System.out.println("\n✨ ¡Correcto! Ganas 300 puntos de experiencia.");
            jugador.sumarExperiencia(300);
        } else {
            System.out.println("\n❌ Respuesta incorrecta. No ganas nada.");
        }
    }
}
