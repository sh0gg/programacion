package ud7.DBRexamen.web;

// AUTOR: DAVID BESADA RAMILO
// EXAMEN PROG UD7 - DAM1
// FECHA: 28/05/2025

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LogApache {

    public static void main(String[] args) {
        int accesos = 0;
        int accesosIncorrectos = 0;
        Map<String,Integer> ips = new TreeMap<>();

        String ruta = "ud7/DBRexamen/web/bacharelato_access.log"; // Ruta relativa al archivo

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                accesos++;
                if (linea.contains(" 404 ")) {
                    accesosIncorrectos++;
                }
                String[] cortesAccesos = linea.split(" ");

                if (ips.containsKey(cortesAccesos[0])) {
                    ips.put(cortesAccesos[0], ips.get(cortesAccesos[0]) + 1);
                } else {
                    ips.put(cortesAccesos[0], 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("Accesos de la aplicacion: " + accesos);
        System.out.println("Accesos fallidos: " + accesosIncorrectos);

        // no tengo ni idea de como ordenar un mapa por los valores de sus claves
        ips.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });

    }
}
