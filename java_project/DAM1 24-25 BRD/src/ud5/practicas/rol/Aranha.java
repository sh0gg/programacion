package ud5.practicas.rol;

import java.util.Random;

public class Aranha extends Monstruo {
    public Aranha(String nombre) {
        super(nombre, generar(10, 50), generar(20, 40), generar(40, 70), generar(30, 80));
    }

    // Método auxiliar para generar valores aleatorios dentro de un rango
    private static int generar(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}