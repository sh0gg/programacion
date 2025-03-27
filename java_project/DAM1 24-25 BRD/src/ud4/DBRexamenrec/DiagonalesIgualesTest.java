package ud4.DBRexamenrec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagonalesIgualesTest {
    @Test
    public void testDiagonalesIguales() {
        int[][] t21 = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        int[][] t22 = {{1}};
        int[][] t23 = {};
        int[][] t24 = null;
        int[][] t25 = {
                {1, 2, 1},
                {1, 2, 3},
                {1, 2, 3}
        };
        int[][] t26 = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };

        assertTrue(DiagonalesIguales.diagonalesIguales(t21));
        assertTrue(DiagonalesIguales.diagonalesIguales(t22));
        assertFalse(DiagonalesIguales.diagonalesIguales(t23));
        assertFalse(DiagonalesIguales.diagonalesIguales(t24));
        assertFalse(DiagonalesIguales.diagonalesIguales(t25));
        assertFalse(DiagonalesIguales.diagonalesIguales(t26));
    }
}