package ud4.ArraysNumerados;

import java.util.Scanner;

public class EjArrays08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[20];
        double[] sueldos = new double[20];
        int indiceMayor = 0;

        for (int i = 0; i < 20; i++) {
            System.out.print("Introduce el nombre del empleado " + (i + 1) + ":");
            nombres[i] = sc.next();
            System.out.print("Introduce el sueldo del empleado " + (i + 1) + ":");
            sueldos[i] = sc.nextDouble();
            if (sueldos[i] > sueldos[indiceMayor]) {
                indiceMayor = i;
            }
        }
        
        sc.close();

        System.out.println("El empleado que más gana es " + nombres[indiceMayor]
                + " con un sueldo de " + sueldos[indiceMayor]);
    }
}
