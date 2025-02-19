package ud5.practicas.rol;

import java.util.Scanner;

public class MegaRol {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🌌 MEGAROL: FOR THE PAX OF THE UNIVERSE 🌌");
            System.out.println("1️⃣ Crear un personaje");
            System.out.println("2️⃣ Ver personajes disponibles");
            System.out.println("3️⃣ Iniciar un combate");
            System.out.println("4️⃣ Explorar la mazmorra");
            System.out.println("5️⃣ Salir");
            System.out.print("🔹 Elige una opción: ");

            int opcion;
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida. Ingresa un número.");
                scanner.next(); // Limpiar entrada inválida
                continue;
            }

            switch (opcion) {
                case 1 -> GestorPersonajes.crearPersonaje();
                case 2 -> mostrarPersonajes();
                case 3 -> GestorPersonajes.combate();
                case 4 -> GestorPersonajes.mazmorra();
                case 5 -> {
                    System.out.println("👋 ¡Gracias por jugar MegaRol! 🌟");
                    return;
                }
                default -> System.out.println("❌ Opción inválida, intenta de nuevo.");
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
