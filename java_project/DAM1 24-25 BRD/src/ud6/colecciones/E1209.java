package ud6.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class E1209 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        numeros = (List<Integer>) ud6.Util.numerosAleartoriosEntre100(20);

        System.out.println("Elementos con valor par");
        // Indice y valor de los elementos con valor par
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                System.out.println(i + ": " + numeros.get(i));
            }
        }

//        //Con iterador
//        int i = 0;
//        Iterator<Integer> iterador = numeros.iterator();
//        while (iterador.hasNext()) {
//            Integer n = iterador.next();
//            if (n % 2 == 0) {
//        System.out.println(i + ": " + n);
//            }
//        }


        System.out.println("Elementos con valor impar");
        // Indice y valor de los elementos con valor impar
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 != 0) {
                System.out.println(i + ": " + numeros.get(i));
            }
        }
    }
}
