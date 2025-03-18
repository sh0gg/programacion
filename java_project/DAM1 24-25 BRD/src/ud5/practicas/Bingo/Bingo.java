package ud5.practicas.Bingo;

import java.util.*;

class Bingo {
    private List<Jugador> jugadores = new ArrayList<>();
    private Set<Integer> bolasSacadas = new HashSet<>();
    private Random random = new Random();

    private final int MAX_NUMEROS = 90;
    private final int MAX_CARTONES = 5;

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);

        // ENTRADA DE NUMERO DE JUGADORES
        int numJugadores;
        while (true) {
            System.out.println("Ingrese el número de jugadores:");
            if (scanner.hasNextInt()) {
                numJugadores = scanner.nextInt();
                if (numJugadores > 0) {
                    break;
                } else {
                    System.out.println("El número de jugadores debe ser mayor que 0.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        // ENTRADA DE NOMBRES DE JUGADORES
        scanner.nextLine(); // Consumir la línea pendiente
        for (int i = 0; i < numJugadores; i++) {
            String nombre;
            while (true) {
                System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
                nombre = scanner.nextLine().trim();
                if (!nombre.isEmpty() && nombre.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("El nombre debe contener solo letras y no debe estar vacío.");
                }
            }

            // ENTRADA DE NUMERO DE CARTONES POR JUGADOR
            int numCartones;
            while (true) {
                System.out.println("¿Cuántos cartones desea (máx. 5)?");
                if (scanner.hasNextInt()) {
                    numCartones = scanner.nextInt();
                    if (numCartones >= 1 && numCartones <= MAX_CARTONES) {
                        break;
                    } else {
                        System.out.println("El número de cartones debe estar entre 1 y 5.");
                    }
                } else {
                    System.out.println("Por favor, ingrese un número válido.");
                    scanner.next(); // Limpiar el buffer
                }
            }
            scanner.nextLine(); // Consumir la línea pendiente

            Jugador jugador = new Jugador(nombre, numCartones);
            jugadores.add(jugador);
        }

        // ENTRADA DE MODO DE JUEGO
        int modo;
        while (true) {
            System.out.println("Seleccione el modo de juego: 1) Turno a turno  2) Automático");
            if (scanner.hasNextInt()) {
                modo = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea que queda en el buffer después de nextInt()
                if (modo == 1 || modo == 2) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese una opción válida (1 o 2).");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar el buffer
            }
        }

        // Asegurarse de que solo se extrae una bola al inicio
        if (modo == 1) {
            jugarTurnoATurno(scanner);
        } else {
            jugarAutomatico();
        }

        scanner.close();

    }

    private void jugarTurnoATurno(Scanner scanner) {
        boolean bingo = false;
        while (!bingo) {
            int bola = sacarBola();
            System.out.println("Bola extraída: " + bola);

            // Comprobar línea o bingo
            for (Jugador jugador : jugadores) {
                if (jugador.marcarNumero(bola)) {
                    System.out.println(jugador.getNombre() + " ha marcado el número " + bola);
                    if (jugador.hasLinea()) {
                        System.out.println(jugador.getNombre() + " ha completado una línea!");
                    }
                    if (jugador.hasBingo()) {
                        System.out.println(jugador.getNombre() + " ha ganado el Bingo!");
                        bingo = true;
                        break;
                    }
                }
            }

            // Mostrar el estado de los cartones después de cada bola extraída
            for (Jugador jugador : jugadores) {
                jugador.mostrarCartones();
            }

            System.out.println("Presione ENTER para continuar...");
            scanner.nextLine();
        }
    }

    private void jugarAutomatico() {
        boolean bingo = false;
        while (!bingo) {
            int bola = sacarBola();
            System.out.println("Bola extraída: " + bola);
            for (Jugador jugador : jugadores) {
                if (jugador.marcarNumero(bola)) {
                    System.out.println(jugador.getNombre() + " ha ganado el Bingo!");
                    bingo = true;
                    break;
                }
            }
        }
    }

    private int sacarBola() {
        int bola;
        do {
            bola = random.nextInt(MAX_NUMEROS) + 1;
        } while (bolasSacadas.contains(bola));
        bolasSacadas.add(bola);
        return bola;
    }

    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        bingo.iniciarJuego();
    }
}

class Jugador {
    private String nombre;
    private List<Carton> cartones = new ArrayList<>();

    public Jugador(String nombre, int numCartones) {
        this.nombre = nombre;
        for (int i = 0; i < numCartones; i++) {
            cartones.add(new Carton());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean marcarNumero(int numero) {
        boolean marcado = false;
        for (Carton carton : cartones) {
            if (carton.marcarNumero(numero)) {
                marcado = true;
            }
        }
        return marcado;
    }

    public boolean hasLinea() {
        for (Carton carton : cartones) {
            if (carton.hasLinea()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBingo() {
        for (Carton carton : cartones) {
            if (carton.hasBingo()) {
                return true;
            }
        }
        return false;
    }

    public void mostrarCartones() {
        System.out.println("\nCartones de " + nombre + ":");
        int index = 1;
        for (Carton carton : cartones) {
            System.out.println("Cartón " + index + ":");
            carton.mostrarCarton();
            index++;
        }
    }

}

class Carton {
    private int[][] matriz = new int[3][9];
    private boolean[][] marcado = new boolean[3][9];

    public Carton() {
        generarCarton();
    }

    private void generarCarton() {
        Random random = new Random();
        Set<Integer> numerosUsados = new HashSet<>();

<<<<<<< HEAD
        // Iterar sobre las 9 columnas y generar números
        for (int columna = 0; columna < 9; columna++) {
            int numMin = columna * 10 + 1;  // Rango mínimo de la columna
            int numMax = (columna + 1) * 10;  // Rango máximo de la columna

            // Generar los 3 números en cada columna, asegurando que sean únicos y en el rango adecuado
            List<Integer> columnaNumeros = new ArrayList<>();
            while (columnaNumeros.size() < 3) {
                int numero = random.nextInt(numMax - numMin + 1) + numMin;
                if (!numerosUsados.contains(numero)) {
                    columnaNumeros.add(numero);
                    numerosUsados.add(numero);
                }
            }

            // Ordenar los números generados en la columna de menor a mayor
            Collections.sort(columnaNumeros);

            // Asignar los números generados a las filas, asegurando que cada fila tenga 5 números
            // y se mantenga el patrón de huecos en cada fila
            for (int i = 0; i < 3; i++) {
                if (i < columnaNumeros.size()) {
                    matriz[i][columna] = columnaNumeros.get(i);  // Asignar el número a la columna correspondiente
                } else {
                    matriz[i][columna] = 0;  // Dejar los huecos (0 representa un hueco)
                }
            }
        }

        // Ahora, distribuimos los números en cada fila asegurando que haya exactamente 5 números por fila
        // y el resto de las casillas sean huecos (#).
        for (int fila = 0; fila < 3; fila++) {
            List<Integer> numerosFila = new ArrayList<>();
            for (int columna = 0; columna < 9; columna++) {
                if (matriz[fila][columna] != 0) {
                    numerosFila.add(matriz[fila][columna]);  // Añadir los números de la fila
                }
            }

            // Aleatoriamente, distribuimos los números en la fila y completamos con huecos
            Collections.shuffle(numerosFila);  // Aleatorizar los números en la fila
            int j = 0;
            for (int columna = 0; columna < 9; columna++) {
                if (j < 5) {
                    matriz[fila][columna] = numerosFila.get(j);  // Asignar números
                    j++;
                } else {
                    matriz[fila][columna] = -1;  // Asignar huecos (#)
=======
        for (int fila = 0; fila < 3; fila++) {
            int numerosEnFila = 0;
            while (numerosEnFila < 5) {
                int columna = random.nextInt(9);
                if (matriz[fila][columna] == 0) {
                    int numMin = columna * 10 + 1;
                    int numMax = (columna + 1) * 10;
                    int numero;
                    do {
                        numero = random.nextInt(numMax - numMin + 1) + numMin;
                    } while (numerosUsados.contains(numero));
                    matriz[fila][columna] = numero;
                    numerosUsados.add(numero);
                    numerosEnFila++;
>>>>>>> a068ad1 (Add Bingo game classes and XML schema definitions for modules)
                }
            }
        }
    }

<<<<<<< HEAD


=======
>>>>>>> a068ad1 (Add Bingo game classes and XML schema definitions for modules)
    public boolean marcarNumero(int numero) {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (matriz[fila][columna] == numero) {
                    marcado[fila][columna] = true;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasLinea() {
        for (int fila = 0; fila < 3; fila++) {
            boolean lineaCompleta = true;
            for (int columna = 0; columna < 9; columna++) {
                if (matriz[fila][columna] != 0 && !marcado[fila][columna]) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) return true;
        }
        return false;
    }

    public boolean hasBingo() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (matriz[fila][columna] != 0 && !marcado[fila][columna]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrarCarton() {
        String formato = "%-5s";

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (matriz[fila][columna] != 0) {
                    if (marcado[fila][columna]) {
                        System.out.print(String.format(formato, "[X]"));
                    } else {
                        System.out.print(String.format(formato, "[" + matriz[fila][columna] + "]"));
                    }
                } else {
                    System.out.print(String.format(formato, "[#]"));
                }
            }
            System.out.println();
        }
    }


}
