package ud6.colecciones;

import java.util.*;

public class E1210 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros = (List<Integer>) ud6.Util.numerosAleartorios(20, 10);

        Integer[] t = numeros.toArray(new Integer[0]);
        Arrays.sort(t);
        numeros = Arrays.asList(t);

        // Lista sin repetidos
        List<Integer> numSinRepetidos = new ArrayList<>();
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            if (!numSinRepetidos.contains(n)) {
                numSinRepetidos.add(n);
            }
        }

        //Lista de repetidos // REVISAR
        List<Integer> repetidos = numeros;
        repetidos.removeAll(numSinRepetidos);
        for (Integer n : repetidos) {
            if (repetidos.contains(repetidos.indexOf(n))) {
                repetidos.remove(n);
            }
        }
        System.out.println(repetidos);


        // Los que solo aparecen una vez
        Set<Integer> unaVez = new TreeSet<>();
        for (Integer numero : numeros){
            if (numeros.indexOf(numero) == numeros.lastIndexOf(numero)){
                unaVez.add(numero);
            }
        }

        System.out.println("Lista de numeros:");
        System.out.println(numeros);

        System.out.println("Lista sin numeros repetidos:");
        System.out.println(numSinRepetidos);

        System.out.println("Lista de numeros repetidos:");
        System.out.println(repetidos);

        System.out.println("Lista de los numeros que solo aparecen una vez:");
        System.out.println(unaVez);
    }
}
