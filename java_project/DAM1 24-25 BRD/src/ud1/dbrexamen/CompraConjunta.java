package ud1.dbrexamen;

// Mi nombre es David Besada Ramilo

import java.util.Scanner;

// Una pelota vale X euros y 3 amigos quieren comprarla.

public class CompraConjunta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precioPelota;
        double pagaAmigo1;
        double pagaAmigo2;
        double pagaAmigo3;
        double pagado;

        System.out.println("3 amigos quieren comprar una pelota...");
        System.out.println("¿Cuánto vale la pelota?");
        precioPelota = scanner.nextDouble();

        System.out.println("¿Cuánto va a pagar el primer amigo?");
        pagaAmigo1 = scanner.nextDouble();
        System.out.println("¿Cuánto va a pagar el segundo amigo?");
        pagaAmigo2 = scanner.nextDouble();
        System.out.println("¿Cuánto va a pagar el tercer amigo?");
        pagaAmigo3 = scanner.nextDouble();

        pagado = (precioPelota - (pagaAmigo1 + pagaAmigo2 + pagaAmigo3));

        String mensaje = (pagado > 0)
                ? "Faltan " + pagado + " euros para poder comprar la pelota."
                : "Sobran " + (-pagado) + " euros despues de comprar la pelota.";

        System.out.println(mensaje);

        scanner.close();

    }

}
