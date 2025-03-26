package contornos.ud3.examenContornosUD3DavidBesada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN CONTORNOS UD3

class EmailValidatorTest {
    @Test
    void esValido() {
        assertEquals(true,EmailValidator.isValid("test@gmail.com"));
    }

    @Test
    void esNullOrEmpty() {
        assertEquals(false,EmailValidator.isValid(""));
    }

    @Test
    void tieneDosArrobas() {
        assertEquals(false,EmailValidator.isValid("test@@gmail.com"));
    }

    @Test
    void noTieneArrobas() {
        assertEquals(false,EmailValidator.isValid("testgmail.com"));
    }

    @Test
    void noTienePunto() {
        assertEquals(false,EmailValidator.isValid("test@gmailcom"));
    }

    @Test
    void tieneUser() {
        assertEquals(false,EmailValidator.isValid("@gmail.com"));
    }

}