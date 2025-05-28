package ud7.Ficheros;

import java.io.*;
import java.util.Scanner;

public class E1006 {
    // Constante con la ruta base del archivo (ajústala según tu estructura de carpetas)
    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

    public static void main(String[] args) {
        int suma = 0;         // Acumulador de la suma de enteros válidos
        int contador = 0;     // Contador de enteros válidos
        int errores = 0;      // Contador de datos no enteros (errores)

        try {
            // Abrimos el archivo para lectura con un BufferedReader (eficiente para texto)
            BufferedReader br = new BufferedReader(new FileReader(PATH + "Enteros.txt"));
            // Usamos Scanner sobre el BufferedReader para poder analizar token a token
            Scanner sc = new Scanner(br);

            // Procesamos cada token del archivo
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    // Si el token es un número entero válido, lo leemos y sumamos
                    int num = sc.nextInt();
                    suma += num;
                    contador++;
                } else {
                    // Si el token no es un entero, lo leemos igualmente para descartarlo
                    String invalido = sc.next();
                    System.out.println("Dato no entero encontrado: \"" + invalido + "\"");
                    errores++; // Contabilizamos el error
                }
            }

            // Cerramos los recursos (buena práctica aunque Scanner ya se auto-cierra en try-with-resources)
            br.close();
            sc.close();

            // Calculamos la media, solo si hemos leído al menos un número válido
            double media = (contador > 0) ? (double) suma / contador : 0;

            // Mostramos los resultados por consola
            System.out.println("Suma: " + suma);
            System.out.println("Media: " + media);
            System.out.println("Datos no enteros ignorados: " + errores);

        } catch (FileNotFoundException e) {
            // Se lanza si el archivo no se encuentra en la ruta especificada
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            // Se lanza si hay un error de entrada/salida al trabajar con el archivo
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}

