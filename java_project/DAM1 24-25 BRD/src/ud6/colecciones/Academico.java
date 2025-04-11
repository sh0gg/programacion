package ud6.colecciones;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class Academico implements Comparable<Academico> {

    /**
     * Lee y carga el contenido de un fichero de texto a un String (fuente OpenAI)
     *
     * @param filePath Ruta del fichero
     * @return Contenido del fichero como un String
     */
    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            // Creamos un objeto FileReader que nos permitirá leer el fichero
            FileReader reader = new FileReader(filePath);

            // Creamos un buffer para leer el fichero de forma más eficiente
            BufferedReader buffer = new BufferedReader(reader);

            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }

            // Cerramos el buffer y el fichero
            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
            // e.printStackTrace();
        }

        // Devolvemos el contenido del fichero como un String
        return fileContent.toString();
    }

    private String nombre;
    private Integer anoIngreso;

    Academico(String nombre, Integer anoIngreso) {
        this.nombre = nombre;
        this.anoIngreso = anoIngreso;
    }

    @Override
    public String toString() {
        return nombre + " (" + anoIngreso + ")";
    }

    @Override
    public int compareTo(Academico o) {
        return this.nombre.compareTo(o.nombre);
    }


    static boolean nuevoAcademico(Map<Character, Academico> academia, Academico
            nuevo, Character letra) {
        if (academia != null || nuevo != null || letra != null) {
            academia.put(letra, nuevo);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String contenidoFichero = readFileToString("java_project/DAM1 24-25 BRD/src/ud6/colecciones/academicos.txt");
        String[] lineas = contenidoFichero.split("\\n");

        HashMap<Character, Academico> academia = new HashMap<>();

        for (int i = 0; i < lineas.length; i++) {
            Character letra = lineas[i].charAt(6);
            String nombre = lineas[i].substring(7, lineas[i].length() - 6);
            Integer ano = Integer.parseInt(lineas[i].substring(lineas[i].length() - 5, lineas[i].length() - 1));
            nuevoAcademico(academia, new Academico(nombre, ano), letra);
        }

        System.out.println(academia);

        System.out.println("\nSin letra, por orden de nombre");
        System.out.println("=================================\n");
        List<Academico> lista = new ArrayList<>(academia.values());
        Collections.sort(lista);
        for (Academico academico : lista) {
            System.out.println(academico);
        }

        System.out.println("\nSin letra, por orden de año de ingreso, en caso de empate, por nombre");
        System.out.println("=======================================================================\n");
        lista.sort(new Comparator<Academico>() {
            @Override
            public int compare(Academico o1, Academico o2) {
                int res = o1.anoIngreso - o2.anoIngreso;
                if (res == 0) {
                    res = o1.nombre.compareTo(o2.nombre);
                }
                return res;
            }
        });

        for (Academico academico : lista) {
            System.out.println(academico);
        }

        System.out.println("\nOrdenados por la letra de su sillón");
        System.out.println("=====================================\n");
        Set<Character> letras = academia.keySet();

        for (Character letra : letras) {
            Academico academico = academia.get(letra);
            System.out.println(letra + " - " + academico);
        }

    }

}
