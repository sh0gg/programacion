package ud4.ArraysNumerados;

public class EjArrays04 {
    public static void main(String[] args) {

        int[] pares = new int[20];

        for (int i = 0; i < pares.length; i++) {
            pares[i] = i * 2; // Los números pares son múltiplos de 2
        }

        System.out.println("Los primeros 20 números pares son:");

        for (int num : pares) {
            System.out.print(num + " ");
        }
        
    }
}
