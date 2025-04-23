package ud6.ejerciciosstream.E1304;

import ud6.colecciones.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        Integer[] tablaNumeros = new Integer[50];
        List<Integer> listaNumeros = new ArrayList<>();
        for (int i = 0; i < tablaNumeros.length; i++) {
            int num = rnd.nextInt(100) + 1;
            tablaNumeros[i] = num;
            listaNumeros.add(num);
        }

        System.out.println(Arrays.toString(tablaNumeros));
        System.out.println("Filtrando múltiplos de 3:");
        Integer[] multiplosTres = filtrar(tablaNumeros, x -> x % 3 == 0);
        System.out.println(Arrays.toString(multiplosTres));

        System.out.println("Filtrando pares en la lista");
        List<Integer> numerosPares = filtrar(listaNumeros, x -> x % 2 == 0);
        System.out.println(numerosPares);

        System.out.println("Clientes");
        List<Cliente> clientes = Cliente.clientesDeEjemplo();
        System.out.println(clientes);
        System.out.println("Clientes mayores de edad:");
        List<Cliente> mayoresEdad = filtrar(clientes, c -> c.edad() >= 18);
        System.out.println(mayoresEdad);
    }

    static <T> T[] filtrar(T[] t, Predicate<T> p) {
        T[] filtrados = Arrays.copyOf(t, 0);

        for (T e : t) {
            if (p.test(e)) {
                filtrados = Arrays.copyOf(filtrados, filtrados.length + 1);
                filtrados[filtrados.length - 1] = e;
            }
        }

        return filtrados;
    }

    static <T> List<T> filtrar(List<T> l, Predicate<T> p) {
        List<T> lista = new ArrayList<>();
        for (T e : l) {
            if (p.test(e)) {
                lista.add(e);
            }
        }
        return lista;
    }
}
