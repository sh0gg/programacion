package ud5.practicas.rol;

import ud5.practicas.rol.GestorPersonajes;
import ud5.practicas.rol.Personaje;

import java.util.Scanner;

public class MegaRol {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // 🔥 Restaurar la vida de los personajes antes de comenzar el juego
        GestorPersonajes.restaurarPersonajes();

        while (true) {
            System.out.println("\n🌌 MEGAROL 🌌");
            System.out.println("1️⃣ Crear un personaje");
            System.out.println("2️⃣ Ver personajes");
            System.out.println("3️⃣ Iniciar un combate");
            System.out.println("4️⃣ Explorar la mazmorra");
            System.out.println("5️⃣ Explorar la mazmorra en Autoplay"); // 🔥 Nueva opción añadida
            System.out.println("6️⃣ Administrar inventario");
            System.out.println("7️⃣ Salir");
            System.out.print("🔹 Elige una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1 -> GestorPersonajes.crearPersonaje();
                case 2 -> mostrarPersonajes();
                case 3 -> GestorPersonajes.combate();
                case 4 -> GestorPersonajes.mazmorra();
                case 5 -> GestorPersonajes.autoplayMazmorra(); // 🔥 Llamamos al nuevo modo autoplay
                case 6 -> GestorPersonajes.administrarInventario();
                case 7 -> {
                    System.out.println("👋 ¡Gracias por jugar MegaRol! 🌟");
                    return;
                }
                default -> System.out.println("❌ Opción inválida.");
            }
        }
    }

    private static void mostrarPersonajes() {
        var personajes = GestorPersonajes.cargarPersonajes();
        if (personajes.isEmpty()) {
            System.out.println("⚠️ No hay personajes creados aún.");
        } else {
            System.out.println("\n📜 Lista de personajes:");
            for (Personaje p : personajes) {
                System.out.println("🔹 " + p);
            }
        }
    }
}
