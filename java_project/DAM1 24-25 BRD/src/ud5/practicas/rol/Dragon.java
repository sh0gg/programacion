package ud5.practicas.rol;

import java.util.Random;

public class Dragon extends Monstruo {
    public Dragon(String nombre) {
        super(nombre, generar(100, 200), generar(60, 100), generar(80, 120), generar(120, 250));
    }

// Método auxiliar para generar valores aleatorios dentro de un rango
private static int generar(int min, int max) {
    return new Random().nextInt(max - min + 1) + min;
}
}