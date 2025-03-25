package ud5.practicas.ExamenTest.ConInterfaces;

import java.util.Arrays;

public class PreguntaOpcionMultiple implements PreguntaTest {

    private String enunciado;
    private String[] respuestas;
    private int correcta;

    public PreguntaOpcionMultiple(String enunciado, String[] respuestas, int correcta) {
        if (respuestas == null || respuestas.length < 2) throw new IllegalArgumentException("Mínimo 2 respuestas");
        if (correcta < 0 || correcta >= respuestas.length) throw new IllegalArgumentException("Índice fuera de rango");

        this.enunciado = enunciado;
        this.respuestas = respuestas;
        this.correcta = correcta;
    }

    @Override
    public boolean corregir(int opcion) {
        return opcion == correcta;
    }

    @Override
    public String getEnunciado() {
        return enunciado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(enunciado);
        for (int i = 0; i < respuestas.length; i++) {
            sb.append(String.format("\n%c) %s", 'a' + i, respuestas[i]));
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PreguntaOpcionMultiple)) return false;
        PreguntaOpcionMultiple other = (PreguntaOpcionMultiple) o;
        return enunciado.equals(other.enunciado) && Arrays.deepEquals(respuestas, other.respuestas);
    }
}

