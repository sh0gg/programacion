package ud5.practicas.ExamenTest.ConInterfaces;

import java.util.LinkedHashSet;
import java.util.Set;

public class Examen {

    private String titulo;
    private Set<PreguntaTest> preguntas;

    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new LinkedHashSet<>();
    }

    public boolean addPregunta(PreguntaTest p) {
        return preguntas.add(p); // No añade si ya existe (depende de equals)
    }

    public int numPreguntas() {
        return preguntas.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(titulo + "\n");
        int num = 1;
        for (PreguntaTest p : preguntas) {
            sb.append(num++).append(". ").append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
