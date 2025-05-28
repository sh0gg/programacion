package ud7.FicherosBinarios;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class E1103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la cantidad de números aleatorios: ");
        int n = sc.nextInt();
        
        sc.close();
        
        double[] numeros = new double[n];
        Random rand = new Random();

        // Generamos los números aleatorios
        for (int i = 0; i < n; i++) {
            numeros[i] = rand.nextDouble() * 100;
        }

        // Guardamos el array
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("aleatorios.dat"))) {
            out.writeObject(numeros);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }

        // Leemos el array y lo mostramos
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("aleatorios.dat"))) {
            double[] leidos = (double[]) in.readObject();
            System.out.println("Números leídos:");
            for (double d : leidos) {
                System.out.println(d);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
    }
}
