package ud2.DBRexamen;

// Ejercicio hecho por David Besada

import java.util.Scanner;

public class DuracionBombillas {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("¿Porqué se ha roto esta bombilla?");
        System.out.println("=================================");
        System.out.println("¿Cuántas horas puede alcanzar encendida?");
        int maxHoras = leerInt();
        System.out.println("¿Cuántas veces puede encenderse?");
        int maxEncendidos = leerInt();
        System.out.println("¿Cuántas horas se mantendrá encendida? (No más de 10)");
        int horasUso = leerInt();

        System.out.println(causaFinBombilla(maxHoras, maxEncendidos, horasUso));
        System.out.println("Fin del programa");

    }

    public static String causaFinBombilla(int maxHoras, int maxEncendidos, int horasUso) {

        String causaFinBombilla = "";

        int horasUsado = maxEncendidos * horasUso;

        if (horasUsado > maxHoras) {
            causaFinBombilla = "HORAS";
        }

        if (horasUsado < maxHoras) {
            causaFinBombilla = "ENCENDIDOS";
        }

        if (horasUsado == maxHoras) {
            causaFinBombilla = "ENCENDIDOS + HORAS";
        }

        if (maxHoras <= 0) {
            causaFinBombilla = "ERROR";
        }

        if (maxEncendidos <= 0) {
            causaFinBombilla = "ERROR";
        }

        if (horasUso <= 0) {
            causaFinBombilla = "ERROR";
        }

        if (horasUso > 10) {
            causaFinBombilla = "ERROR";
        }

        return causaFinBombilla;
    }

    public static int leerInt() {
        int resultado = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("No puedes dejar el valor vacío.");
                }
                resultado = Integer.parseInt(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Introduce un número entero válido: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return resultado;
    }
}
