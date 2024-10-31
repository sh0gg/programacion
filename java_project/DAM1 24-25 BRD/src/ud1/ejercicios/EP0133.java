package ud1.ejercicios;

/*EP0133_ConversionAlmacenamientoDatos
Desarrolla un programa en Java que convierta unidades de almacenamiento entre bytes,
kilobytes (KB), megabytes (MB) y gigabytes (GB). Solicita al usuario la cantidad de datos y
la unidad de origen y destino.
● 1 KB = 1024 bytes
● 1 MB = 1024 KB
● 1 GB = 1024 MB
El programa deberá realizar la conversión correspondiente y mostrar el resultado.
 */

import java.util.Scanner;

public class EP0133 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce la cantidad de datos:");
        double cantidad = scanner.nextDouble();
        
        System.out.println("Introduce la unidad de entrada (KB, MB, GB):");
        String unidadEntrada = scanner.next().toLowerCase();
        
        System.out.println("Introduce la unidad de salida (KB, MB, GB):");
        String unidadSalida = scanner.next().toLowerCase();
    

        double cantidadEnBytes = unidadEntrada.equals("kb") 
            ? cantidad * 1024 
            : unidadEntrada.equals("mb") 
                ? cantidad * 1024 * 1024 
                : unidadEntrada.equals("gb") 
                    ? cantidad * 1024 * 1024 * 1024 
                    : -1;
                        
        
        double resultado = unidadSalida.equals("kb") 
            ? cantidadEnBytes / 1024 
            : unidadSalida.equals("mb") 
                ? cantidadEnBytes / (1024 * 1024) 
                : unidadSalida.equals("gb") 
                    ? cantidadEnBytes / (1024 * 1024 * 1024) 
                    : -1;
        
        // Verificar si se ha introducido una unidad no válida
        if (cantidadEnBytes == -1 || resultado == -1) {
            System.out.println("Unidad de entrada o salida no válida.");
        } else {
            // Mostrar el resultado
            System.out.println("El resultado es: " + resultado + " " + unidadSalida);
        }
        
        scanner.close();
    }
}
/*


import java.util.Scanner;

public class EP0133 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String unidadEntrada;
        String unidadSalida;
        double cantidad;
    
        double operacion = unidadEntrada.equals("kb") 
        ? (double) operacion = unidadSalida.equals("kb") 
            ? cantidad * 1
            : (double) operacion = unidadSalida.equals("mb")
                ? cantidad * 1000
                : (double) operacion = unidadSalida.equals("gb")
                    ? cantidad * 1000 * 1000
                    : cantidad * 0 
        : cantidad * 0;


        scanner.close();
    }
}
*/