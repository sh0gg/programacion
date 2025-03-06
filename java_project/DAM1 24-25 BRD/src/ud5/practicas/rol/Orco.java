package ud5.practicas.rol;

import java.util.Random;

public class Orco extends Monstruo {
    public Orco(String nombre) {
        super(nombre, generar(30, 80), generar(30, 50), generar(30, 60), generar(30, 100));
    }

    // Método auxiliar para generar valores aleatorios dentro de un rango
    private static int generar(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
