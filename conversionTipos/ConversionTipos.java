package conversionTipos;

public class ConversionTipos {

    public static void main(String[] args) {

        int a = 10;
        double b = a;

        System.out.println(b);

        // -------------------------------

        double x = 9.99;
        int y = (int) x;

        System.out.println(y);

        // --------------------------------

        short s = 5;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        System.out.println(d);

        // Multiplicamos por un número grande
        double resultado = d * 1e12;
        System.out.println("Resultado en double: " + resultado);
        // Cambiamos a int
        int convertido = (int) resultado;
        System.out.println("Resultado convertido a int: " + convertido);

        // --------------------------------

        int a1 = 5;
        int b2 = 2;
        double resultado1 = a1 / b2;
        System.out.println(resultado1);

        // Solucion

        int a3 = 5;
        int b4 = 2;
        double resultado2 = (double) a3 / b4; // Convertimos 'a' a double para que la operación sea en punto flotante
        System.out.println("Resultado con casting: " + resultado2);

        // Segunda división con variables de tipo double
        double x1 = 5.0;
        double y2 = 2.0;
        double resultadoDouble = x1 / y2;
        System.out.println("Resultado con double: " + resultadoDouble);

        // --------------------------------

        /*
         * Original
         * int x = 100;
         * double y = 20.5;
         * double resultado = x + y;
         */

        // Solución

        int x2 = 100;
        double y3 = 20.5;
        double resultadoDouble2 = x2 + y3;
        int resultadoEntero = (int) (x2 + y3); // Casting explícito de double a int
        System.out.println("Resultado double: " + resultadoDouble2);
        System.out.println("Resultado después del casting a int: " + resultadoEntero);

        // --------------------------------

        // --------------------------------

        // --------------------------------

        // --------------------------------

    }

}
