package ud7.Ficheros.E1109;

/* E1109. Implementar un programa que registra la evolución temporal de la temperatura en
una ciudad. La aplicación mostrará un menú que permite añadir nuevos registros de
temperatura y mostrar el listado de todos los registros históricos. Cada registro constará
de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora, que
se leerá del sistema en el momento de la creación del registro.
 */

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temperatura implements Serializable{
    double temperatura;
    LocalDateTime fecha;

    public Temperatura(double temperatura, LocalDateTime fecha) {
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/registrosTemperaturas.dat";

    public static void main(String[] args) {
        System.out.println("Registro de temperaturas");
        System.out.println("");
        System.out.println("1. Añadir un registro.");
        System.out.println("2. Mostrar registros.");
        System.out.println("3. Salir.");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("¿Qué temperatura hace?");
                double temperatura = sc.nextDouble();
                addRegister(temperatura, LocalDateTime.now());
                break;
            case 2:
                List<Temperatura> registros = showRegister();
                for (Temperatura temp : registros) {
                    System.out.println(temp);
                }
                break;
            case 3:
                break;
        }
    }

    private static void addRegister(double temp, LocalDateTime regTime) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH))) {
            out.writeObject(new Temperatura(temp, regTime));
            System.out.println("Registro agregado exitosamente");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Temperatura> showRegister() {
        List<Temperatura> registros = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            while (true) {
                registros.add((Temperatura) ois.readObject());
            }
        } catch (EOFException | FileNotFoundException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return registros;
    }
}

