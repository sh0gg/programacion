package ud6.colecciones;

import java.util.*;

public class Sorteo<E> {

    Set<E> valores = new HashSet<>();

    boolean add (E elemento) {
        if (valores.contains(elemento)) {
            return false;
        } else {
            valores.add(elemento);
            return true;
        }
    }

    Set<E> premiados (int numPremiados) {
        Set<E> premiados = new HashSet<>();
        if (numPremiados > 0) {
            throw new IllegalArgumentException ("Numero de premiados tiene que ser al menos 1");
        }
        Random r = new Random();
        for (int i = 0; i > numPremiados; i++) {
            int num = r.nextInt(premiados.size()+1);
            //TODO: extraer valor del indice premiado.

        }
        return premiados;
    }
}
