package ud4.stringsapuntes;

import java.util.Scanner;

public class E0605 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a darle la vuelta a una cadena!!");
        String frase = sc.nextLine();
        sc.close();

        String auxiliar = "";

        for (int i = frase.length() - 1; i > -1; i--) {
            auxiliar += frase.charAt(i);
        }
        System.out.println("La cadena al revés es " + auxiliar);

        if (auxiliar.equalsIgnoreCase(frase)) {
            System.out.println("¡¡WOW!! ¡¡ESTA CADENA ES UN PALÍNDROMO!!");
        }

    }
    
}
