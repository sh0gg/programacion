package ud6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Util {
    public static Collection<Integer> numerosAleartoriosEntre100(int numero) {
        Collection<Integer> numerosAleartorios = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < numero; i++) {
            numerosAleartorios.add(r.nextInt(100)+1);
        }
        return numerosAleartorios;
    }
}
