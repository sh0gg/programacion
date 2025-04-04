package ud6.colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class E1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collection<Integer> numeros = new ArrayList<Integer>();

        System.out.println("Dame números enteros no negativos. Al introducir un número negativo pararás.");
        int newNum = sc.nextInt();
        while (newNum > 0) {
            numeros.add(newNum);
            System.out.println("Número introducido");
            System.out.print("Siguiente número: ");
            newNum = sc.nextInt();
        }
        sc.close();

        // Print todos

        System.out.println("Mostrando todos los números: ");

        System.out.println(numeros);

        System.out.println(" ");
        System.out.println("============================");
        System.out.println("Mostrando todos los números pares: ");

        // Print pares

        Iterator<Integer> it2 = numeros.iterator();
        while (it2.hasNext()) {
            Integer n = it2.next();
            if (n % 2 != 0) {
                it2.remove();
            }
        }
        System.out.println(numeros);

        System.out.println(" ");
        System.out.println("============================");
        System.out.println("Mostrando todos los números múltiplos: ");

        // Print multiplos de 3

        Iterator<Integer> it3 = numeros.iterator();
        while (it3.hasNext()) {
            Integer n = it3.next();
            if (n % 3 == 0) {
                it3.remove();
            }
        }
        System.out.println(numeros);

    }
}
