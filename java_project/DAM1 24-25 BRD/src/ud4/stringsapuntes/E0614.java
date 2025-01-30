package ud4.stringsapuntes;

import java.util.Random;
import java.util.Scanner;

public class E0614 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Dame una palabra: ");
        String solucion = sc.nextLine();

        String anagrama = scrambleWord(solucion);
        // Separación de solución con anagrama
        for (int i = 0; i < 100; i++) {
            System.out.println(" ");
        }
        System.out.println(anagrama);

        System.out.println("¿Cuál era la palabra original?");
        String respuesta = sc.nextLine();

        int fallos = 0;

        while (!respuesta.equalsIgnoreCase(solucion) && fallos < 3) {
            fallos++;
            System.out.println("¡La solución no es correcta! ¡Prueba de nuevo!");
            respuesta = sc.nextLine();
        }

        if (fallos == 3) {
            System.out.println("¡Has perdido! ¡La palabra era " + solucion + "!");
        }

        System.out.println("¡¡ENHORABUENA!! ¡¡HAS GANADO!!");
        
    }

    private static String scrambleWord(String str) {
        Random random = new Random();
        char[] auxiliar = str.toCharArray();
        for (int i = auxiliar.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = auxiliar[i];
            auxiliar[i] = auxiliar[j];
            auxiliar[j] = temp;
        }
        return new String(auxiliar);
    }

}
