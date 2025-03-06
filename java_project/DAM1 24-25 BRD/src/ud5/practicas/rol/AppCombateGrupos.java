package ud5.practicas.rol;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppCombateGrupos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = GestorPersonajes.cargarPersonajes();

        if (personajes.size() < 6) {
            System.out.println("No hay suficientes personajes para organizar un combate de grupo.");
            scanner.close();
            return;
        }

        // Selección de grupos
        List<Personaje> grupo1 = new ArrayList<>();
        List<Personaje> grupo2 = new ArrayList<>();

        System.out.println("Selecciona los personajes para el Grupo 1:");
        seleccionarGrupo(scanner, personajes, grupo1, 3, 6);

        System.out.println("Selecciona los personajes para el Grupo 2:");
        seleccionarGrupo(scanner, personajes, grupo2, 3, 6);

        // Combate
        System.out.println("¡El combate comienza!");
        combateGrupal(grupo1, grupo2);

        scanner.close();
    }

    private static void seleccionarGrupo(Scanner scanner, List<Personaje> personajes, List<Personaje> grupo, int min, int max) {
        while (grupo.size() < max) {
            System.out.println("Personajes disponibles:");
            for (int i = 0; i < personajes.size(); i++) {
                System.out.println((i + 1) + ". " + personajes.get(i));
            }

            System.out.print("Selecciona un personaje (0 para terminar): ");
            int eleccion = scanner.nextInt() - 1;

            if (eleccion == -1 && grupo.size() >= min) break; // Terminar si hay al menos min personajes
            if (eleccion >= 0 && eleccion < personajes.size()) {
                grupo.add(personajes.remove(eleccion));
                System.out.println("Personaje agregado al grupo.");
            } else {
                System.out.println("Selección inválida.");
            }
        }
    }

    private static void combateGrupal(List<Personaje> grupo1, List<Personaje> grupo2) {
        while (grupoSigueVivo(grupo1) && grupoSigueVivo(grupo2)) {
            List<Personaje> ordenAtaque = new ArrayList<>();
            ordenAtaque.addAll(grupo1);
            ordenAtaque.addAll(grupo2);

            // Ordenar por agilidad (de mayor a menor)
            ordenAtaque.sort(Comparator.comparingInt(Personaje::getAgilidad).reversed());

            for (Personaje atacante : ordenAtaque) {
                if (!atacante.estaVivo()) continue;

                List<Personaje> enemigos = grupo1.contains(atacante) ? grupo2 : grupo1;
                Personaje objetivo = seleccionarObjetivo(enemigos);
                
                if (objetivo == null) break; // El grupo enemigo ha sido derrotado

                System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre());
                int dano = atacante.atacar(objetivo);
                System.out.println("Daño infligido: " + dano);

                if (!objetivo.estaVivo()) {
                    System.out.println(objetivo.getNombre() + " ha muerto.");
                }
            }
        }

        System.out.println("¡El combate ha terminado!");
        if (grupoSigueVivo(grupo1)) {
            System.out.println("¡Grupo 1 gana!");
        } else {
            System.out.println("¡Grupo 2 gana!");
        }
    }

    private static Personaje seleccionarObjetivo(List<Personaje> enemigos) {
        List<Personaje> vivos = new ArrayList<>();
        for (Personaje p : enemigos) {
            if (p.estaVivo()) vivos.add(p);
        }
        if (vivos.isEmpty()) return null;
        return vivos.get(0); // Selecciona el primer enemigo vivo
    }

    private static boolean grupoSigueVivo(List<Personaje> grupo) {
        for (Personaje p : grupo) {
            if (p.estaVivo()) return true;
        }
        return false;
    }
}
