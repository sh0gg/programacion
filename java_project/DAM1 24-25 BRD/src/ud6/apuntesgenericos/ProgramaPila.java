package ud6.apuntesgenericos;

import java.util.Scanner;

public class ProgramaPila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContenedorLista<Integer> pila = new ContenedorLista<>(new Integer[0]);

        System.out.println("Introduce números positivos para apilar. (-1 para terminar):");
        int num;
        while ((num = sc.nextInt()) != -1) {
            if (num >= 0) pila.apilar(num);
        }

        System.out.println("Desapilando elementos:");
        while (!pila.estaVacia()) {
            System.out.println(pila.desapilar());
        }
    }
}
