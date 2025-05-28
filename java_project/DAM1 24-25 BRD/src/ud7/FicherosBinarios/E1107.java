package ud7.FicherosBinarios;

import java.io.*;
import java.util.Scanner;

public class E1107 {
    public static void main(String[] args) {
        String ruta = "numeros.dat";

        // Guardamos los números introducidos por teclado
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(ruta))) {
            Scanner sc = new Scanner(System.in);
            int num;
            System.out.println("Introduce números (finaliza con -1):");

            while ((num = sc.nextInt()) != -1) {
                out.writeInt(num);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los números: " + e.getMessage());
        }
        

        // Leemos de numeros.dat y copiamos a numerosCopia.dat
        try (DataInputStream in = new DataInputStream(new FileInputStream(ruta));
             DataOutputStream outCopy = new DataOutputStream(new FileOutputStream("numerosCopia.dat"))) {

            System.out.println("Números leídos y copiados:");
            while (true) {
                int num = in.readInt();
                System.out.println(num);
                outCopy.writeInt(num);
            }

        } catch (EOFException eof) {
            System.out.println("Copia finalizada.");
        } catch (IOException e) {
            System.out.println("Error en la copia: " + e.getMessage());
        }
    }
}
