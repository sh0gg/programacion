package ud6.ejerciciosstream.E1305;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        List<Double> listaNumeros = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listaNumeros.add(i*1.0);
        }
        Function<Double,Double> raiz = Math::sqrt;

        List<Double> raicesCuadradas = transformar(listaNumeros,raiz);

        System.out.println(raicesCuadradas);
    }

    static <T, V> List<V> transformar(List<T> t, Function<T, V> f) {

        List<V> lista = new ArrayList<>();
        for (T e : t) {
            if (f.apply(e) != null) {
                lista.add(f.apply(e));
            }
        }
        return lista;
    }

}
