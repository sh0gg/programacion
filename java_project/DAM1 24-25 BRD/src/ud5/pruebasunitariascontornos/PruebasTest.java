package ud5.pruebasunitariascontornos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PruebasTest {

    @Test
    public void testNumeroPerfecto6() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(6), "6 es un número perfecto");
    }

    @Test
    public void testNumeroPerfecto28() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(28), "28 es un número perfecto");
    }

    @Test
    public void testNumeroNoPerfecto() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(10), "10 no es un número perfecto");
    }

    @Test
    public void testNumeroNegativo() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(-6), "-6 no es un número perfecto");
    }

    @Test
    public void testCero() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(0), "0 es un número perfecto");
    }

    @Test
    public void testNumeroUno() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertFalse(prueba.esNumeroPerfecto(1), "1 no es un número perfecto");
    }

    @Test
    public void testNumeroGrande() {
        contornos.ud3.Pruebas prueba = new contornos.ud3.Pruebas();
        assertTrue(prueba.esNumeroPerfecto(496), "496 es un número perfecto");
    }
}