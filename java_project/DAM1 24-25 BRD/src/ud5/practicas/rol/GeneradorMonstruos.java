package ud5.practicas.rol;

import java.util.Random;

public class GeneradorMonstruos {
    public static Monstruo generarMonstruoAleatorio() {
        Random rand = new Random();
        int probabilidad = rand.nextInt(100);

        if (probabilidad < 40) {
            return new Orco("Orco Salvaje");
        } else if (probabilidad < 70) {
            return new Aranha("Araña Gigante");
        } else if (probabilidad < 90) {
            return new Troll("Troll de Cueva");
        } else {
            return new Dragon("Dragón Rojo");
        }
    }
}