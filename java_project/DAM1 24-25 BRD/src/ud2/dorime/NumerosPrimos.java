package ud2.dorime;

public class NumerosPrimos {

    public static void main(String[] args) {

        System.out.println("¡Vamos a calcular números primos!");

        int x = 2; // Empezamos desde 2, ya que es el primer número primo
        int contadorPrimos = 0; // Contador de números primos

        while (true) { // Bucle infinito para calcular al infinito
            boolean esPrimo = true;

            // Comprobamos si el número x es primo
            for (int y = 2; y <= Math.sqrt(x); y++) {
                if (x % y == 0) {
                    esPrimo = false;
                    break;
                }
            }

            if (esPrimo) {
                System.out.printf("El número %d ES primo %n", x);
                contadorPrimos++;
                System.out.printf("Cantidad de números primos encontrados: %d%n", contadorPrimos);
            } else {
                System.out.printf("El número %d NO es primo %n", x);
            }

            x++; // Avanzamos al siguiente número
        }
    }
}