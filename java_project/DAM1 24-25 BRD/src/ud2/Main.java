package ud2;

public class Main {
    public static void main(String[] args) {
        int min = 1;
        int max = 10;

        // (int) castea el valor de double a int

        // se usa +1 para que incluya el numero 10, si no lo excluye

        // se usa el + min para que empiece en el 1 y no en el cero

        // [1,10) si no pones el +1 y [1,10] si pones el +1

        int randomInt = (int)(Math.random() * (max + 1)) + min;
        System.out.println("Número entero aleatorio entre 1 y 10: " + randomInt);
    }

    // Para bucles usar el siguiente !!

    public static void bucles(String[] args) {

        // Da cuatro valores aleatorios entre el 1 y el 100

        for (int i = 0; i < 5; i++) {
            System.out.println("Número aleatorio " + (i + 1) + ": " + Math.random() * (100 - 1 + 1) + 1 );
        }
    }
}

