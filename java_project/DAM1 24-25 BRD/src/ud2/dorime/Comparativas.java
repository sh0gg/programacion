package ud2.dorime;

import java.util.Scanner;

public class Comparativas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String Juana = "Juana";
        final String Jose = "Jose";
        final String Chema = "Chema";
        String nombre1, nombre2, nombre3;
        double score1, score2, score3;

        System.out.println("¡Vamos a ordenar por nota las calificaciones de la clase!");
        System.out.println("Introduce la nota de Juana");
        double scoreJuana = scanner.nextDouble();
        System.out.println("Introduce la nota de Jose");
        double scoreJose = scanner.nextDouble();
        System.out.println("Introduce la nota de Chema");
        double scoreChema = scanner.nextDouble();

        if (scoreJuana > scoreJose) {

            if (scoreJose > scoreChema) {
                // Juana > Jose > Chema
                score1 = scoreJuana;
                nombre1 = Juana;
                score2 = scoreJose;
                nombre2 = Jose;
                score3 = scoreChema;
                nombre3 = Chema;
            } else {
                // Juana > Chema > Jose
                score1 = scoreJuana;
                nombre1 = Juana;
                score2 = scoreChema;
                nombre2 = Chema;
                score3 = scoreJose;
                nombre3 = Jose;
            }

        } else if (scoreJuana > scoreChema) {
            if (scoreChema > scoreJuana) {
                // Jose, Chema, Juana
                score1 = scoreJose;
                nombre1 = Jose;
                score2 = scoreChema;
                nombre2 = Chema;
                score3 = scoreJuana;
                nombre3 = Juana;
            } else {
                // Jose, Juana, Chema
                score1 = scoreJose;
                nombre1 = Jose;
                score2 = scoreJuana;
                nombre2 = Juana;
                score3 = scoreChema;
                nombre3 = Chema;
            }

            if (scoreChema > scoreJuana) {
                if (scoreJose > scoreJuana) {
                    // Chema, Jose, Juana
                    score1 = scoreChema;
                    nombre1 = Chema;
                    score2 = scoreJose;
                    nombre2 = Jose;
                    score3 = scoreJuana;
                    nombre3 = Juana;
                } else {
                    // Chema, Jose, Juana
                    score1 = scoreChema;
                    nombre1 = Chema;
                    score2 = scoreJuana;
                    nombre2 = Juana;
                    score3 = scoreJose;
                    nombre3 = Jose;
                }

            }

            System.out.println("Las calificaciones son las siguientes:");
            System.out.printf("%s ha sacado un %.2f %n", nombre1, score1);
            System.out.printf("%s ha sacado un %.2f %n", nombre2, score2);
            System.out.printf("%s ha sacado un %.2f %n", nombre3, score3);

            scanner.close();
        }

    }
}
