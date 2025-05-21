package ud7.Ficheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AP103 {
        static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/";

        public static void main(String[] args) {

            List<Jugador> jugadores = new ArrayList<Jugador>();

            try {

                BufferedReader br = new BufferedReader(new FileReader(PATH + "Jugadores.txt"));
                Scanner sc = new Scanner(br);

                while (sc.hasNextLine()) {
                    String nombre = sc.next();
                    int edad = sc.nextInt();
                    double estatura = sc.nextByte();
                    jugadores.add(new Jugador(nombre,edad,estatura));
                }

                br.close();
                sc.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

}
class Jugador {
    String nombre;
    int edad;
    double estatura;

    public Jugador(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + "]";
    }
}



