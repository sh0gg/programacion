package ud4.DBRexamen;

import java.util.Scanner;

public class BuscaTesouroV05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ancho = obtenerDimension(sc, "ancho");
        int alto = obtenerDimension(sc, "alto");

        int[][] mapa = inicializarMapa(ancho, alto);
        int[] posicionTesoro = colocarTesoro(mapa, ancho, alto);
        int intentosMaximos = calcularIntentosMaximos(ancho, alto);
        int intentos = 0;

        System.out.println("El capitán pirata ha escondido bien su tesoro en esta zona de " + ancho * alto + " casillas...");
        System.out.println("¡¡Tienes un total de " + intentosMaximos + " intentos, para encontrarlo!!");

        while (true) {
            int[] intento = obtenerIntento(sc, ancho, alto);
            intentos++;

            if (intento[0] == posicionTesoro[0] && intento[1] == posicionTesoro[1]) {
                System.out.println("¡ENHORABUENA! Has encontrado el tesoro del pirata en " + intentos + " intento(s). Disfruta de tus riquezas mientras puedas, grumete...");
                break;
            }

            mapa[intento[0]][intento[1]] = 1;
            String direccion = calcularDireccion(posicionTesoro, intento);
            String distancia = calcularDistancia(posicionTesoro, intento);

            System.out.println("¡Buen intento, grumete! Pero el tesoro se encuentra " + distancia + " al " + direccion);
            imprimirMapa(mapa, ancho, alto);

            if (intentos >= intentosMaximos) {
                System.out.println("¡Mala suerte, mequetrefe! El tesoro del pirata seguirá escondido por la eternidad.");
                break;
            }
        }

        // Mostrar el mapa al final del juego
        imprimirMapa(mapa, ancho, alto);
        // Dibujar el tesoro en ASCII
        dibujarTesoro();
    }

    private static int obtenerDimension(Scanner sc, String dimension) {
        int dimensionValue;
        while (true) {
            System.out.print("Introduce el " + dimension + " (mínimo 3, máximo 20): ");
            if (sc.hasNextInt()) {
                dimensionValue = sc.nextInt();
                if (dimensionValue >= 3 && dimensionValue <= 20) {
                    break;
                } else {
                    System.out.println("Por favor, introduce un número válido dentro del rango permitido.");
                }
            } else {
                System.out.println("Por favor, introduce un número entero válido.");
                sc.nextLine(); // Limpiar la entrada
            }
        }
        return dimensionValue;
    }
    
    private static int[][] inicializarMapa(int ancho, int alto) {
        return new int[ancho][alto];
    }

    private static int[] colocarTesoro(int[][] mapa, int ancho, int alto) {
        int x, y;
        do {
            x = (int) (Math.random() * ancho);
            y = (int) (Math.random() * alto);
        } while (mapa[x][y] == 1); // Evita colocar el tesoro en una casilla ya intentada
        
        mapa[x][y] = 2;
        return new int[]{x, y};
    }
    
    private static int calcularIntentosMaximos(int ancho, int alto) {
        return Math.max(5, (ancho * alto) / 10); // Mínimo 5 intentos garantizados
    }

    private static int[] obtenerIntento(Scanner sc, int ancho, int alto) {
        int x, y;
        do {
            x = obtenerCoordenada(sc, "primera", ancho);
        } while (x >= ancho || x < 0);

        do {
            y = obtenerCoordenada(sc, "segunda", alto);
        } while (y >= alto || y < 0);

        return new int[]{x, y};
    }

    private static int obtenerCoordenada(Scanner sc, String coordenada, int limite) {
        int valor;
        while (true) {
            System.out.print("Dame la " + coordenada + " coordenada: ");
            if (sc.hasNextInt()) {
                valor = sc.nextInt() - 1;
                if (valor >= 0 && valor < limite) {
                    break;
                } else {
                    System.out.println("Por favor, introduce un número entero válido dentro del rango.");
                }
            } else {
                System.out.println("Por favor, introduce un número entero válido.");
                sc.next(); // Limpiar la entrada no válida
            }
        }
        return valor;
    }

    private static String calcularDireccion(int[] posicionTesoro, int[] intento) {
        String direccion = "";
    
        if (posicionTesoro[1] > intento[1]) { // El tesoro está más abajo
            if (posicionTesoro[0] > intento[0]) {
                direccion = "sureste";
            } else if (posicionTesoro[0] < intento[0]) {
                direccion = "suroeste";
            } else {
                direccion = "sur"; // Mismo eje X, solo al sur
            }
        } else if (posicionTesoro[1] < intento[1]) { // El tesoro está más arriba
            if (posicionTesoro[0] > intento[0]) {
                direccion = "noreste";
            } else if (posicionTesoro[0] < intento[0]) {
                direccion = "noroeste";
            } else {
                direccion = "norte"; // Mismo eje X, solo al norte
            }
        } else { // Misma coordenada Y (misma fila), está en la misma línea horizontal
            if (posicionTesoro[0] > intento[0]) {
                direccion = "este";
            } else if (posicionTesoro[0] < intento[0]) {
                direccion = "oeste";
            } else {
                direccion = "aquí"; // El intento está en la misma posición del tesoro
            }
        }
    
        return direccion;
    }

    private static String calcularDistancia(int[] posicionTesoro, int[] intento) {
        int d = (int) Math.sqrt(Math.pow(intento[0] - posicionTesoro[0], 2) + Math.pow(intento[1] - posicionTesoro[1], 2));
        return d <= 2 ? "cerca" : "lejos";
    }

    private static void imprimirMapa(int[][] mapa, int ancho, int alto) {
        imprimirMapa(mapa, ancho, alto, true); // Llama a la versión completa con el valor por defecto true
    }

    private static void imprimirMapa(int[][] mapa, int ancho, int alto, boolean revelarTesoro) {
        for (int j = 0; j < alto; j++) {
            for (int i = 0; i < ancho; i++) {
                if (mapa[i][j] == 1) {
                    System.out.print("O ");
                } else if (mapa[i][j] == 2 && revelarTesoro) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
    private static void dibujarTesoro() {
        System.out.println("  ________");
        System.out.println(" /\\       \\");
        System.out.println("/  \\_______\\");
        System.out.println("\\  /    /  /");
        System.out.println(" \\/_______/");
    }
}