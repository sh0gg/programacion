package ud6.colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

import ud6.Util;

public class E1208 {
    public static void main(String[] args) {
        Collection<Integer> numeros = new ArrayList();

        numeros = ud6.Util.numerosAleartorios(20,100);

        System.out.println(numeros);

        Integer[] t = numeros.toArray(new Integer[0]);

        // De menor a mayor
        Arrays.sort(t);
        Collection<Integer> numerosMenorMayor = Arrays.asList(t);
        System.out.println(numerosMenorMayor);

        // De mayor a menor

        Comparator<Integer> ordenMayorMenor = Comparator.reverseOrder();

        Arrays.sort(t, ordenMayorMenor);

        Collection<Integer> numerosMayorMayor = Arrays.asList(t);

        System.out.println(numerosMayorMayor);

    }
}
