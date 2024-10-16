package ud1.dbrexamen;

// Mi nombre es David Besada Ramilo

import java.util.Scanner;

// Una pelota vale X euros y 3 amigos quieren comprarla.

public class CompraConjunta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precioPelota;
        double pagaJaime;
        double pagaJose;
        double pagaJosefa;
        double pagado;

        System.out.println("Jaime, Jóse y Josefa quieren comprar una pelota...");
        System.out.println("¿Cuánto vale la pelota?");
        precioPelota = scanner.nextDouble();

        System.out.println("¿Cuánto va a pagar Jaime?");
        pagaJaime = scanner.nextDouble();
        System.out.println("¿Cuánto va a pagar Jóse?");
        pagaJose = scanner.nextDouble();
        System.out.println("¿Cuánto va a pagar Josefa?");
        pagaJosefa = scanner.nextDouble();

        pagado = (precioPelota - (pagaJaime + pagaJose + pagaJosefa));

        String mensaje = (pagado > 0)
                ? "Faltan " + pagado + " euros para poder comprar la pelota."
                : "Sobran " + (-pagado) + " euros despues de comprar la pelota.";

        System.out.println(mensaje);

        scanner.close();

    }

}
