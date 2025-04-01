package ud6.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class E1208 {
    public static void main(String[] args) {
        Collection<Integer> numeros = new ArrayList();
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            numeros.add(rnd.nextInt(100)+1);
        }

        System.out.println(numeros);

        Integer[] arrayNumeros = numeros.toArray(new Integer[0]);

        Arrays.sort(arrayNumeros);

        numeros = Arrays.asList(arrayNumeros);

        System.out.println(numeros);


    }
}
