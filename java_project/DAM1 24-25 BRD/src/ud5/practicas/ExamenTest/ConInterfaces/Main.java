package ud5.practicas.ExamenTest.ConInterfaces;

public class Main {
    public static void main(String[] args) {
        String[] respuestas1 = {"Rojo", "Verde", "Azul"};
        String[] respuestas2 = {"Rojo", "Verde", "Azul"};
        String[] respuestas3 = {"Amarillo", "Verde", "Azul"};

        // Dos preguntas con mismo enunciado y mismas respuestas
        PreguntaOpcionMultiple p1 = new PreguntaOpcionMultiple("¿Cuál es el color del cielo?", respuestas1, 2);
        PreguntaOpcionMultiple p2 = new PreguntaOpcionMultiple("¿Cuál es el color del cielo?", respuestas2, 0);
        PreguntaOpcionMultiple p3 = new PreguntaOpcionMultiple("¿Cuál es el color del sol?", respuestas3, 0);

        // Comparaciones
        System.out.println("¿p1.equals(p2)? → " + p1.equals(p2)); // true (mismo enunciado + respuestas)
        System.out.println("¿p1.equals(p3)? → " + p1.equals(p3)); // false

        // Probar toString
        System.out.println("\nContenido de p1:");
        System.out.println(p1);

        // Probar corregir
        System.out.println("\n¿Es correcta la opción 2? " + p1.corregir(2)); // true
        System.out.println("¿Es correcta la opción 1? " + p1.corregir(1)); // false
    }
}

