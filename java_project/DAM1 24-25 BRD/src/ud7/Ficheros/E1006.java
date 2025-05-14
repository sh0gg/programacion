package ud7.Ficheros;

import java.io.*;
import java.util.Scanner;

public class E1006 {
    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

    public static void main(String[] args) {
        int suma = 0;
        try {

            BufferedReader br = new BufferedReader(new FileReader(PATH + "Enteros.txt"));
            Scanner sc = new Scanner(br);

            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                suma += num;
            }

            br.close();
            sc.close();

            System.out.println("Suma: " + suma);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
