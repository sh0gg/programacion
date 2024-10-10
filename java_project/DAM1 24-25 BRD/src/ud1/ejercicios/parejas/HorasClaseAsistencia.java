package ud1.ejercicios.parejas;

import java.util.Scanner;

public class HorasClaseAsistencia {
    // Driver: Carlos de la Torre Aboal
    // Copilot: David Besada Ramilo
    public static void main(String[] args) {
        final int MINUTOS = 240 * 60;
        final double apercibimiento = 0.06;
        final double perdidaEv = 0.10;
        final double sesiones = MINUTOS / 50;

        double ses6Perc = sesiones * apercibimiento;
        double ses10Perc = sesiones * perdidaEv;

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduzca el número de faltas del alumno: ");
        int faltas = sc.nextInt();
        sc.close();

        System.out.printf("Número de sesiones de 50': %.0f %n ", sesiones);
        System.out.printf("Número de faltas sin justificar que implican un apercebimiento: %.0f %n ", ses6Perc);
        System.out.printf(
                "Número de faltas sin justificar que implican una pérdida de la evaluación continua: %.0f %n ",
                ses10Perc);

        String consecuencias = (faltas < ses6Perc) ? "Ningún problema"
                : (faltas < ses10Perc) ? "Apercibimiento" : "Pérdida de evaluación continua";

        System.out.println(consecuencias);

    }
}
