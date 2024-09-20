package identificadores;

public class Identificadores {
    public static void main(String[] args) {
        String phoneNumber = "900900900";
        double totalSales = 843.78;
        String myName = "David";

        boolean itsRaining = false;

        char favChar = 'B';

        byte age;
        age = 22;

        long hugeNum = 987987987987987879L;

        System.out.print("Numero de Teléfono: ");
        System.out.println(phoneNumber);

        System.out.println("Total ventas: " + totalSales);

        System.out.println("Me llamo " + myName);

        if (itsRaining) {
            System.out.println("Está lloviendo");
        }

        /*Me como los mocos*/

        System.out.println("Me quiero morir " + favChar);

        System.out.println("Edad: " + age);
        System.out.println("Número enorme: " + hugeNum);

    }
}
