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
import java.util.Random;
import java.util.Scanner;

public class GestorPersonajes {
    private static final String FILE_PATH = "ud5/practicas/rol/personajes.json";
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    /** Cargar personajes desde el archivo JSON */
    public static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
        } catch (IOException e) {
            System.out.println("📂 Archivo no encontrado. Se creará uno nuevo.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al leer personajes. Inicializando lista vacía.");
        }
        return personajes != null ? personajes : new ArrayList<>();
    }

    /** Guardar la lista de personajes en JSON */
    public static void guardarPersonajes(List<Personaje> personajes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            gson.toJson(personajes, file);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los personajes.");
        }
    }

    /** Crear un nuevo personaje */
    public static void crearPersonaje() {
        List<Personaje> personajes = cargarPersonajes();
        System.out.print("📝 Introduce el nombre del personaje: ");
        String nombre = scanner.nextLine();

        System.out.print("🧬 Introduce la raza (HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL): ");
        String raza = scanner.nextLine().toUpperCase();

        try {
            Personaje nuevoPersonaje = new Personaje(nombre, raza);
            personajes.add(nuevoPersonaje);
            System.out.println("✅ Personaje creado: " + nuevoPersonaje);
            guardarPersonajes(personajes);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /** Iniciar un combate entre dos personajes */
    public static void combate() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        // Selección de personajes con validación
        Personaje p1 = seleccionarPersonaje(personajes, "🎭 Elige el primer personaje: ");
        Personaje p2 = seleccionarPersonaje(personajes, "🎭 Elige el segundo personaje: ");

        if (p1 == null || p2 == null || p1 == p2) {
            System.out.println("❌ Selección inválida.");
            return;
        }

        System.out.println("\n🔥 --- COMIENZA EL COMBATE --- 🔥");
        p1.mostrar();
        p2.mostrar();

        Personaje atacante = (p1.getAgilidad() > p2.getAgilidad()) ? p1 : p2;
        Personaje defensor = (atacante == p1) ? p2 : p1;

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n⚔️ " + atacante + " ataca a " + defensor);
            int dano = atacante.atacar(defensor);
            System.out.println("💥 Daño infligido: " + dano);

            if (!defensor.estaVivo()) {
                System.out.println("💀 " + defensor + " ha sido derrotado!");
                break;
            }

            Personaje temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        System.out.println("\n🏆 --- FIN DEL COMBATE --- 🏆");
        p1.mostrar();
        p2.mostrar();

        guardarPersonajes(personajes);
    }

    /** Explorar la mazmorra */
    public static void mazmorra() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        Personaje jugador = seleccionarPersonaje(personajes, "🏰 Elige un personaje para explorar la mazmorra: ");
        if (jugador == null) return;

        boolean explorando = true;
        while (explorando && jugador.estaVivo()) {
            System.out.println("\n📜 ¿Qué quieres hacer?");
            System.out.println("1️⃣ Avanzar en la mazmorra");
            System.out.println("2️⃣ Revisar tu estado");
            System.out.println("3️⃣ Salir");

            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1 -> eventoMazmorra(jugador);
                case 2 -> jugador.mostrar();
                case 3 -> {
                    explorando = false;
                    System.out.println("🏆 ¡Has escapado con vida!");
                }
                default -> System.out.println("❌ Opción inválida.");
            }
        }

        if (!jugador.estaVivo()) {
            System.out.println("💀 Has caído en la mazmorra...");
        }

        guardarPersonajes(personajes);
    }

    /** Generar un evento en la mazmorra */
private static void eventoMazmorra(Personaje jugador) {
    int evento = rand.nextInt(3);

    if (evento == 0) {
        // Encuentro con un monstruo
        Personaje monstruo = generarMonstruo();
        System.out.println("\n👹 Un " + monstruo + " aparece!");
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

/** Simulación de combate entre el jugador y un enemigo */
private static void combate(Personaje jugador, Personaje enemigo) {
    System.out.println("\n⚔️ ¡Empieza el combate entre " + jugador + " y " + enemigo + "!");

    while (jugador.estaVivo() && enemigo.estaVivo()) {
        // Turno del jugador
        System.out.println("\n⚔️ " + jugador + " ataca a " + enemigo);
        int dano = jugador.atacar(enemigo);
        System.out.println("💥 Daño infligido: " + dano);

        if (!enemigo.estaVivo()) {
            System.out.println("\n🎉 ¡Has derrotado al " + enemigo + " y ganado experiencia!");
            jugador.sumarExperiencia(500);
            return;
        }

        // Turno del enemigo
        System.out.println("\n☠️ " + enemigo + " ataca a " + jugador);
        dano = enemigo.atacar(jugador);
        System.out.println("💀 Daño recibido: " + dano);

        if (!jugador.estaVivo()) {
            System.out.println("\n💀 El monstruo te ha derrotado...");
        }
    }

    guardarPersonajes(cargarPersonajes()); // Guardar
}


    /** Generar un monstruo en la mazmorra */
    private static Personaje generarMonstruo() {
        String[] monstruos = {"Goblin", "Esqueleto", "Orco", "Troll", "Demonio"};
        String[] jefes = {"Lich", "Dragón", "Señor de la Oscuridad"};

        boolean esJefe = rand.nextInt(100) < 20;
        String nombre = esJefe ? jefes[rand.nextInt(jefes.length)] : monstruos[rand.nextInt(monstruos.length)];
        int multiplicador = esJefe ? 3 : 1;

        try {
            return new Personaje(
                nombre, "MONSTRUO",
                (rand.nextInt(50) + 10) * multiplicador,
                (rand.nextInt(50) + 10) * multiplicador,
                (rand.nextInt(50) + 10) * multiplicador,
                (rand.nextInt(50) + 10) * multiplicador,
                (rand.nextInt(50) + 10) * multiplicador,
                (rand.nextInt(50) + 10) * multiplicador
            );
        } catch (Exception e) {
            System.out.println("❌ Error al generar el monstruo.");
            return null;
        }
    }

    /** Seleccionar un personaje con validación */
    private static Personaje seleccionarPersonaje(List<Personaje> personajes, String mensaje) {
        int index = -1;
        while (index < 0 || index >= personajes.size()) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                index = scanner.nextInt() - 1;
                scanner.nextLine();
            } else {
                System.out.println("❌ Entrada inválida. Ingresa un número.");
                scanner.next();
            }
        }
        return personajes.get(index);
    }
    /** Evento de acertijo en la mazmorra */
private static void acertijo(Personaje jugador) {
    System.out.println("\n🧩 ¡Has encontrado un acertijo mágico!");

    // Lista de acertijos posibles
    String[][] acertijos = {
        {"¿Cuál es el pilar de la POO que permite reutilizar código?", "herencia"},
        {"Si en Java una clase implementa una interfaz, ¿qué palabra clave se usa?", "implements"},
        {"¿Cómo se llama el proceso de ocultar detalles internos de un objeto y exponer solo lo necesario?", "encapsulamiento"},
        {"¿Qué palabra clave en Java se usa para crear un objeto?", "new"}
    };

    // Decidir si hacer una pregunta de programación o un cálculo matemático
    boolean esPreguntaMatematica = rand.nextBoolean();

    String pregunta;
    String respuestaCorrecta;

    if (esPreguntaMatematica) {
        // Generar números aleatorios para una suma
        int num1 = rand.nextInt(20) + 1; // Números entre 1 y 20
        int num2 = rand.nextInt(20) + 1;
        pregunta = "¿Cuánto es " + num1 + " + " + num2 + "?";
        respuestaCorrecta = String.valueOf(num1 + num2);
    } else {
        // Seleccionar una pregunta de POO al azar
        int index = rand.nextInt(acertijos.length);
        pregunta = acertijos[index][0];
        respuestaCorrecta = acertijos[index][1];
    }

    // Pedir respuesta al usuario
    System.out.print("❓ " + pregunta + " ");
    String respuestaUsuario = scanner.nextLine().trim().toLowerCase();

    if (respuestaUsuario.equals(respuestaCorrecta)) {
        System.out.println("\n✨ ¡Correcto! Ganas 300 puntos de experiencia.");
        jugador.sumarExperiencia(300);
    } else {
        System.out.println("\n❌ Respuesta incorrecta. No ganas nada.");
    }

    guardarPersonajes(cargarPersonajes()); // Guardar cambios después del acertijo
}

}
