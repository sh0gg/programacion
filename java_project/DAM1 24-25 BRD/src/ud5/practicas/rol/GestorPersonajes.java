package ud5.practicas.rol;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.concurrent.atomic.AtomicBoolean;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class GestorPersonajes {
    private static final String FILE_PATH = "ud5/practicas/rol/personajes.json";
    private static final String FILE_PATH_ITEMS = "ud5/practicas/rol/items.json";
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Cargar personajes desde el archivo JSON
     */
    public static List<Personaje> cargarPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JsonElement jsonElement = gson.fromJson(reader, JsonElement.class);
            if (jsonElement != null && jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                if (jsonObject.has("personajes")) {
                    Type personajeListType = new TypeToken<ArrayList<Personaje>>() {
                    }.getType();
                    personajes = gson.fromJson(jsonObject.get("personajes"), personajeListType);
                } else {
                    System.out.println("⚠️ El archivo JSON no contiene la clave 'personajes'.");
                }
            }
        } catch (IOException e) {
            System.out.println("📂 Archivo 'personajes.json' no encontrado. Se creará uno nuevo.");
        } catch (Exception e) {
            System.out.println("⚠️ Error al leer 'personajes.json': " + e.getMessage());
        }

        return personajes;
    }


    public static void guardarPersonajes(List<Personaje> personajes) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("personajes", gson.toJsonTree(personajes));
            gson.toJson(jsonObject, writer);
        } catch (IOException e) {
            System.out.println("⚠️ Error al guardar personajes.json");
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

            // 🔥 Recargar la lista de personajes después de guardarla
            personajes = cargarPersonajes();

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
            List<Item> itemsDisponibles = cargarItems(); // 🔥 Cargar los ítems disponibles
            int dano = atacante.atacar(defensor, itemsDisponibles);
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

    public static void mazmorra() throws Exception {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        // Seleccionar personaje para explorar la mazmorra
        Personaje jugador = seleccionarPersonaje(personajes, "🏰 Elige un personaje para explorar la mazmorra: ");
        if (jugador == null) return;

        boolean explorando = true;
        int turnos = 0;  // 🔥 Contador de turnos en la mazmorra

        while (explorando && jugador.estaVivo()) {
            System.out.println("\n📜 ¿Qué quieres hacer?");
            System.out.println("1️⃣ Avanzar en la mazmorra");
            System.out.println("2️⃣ Revisar tu estado");
            System.out.println("3️⃣ Salir");
            System.out.print("🔹 Elige una opción: ");

            int eleccion = -1;
            if (scanner.hasNextInt()) {
                eleccion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("❌ Entrada inválida. Ingresa un número.");
                scanner.next();  // Limpiar el scanner
                continue;
            }

            switch (eleccion) {
                case 1 -> {
                    turnos++;  // 🕒 Aumentamos el turno
                    eventoMazmorra(jugador, turnos);
                }
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
    private static void eventoMazmorra(Personaje jugador, int turnos) throws Exception {
        int evento = rand.nextInt(100); // Probabilidades basadas en 100

        if (evento < 40) {  // 40% de probabilidad de combate
            Personaje monstruo = generarMonstruo(turnos, jugador);  // 🔹 Ahora pasamos el jugador
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
        System.out.println("❤️ Vida de " + jugador.getNombre() + ": " + jugador.getPuntosVida() + "/" + jugador.getMaxPuntosVida());


        while (jugador.estaVivo() && enemigo.estaVivo()) {
            // Turno del jugador
            System.out.println("\n⚔️ " + jugador.getNombre() + " ataca a " + enemigo.getNombre());
            List<Item> itemsDisponibles = cargarItems(); // 🔥 Cargar los ítems disponibles
            int dano = jugador.atacar(enemigo, itemsDisponibles);
            System.out.println("💥 Daño infligido: " + dano);

            if (!enemigo.estaVivo()) {
                System.out.println("\n🎉 ¡Has derrotado al " + enemigo.getNombre() + " y ganado experiencia!");
                jugador.sumarExperiencia(500);

                // 🔥 Ahora se toma en cuenta el nivel del enemigo para mejores recompensas
                encontrarObjeto(jugador, enemigo);
                return;
            }


            // Turno del enemigo
            System.out.println("\n☠️ " + enemigo.getNombre() + " ataca a " + jugador.getNombre());
            dano = enemigo.atacar(jugador, itemsDisponibles);
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
    private static Personaje generarMonstruo(int turnos, Personaje jugador) {
        String[] monstruos = {"Goblin", "Esqueleto", "Orco", "Troll", "Demonio"};
        String[] jefes = {"Lich", "Dragón", "Señor de la Oscuridad"};

        boolean esJefe = turnos >= 10 && rand.nextInt(100) < 20;  // Jefes solo aparecen después del turno 10

        String nombre = esJefe ? jefes[rand.nextInt(jefes.length)] : monstruos[rand.nextInt(monstruos.length)];
        int multiplicador = esJefe ? 3 : 1;

        int fuerza, agilidad, constitucion, inteligencia, intuicion, presencia;

        if (turnos <= 15) {
            // 🔹 En los primeros 15 turnos, los enemigos se balancean con el personaje
            fuerza = (int) ((jugador.getFuerza() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
            agilidad = (int) ((jugador.getAgilidad() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
            constitucion = (int) ((jugador.getConstitucion() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
            inteligencia = (int) ((jugador.getInteligencia() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
            intuicion = (int) ((jugador.getIntuicion() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
            presencia = (int) ((jugador.getPresencia() * (rand.nextDouble() * 0.5 + 0.5)) * multiplicador);
        } else {
            // 🔹 Después del turno 15, los enemigos son completamente aleatorios
            fuerza = (rand.nextInt(50) + 10) * multiplicador;
            agilidad = (rand.nextInt(50) + 10) * multiplicador;
            constitucion = (rand.nextInt(50) + 10) * multiplicador;
            inteligencia = (rand.nextInt(50) + 10) * multiplicador;
            intuicion = (rand.nextInt(50) + 10) * multiplicador;
            presencia = (rand.nextInt(50) + 10) * multiplicador;
        }

        try {
            return new Personaje(nombre, "MONSTRUO", fuerza, agilidad, constitucion, inteligencia, intuicion, presencia);
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
    private static void acertijo(Personaje jugador) throws Exception {
        System.out.println("\n🧩 ¡Has encontrado un acertijo mágico!");

        String[][] acertijos = {
                {"¿Cuál es el pilar de la POO que permite reutilizar código?", "herencia"},
                {"Si en Java una clase implementa una interfaz, ¿qué palabra clave se usa?", "implements"},
                {"¿Cómo se llama el proceso de ocultar detalles internos de un objeto y exponer solo lo necesario?", "encapsulamiento"},
                {"¿Qué palabra clave en Java se usa para crear un objeto?", "new"},
                {"¿Cómo se llama la capacidad de un método para tomar diferentes formas en distintas clases?", "polimorfismo"},
                {"¿Qué pilar de la POO permite definir múltiples métodos con el mismo nombre pero diferentes parámetros?", "sobrecarga"},
                {"¿Qué palabra clave en Java evita que una variable sea modificada después de inicializarla?", "final"},
                {"¿Qué palabra clave permite acceder a un método sin necesidad de instanciar la clase?", "static"},
                {"En Java, si una clase hereda de otra, ¿qué palabra clave se usa para llamar al constructor de la clase padre?", "super"},
                {"¿Cómo se llama la técnica que permite a un objeto comportarse como su clase base?", "upcasting"}
        };

        boolean esPreguntaMatematica = rand.nextBoolean();
        String pregunta, respuestaCorrecta;

        if (esPreguntaMatematica) {
            int operacion = rand.nextInt(5); // 0=Suma, 1=Resta, 2=Multiplicación, 3=División, 4=Módulo
            int num1, num2;

            do {
                num1 = rand.nextInt(20) + 1;
                num2 = rand.nextInt(10) + 1;
            } while (operacion == 3 && num1 % num2 != 0); // Evita divisiones con decimales

            switch (operacion) {
                case 0: // Suma
                    pregunta = "¿Cuánto es " + num1 + " + " + num2 + "?";
                    respuestaCorrecta = String.valueOf(num1 + num2);
                    break;
                case 1: // Resta
                    pregunta = "¿Cuánto es " + num1 + " - " + num2 + "?";
                    respuestaCorrecta = String.valueOf(num1 - num2);
                    break;
                case 2: // Multiplicación
                    pregunta = "¿Cuánto es " + num1 + " * " + num2 + "?";
                    respuestaCorrecta = String.valueOf(num1 * num2);
                    break;
                case 3: // División (solo si el resultado es entero)
                    pregunta = "¿Cuánto es " + num1 + " / " + num2 + "?";
                    respuestaCorrecta = String.valueOf(num1 / num2);
                    break;
                case 4: // Módulo (resto de la división)
                    pregunta = "¿Cuál es el residuo de " + num1 + " % " + num2 + "?";
                    respuestaCorrecta = String.valueOf(num1 % num2);
                    break;
                default:
                    pregunta = "Error al generar la pregunta";
                    respuestaCorrecta = "0";
            }
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

            // Ahora el nivel del jugador afecta la probabilidad de obtener un objeto
            encontrarObjeto(jugador, new Personaje("Reto de la Mazmorra", "MONSTRUO", 50, 50, 50, 50, 50, 50));
        } else {
            System.out.println("\n❌ Respuesta incorrecta. No ganas nada.");
        }

        guardarPersonajes(cargarPersonajes());
    }


    // Variable estática para evitar repetir la última pregunta de POO
    private static int ultimaPregunta = -1;

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
                    System.out.println("📅 Última ejecución registrada: " + ultimaEjecucion);
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ No se encontró información de la última ejecución o hubo un error: " + e.getMessage());
        }

        // Obtener tiempo actual
        LocalDateTime ahora = LocalDateTime.now();
        if (ultimaEjecucion == null) {
            ultimaEjecucion = ahora;
        }

        // Calcular minutos transcurridos
        long minutosPasados = ChronoUnit.MINUTES.between(ultimaEjecucion, ahora);
        System.out.println("⏳ Minutos transcurridos desde la última sesión: " + minutosPasados);

        if (minutosPasados > 0) {
            for (Personaje p : personajes) {
                int nuevaVida = p.getPuntosVida() + (int) minutosPasados * 10;
                p.setPuntosVida(Math.min(nuevaVida, p.getMaxPuntosVida()));

                if (p.getPuntosVida() > 0 && p.getPuntosVida() - (int) minutosPasados * 10 <= 0) {
                    System.out.println("✨ " + p.getNombre() + " ha revivido con " + p.getPuntosVida() + " puntos de vida.");
                }
            }

            guardarPersonajes(personajes);
        }

        // Guardar la nueva última ejecución en `personajes.json`
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("personajes", gson.toJsonTree(personajes));
            jsonObject.addProperty("ultimaEjecucion", ahora.toString());

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                gson.toJson(jsonObject, writer);
                System.out.println("✅ Se ha actualizado la última ejecución a: " + ahora);
            }
        } catch (IOException e) {
            System.out.println("❌ Error al guardar la última ejecución en 'personajes.json': " + e.getMessage());
        }
    }

    public static void administrarInventario() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        Personaje jugador = personajes.get(0); // Selección rápida
        List<Item> items = cargarItems();

        System.out.println("\n📜 Inventario de " + jugador.getNombre());
        System.out.println("1️⃣ Añadir objeto");
        System.out.println("2️⃣ Eliminar objeto");
        System.out.println("3️⃣ Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.println("🔍 Lista de ítems disponibles:");
                for (Item item : items) {
                    System.out.println(item.getId() + " - " + item.getNombre());
                }
                System.out.print("📝 Introduce el ID del objeto a añadir: ");
                String itemId = scanner.nextLine();
                jugador.agregarItem(itemId);
                guardarPersonajes(personajes);
            }
            case 2 -> {
                System.out.print("🗑 Introduce el ID del objeto a eliminar: ");
                String itemId = scanner.nextLine();
                jugador.eliminarItem(itemId);
                guardarPersonajes(personajes);
            }
            case 3 -> System.out.println("🚪 Saliendo...");
            default -> System.out.println("❌ Opción inválida.");
        }
    }

    private static void encontrarObjeto(Personaje jugador, Personaje enemigo) {
        List<Item> itemsDisponibles = cargarItems();
        if (itemsDisponibles.isEmpty()) {
            System.out.println("📦 No hay objetos disponibles en el juego.");
            return;
        }

        // 🛠️ Ajustar probabilidad en base al nivel del jugador
        int probabilidadBase = 5; // Probabilidad mínima del 5%
        int probabilidadPorNivel = Math.min(jugador.getNivel() / 2, 30); // Máximo 30% extra
        int probabilidadFinal = probabilidadBase + probabilidadPorNivel;

        if (rand.nextInt(100) < probabilidadFinal) { // Determinar si gana un objeto
            Item objetoEncontrado = seleccionarObjetoPorDificultad(itemsDisponibles, enemigo);
            jugador.agregarItem(objetoEncontrado);
            System.out.println("🎁 ¡" + jugador.getNombre() + " ha encontrado un objeto: " + objetoEncontrado.getNombre() + "!");
        }
    }

    /**
     * Selecciona un objeto basado en la dificultad del enemigo.
     * Los monstruos fuertes otorgan objetos con mejores bonificaciones.
     */
    private static Item seleccionarObjetoPorDificultad(List<Item> items, Personaje enemigo) {
        int dificultad = enemigo.getNivel();
        if (dificultad > 10) {
            // Si es un enemigo fuerte, buscar un objeto con buenos bonos
            return items.stream()
                    .max((i1, i2) -> Integer.compare(i1.getBonoFuerza() + i1.getBonoAgilidad() + i1.getBonoConstitucion(),
                            i2.getBonoFuerza() + i2.getBonoAgilidad() + i2.getBonoConstitucion()))
                    .orElse(items.get(rand.nextInt(items.size())));
        } else {
            // Si el enemigo es débil, dar un objeto aleatorio normal
            return items.get(rand.nextInt(items.size()));
        }
    }


    public static void guardarItems(List<Item> items) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter(FILE_PATH_ITEMS)) {
            gson.toJson(items, file);
        } catch (IOException e) {
            System.out.println("❌ Error al guardar los ítems.");
        }
    }

    public static List<Item> cargarItems() {
        List<Item> items = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(FILE_PATH_ITEMS)) {
            Type itemListType = new TypeToken<ArrayList<Item>>() {
            }.getType();
            items = gson.fromJson(reader, itemListType);
        } catch (IOException e) {
            System.out.println("📂 Archivo de ítems no encontrado.");
        }

        return items;
    }


    public static void autoplayMazmorra() throws Exception {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        Personaje jugador = seleccionarPersonaje(personajes, "🏰 Elige un personaje para el modo Autoplay: ");
        if (jugador == null) return;

        int pocionesEncontradas = 0;
        int objetosEncontrados = 0;
        Map<String, Integer> monstruosVencidos = new HashMap<>();
        AtomicBoolean explorando = new AtomicBoolean(true); // 🔥 Variable que controla si sigue explorando
        int turnos = 0;

        System.out.println("\n🚀 Modo Autoplay: Explorando la mazmorra...");
        System.out.println("⚠️ Escribe cualquier letra + [ENTER] para detener el autoplay en cualquier momento.");

        // 🔥 Hilo en segundo plano que escucha la entrada del usuario
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // Espera que el usuario presione una tecla
            explorando.set(false); // 🔥 Detener autoplay cuando el usuario ingrese algo
            System.out.println("\n🛑 ¡Autoplay detenido por el usuario!");
        });
        inputThread.start(); // Iniciar el hilo de escucha

        while (explorando.get() && jugador.estaVivo()) {
            turnos++;
            System.out.println("\n----------------------------------");
            System.out.println("📜 Turno " + turnos + " en la mazmorra...");

            // Generar un monstruo
            Personaje monstruo = generarMonstruo(turnos, jugador);
            System.out.println("\n👹 ¡Aparece un " + monstruo.getNombre() + " (Nivel " + monstruo.getNivel() + ")!");

            // Combate automático
            combate(jugador, monstruo);

            // Si el jugador muere en el combate, salir del autoplay
            if (!jugador.estaVivo()) {
                System.out.println("💀 " + jugador.getNombre() + " ha caído en la mazmorra...");
                break;
            }

            // Registrar victoria sobre el monstruo
            monstruosVencidos.put(monstruo.getNombre(), monstruosVencidos.getOrDefault(monstruo.getNombre(), 0) + 1);

            // 🔹 Pequeña pausa entre combates (simulación de tiempo real)
            try {
                Thread.sleep(1500); // 1.5 segundos de pausa entre combates
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Si la vida del jugador es menor al 50% antes del siguiente combate, escapar
            int vidaActual = jugador.getPuntosVida();
            int vidaMaximaReal = jugador.getMaxPuntosVida();

            System.out.println("🔍 Depuración: Vida actual = " + vidaActual + ", Vida máxima real = " + vidaMaximaReal);

            if (vidaActual < vidaMaximaReal / 2) {
                System.out.println("\n🏃 " + jugador.getNombre() + " decide huir de la mazmorra antes de morir...");
                break;
            }

            // 30% de probabilidad de encontrar una poción
            if (rand.nextInt(100) < 30) {
                int cura = rand.nextInt(20) + 10;
                jugador.curar();
                pocionesEncontradas++;
                System.out.println("\n🧪 ¡Has encontrado una poción y recuperado " + cura + " puntos de vida!");
            }

            // 20% de probabilidad de encontrar un objeto
            if (rand.nextInt(100) < 20) {
                List<Item> itemsDisponibles = cargarItems();
                if (!itemsDisponibles.isEmpty()) {
                    Item objetoEncontrado = itemsDisponibles.get(rand.nextInt(itemsDisponibles.size()));
                    jugador.agregarItem(objetoEncontrado);
                    objetosEncontrados++;
                    System.out.println("\n🎁 ¡Has encontrado un objeto: " + objetoEncontrado.getNombre() + "!");
                }
            }
        }

        System.out.println("\n🏆 ¡Exploración terminada!");
        explorando.set(false);
    }


    public static void curarTodos() {
        List<Personaje> personajes = cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes disponibles.");
            return;
        }

        for (Personaje p : personajes) {
            p.setPuntosVida(p.getMaxPuntosVida());
        }

        guardarPersonajes(personajes);
        System.out.println("💖 Todos los personajes han sido curados al máximo.");
    }


}

