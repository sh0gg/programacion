package ud5.pruebasunitariascontornos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    @Test
    void testUno() {
        int valor = 1;
        int resultado = MathUtils.factorial(valor);
        int valorEsperado = 1;
        assertEquals(valorEsperado, resultado);
    }

    @Test
    void testCinco() {
        int valor = 5;
        int resultado = MathUtils.factorial(valor);
        int valorEsperado = 120;
        assertEquals(valorEsperado, resultado);
    }

    @Test
    void testCuatro() {
        int valor = 4;
        int resultado = MathUtils.factorial(valor);
        int valorEsperado = 24;
        assertEquals(valorEsperado, resultado);
    }

    @Test
    void testNegativo() {
        int valor = -10;
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(valor);
        });
        String mensajeEsperado = "El número debe ser positivo";
        String mensajeReal = excepcion.getMessage();

        assertTrue(mensajeReal.contains(mensajeEsperado),
        "El mensaje de excepción no coincide con el esperado");
    }


}