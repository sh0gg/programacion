package ud2.ejercicioscondicionales;

import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Sistema de Calculadora Interactiva\r\n" + //
                "1. Realizar operación matemática (+, -, *, /)\r\n" + //
                "2. Calcular el IMC (Índice de Masa Corporal)\r\n" + //
                "3. Calcular descuento sobre un producto\r\n" + //
                "4. Verificar si un número es par o impar\r\n" + //
                "5. Simulación de cajero automático\r\n" + //
                "6. Salir ");
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            // Realizar operaciones matemáticas
            case 1:
                System.out.println("Introduzca la operacion matemática que quiera realizar");
                System.out.println("Pulsar:\nSuma: 0\nResta: 1\nMultiplicación: 2\nDivisión: 3");
                int operacion = scanner.nextInt();
                System.out.println("Introduzca los dos numeros, separados por espacios, que quieras operar");
                int numero1 = scanner.nextInt();
                int numero2 = scanner.nextInt();
                double resultado;
                switch (operacion) {
                    case 0:
                        resultado = numero1 + numero2;
                        System.out.println("El resultado es " + resultado);
                        break;
                    case 1:
                        resultado = numero1 - numero2;
                        System.out.println("El resultado es " + resultado);
                        break;
                    case 2:
                        resultado = numero1 * numero2;
                        System.out.println("El resultado es " + resultado);
                        break;
                    case 3:
                        resultado = numero1 / numero2;
                        System.out.println("El resultado es " + resultado);
                        break;
                    default:
                        break;
                }
                
                break;
            // Calcular el IMC
            case 2:
                break;
            // Calcular descuento sobre un producto
            case 3:
                break;
            // Verificar si un número es par o impar
            case 4:
                System.out.println("Introduzca un número: ");
                int nParImpar = scanner.nextInt();
                scanner.close();
                String parImparStr;
                if (nParImpar % 2 == 0) {
                    parImparStr = "";
                } else {
                    parImparStr = "im";
                }
                System.out.printf("\nEl número %2 es %spar", nParImpar, parImparStr);
                break;
            // Simulación de cajero automático
            case 5:
                break;
            // Salir
            case 6:
                System.out.println("Cerrando programa...");
                scanner.close();
                return;
            default:
                break;
        }
    }
}