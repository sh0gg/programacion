package ud7.pruebaExamen.notas;

import java.io.*;

/**
 * @author [Tu Nombre Completo]
 * Programa para leer notas de estudiantes, calcular promedio y escribir resultados.
 */
public class AppNotas {

    public static void main(String[] args) {
        String ficheroEntrada = "notas.txt";
        String ficheroSalida = "promedios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {

            String linea;
            boolean hayDatos = false;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                hayDatos = true;

                // Separar nombre y notas
                String[] partes = linea.split(",");
                if (partes.length < 2) {
                    System.out.println("Formato incorrecto en línea: " + linea);
                    continue;  // Saltar línea con error
                }

                String nombre = partes[0].trim();
                if (nombre.isEmpty()) {
                    System.out.println("Nombre vacío en línea: " + linea);
                    continue;
                }

                try {
                    // Parsear notas y calcular suma
                    double suma = 0;
                    int contador = 0;
                    for (int i = 1; i < partes.length; i++) {
                        double nota = Double.parseDouble(partes[i].trim());
                        suma += nota;
                        contador++;
                    }
                    double promedio = suma / contador;

                    // Escribir resultado en fichero
                    bw.write(nombre + ": " + promedio);
                    bw.newLine();

                } catch (NumberFormatException e) {
                    System.out.println("Error en formato de notas en línea: " + linea);
                }
            }

            if (!hayDatos) {
                System.out.println("El fichero está vacío.");
            } else {
                System.out.println("Proceso terminado. Resultados en " + ficheroSalida);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + ficheroEntrada + " no existe.");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura: " + e.getMessage());
        }
    }
}
