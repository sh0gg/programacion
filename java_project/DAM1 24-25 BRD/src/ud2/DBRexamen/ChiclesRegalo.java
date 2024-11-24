package ud2.DBRexamen;

// Ejercicio hecho por David Besada

import java.util.Scanner;

public class ChiclesRegalo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("¿Cuántos chicles disfrutaremos?");
        System.out.println("=================================");
        System.out.println("¿Cuántos chicles vamos a comprar?");
        int chiclesComprados = leerInt();
        System.out.println("Con la oferta actual ¿Cuántos envoltorios necesitamos?");
        int numEnvoltorios = leerInt();
        System.out
                .println("Con la oferta actual ¿Cuántos chicles nos dan por cada " + numEnvoltorios + " envoltorios?");
        int numRegaloOferta = leerInt();

        System.out.println(totalChicles(chiclesComprados, numEnvoltorios, numRegaloOferta));
        System.out.println("Fin del programa");

    }

    public static int totalChicles(int chiclesComprados, int numEnvoltorios, int numRegaloOferta) {

        int totalChicles = 0;
        int chiclesRegalo = 0;

        if (chiclesComprados < 0) {
            return totalChicles = -1;
        }
        if (numEnvoltorios < 0) {
            return totalChicles = -1;
        }
        if (numRegaloOferta < 0 || numRegaloOferta > numEnvoltorios) {
            return totalChicles = -1;
        }

        if (numEnvoltorios != 0) {
            chiclesRegalo = (chiclesComprados / numEnvoltorios) * numRegaloOferta;

            while (chiclesRegalo <= numEnvoltorios) {
                chiclesRegalo = chiclesRegalo + ((chiclesRegalo / numEnvoltorios) * numRegaloOferta);
            }
        }
        totalChicles = chiclesComprados + chiclesRegalo;

        return totalChicles;

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
