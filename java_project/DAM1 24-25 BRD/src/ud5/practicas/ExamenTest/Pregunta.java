package ud5.practicas.ExamenTest;

public class Pregunta {
    private String enunciado;
    private String[] opciones;
    private int indiceCorrecta;

    public Pregunta(String enunciado, String[] opciones, int indiceCorrecta) {
        // Al menos dos opciones
        if (opciones.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos dos respuestas.");
        }
        // Sea diferente a las otras
        for (int i = 0; i < opciones.length; i++) {
            for (int j = i + 1; j < opciones.length; j++) {
                if (opciones[i].equals(opciones[j])) {
                    throw new IllegalArgumentException("Las opciones de respuesta deben ser únicas.");
                }
            }
        }
        if (indiceCorrecta < 0 || indiceCorrecta >= opciones.length) {
            throw new IllegalArgumentException("Índice de la respuesta correcta no válido.");
        }
        this.enunciado = enunciado;
        this.opciones = opciones;
        this.indiceCorrecta = indiceCorrecta;
    }

    // Metodo para corregir la respuesta
    public boolean corregir(int indiceElegido) {
        return indiceElegido == this.indiceCorrecta;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.enunciado).append("\n");
        char letra = 'a';
        for (int i = 0; i < opciones.length; i++) {
            sb.append(letra).append(") ").append(opciones[i]).append("\n");
            letra++;
        }
        return sb.toString();
    }

    // Metodo equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pregunta pregunta = (Pregunta) obj;
        return this.enunciado.equals(pregunta.enunciado) && this.opciones.equals(pregunta.opciones);
    }
}
