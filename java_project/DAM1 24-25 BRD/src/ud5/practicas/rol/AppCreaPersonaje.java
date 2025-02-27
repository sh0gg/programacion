package ud5.practicas.rol;

import java.util.List;
import java.util.Scanner;

public class AppCreaPersonaje {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = GestorPersonajes.cargarPersonajes();

        try {
            System.out.println("Selecciona el tipo de creación de personaje:");
            System.out.println("1. Completo (Todos los atributos)");
            System.out.println("2. Monstruo (Ataque, Defensa, Velocidad)");
            System.out.println("3. Nombre y raza (Atributos aleatorios)");
            System.out.println("4. Solo nombre (Se asigna como humano)");
            System.out.print("Ingresa una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Introduce el nombre del personaje: ");
            String nombre = scanner.nextLine();

            Personaje nuevoPersonaje = null;

            switch (opcion) {
                case 1: // Creación completa
                    System.out.print("Introduce la raza: ");
                    String raza = scanner.nextLine().toUpperCase();

                    System.out.print("Fuerza: ");
                    int fuerza = scanner.nextInt();
                    System.out.print("Agilidad: ");
                    int agilidad = scanner.nextInt();
                    System.out.print("Constitución: ");
                    int constitucion = scanner.nextInt();
                    System.out.print("Inteligencia: ");
                    int inteligencia = scanner.nextInt();
                    System.out.print("Intuición: ");
                    int intuicion = scanner.nextInt();
                    System.out.print("Presencia: ");
                    int presencia = scanner.nextInt();

                    nuevoPersonaje = new Personaje(nombre, raza, fuerza, agilidad, constitucion, inteligencia, intuicion, presencia);

                case 2: // Monstruo
                    if (nuevoPersonaje != null) break; // Evita caer en los casos siguientes

                    System.out.print("Ataque: ");
                    int ataque = scanner.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();
                    System.out.print("Velocidad: ");
                    int velocidad = scanner.nextInt();
                    System.out.print("Puntos de vida: ");
                    int puntosVida = scanner.nextInt();

                    nuevoPersonaje = new Monstruo(nombre, ataque, defensa, velocidad, puntosVida);

                case 3: // Solo nombre y raza
                    if (nuevoPersonaje != null) break;

                    System.out.print("Introduce la raza: ");
                    raza = scanner.nextLine().toUpperCase();

                    nuevoPersonaje = new Personaje(nombre, raza);

                case 4: // Solo nombre, se asume humano
                    if (nuevoPersonaje != null) break;

                    nuevoPersonaje = new Personaje(nombre, "HUMANO");
            }

            if (nuevoPersonaje != null) {
                personajes.add(nuevoPersonaje);
                System.out.println("Personaje creado: " + nuevoPersonaje);
                GestorPersonajes.guardarPersonajes(personajes);
            } else {
                System.out.println("No se creó ningún personaje.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
