package contornos.ud3.examenContornosUD3DavidBesada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN CONTORNOS UD3

class DiscountSystemTest {
    @Test
    void testNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountSystem.applyDiscount(-2.0, true);
        });
    }

    @Test
    void testCompraPequeNoLeal() {
        assertEquals(47.5, DiscountSystem.applyDiscount(50, false), 0.1);
    }

    @Test
    void testCompraPequeLeal() {
        assertEquals(90, DiscountSystem.applyDiscount(100, true), 0.1);
    }

    @Test
    void testCompraGrandeNoLeal() {
        assertEquals(170, DiscountSystem.applyDiscount(200, false), 0.1);
    }

    @Test
    void testCompraGrandeLeal() {
        assertEquals(170, DiscountSystem.applyDiscount(200, true), 0.1);
    }
}