package ud5.practicas.rol;

import java.util.List;
import java.util.Scanner;

public class AppCombateSingular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Personaje> personajes = GestorPersonajes.cargarPersonajes();

        if (personajes.size() < 2) {
            System.out.println("No hay suficientes personajes para un combate.");
            scanner.close();
            return;
        }

        System.out.println("Selecciona dos personajes para el combate:");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.println((i + 1) + ". " + personajes.get(i));
        }

        System.out.print("Elige el primer personaje: ");
        int p1Index = scanner.nextInt() - 1;
        System.out.print("Elige el segundo personaje: ");
        int p2Index = scanner.nextInt() - 1;

        if (p1Index < 0 || p2Index >= personajes.size() || p1Index == p2Index) {
            System.out.println("Selección inválida.");
            scanner.close();
            return;
        }

        Personaje p1 = personajes.get(p1Index);
        Personaje p2 = personajes.get(p2Index);

        System.out.println("Inicio del combate: " + p1 + " vs " + p2);

        Personaje atacante = p1.getAgilidad() > p2.getAgilidad() ? p1 : p2;
        Personaje defensor = atacante == p1 ? p2 : p1;

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println(atacante + " ataca a " + defensor);
            int dano = atacante.atacar(defensor);
            System.out.println("Daño infligido: " + dano);

            if (!defensor.estaVivo()) {
                System.out.println(defensor + " ha muerto.");
                break;
            }

            Personaje temp = atacante;
            atacante = defensor;
            defensor = temp;
        }

        GestorPersonajes.guardarPersonajes(personajes);
        scanner.close();
    }
}
