package ud6.apuntesgenericos;

import java.util.Scanner;

public class ProgramaCola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContenedorLista<Integer> cola = new ContenedorLista<>(new Integer[0]);

        System.out.println("Introduce números positivos para encolar. (-1 para terminar):");
        int num;
        while ((num = sc.nextInt()) != -1) {
            if (num >= 0) cola.encolar(num);
        }

        System.out.println("Desencolando elementos:");
        while (!cola.estaVacia()) {
            System.out.println(cola.desencolar());
        }
    }
}
