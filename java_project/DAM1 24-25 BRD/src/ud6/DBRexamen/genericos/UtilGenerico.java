package ud6.DBRexamen.genericos;

import java.util.*;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN UD6 PROGRAMACIÓN

public class UtilGenerico<T> {

    public static <T> List<T> repetidos(List<T> lista){

        // Conseguimos solo los que NO se repiten

        Collection<T> sinRepetidos = new HashSet<T>();
        for (T t : lista){
            sinRepetidos.add(t);
        }

        // Quitamos los que no se repiten de la lista original

        lista.removeAll(List.of(sinRepetidos));

        // Hacemos un HashSet de la lista para mostrar solo UNA vez los que se repetian de la original

        Collection<T> repetidosUnaVez = new HashSet<T>(lista);

        List<T> repetidos = new ArrayList(repetidosUnaVez);

        return repetidos;

    };

    public static <T> Collection<T> filtrarMayores(Collection<T> lista, T filtro, Comparator<T> comparator) {
        Collection<T> filtrados = new ArrayList();
        for (T t : lista) {
            if (comparator.compare(filtro, t) <= 0) {
                filtrados.add(t);
            }
        }
        return filtrados;
    };

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList();
        Random r = new Random();
        for (int i = 0; i < 25; i++) {
            lista.add(r.nextInt(10)+1);
        }

        List<Integer> nuevaLista = new ArrayList();
        nuevaLista = repetidos(lista);

        Collection<Integer> nuevaLista2 = new ArrayList();
        Comparator<Integer> compName = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        nuevaLista2 = filtrarMayores(lista,5,compName);


        System.out.println("Lista de números con repetidos: " + lista);
        System.out.println("Lista de números que se repiten: " + nuevaLista);
        System.out.println("Lista de números mayores que 5 (de la lista original)" + nuevaLista2);


    }

}
