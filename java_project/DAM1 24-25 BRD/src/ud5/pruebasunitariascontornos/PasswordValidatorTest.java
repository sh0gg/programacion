package ud5.pruebasunitariascontornos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// POR CARLOS DE LA TORRE Y DAVID BESADA

class PasswordValidatorTest {

    @Test
    void noSuficientesLetras() {
        String password = "abcdef";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void noMayusNoNum() {
        String password = "abcdefgh";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void noNum() {
        String password = "Abcdefgh";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void noMayus() {
        String password = "abcd1234";
        assertFalse(PasswordValidator.isValid(password));
    }

    @Test
    void mayusAndNum() {
        String password = "Abcd1234";
        assertTrue(PasswordValidator.isValid(password));
    }


}