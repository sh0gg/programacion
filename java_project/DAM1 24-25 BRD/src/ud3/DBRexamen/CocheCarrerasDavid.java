/* package ud3.DBRexamen;

// Ejercicio realizado por David Besada Ramilo

/*

System.out.println("RAYO");
System.out.println("====");
CocheCarreras rayo = new CocheCarreras("Rayo", 90, 400);
rayo.mostrar();
rayo.avanzar();
rayo.usarTurbo();
rayo.mostrar()
System.out.println("TRUENO");
System.out.println("======");
CocheCarreras trueno = new CocheCarreras("Trueno", 60, 5, 300);
trueno.mostrar();
while (trueno.getAutonomiaRestante() != 0)
trueno.usarTurbo();
trueno.mostrar();
trueno.repostar();
trueno.mostrar();

 */

public class CocheCarreras {

    private String nombre;
    private double autonomia;
    private double velocidadMaxima;
    private int turbo = (int) (autonomia / (velocidadMaxima * 150));
    private int turbosRestantes;
    private double distanciaRecorrida;
    private double autonomiaRestante = autonomia - distanciaRecorrida;

    public CocheCarreras(String nombre) {
        this.nombre = nombre;
    }

    public CocheCarreras(String nombre, double velocidadMaxima, double autonomia) {
        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.autonomia = autonomia;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public int getTurbosRestantes() {
        return turbosRestantes;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public CocheCarreras(String nombre, double velocidadMaxima, int turbo, double autonomia) {
        this.nombre = nombre;
        this.velocidadMaxima = velocidadMaxima;
        this.turbo = turbo;
        this.autonomia = autonomia;
    }

        public static usarTurbo() {
            turbosRestantes = turbosRestantes - 1; 
            return distanciaRecorrida = velocidadMaxima 
    }
}
