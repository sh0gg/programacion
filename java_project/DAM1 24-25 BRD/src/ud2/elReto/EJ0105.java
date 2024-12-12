package ud2.elReto;

import java.util.Scanner;

public class SumaDeDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de entrada
            int numero = scanner.nextInt();
            if (numero < 0) {
                break; // Terminar si el número es negativo
            }

            // Convertir el número a cadena para procesar cada dígito
            String numeroStr = String.valueOf(numero);
            int suma = 0;
            StringBuilder resultado = new StringBuilder();

            // Iterar sobre cada carácter de la cadena
            for (int i = 0; i < numeroStr.length(); i++) {
                // Obtener el dígito como entero
                int digito = Character.getNumericValue(numeroStr.charAt(i));
                suma += digito;

                // Añadir el dígito al resultado
                resultado.append(digito);

                // Añadir el signo '+' si no es el último dígito
                if (i < numeroStr.length() - 1) {
                    resultado.append(" + ");
                }
            }

            // Añadir el resultado de la suma
            resultado.append(" = ").append(suma);

            // Imprimir el resultado
            System.out.println(resultado.toString());
        }
    }
}
