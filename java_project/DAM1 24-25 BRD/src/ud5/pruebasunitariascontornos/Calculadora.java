package ud5.pruebasunitariascontornos;

import org.junit.jupiter.api.Test;

public class Calculadora {
    private int num1;
    private int num2;
    public Calculadora(int a, int b) {
        num1 = a;
        num2 = b;
    }
    public int suma() {
        return num1 + num2;
    }
    public int resta() {
        return num1 - num2;
    }
    public int multiplica() {
        return num1 * num2;
    }
    public int divide() {
        return num1 / num2;
    }
}


