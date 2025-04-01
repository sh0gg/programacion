package ud6.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class E1206B {
    public static void main(String[] args) {
        Collection<Integer> numerosPositivos = new ArrayList();
        Collection<Integer> numerosNegativos = new ArrayList();
        Random rnd = new Random();
        
        for (int i = 0; i < 100; i++) {
            int numAleatorio = rnd.nextInt(201) - 100;
            if (numAleatorio >= 0)
                numerosPositivos.add(numAleatorio);
            if (numAleatorio < 0)
                numerosNegativos.add(numAleatorio);
        }
        
        System.out.println("Positivos: " + numerosPositivos);
        getSuma(numerosPositivos);
        System.out.println("================================");
        System.out.println("Negativos: " + numerosNegativos);
        getSuma(numerosNegativos);

        Iterator<Integer> it = numerosPositivos.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            if (n > 10) {
                it.remove();
            }
        }
        System.out.println(numerosPositivos);

        it = numerosNegativos.iterator();
        while (it.hasNext()) {
            Integer n = it.next();
            if (n < -10) {
                it.remove();
            }
        }
        System.out.println(numerosNegativos);


    }

    private static void getSuma(Collection<Integer> numerosPositivos) {
        int suma = 0;
        for (Integer numero : numerosPositivos) {
            suma += numero;
        }
        System.out.println("Suma: " + suma);
    }
}
