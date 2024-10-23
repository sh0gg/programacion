package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class hora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hora, min, sec;

        System.out.println("Dime que hora es:");
        hora = scanner.nextInt();
        if ( hora > 24) {
            System.out.println("¡Esa hora no es válida!");
            scanner.close();
            return;
        }
        min = scanner.nextInt();
        if ( min > 60) {
            System.out.println("¡Eses minutos no son válidos!");
            scanner.close();
            return;
        }
        sec = scanner.nextInt();
        if ( sec > 60) {
            System.out.println("¡Eses segundos no son válidos!");
            scanner.close();
            return;
        }

        System.out.printf("Son las %02d:%02d:%02d %n", hora, min, sec);

        System.out.println("Vamos a añadirle un segundo.");

        sec = sec + 1;

        if (sec == 60) {
            sec = 0;
            min = min + 1;
        }

        if (min == 60) {
            min = 0;
            hora = hora + 1;
        }

        if (hora == 24) {
            hora = 0;
            min = 0;
            sec = 0;
        }

        System.out.printf("Son las %02d:%02d:%02d", hora, min, sec);

        scanner.close();
    }
}
