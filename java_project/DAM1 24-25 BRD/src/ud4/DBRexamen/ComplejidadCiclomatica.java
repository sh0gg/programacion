package ud4.DBRexamen;

// Realizado por David Besada Ramilo
// Examen UD04 de Programación

public class ComplejidadCiclomatica {

    public static void main(String[] args) {
        int[][] grafo1 = {
                {1},
                {3,5},
                {1},
                {2,4},
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
        System.out.println(complejidadCiclomatica(grafo1));
        System.out.println(complejidadCiclomatica(grafo2));
    }

    private static int complejidadCiclomatica(int[][] grafo) {
        int complejidad = 0;
        int nodos = 0;
        int aristas = 0;
        for (int i = 0; i < grafo.length; i++) {
            nodos++;
            for (int j = 0; j < grafo[i].length; j++) {
                aristas++;
            }
        }
        complejidad = aristas - nodos + 2;
        return complejidad;
    }


}
