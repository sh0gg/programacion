package contornos.ud3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeClassifierTest {

    @Test
    void testInfantil() {
        assertEquals("Infantil", AgeClassifier.classify(5));
    }

    @Test
    void testAdolescente() {
        assertEquals("Adolescente", AgeClassifier.classify(15));
    }

    @Test
    void testAdulto() {
        assertEquals("Adulto", AgeClassifier.classify(30));
    }

    @Test
    void testSenior() {
        assertEquals("Senior", AgeClassifier.classify(70));
    }

    @Test
    void testEdadInvalidaNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            AgeClassifier.classify(-5);
        });
    }
    @Test
    void testEdadInvalidaMayorA120() {
        assertThrows(IllegalArgumentException.class, () -> {
            AgeClassifier.classify(130);
        });
    }
}
