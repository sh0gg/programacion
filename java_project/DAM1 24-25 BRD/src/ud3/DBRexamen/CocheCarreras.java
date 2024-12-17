package ud3.DBRexamen; // Reemplaza 'xxx' por tus iniciales

import java.util.Random;

public class CocheCarreras {
    private String nombre;
    private int velocidadMaxima;
    private int turbosMaximos;
    private int autonomiaMaxima;
    private int autonomiaRestante;
    private int turbosRestantes;
    private int distanciaRecorrida;

    // Constructor completo
    public CocheCarreras(String nombre, int velocidadMaxima, int turbosMaximos, int autonomiaMaxima) {
        this.nombre = nombre;
        this.velocidadMaxima = Math.min(100, Math.max(1, velocidadMaxima)); // Entre 1 y 100
        this.turbosMaximos = turbosMaximos;
        this.autonomiaMaxima = autonomiaMaxima;
        this.autonomiaRestante = autonomiaMaxima;
        this.turbosRestantes = turbosMaximos;
        this.distanciaRecorrida = 0;
    }

    // Constructor con turbos por defecto (3)
    public CocheCarreras(String nombre, int velocidadMaxima, int autonomiaMaxima) {
        this(nombre, velocidadMaxima, 3, autonomiaMaxima);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public int getTurbosRestantes() {
        return turbosRestantes;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    // Métodos funcionales
    public int avanzar() {
        Random rand = new Random();
        int metros = rand.nextInt(velocidadMaxima) + 1;
        int avanceReal = Math.min(metros, autonomiaRestante);
        autonomiaRestante -= avanceReal;
        distanciaRecorrida += avanceReal;
        return avanceReal;
    }

    public int usarTurbo() {
        if (turbosRestantes > 0) {
            int metros = (int) (velocidadMaxima * 1.5);
            int avanceReal = Math.min(metros, autonomiaRestante);
            autonomiaRestante -= avanceReal;
            distanciaRecorrida += avanceReal;
            turbosRestantes--;
            return avanceReal;
        }
        return 0;
    }

    public void repostar() {
        autonomiaRestante = autonomiaMaxima;
        turbosRestantes = turbosMaximos;
    }

    public void reiniciarDistancia() {
        distanciaRecorrida = 0;
    }

    public void mostrar() {
        System.out.printf("Coche: %s\n", nombre);
        System.out.printf("Velocidad Máxima: %d mps\n", velocidadMaxima);
        System.out.printf("Turbos: %d/%d\n", turbosRestantes, turbosMaximos);
        System.out.printf("Autonomía: %d/%d\n", autonomiaRestante, autonomiaMaxima);
        System.out.printf("Distancia Recorrida: %d metros\n", distanciaRecorrida);
    }

    // Método main para pruebas
    public static void main(String[] args) {
        System.out.println("RAYO");
        System.out.println("====");
        CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
        rayo.mostrar();
        rayo.avanzar();
        rayo.usarTurbo();
        rayo.mostrar();

        System.out.println("TRUENO");
        System.out.println("======");
        CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);
        trueno.mostrar();
        while (trueno.getAutonomiaRestante() > 0) {
            trueno.usarTurbo();
        }
        trueno.mostrar();
        trueno.repostar();
        trueno.mostrar();
    }
}
