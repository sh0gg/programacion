package ud5.practicas.rol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

    /**
     * Cargar personajes desde el archivo JSON
     */
    public static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("personajes.json")) {
            Type personajeListType = new TypeToken<ArrayList<Personaje>>() {}.getType();
            personajes = gson.fromJson(reader, personajeListType);
    
            // 🔹 Asegurar que todos los personajes tengan un inventario inicializado
            for (Personaje p : personajes) {
                if (p.getInventario() == null) {
                    p.setInventario(new ArrayList<>());
                }
            }
    
        } catch (IOException e) {
            System.out.println("📂 Archivo no encontrado. Se creará uno nuevo.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al leer personajes. Inicializando lista vacía.");
        }
        return personajes != null ? personajes : new ArrayList<>();
    }
    


    public static void guardarPersonajes(List<Personaje> personajes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter("personajes.json")) {
            for (Personaje p : personajes) {
                if (p.getInventario() == null) { 
                    p.setInventario(new ArrayList<>()); // ✅ Prevenir NullPointerException
                }
            }
            gson.toJson(personajes, file);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los personajes.");
        }
    }
    
    

    /**
     * Crear un nuevo personaje
     */
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

    /**
     * Iniciar un combate entre dos personajes
     */
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

    public static void mazmorra() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        // Seleccionar personaje para explorar la mazmorra
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


    /**
     * Generar un evento en la mazmorra
     */
    private static void eventoMazmorra(Personaje jugador) {
        int evento = rand.nextInt(100); // Probabilidades basadas en 100

        if (evento < 40) {  // 40% de probabilidad de combate
            Personaje monstruo = generarMonstruo();
            System.out.println("\n👹 Un " + monstruo + " aparece!");
            combate(jugador, monstruo);
        } else if (evento < 70) {  // 30% de probabilidad de acertijo
            acertijo(jugador);
        } else {  // 30% de probabilidad de encontrar una poción
            int cura = rand.nextInt(20) + 10;
            jugador.curar();
            System.out.println("\n🧪 ¡Has encontrado una poción! Recuperas " + cura + " puntos de vida.");
        }
    }


    /**
     * Simulación de combate entre el jugador y un enemigo
     */
    private static void combate(Personaje jugador, Personaje enemigo) {
        System.out.println("\n⚔️ ¡Empieza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
    
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            // Turno del jugador
            System.out.println("\n⚔️ " + jugador.getNombre() + " ataca a " + enemigo.getNombre());
            int dano = jugador.atacar(enemigo);
            System.out.println("💥 Daño infligido: " + dano);
    
            if (!enemigo.estaVivo()) {
                System.out.println("\n🎉 ¡Has derrotado al " + enemigo.getNombre() + " y ganado experiencia!");
                jugador.sumarExperiencia(500);
    
                // Posibilidad de encontrar un objeto tras la victoria
                encontrarObjeto(jugador);
                return;
            }
    
            // Turno del enemigo
            System.out.println("\n☠️ " + enemigo.getNombre() + " ataca a " + jugador.getNombre());
            dano = enemigo.atacar(jugador);
            System.out.println("💀 Daño recibido: " + dano);
    
            if (!jugador.estaVivo()) {
                System.out.println("\n💀 El monstruo te ha derrotado...");
            }
        }
    
        guardarPersonajes(cargarPersonajes()); // Guardar los cambios
    }
    


    /**
     * Generar un monstruo en la mazmorra
     */
    private static Personaje generarMonstruo() {
        String[] monstruos = {"Goblin", "Esqueleto", "Orco", "Troll", "Demonio"};
        String[] jefes = {"Lich", "Dragón", "Señor de la Oscuridad"};

        boolean esJefe = rand.nextInt(100) < 20;
        String nombre = esJefe ? jefes[rand.nextInt(jefes.length)] : monstruos[rand.nextInt(monstruos.length)];
        int multiplicador = esJefe ? 3 : 1;

        try {
            return new Personaje(nombre, "MONSTRUO", (rand.nextInt(50) + 10) * multiplicador, (rand.nextInt(50) + 10) * multiplicador, (rand.nextInt(50) + 10) * multiplicador, (rand.nextInt(50) + 10) * multiplicador, (rand.nextInt(50) + 10) * multiplicador, (rand.nextInt(50) + 10) * multiplicador);
        } catch (Exception e) {
            System.out.println("❌ Error al generar el monstruo.");
            return null;
        }
    }

    /**
     * Seleccionar un personaje con validación (solo personajes vivos)
     */
    private static Personaje seleccionarPersonaje(List<Personaje> personajes, String mensaje) {
        // Filtrar solo personajes vivos
        List<Personaje> personajesVivos = new ArrayList<>();
        for (Personaje p : personajes) {
            if (p.estaVivo()) {
                personajesVivos.add(p);
            }
        }

        // Si no hay personajes vivos, avisar y salir
        if (personajesVivos.isEmpty()) {
            System.out.println("⚠️ No hay personajes vivos disponibles.");
            return null;
        }

        // Mostrar personajes vivos
        System.out.println("\n📜 Personajes vivos disponibles:");
        for (int i = 0; i < personajesVivos.size(); i++) {
            System.out.println((i + 1) + ". " + personajesVivos.get(i));
        }

        // Selección con validación
        int index = -1;
        while (index < 0 || index >= personajesVivos.size()) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                index = scanner.nextInt() - 1;
                scanner.nextLine();
            } else {
                System.out.println("❌ Entrada inválida. Ingresa un número.");
                scanner.next();
            }
        }

        return personajesVivos.get(index);
    }

    /**
     * Evento de acertijo en la mazmorra
     */
    private static void acertijo(Personaje jugador) {
        System.out.println("\n🧩 ¡Has encontrado un acertijo mágico!");
    
        String[][] acertijos = {
            {"¿Cuál es el pilar de la POO que permite reutilizar código?", "herencia"},
            {"Si en Java una clase implementa una interfaz, ¿qué palabra clave se usa?", "implements"},
            {"¿Cómo se llama el proceso de ocultar detalles internos de un objeto y exponer solo lo necesario?", "encapsulamiento"},
            {"¿Qué palabra clave en Java se usa para crear un objeto?", "new"}
        };
    
        boolean esPreguntaMatematica = rand.nextBoolean();
        String pregunta, respuestaCorrecta;
    
        if (esPreguntaMatematica) {
            int num1 = rand.nextInt(20) + 1;
            int num2 = rand.nextInt(20) + 1;
            pregunta = "¿Cuánto es " + num1 + " + " + num2 + "?";
            respuestaCorrecta = String.valueOf(num1 + num2);
        } else {
            int index;
            do {
                index = rand.nextInt(acertijos.length);
            } while (ultimaPregunta == index);
    
            ultimaPregunta = index;
            pregunta = acertijos[index][0];
            respuestaCorrecta = acertijos[index][1];
        }
    
        System.out.print("❓ " + pregunta + " ");
        String respuestaUsuario = scanner.nextLine().trim().toLowerCase();
    
        if (respuestaUsuario.equals(respuestaCorrecta)) {
            System.out.println("\n✨ ¡Correcto! Ganas 300 puntos de experiencia.");
            jugador.sumarExperiencia(300);
    
            // Posibilidad de encontrar un objeto tras acertar
            encontrarObjeto(jugador);
        } else {
            System.out.println("\n❌ Respuesta incorrecta. No ganas nada.");
        }
    
        guardarPersonajes(cargarPersonajes());
    }
    

    // Variable estática para evitar repetir la última pregunta de POO
    private static int ultimaPregunta = -1;

    /** Restaurar vida de los personajes basada en el tiempo real transcurrido */
    public static void restaurarPersonajes() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) return;

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        LocalDateTime ultimaEjecucion = null;

        // Leer última ejecución desde JSON
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                JsonObject json = jsonElement.getAsJsonObject();
                if (json.has("ultimaEjecucion")) {
                    ultimaEjecucion = LocalDateTime.parse(json.get("ultimaEjecucion").getAsString());
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró información de la última ejecución.");
        }

        // Obtener tiempo actual
        LocalDateTime ahora = LocalDateTime.now();
        if (ultimaEjecucion == null) {
            ultimaEjecucion = ahora;
        }

        // Calcular minutos transcurridos
        long minutosPasados = ChronoUnit.MINUTES.between(ultimaEjecucion, ahora);

        if (minutosPasados > 0) {
            System.out.println("⏳ Han pasado " + minutosPasados + " minutos desde la última sesión.");
            for (Personaje p : personajes) {
                if (p.estaVivo()) {
                    int nuevaVida = Math.min(p.getPuntosVida() + ((int) minutosPasados) * 10, p.getMaxPuntosVida());
                    p.setPuntosVida(nuevaVida);
                } else {
                    // Revivir personajes muertos si ha pasado suficiente tiempo (igual a su vida máxima)
                    if (minutosPasados >= p.getMaxPuntosVida()) {
                        p.curar(); // Revive al personaje completamente
                        System.out.println("✨ " + p.getNombre() + " ha revivido tras descansar.");
                    }
                }
            }
            guardarPersonajes(personajes);
        }

        // Guardar la nueva última ejecución en `personajes.json`
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JsonObject json = new JsonObject();
            json.add("personajes", gson.toJsonTree(personajes));
            json.addProperty("ultimaEjecucion", ahora.toString());
            gson.toJson(json, writer);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la última ejecución.");
        }
    }

    public static void administrarInventario() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }
    
        Personaje jugador = seleccionarPersonaje(personajes, "🎒 Elige un personaje para administrar su inventario: ");
        if (jugador == null) return;
    
        boolean gestionando = true;
        while (gestionando) {
            System.out.println("\n📜 Inventario de " + jugador.getNombre());
            jugador.mostrarInventario();
            System.out.println("1️⃣ Añadir objeto");
            System.out.println("2️⃣ Eliminar objeto");
            System.out.println("3️⃣ Salir");
            System.out.print("🔹 Elige una opción: ");
    
            int opcion = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcion) {
                case 1:
                    System.out.print("📝 Nombre del objeto: ");
                    String nombreItem = scanner.nextLine();
                    System.out.print("⚔️ Tipo (Arma, Armadura, Poción): ");
                    String tipo = scanner.nextLine();
                    System.out.print("💪 Bono de fuerza: ");
                    int bonoFuerza = scanner.nextInt();
                    System.out.print("🏃 Bono de agilidad: ");
                    int bonoAgilidad = scanner.nextInt();
                    System.out.print("❤️ Bono de constitución: ");
                    int bonoConstitucion = scanner.nextInt();
                    scanner.nextLine();
    
                    Item nuevoItem = new Item(nombreItem, tipo, bonoFuerza, bonoAgilidad, bonoConstitucion);
                    jugador.agregarItem(nuevoItem);
                    guardarPersonajes(personajes);
                    break;
    
                case 2:
                    System.out.print("🗑 Nombre del objeto a eliminar: ");
                    String eliminar = scanner.nextLine();
                    jugador.eliminarItem(eliminar);
                    guardarPersonajes(personajes);
                    break;
    
                case 3:
                    gestionando = false;
                    break;
    
                default:
                    System.out.println("❌ Opción inválida.");
            }
        }
    }

    private static void encontrarObjeto(Personaje jugador) {
        List<Item> itemsDisponibles = cargarItems();
    
        // Probabilidad de encontrar un objeto (1% a 5%)
        int probabilidad = rand.nextInt(100);
        if (probabilidad < rand.nextInt(5) + 1) { // Un número aleatorio entre 1 y 5%
            if (!itemsDisponibles.isEmpty()) {
                Item objetoEncontrado = itemsDisponibles.get(rand.nextInt(itemsDisponibles.size()));
                jugador.agregarItem(objetoEncontrado);
                System.out.println("🎁 ¡" + jugador.getNombre() + " ha encontrado un objeto: " + objetoEncontrado.getNombre() + "!");
            } else {
                System.out.println("📦 No hay objetos disponibles en el juego.");
            }
        }
    }

    public static List<Item> cargarItems() {
        List<Item> items = new ArrayList<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("items.json")) {
            Type itemListType = new TypeToken<ArrayList<Item>>() {}.getType();
            items = gson.fromJson(reader, itemListType);
        } catch (IOException e) {
            System.out.println("📂 Archivo de ítems no encontrado. Se creará uno nuevo.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al leer ítems. Inicializando lista vacía.");
        }
        return items != null ? items : new ArrayList<>();
    }
    


}

