package ud2.Practicas;

import java.util.Random;
import java.util.Scanner;

public class CalculadoraHumana {

    // Constantes del juego
    private static final int MAX_OPERACIONES = 7;
    private static final int MAX_FALLOS = 3;
    private static final int LIMITE_OPERANDOS = 200;

    // Scanner estático para uso global
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("¡Bienvenido a la Calculadora Humana!");
        System.out.println("Resuelve las operaciones matemáticas. Necesitas 7 aciertos para ganar.");
        System.out.println("Máximo de fallos permitidos: " + MAX_FALLOS);

        int aciertos = 0;
        int fallos = 0;
        int operando1 = random.nextInt(LIMITE_OPERANDOS) + 1; // Genera el primer operando

        // Bucle principal del juego
        while (aciertos < MAX_OPERACIONES && fallos < MAX_FALLOS) {
            char operador = obtenerOperadorAleatorio(random);
            int operando2 = obtenerOperando2(operando1, operador, random);
            int resultadoCorrecto = calcularResultado(operando1, operando2, operador);

            System.out.printf("¿Cuánto es %d %c %d?%n", operando1, operador, operando2);
            int respuestaUsuario = leerInt();

            // Verificar la respuesta del usuario
            if (respuestaUsuario == resultadoCorrecto) {
                System.out.println("¡Correcto!");
                aciertos++;
                operando1 = resultadoCorrecto; // El resultado correcto se convierte en el nuevo operando1
            } else {
                System.out.printf("Incorrecto. La respuesta era %d.%n", resultadoCorrecto);
                fallos++;
            }

            System.out.printf("Aciertos: %d | Fallos: %d%n%n", aciertos, fallos);
        }

        // Mostrar el resultado final del juego
        if (aciertos >= MAX_OPERACIONES) {
            System.out.println("¡Felicidades! Has ganado el juego.");
        } else {
            System.out.println("Has perdido. Mejor suerte la próxima vez.");
        }

        scanner.close();
    }

    // Genera un operador aleatorio
    private static char obtenerOperadorAleatorio(Random random) {
        char[] operadores = {'+', '-', '*', '/'};
        return operadores[random.nextInt(operadores.length)];
    }

    // Genera el segundo operando considerando el operador
    private static int obtenerOperando2(int operando1, char operador, Random random) {
        int operando2 = 1; // Inicialización fuera del bucle
        boolean operandoValido = false;

        while (!operandoValido) {
            operando2 = random.nextInt(LIMITE_OPERANDOS) + 1;
            if (operador == '/') {
                operandoValido = operando1 % operando2 == 0; // Garantiza divisiones exactas
            } else {
                operandoValido = true; // No hay restricciones para otros operadores
            }
        }

        return operando2;
    }

    // Calcula el resultado de la operación
    private static int calcularResultado(int operando1, int operando2, char operador) {
        return switch (operador) {
            case '+' -> operando1 + operando2;
            case '-' -> operando1 - operando2;
            case '*' -> operando1 * operando2;
            case '/' -> operando1 / operando2;
            default -> 0; // No debería ocurrir
        };
    }

    // Leer un entero del usuario con control de excepciones
    private static int leerInt() {
        boolean entradaValida = false;
        int resultado = 0;

        while (!entradaValida) {
            try {
                resultado = scanner.nextInt();
                entradaValida = true;
            } catch (Exception e) {
                System.out.print("Entrada inválida. Introduce un número entero: ");
                scanner.next(); // Limpiar entrada no válida
            }
        }

        return resultado;
    }
}
