package ud3.DBRexamen; // Reemplaza 'xxx' por tus iniciales

import java.util.Random;

public class JuegoCarreras01 {
    public static void main(String[] args) {
        CocheCarreras rayo = new CocheCarreras("Rayo", 90, 3, 400);
        CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);

        System.out.println("Características iniciales:");
        rayo.mostrar();
        trueno.mostrar();

        int meta = 500; // Metros para ganar
        Random rand = new Random();
        CocheCarreras ganador = null;

        System.out.println("\n¡Empieza la carrera!\n");

        // Determinar orden de inicio
        CocheCarreras primero = (rayo.getVelocidadMaxima() >= trueno.getVelocidadMaxima()) ? rayo : trueno;
        CocheCarreras segundo = (primero == rayo) ? trueno : rayo;

        while (ganador == null) {
            for (CocheCarreras coche : new CocheCarreras[]{primero, segundo}) {
                if (coche.getAutonomiaRestante() == 0) {
                    System.out.printf("%s para a repostar.\n", coche.getNombre());
                    coche.repostar();
                } else if (coche.getTurbosRestantes() > 0 && rand.nextInt(100) < 25) {
                    int avance = coche.usarTurbo();
                    System.out.printf("%s usa un turbo y avanza %d metros. Quedan %d turbos. (Total recorrido: %d metros)\n",
                            coche.getNombre(), avance, coche.getTurbosRestantes(), coche.getDistanciaRecorrida());
                } else {
                    int avance = coche.avanzar();
                    System.out.printf("%s avanza %d metros (Total recorrido: %d metros).\n",
                            coche.getNombre(), avance, coche.getDistanciaRecorrida());
                }

                if (coche.getDistanciaRecorrida() >= meta) {
                    ganador = coche;
                    break;
                }
            }
        }

        System.out.printf("\n¡%s ha cruzado la meta y es el ganador!\n", ganador.getNombre());
    }
}
