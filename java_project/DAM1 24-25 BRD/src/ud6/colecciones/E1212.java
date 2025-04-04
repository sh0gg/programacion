package ud6.colecciones;

import java.util.*;

public class E1212 {
    static <E> Set<E> union(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> resultado = new TreeSet<>(conjunto1);
        resultado.addAll(conjunto2);
        return resultado;
    }

    static <E> Set<E> interseccion(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> resultado = new TreeSet<>(conjunto1);
        resultado.retainAll(conjunto2);
        return resultado;
    }

    static <E> Set<E> except(Set<E> conjunto1, Set<E> conjunto2) {
        Set<E> resultado = new TreeSet<>(conjunto1);
        resultado.removeAll(conjunto2);
        return resultado;
    }

    public static void main(String[] args) {

        Set<Integer> numeros1 = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            numeros1.add(r.nextInt(20)+1);
        }

        Set<Integer> numeros2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            numeros2.add(r.nextInt(20)+1);
        }

        System.out.println(numeros1);
        System.out.println(numeros2);

        System.out.println("Unión");
        Set<Integer> resultado1 = union(numeros1, numeros2);
        System.out.println(resultado1);

        System.out.println("Intersección");
        Set<Integer> resultado2 = interseccion(numeros1, numeros2);
        System.out.println(resultado2);

        System.out.println("Excepcion");
        Set<Integer> resultado3 = except(numeros1, numeros2);
        System.out.println(resultado3);
    }

}
