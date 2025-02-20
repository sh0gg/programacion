package ud5.clasesejercicios.E080123;

public class TestHoras {
    public static void main(String[] args) {
        // Prueba de la clase Hora
        System.out.println("h1 es igual a 23:59");
        Hora h1 = new Hora(23, 59);
        System.out.println(h1); // 23:59
        h1.inc();
        System.out.println(h1); // 00:00

        // Prueba de la clase HoraExacta
        System.out.println("h2 es igual a 12:30:59");
        HoraExacta h2 = new HoraExacta(12, 30, 59);
        System.out.println(h2); // 12:30:59
        h2.inc();
        System.out.println(h2); // 12:31:00

        // Comparación de dos horas exactas
        System.out.println("h3 es igual a 12:31:00. ¿Es igual a h2? Respuesta:");
        HoraExacta h3 = new HoraExacta(12, 31, 0);
        System.out.println(h2.equals(h3)); // true
    }
}

