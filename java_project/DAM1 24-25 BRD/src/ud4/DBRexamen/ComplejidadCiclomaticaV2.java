package ud4.DBRexamen;

// Realizado por David Besada
// Examen UD04 de Programación

public class ComplejidadCiclomaticaV2 {

    public static void main(String[] args) {
        int[][] grafo1 = {
                {1},
                {3, 5},
                {1},
                {2, 4},
                {6},
                {6},
                {}
        };

        int[][] grafo2 = {
                {1, 6},
                {2, 5},
                {3, 4},
                {4},
                {1},
                {0},
                {}
        };

        System.out.println("Complejidad del grafo 1: " + calcularComplejidad(grafo1));
        System.out.println("Complejidad del grafo 2: " + calcularComplejidad(grafo2));
    }

    private static int calcularComplejidad(int[][] grafo) {
        int nodos = grafo.length;
        int aristas = 0;

        for (int[] conexiones : grafo) {
            aristas += conexiones.length;
        }

        return aristas - nodos + 2;
    }
}
