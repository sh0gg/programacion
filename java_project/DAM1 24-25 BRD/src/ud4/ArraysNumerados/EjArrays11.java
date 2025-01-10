package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays11 {
    static char[][] tablero = new char[3][3];

    public static void main(String[] args) {
        iniciarTablero();
        boolean hayGanador = false;
        int turnos = 0;
        char jugadorActual = 'X';
        while (!hayGanador && turnos < 9) {
            mostrarTablero();
            leerMovimiento(jugadorActual);
            hayGanador = comprobarVictoria(jugadorActual);
            if (hayGanador) {
                mostrarTablero();
                System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
            } else {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                turnos++;
            }
        }
        if (!hayGanador) {
            mostrarTablero();
            System.out.println("¡Es un empate!");
        }
    }

    static void iniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    static void mostrarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void leerMovimiento(char jugador) {
        Scanner sc = new Scanner(System.in);
        int fila, columna;
        do {
            System.out.println("Turno del jugador " + jugador + ". Introduce fila y columna (0-2):");
            fila = sc.nextInt();
            columna = sc.nextInt();
        } while (fila < 0 || fila > 2 || columna < 0 || columna > 2 ||
                tablero[fila][columna] != '-');
        tablero[fila][columna] = jugador;
        
        sc.close();
    }

    static boolean comprobarVictoria(char jugador) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador &&
                    tablero[i][2] == jugador)
                return true;
            if (tablero[0][i] == jugador && tablero[1][i] == jugador &&
                    tablero[2][i] == jugador)
                return true;
        }
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador)
            return true;
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)
            return true;
        return false;
    }
}
