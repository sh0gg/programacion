package ud2.ejerciciosbucles;


import java.util.*;

public class EP0305 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int respuesta = 1;
        int numero3 = 0;
        int numero1;
        int numero2;
        int aciertos = 0;

        System.out.printf("¡Vamos a ver que tal calculas!%n");
 
        do {

            numero1 = random.nextInt(100);
            numero2 = random.nextInt(100);
    
            numero3 = numero1 + numero2;

            System.out.printf("¡Suma %d con %d y escribe el resultado!%n", numero1, numero2);
            respuesta = scanner.nextInt();
            System.out.printf("¡%d es correcto! (%d + %d = %d) ¡Probemos con otro! %n%n", respuesta, numero1, numero2, numero3);
            aciertos ++;

        } while (numero3 == respuesta);

        System.out.printf("¡Te has equivocado! la respuesta de %d + %d era %d. No era %d... %n%n", numero1, numero2, numero3, respuesta);

        System.out.printf("¡Has acertado un total de %d veces! %n%n", aciertos);

        scanner.close();
    }
    
}
