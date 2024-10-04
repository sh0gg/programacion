package ud1.exercicios.dbr20241004;

/*EP0123_ConversionMasa. Escribe un programa que convierta unidades de masa entre kilogramos y libras o viceversa. El programa solicitará al usuario la cantidad de masa y la unidad de medida origen (kilogramos o libras).
1 kilogramo = 1000 gramos
1 libra = 453.592 gramos
El programa deberá manejar las conversiones automáticamente y mostrar el resultado al usuario. Utiliza el operador ternario para evaluar la unidad de medida introducida por el usuario. El programa mostrará por pantalla el resultado con la unidad de medida adecuada.
 */

import java.util.Scanner;

public class EP0123_ConversionMasa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cantidad;
        String unidad;
        final double gPerKilo = 1000.0;
        final double gPerLb = 453.592;

        System.out.print("Introduce la cantidad de masa: ");
        cantidad = scanner.nextDouble();

        System.out.print("Introduce la unidad de medida (kg o lb): ");
        unidad = scanner.next().toLowerCase();


        double resultado = unidad.equals("kg") 
                           ? cantidad * gPerKilo / gPerLb // De kg a lb
                           : cantidad * gPerLb / gPerKilo; // De lb a kg

        String unidadResultado = unidad.equals("kg") ? "lb" : "kg";

        System.out.printf("%.2f %s son %.2f %s%n", cantidad, unidad, resultado, unidadResultado);
    
        scanner.close();
    }
}
