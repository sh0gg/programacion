package ud5.practicas.ExamenTest;

public class Examen {
    private String titulo;
    private Pregunta[] preguntas;
    private int numPreguntas;

    // Constructor
    public Examen(String titulo) {
        this.titulo = titulo;
        this.preguntas = new Pregunta[10];
        this.numPreguntas = 0;
    }

    // Metodo para añadir una pregunta
    public void addPregunta(Pregunta pregunta) {
        for (int i = 0; i < numPreguntas; i++) {
            if (preguntas[i].equals(pregunta)) {
                System.out.println("La pregunta ya está en el examen.");
                return;
            }
        }
        if (numPreguntas >= preguntas.length) {
            // Aumentar el tamaño del array si es necesario
            Pregunta[] newPreguntas = new Pregunta[preguntas.length * 2];
            System.arraycopy(preguntas, 0, newPreguntas, 0, preguntas.length);
            preguntas = newPreguntas;
        }
        preguntas[numPreguntas++] = pregunta;
    }

    // Metodo para obtener el número de preguntas
    public int numPreguntas() {
        return numPreguntas;
    }

    // Metodo toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Examen: ").append(this.titulo).append("\n");
        for (int i = 0; i < numPreguntas; i++) {
            sb.append(i + 1).append(") ").append(preguntas[i].toString());
        }
        return sb.toString();
    }
}