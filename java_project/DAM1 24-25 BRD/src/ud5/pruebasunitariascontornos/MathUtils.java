package ud5.pruebasunitariascontornos;

public class MathUtils {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        } // 2


        int resultado = 1; // 3
        for (int i = 1; i <= n; i++) { 
            resultado *= i;
        } // 4
        return resultado; // 5
    }
}
