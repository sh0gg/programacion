package DBRexamen;

// Ejercicio hecho por David Besada

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

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

        int resto;
        int totalChicles = chiclesComprados;
        // int chiclesRegalo = 0;

        if (chiclesComprados < 0) {
            return totalChicles = -1;
        }

        if (numEnvoltorios < 0) {
            return totalChicles = -1;
        }

        if (numRegaloOferta < 0) {
            return totalChicles = -1;
        }

        if (numRegaloOferta > numEnvoltorios) {
            return totalChicles = -1;
        }

        if (numEnvoltorios == 0) {
            return totalChicles = chiclesComprados;
        }


        resto = chiclesComprados / numEnvoltorios;
        totalChicles += resto * numRegaloOferta;
        int acumulado = chiclesComprados % numEnvoltorios;

        while (resto >= numEnvoltorios) {
            int chiclesSobrantes = acumulado + resto;
            resto = chiclesSobrantes / numEnvoltorios;
            acumulado = chiclesSobrantes % numEnvoltorios;
            totalChicles += resto * numRegaloOferta;
        }

        totalChicles = totalChicles + acumulado;

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

    @Test
    public void ChiclesRegaloTest() {
    
        assertEquals(31, totalChicles(25, 5, 1));
        assertEquals(6, totalChicles(5, 5, 1));
        assertEquals(111, totalChicles(100, 10, 1));
        assertEquals(-1, totalChicles(20, 2, 5));
        assertEquals(-1, totalChicles(10, -1, 0));
        assertEquals(-1, totalChicles(-1, 2, 1));
        assertEquals(-1, totalChicles(10, 1, -1));
        assertEquals(-1, totalChicles(20, 1, 2));
        assertEquals(10, totalChicles(7, 3, 1));
        assertEquals(40, totalChicles(27, 3, 1));
        assertEquals(21, totalChicles(11, 2, 1));
        assertEquals(31, totalChicles(16, 2, 1));
        assertEquals(100, totalChicles(100, 0, 0));
        // assertEquals(100, totalChicles(100, 0, 1));
        // assertEquals(0, totalChicles(0, 0, 1));
        // assertEquals(0, totalChicles(0, 2, 1));
    }
}
