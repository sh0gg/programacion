package ud4.arraysejercicios;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class E0509 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println("¿Cuántas puntuaciones vas a introducir?");
        int numeroPuntuaciones = scanner.nextInt();

        Double[] puntuaciones = new Double[numeroPuntuaciones];

        System.out.println("Introduce las puntuaciones de los " + numeroPuntuaciones + " programadores:");
        for (int i = 0; i < numeroPuntuaciones; i++) {
            puntuaciones[i] = scanner.nextDouble();
        }

        Arrays.sort(puntuaciones, Collections.reverseOrder());
        System.out.println("Mejores puntuaciones : " + Arrays.toString(puntuaciones));

        System.out.println("Introduce las puntuaciones de los programadores de exhibición. Introduce -1 para parar.");
        // Bucle de lectura anticipada
        double nota = scanner.nextDouble();
        while (nota != -1) {

            // Proceso: Añadir ordenado
            Double[] tAux = new Double[puntuaciones.length + 1];
            int posicion = Arrays.binarySearch(puntuaciones, nota, Collections.reverseOrder());
            if (posicion < 0) {
                posicion = -posicion - 1;
            }

            System.arraycopy(puntuaciones, 0, tAux, 0, posicion);
            tAux[posicion] = nota;
            System.arraycopy(puntuaciones, posicion, tAux, posicion + 1, puntuaciones.length - posicion);
            puntuaciones = tAux;

            // Proxima lectura
            nota = scanner.nextDouble();
        }
        scanner.close();

        System.out.println("Puntuaciones finales: " + Arrays.toString(puntuaciones));
    }

}
