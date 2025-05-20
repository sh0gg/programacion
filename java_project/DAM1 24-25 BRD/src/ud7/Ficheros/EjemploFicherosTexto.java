package ud7.Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploFicherosTexto {

    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

    public static void main(String[] args)  {
        try {

            BufferedReader br = new BufferedReader(new FileReader(PATH + "texto.txt"));
            String linea = br.readLine();

            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
