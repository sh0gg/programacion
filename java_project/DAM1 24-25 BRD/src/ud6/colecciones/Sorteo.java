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
        }

        if (numPremiados > valores.size()) {
            numPremiados = valores.size();
        }

        List<E> lista = new ArrayList<>(valores);
        Set<E> premiados = new HashSet<>();
        Random r = new Random();

        while (premiados.size() < numPremiados) {
            int index = r.nextInt(lista.size());
            premiados.add(lista.get(index));
        }

        return premiados;
    }
    
}
