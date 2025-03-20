package ud5.practicas.Bingo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    static final int MAX_NUM = 99;
    static Jugador[] jugadores;
    static int[] numerosSorteados = new int[0];
    static boolean linea = false;
    static boolean bingo = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBINGO");
        System.out.println("=====\n");

        System.out.print("Número de jugadores: ");
        int numJugadores = sc.nextInt();
        jugadores = new Jugador[numJugadores];

        System.out.println("\nIntroduce los datos de los jugadores:");

        for (int i = 1; i <= numJugadores; i++) {
            sc.nextLine(); // Limpio el buffer de entrada de teclado
            System.out.print("Nombre jugador" + i + ": ");
            String nombre = sc.nextLine();
            System.out.print("Número de cartones: ");
            int numCartones = sc.nextInt();
            System.out.println();

            Jugador jugador = new Jugador(nombre, numCartones);
            jugadores[i - 1] = jugador;
            System.out.println(jugador);
        }

        // Comienza el Juego
        System.out.println("Comienza el juego");
        System.out.println("-----------------");
        // Dos Modalidades
        System.out.println("Que modalidad prefieres? (N - Número a número)  (A - Automática)");
        sc.nextLine(); // Limpio el buffer de entrada de teclado
        int opcion = sc.nextLine().toUpperCase().charAt(0);
        switch (opcion) {
            case 'N':
                modoNumeroANumero();
                break;
            case 'A':
                modoAutomatico();
                break;
            default:
                System.out.println("Opción incorrecta. Fin del programa");
        }
    }

    private static void modoAutomatico() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modoAutomatico'");
    }

    private static void modoNumeroANumero() {
        do {
            // El programa saca un bola aleatoria, no repetida
            int numero = sortearNumero();
            System.out.println("Número que sale del bombo: " + numero);
            System.out.println("Números ya cantados: " + Arrays.toString(numerosSorteados));
            // Revisar Cartones
            revisarCartonesJugadores();
            System.out.println("Pulsa ENTER para continuar");
            new Scanner(System.in).nextLine();
        } while (!bingo);

        System.out.println("Fin del programa!");
    }

    private static void revisarCartonesJugadores() {
        boolean nuevaLinea = false;
        boolean nuevoBingo = false;
        for (Jugador jugador : jugadores) {
            for (Carton carton : jugador.cartones) {
                switch (carton.revisarCarton(numerosSorteados)) {
                    case 0: break;
                    case 1: //Línea se canta si no se ha hecho antes
                        if (!linea) {
                            System.out.println(jugador.nombre + " ha cantado línea en el siguiente cartón: " );
                            System.out.println(carton);
                            nuevaLinea = true;
                        }
                        break;
                    case 2: //Bingo, si no se ha cantado antes, claro
                        if (!bingo) {
                            System.out.println(jugador.nombre + " ha cantado bingo en su cartón: ");
                            System.out.println(carton);
                            System.out.println("ENHORABUENA!!");
                            nuevoBingo = true;
                        }
                        break;
                }
            }
        }
        if (nuevaLinea)
            linea = true;
        if (nuevoBingo)
            bingo = true;
    }

    /**
     * Sortea un nuevo número y lo añade al array de números sorteados
     *
     * @return
     */
    private static int sortearNumero() {
        Random rnd = new Random();
        int numRandom;
        boolean repetido;
        do {
            numRandom = rnd.nextInt(MAX_NUM) + 1;
            repetido = false;
            int i = 0;
            while (i < numerosSorteados.length && !repetido) {
                if (numerosSorteados[i] == numRandom)
                    repetido = true;
                i++;
            }
        } while (repetido);

        numerosSorteados = Arrays.copyOf(numerosSorteados, numerosSorteados.length + 1);
        numerosSorteados[numerosSorteados.length - 1] = numRandom;
        return numRandom;
    }
}

class Jugador {
    String nombre;
    Carton[] cartones;

    public Jugador(String nombre, int numCartones) {
        this.nombre = nombre;
        // TODO Instanciar cartones
        cartones = new Carton[numCartones];
        for (int i = 0; i < cartones.length; i++) {
            cartones[i] = new Carton();
        }
    }

    @Override
    public String toString() {
        String str = "Jugador: " + nombre + " (" + cartones.length + " cartones)\n\n";
        for (int i = 0; i < cartones.length; i++) {
            str += cartones[i] + "\n";
        }
        return str;
    }
}

class Carton {
    static final int MAX_FILAS = 3;
    static final int MAX_COLS = 5;

    int[][] numeros;

    public Carton() {
        this.numeros = new int[MAX_FILAS][MAX_COLS];
        // Rellenar con números aleatorios distintos.
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                // Genera un número aleatorio
                Random rnd = new Random();
                boolean repetido;
                int numRandom;
                do {
                    numRandom = rnd.nextInt(Bingo.MAX_NUM) + 1;
                    // Comprobar que el numero no está repetido
                    repetido = false;
                    int ii = 0;
                    while (ii < MAX_FILAS && !repetido) {
                        int jj = 0;
                        while (jj < MAX_COLS && !repetido) {
                            if (numeros[ii][jj] == numRandom)
                                repetido = true;
                            jj++;
                        }
                        ii++;
                    }
                } while (repetido);

                numeros[i][j] = numRandom;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLS; j++) {
                str.append(numeros[i][j] + " ");
            }
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * Revisa el cartón comparando los números del mismo con los números sorteados que se pasan como parámetro
     * Devuelve 0 sin tras la revisión no hay línea ni bingo
     * Devuelve 1 si hay línea pero no bingo
     * Devuelve 2 si hay bingo
     * @param numerosSorteo
     * @return
     */
    public int revisarCarton(int[] numerosSorteo) {
        boolean hayLinea = false;
        boolean hayBingo = true;
    
        for (int i = 0; i < MAX_FILAS; i++) {
            boolean lineaCompleta = true;
            for (int j = 0; j < MAX_COLS; j++) {
                boolean encontrado = false;
                for (int n : numerosSorteo) {
                    if (numeros[i][j] == n) {
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    hayBingo = false;
                    lineaCompleta = false;
                }
            }
            if (lineaCompleta) {
                hayLinea = true;
            }
        }
    
        if (hayBingo) return 2;
        if (hayLinea) return 1;
        return 0;
    }
    

}
