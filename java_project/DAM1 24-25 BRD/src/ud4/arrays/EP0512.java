package ud4.arrays;

import java.util.Random;

public class EP0512 {
    public static void desordenar(int[] t) {
        Random random = new Random();
        for (int i = t.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = t[i];
            t[i] = t[j];
            t[j] = temp;
        }
    }
    
    public static int[] desordenarCopia(int[] t) {
        int[] copia = t.clone();
        desordenar(copia);
        return copia;
    }


}
