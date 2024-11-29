package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0415 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce la primera hora (0-23): ");
        int hora1 = sc.nextInt();
        System.out.print("Introduce los minutos de la primera hora (0-59): ");
        int minuto1 = sc.nextInt();
        
        System.out.print("Introduce la segunda hora (0-23): ");
        int hora2 = sc.nextInt();
        System.out.print("Introduce los minutos de la segunda hora (0-59): ");
        int minuto2 = sc.nextInt();

        sc.close();
        
        int diferencia = diferenciaMin(hora1, minuto1, hora2, minuto2);
        System.out.println("La diferencia en minutos es: " + diferencia);
    }
    
    public static int diferenciaMin(int hora1, int minuto1, int hora2, int minuto2) {
        int totalMin1 = hora1 * 60 + minuto1;
        int totalMin2 = hora2 * 60 + minuto2;
        return Math.abs(totalMin2 - totalMin1);
    }
}

