package ud5.pruebasunitariascontornos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PruebasTest {

    @Test
    public void testNumeroPerfecto6() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(6), "6 es un número perfecto");
    }

    @Test
    public void testNumeroPerfecto28() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(28), "28 es un número perfecto");
    }

    @Test
    public void testNumeroNoPerfecto() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(10), "10 no es un número perfecto");
    }

    @Test
    public void testNumeroNegativo() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(-6), "-6 no es un número perfecto");
    }

    @Test
    public void testCero() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(0), "0 es un número perfecto");
    }

    @Test
    public void testNumeroUno() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(1), "1 no es un número perfecto");
    }

    @Test
    public void testNumeroGrande() {
        ud5.pruebasunitariascontornos.Pruebas prueba = new ud5.pruebasunitariascontornos.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(496), "496 es un número perfecto");
    }
}