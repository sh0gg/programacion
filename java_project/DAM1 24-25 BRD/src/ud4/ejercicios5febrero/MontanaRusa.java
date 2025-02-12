package ud4.ejercicios5febrero;

public class MontanaRusa {
    public static void main(String[] args) {
        int[] montanaRusa1 = new int[] { 4, 10, 3, 2 };
        int[] montanaRusa2 = new int[] { 10, 3, 2, 4 };
        int[] montanaRusa3 = new int[] { 4, 10, 3, 2 };
        int[] montanaRusa4 = new int[] { 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1 };
        int[] montanaRusa5 = new int[] { 1, 2, 3, 2, 1 };
        int[] montanaRusa6 = new int[] { 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1 };
        int[] montanaRusa7 = new int[] { 1, 2, 3, 4, 5 };
        int[] montanaRusa8 = new int[] { 5, 4, 3, 2, 3, 4, 4 };
        int[] montanaRusa9 = new int[] { 3, 2, 1, 2, 3 };
        int[] montanaRusa10 = new int[] { 3, 2, 1, 2, 1, 2, 1, 2, 3 };

        System.out.println("La montaña tiene " + contarPicos(montanaRusa1) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa2) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa3) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa4) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa5) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa6) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa7) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa8) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa9) + " pico(s).");
        System.out.println("La montaña tiene " + contarPicos(montanaRusa10) + " pico(s).");


    }

    public static int contarPicos(int[] alturas) {
        int contadorPicos = 0;
        for (int i = 0; i < alturas.length; i++) {
            if (i != 0) {
                if (i != alturas.length - 1) {
                    // ni el primero ni el ultimo
                    if (alturas[i] > alturas[i - 1] && alturas[i] > alturas[i + 1]) {
                        contadorPicos++;
                    }
                } else
                // ultimo del array
                if (alturas[i] == alturas[alturas.length - 1] && alturas[i] > alturas[0]
                        && alturas[i] > alturas[i - 1]) {
                    contadorPicos++;
                }
            } else
            // primero del array
            if (alturas[i] == alturas[0] && alturas[i] > alturas[alturas.length - 1] && alturas[i] > alturas[i + 1]) {
                contadorPicos++;
            }
        }
        return contadorPicos;
    }
}
