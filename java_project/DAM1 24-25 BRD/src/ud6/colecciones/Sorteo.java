package ud6.colecciones;

import java.util.*;

public class Sorteo<E> {

    Set<E> valores = new HashSet<>();

    boolean add(E elemento) {
        return valores.add(elemento); 
    }

    Set<E> premiados(int numPremiados) {
        if (numPremiados < 1) {
            throw new IllegalArgumentException("Numero de premiados tiene que ser al menos 1");
        } else if (numPremiados > valores.size()) {
            numPremiados = valores.size();
        }

        List<E> lista = new ArrayList<>(valores);
        Set<E> premiados = new HashSet<>();
        Random r = new Random();

        while (premiados.size() < numPremiados) {
            int index = r.nextInt(lista.size()+1);
            premiados.add(lista.get(index));
        }

        return premiados;
    }

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
