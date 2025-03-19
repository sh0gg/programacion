package ud5.practicas.praiasdegalicia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class Util {
    /**
     * Importa un array de Praias desde un fichero JSON
     * 
     * @param fichero Ruta del fichero JSON
     * @return Array de Praias
     */
    public static Praia[] importarPraias(String fichero) {
        Gson gson = new Gson();
        String json = Util.readFileToString(fichero);

        // Verificar si json es null o vacío
        if (json == null || json.isEmpty()) {
            System.out.println("Error: El archivo no se pudo leer o está vacío.");
            return null; // Retorna null si no se pudo leer el archivo
        }

        // Deserialización del JSON
        Praia[] praias = gson.fromJson(json, Praia[].class);

        // Verificación de la deserialización
        if (praias == null || praias.length == 0) {
            System.out.println("Error: El archivo no contiene datos válidos o el formato es incorrecto.");
            return null; // Retorna null si el array de praias está vacío o inválido
        }

        return praias;
    }

    /**
     * Lee y carga el contenido de un fichero de texto a un String (fuente OpenAI)
     * 
     * @param filePath Ruta del fichero
     * @return Contenido del fichero como un String
     */
    public static String readFileToString(String filePath) {
        System.out.println("Leyendo archivo desde: " + filePath); // Agregar mensaje de depuración
        StringBuilder fileContent = new StringBuilder();
        
        try {
            // Intentar leer el archivo
            FileReader reader = new FileReader(filePath);
            BufferedReader buffer = new BufferedReader(reader);
            
            String line;
            while ((line = buffer.readLine()) != null) {
                fileContent.append(line);
                fileContent.append("\n");
            }
    
            buffer.close(); // Cerramos el buffer y el lector
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: No existe el fichero o no se puede leer.");
    
            // Si el archivo no existe, lo creamos en el mismo directorio
            try {
                System.out.println("Creando el archivo " + filePath);
                File file = new File(filePath);
                // Si no existe, lo creamos
                if (file.createNewFile()) {
                    System.out.println("Archivo creado: " + file.getName());
                } else {
                    System.out.println("El archivo ya existe.");
                }
            } catch (IOException ex) {
                System.out.println("No se pudo crear el archivo.");
                ex.printStackTrace();
            }
    
            // Imprime el detalle del error
            e.printStackTrace();
        }
    
        return fileContent.toString();
    }
    

    /**
     * Calcula la distancia en metros entre dos puntos geográficos
     * 
     * @param lat1 Latitud del punto 1
     * @param lon1 Longitud del punto 1
     * @param lat2 Latitud del punto 2
     * @param lon2 Longitud del punto 2
     * @return distancia en metros
     */
    public static double distancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2)
                        * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000;
        distance = Math.pow(distance, 2);
        return Math.sqrt(distance);
    }

}
