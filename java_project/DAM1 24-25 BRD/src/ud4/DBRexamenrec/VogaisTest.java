package ud4.DBRexamenrec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VogaisTest {
    @Test
    public void testCambiaVogais() {
        String str = "Programar en Java";
        String stro = "Prigrimir in Jivi";
        char v = 'i';
        assertEquals(stro, Vogais.cambiaVogais(str, v));


        str = "Programar en JAVA";
        stro = "Prigrimir in JIVI";
        v = 'i';
        //assertEquals(stro, App.cambiaVogais(str, v));


        str = "1230981239CDFRTGHYNMBVC";
        stro = "1230981239CDFRTGHYNMBVC";
        v = 'i';
        assertEquals(stro, Vogais.cambiaVogais(str, v));
    }
}