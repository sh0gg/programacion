package ud6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Util {
    public static Collection<Integer> numerosAleartorios(int numero, int maximo) {
        Collection<Integer> numerosAleatorios = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < numero; i++) {
            numerosAleatorios.add(r.nextInt(maximo)+1);
        }
        return numerosAleatorios;
    }
}
