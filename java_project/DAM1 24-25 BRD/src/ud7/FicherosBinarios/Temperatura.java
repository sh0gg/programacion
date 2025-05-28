package ud7.FicherosBinarios;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// Clase que representa un registro de temperatura con fecha y hora
public class Temperatura implements Serializable {
    double temperatura;
    LocalDateTime fecha;

    public Temperatura(double temperatura, LocalDateTime fecha) {
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    // Ruta del archivo binario donde se almacenarán los registros
    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/registrosTemperaturas.dat";

    public static void main(String[] args) {
        menu(); // Iniciamos el menú interactivo
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================");
            System.out.println("     REGISTRO DE TEMPERATURAS");
            System.out.println("==============================");
            System.out.println("1. Añadir un registro.");
            System.out.println("2. Mostrar registros.");
            System.out.println("3. Salir.");
            System.out.print("Selecciona una opción: ");

            int opcion;
            try {
                opcion = sc.nextInt(); // Leer opción numérica
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Introduce un número.");
                sc.nextLine(); // Limpiar buffer del scanner
                continue;
            }

            switch (opcion) {
                case 1:
                    sc.nextLine(); // Limpiar buffer
                    System.out.print("¿Qué temperatura hace? ");
                    String tempStr = sc.nextLine().replace(",", ".");
                    try {
                        double temperatura = Double.parseDouble(tempStr);
                        addRegister(temperatura, LocalDateTime.now()); // Guardamos registro con la fecha actual
                        System.out.println("Registro guardado.");
                    } catch (NumberFormatException e) {
                        System.out.println("Temperatura no válida.");
                    }
                    break;

                case 2:
                    List<Temperatura> registros = showRegister(); // Leer registros desde el archivo
                    System.out.println("\n HISTÓRICO DE REGISTROS");
                    System.out.println("==============================");
                    if (registros.isEmpty()) {
                        System.out.println("No hay registros guardados.");
                    } else {
                        for (Temperatura temp : registros) {
                            System.out.printf("%02d/%s/%d - %.2f ºC%n",
                                    temp.fecha.getDayOfMonth(),
                                    temp.fecha.getMonth(),
                                    temp.fecha.getYear(),
                                    temp.temperatura);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para guardar un nuevo registro en el archivo binario
    private static void addRegister(double temp, LocalDateTime regTime) {
        File file = new File(PATH);
        boolean append = file.exists() && file.length() > 0;

        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = append
                     ? new ObjectOutputStream(fos) {
                         // Sobrescribimos el encabezado solo si el archivo ya existe
                         protected void writeStreamHeader() throws IOException {
                             reset(); // Evita que se escriba una nueva cabecera binaria
                         }
                     }
                     : new ObjectOutputStream(fos)) {

            oos.writeObject(new Temperatura(temp, regTime)); // Guardamos el objeto
            System.out.println("Registro agregado exitosamente");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Método para leer todos los registros del archivo
    private static List<Temperatura> showRegister() {
        List<Temperatura> registros = new ArrayList<>();
        File file = new File(PATH);

        if (!file.exists()) {
            System.out.println("No hay registros aún.");
            return registros;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            while (true) {
                try {
                    registros.add((Temperatura) ois.readObject()); // Leemos objetos hasta EOF
                } catch (EOFException e) {
                    break; // Fin del archivo
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Imprimimos el error si hay problemas
        }

        return registros;
    }
}
