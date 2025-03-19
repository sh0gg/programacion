package ud5.practicas.ExamenTest;

public class App {
    // Metodo principal
    public static void main(String[] args) {
        // Crear algunas preguntas
        Pregunta p1 = new Pregunta("¿Cuál es la capital de Francia?", new String[]{"Berlin", "Madrid", "Paris", "Roma"}, 2);
        Pregunta p2 = new Pregunta("¿Cuánto es 2 + 2?", new String[]{"3", "4", "5", "6"}, 1);

        // Crear un examen y añadir preguntas
        Examen examen = new Examen("Examen de Geografía y Matemáticas");
        examen.addPregunta(p1);
        examen.addPregunta(p2);

        // Mostrar el examen
        System.out.println(examen.toString());

        // Comprobar la corrección de una respuesta
        System.out.println("Respuesta correcta para la pregunta 1 (Elegir 'c') : " + p1.corregir(2));
    }
}
