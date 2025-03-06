package ud5.practicas.rol;

import java.util.Random;

public class Troll extends Monstruo {
    public Troll(String nombre) {
        super(nombre, generar(60, 120), generar(50, 70), generar(20, 40), generar(100, 200));
    }

    // Método auxiliar para generar valores aleatorios dentro de un rango
    private static int generar(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
