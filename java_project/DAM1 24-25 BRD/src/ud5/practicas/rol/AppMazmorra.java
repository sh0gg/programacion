package ud5.practicas.rol;

import java.util.Random;
import java.util.Scanner;

public class AppMazmorra {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce el nombre de tu personaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Introduce la raza (HUMANO, ELFO, ENANO, HOBBIT, ORCO, TROLL): ");
        String raza = scanner.nextLine().toUpperCase();

        try {
            Personaje jugador = new Personaje(nombre, raza);
            System.out.println("\n🏰 ¡Bienvenido a la Mazmorra, " + jugador.toString() + "! 🏰\n");

            boolean explorando = true;
            while (explorando && jugador.estaVivo()) {
                System.out.println("\n📜 ¿Qué quieres hacer?");
                System.out.println("1. Avanzar en la mazmorra");
                System.out.println("2. Revisar tu estado");
                System.out.println("3. Salir de la mazmorra");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
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

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
        String[] nombres = {"Goblin", "Esqueleto", "Orco", "Troll", "Demonio"};
        String nombre = nombres[rand.nextInt(nombres.length)];

        try {
            return new Personaje(nombre, "MONSTRUO", rand.nextInt(80) + 20, rand.nextInt(80) + 20, rand.nextInt(80) + 20, 10, 10, 10);
        } catch (Exception e) {
            System.out.println("Error al generar el monstruo: " + e.getMessage());
            return null; // En caso de error, devolvemos null
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

