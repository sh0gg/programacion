package ud4.DBRexamenrec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumasTest {
    @Test
    public void testSumas() {
        int[] t1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ts1 = {55, 30, 25};
        int[] t2 = {1};
        int[] ts2 = {1, 0, 1};
        int[] t3 = {};
        int[] ts3 = {0, 0, 0};
        int[] t4 = null;
        int[] ts4 = null;

        assertArrayEquals(ts1, Sumas.sumas(t1));
        assertArrayEquals(ts2, Sumas.sumas(t2));
        assertArrayEquals(ts3, Sumas.sumas(t3));
        assertArrayEquals(ts4, Sumas.sumas(t4));

    }

}