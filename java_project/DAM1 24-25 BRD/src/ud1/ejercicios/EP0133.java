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
