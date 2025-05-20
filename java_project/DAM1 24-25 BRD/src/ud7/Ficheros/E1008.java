package ud7.Ficheros;

import java.io.*;
import java.util.Scanner;

public class E1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del archivo a duplicar: ");
        String original = sc.nextLine();

        String copia = "copia_de_" + original;

        try (BufferedReader br = new BufferedReader(new FileReader(original));
             BufferedWriter bw = new BufferedWriter(new FileWriter(copia))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Archivo duplicado como: " + copia);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
