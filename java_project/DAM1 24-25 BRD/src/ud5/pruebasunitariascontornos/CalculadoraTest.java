package ud5.pruebasunitariascontornos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    @Test
    void testSuma() {
        double valorEsperado = 30;
        Calculadora calcu = new Calculadora(20, 10);
        double resultado = calcu.suma();
        assertEquals(valorEsperado, resultado, 0);
    }
    @Test
    void testResta() {
        double valorEsperado = 10;
        Calculadora calcu = new Calculadora(20, 10);
        double resultado = calcu.resta();
        assertEquals(valorEsperado, resultado, 0);
    }
    @Test
    void testMultiplica() {
        double valorEsperado = 200;
        Calculadora calcu = new Calculadora(20, 10);
        double resultado = calcu.multiplica();
        assertEquals(valorEsperado, resultado, 0);
    }
    @Test
    void testDivide() {
        double valorEsperado = 2;
        Calculadora calcu = new Calculadora(20, 10);
        double resultado = calcu.divide();
        assertEquals(valorEsperado, resultado, 0);
    }

}