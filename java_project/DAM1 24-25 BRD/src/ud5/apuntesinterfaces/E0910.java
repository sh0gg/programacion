package ud5.apuntesinterfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class E0910 {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100);
        }

        Comparator numerosOrdenadosDesc = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -((Integer) o1).compareTo((Integer) o2);
            }
        };

        System.out.println(Arrays.toString(numeros));
        Arrays.sort(numeros, numerosOrdenadosDesc);
        System.out.println(Arrays.toString(numeros));


        // Tambien puedes no liarte la cabeza

        Arrays.sort(numeros, Comparator.naturalOrder());
        System.out.println(Arrays.toString(numeros));

        // Y usar el reverse

        Arrays.sort(numeros, Comparator.reverseOrder());
        System.out.println(Arrays.toString(numeros));
    }
}
