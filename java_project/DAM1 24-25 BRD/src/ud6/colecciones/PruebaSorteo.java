package ud6.colecciones;

import java.util.Set;

public class PruebaSorteo {
    public static void main(String[] args) {
        Sorteo<String> sorteo = new Sorteo<>();

        // Añadir participantes
        sorteo.add("Ana");
        sorteo.add("Luis");
        sorteo.add("Carlos");
        sorteo.add("Marta");
        sorteo.add("Lucía");

        // Intentar añadir duplicado (no debería añadirse)
        boolean añadido = sorteo.add("Ana");
        System.out.println("¿Se añadió 'Ana' otra vez?: " + añadido);

        // Sacar 3 premiados
        Set<String> ganadores = sorteo.premiados(3);
        System.out.println("🎉 Ganadores del sorteo:");
        for (String ganador : ganadores) {
            System.out.println(" - " + ganador);
        }
    }
}

