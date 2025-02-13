package ud4.DBRexamen;

// Realizado por David Besada
// Examen UD04 de Programación

import java.util.Scanner;

public class BuscaTesouroV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitar dimensiones del mapa
        System.out.println("Dimensiones del mapa:");
        System.out.print("Introduce el número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = sc.nextInt();

        // Validación de dimensiones
        if (filas <= 0 || columnas <= 0) {
            System.out.println("Dimensiones inválidas. Deben ser mayores a 0.");
            return;
        }

        // Inicialización del mapa
        char[][] mapa = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mapa[i][j] = '.';
            }
        }

        // Generar la posición del tesoro aleatoriamente
        int tesoroFila = (int) (Math.random() * filas);
        int tesoroColumna = (int) (Math.random() * columnas);
        int intentosMaximos = (filas * columnas) / 10;
        int intentos = 0;
        boolean encontrado = false;

        System.out.println("¡Tienes " + intentosMaximos + " intentos para encontrar el tesoro!");

        while (intentos < intentosMaximos) {
            // Solicitar coordenadas al usuario
            int filaIntento, columnaIntento;
            do {
                System.out.print("Introduce la fila (1-" + filas + "): ");
                filaIntento = sc.nextInt() - 1;
            } while (filaIntento < 0 || filaIntento >= filas);

            do {
                System.out.print("Introduce la columna (1-" + columnas + "): ");
                columnaIntento = sc.nextInt() - 1;
            } while (columnaIntento < 0 || columnaIntento >= columnas);

            intentos++;

            if (filaIntento == tesoroFila && columnaIntento == tesoroColumna) {
                encontrado = true;
                break;
            }

            // Marcar la casilla intentada en el mapa
            mapa[filaIntento][columnaIntento] = 'O';

            // Determinar la dirección de la pista
            String pista = "";
            if (filaIntento < tesoroFila) pista += "Sur";
            if (filaIntento > tesoroFila) pista += "Norte";
            if (columnaIntento < tesoroColumna) pista += "Este";
            if (columnaIntento > tesoroColumna) pista += "Oeste";

            // Calcular la distancia euclidiana
            double distancia = Math.sqrt(Math.pow(filaIntento - tesoroFila, 2) + Math.pow(columnaIntento - tesoroColumna, 2));

            // Determinar si está cerca o lejos
            String proximidad = distancia <= 2 ? "cerca" : "lejos";

            System.out.println("El tesoro está más al " + pista + " y estás " + proximidad + ".");

            // Imprimir el mapa actualizado
            imprimirMapa(mapa);
        }

        // Resultado final
        if (encontrado) {
            System.out.println("¡ENHORABUENA! Encontraste el tesoro en " + intentos + " intentos.");
        } else {
            System.out.println("¡Se acabaron los intentos! El tesoro estaba en (" + (tesoroFila + 1) + ", " + (tesoroColumna + 1) + ").");
        }

        // Mostrar el mapa final con la posición del tesoro
        mapa[tesoroFila][tesoroColumna] = 'X';
        imprimirMapa(mapa);
    }

    /**
     * Método para imprimir el mapa en el formato correcto.
     */
    private static void imprimirMapa(char[][] mapa) {
        System.out.println("\nMapa actual:");
        for (char[] fila : mapa) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
