package ud2.ejerciciosfunciones;

import java.util.Scanner;

public class EP0414 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introduce los días: ");
        int dias = sc.nextInt();
        
        System.out.print("Introduce las horas: ");
        int horas = sc.nextInt();
        
        System.out.print("Introduce los minutos: ");
        int minutos = sc.nextInt();

        sc.close();
        
        int segundos = convertirASegundos(dias, horas, minutos);
        System.out.println("Total en segundos: " + segundos);
    }
    
    public static int convertirASegundos(int dias, int horas, int minutos) {
        return dias * 86400 + horas * 3600 + minutos * 60;
    }
}

