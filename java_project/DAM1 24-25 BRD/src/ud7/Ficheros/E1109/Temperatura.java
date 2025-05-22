package ud7.Ficheros.E1109;

/* E1109. Implementar un programa que registra la evolución temporal de la temperatura en
una ciudad. La aplicación mostrará un menú que permite añadir nuevos registros de
temperatura y mostrar el listado de todos los registros históricos. Cada registro constará
de la temperatura en grados centígrados, introducida por teclado, y la fecha y hora, que
se leerá del sistema en el momento de la creación del registro.
 */

public class Temperatura implements Serializable {
    double temperatura;
    LocalDateTime fecha;

    public Temperatura(double temperatura, LocalDateTime fecha) {
        this.temperatura = temperatura;
        this.fecha = fecha;
    }

    static final String PATH = "java_project/DAM1 24-25 BRD/src/ud7/Ficheros/registrosTemperaturas.dat";

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
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
                System.out.println("¿Quieres hacer algo más? (Y/N)");
                String res = sc.next();
                if (res.equalsIgnoreCase("Y")) {
                    System.out.println("\n");
                    menu();
                }
                break;
            case 2:
                List<Temperatura> registros = showRegister();
                System.out.println("Histórico de registros");
                System.out.println("======================");
                for (Temperatura temp : registros) {
                    System.out.println("El día " + temp.fecha.getDayOfMonth() + "/" + temp.fecha.getMonth() + "/" + temp.fecha.getYear()
                            + " hubo un registro de " + temp.temperatura + " grados.");
                }
                System.out.println("");
                System.out.println("¿Quieres hacer algo más? (Y/N)");
                res = sc.next();
                if (res.equalsIgnoreCase("Y")) {
                    System.out.println("\n");
                    menu();
                }
                break;
            case 3:
                break;
        }
    }

    private static void addRegister(double temp, LocalDateTime regTime) {
        File file = new File(PATH);
        boolean append = file.exists() && file.length() > 0;

        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = append
                     ? new ObjectOutputStream(fos) {
                         protected void writeStreamHeader() throws IOException {
                             // Evita volver a escribir la cabecera
                             reset();
                         }
                     }
                     : new ObjectOutputStream(fos)) {

            oos.writeObject(new Temperatura(temp, regTime));
            System.out.println("Registro agregado exitosamente");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
                    registros.add((Temperatura) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return registros;
    }
}