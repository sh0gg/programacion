package ud2.ejercicioscondicionales;

public class EP0411 {
    public static int mcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        if (a >= b) {
            return mcd(a - b, b);
        } else {
            return mcd(a, b - a);
        }

    }

    public static void main(String[] args) {

        int a = 56;
        int b = 12;
        
        System.out.println("El MCD de " + a + " y " + b + " es: " + mcd(a, b));

    }
}
