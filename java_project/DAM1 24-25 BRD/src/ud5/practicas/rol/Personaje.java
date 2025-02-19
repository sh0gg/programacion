package ud5.practicas.rol;

import java.util.Random;
import java.util.Objects;

public class Personaje {
    private String nombre;
    private String raza;
    private int fuerza;
    int agilidad;
    private int constitucion;
    private int inteligencia;
    private int intuicion;
    private int presencia;
    private int nivel = 1;
    private int experiencia = 0;
    private int puntosVida;
    private int maxPuntosVida;

    private static final String[] RAZAS_VALIDAS = {"HUMANO", "ELFO", "ENANO", "HOBBIT", "ORCO", "TROLL", "MONSTRUO"};
    private static final Random rand = new Random();

    // Constructor con todos los atributos
    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion, int inteligencia, int intuicion, int presencia) throws Exception {
        validarRaza(raza);
        validarAtributos(fuerza, agilidad, constitucion, inteligencia, intuicion, presencia);

        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.intuicion = intuicion;
        this.presencia = presencia;
        this.puntosVida = 50 + constitucion;

    }

    // Constructor con nombre y raza, atributos aleatorios
    public Personaje(String nombre, String raza) throws Exception {
        this(nombre, raza, rand.nextInt(100) + 1, rand.nextInt(100) + 1, rand.nextInt(100) + 1,
                rand.nextInt(100) + 1, rand.nextInt(100) + 1, rand.nextInt(100) + 1);
    }

    // Constructor con solo nombre, asume que es humano
    public Personaje(String nombre) throws Exception {
        this(nombre, "HUMANO");
    }

    // Validación de raza
    private void validarRaza(String raza) throws Exception {
        for (String r : RAZAS_VALIDAS) {
            if (r.equalsIgnoreCase(raza)) return;
        }
        throw new Exception("Raza no válida: " + raza);
    }

    // Validación de atributos
    private void validarAtributos(int... atributos) throws Exception {
        for (int atr : atributos) {
            if (atr < 1) throw new Exception("Todos los atributos deben ser mayores o iguales a 1.");
        }
    }

    // Métodos de la clase
    public void mostrar() {
        System.out.println(this);
    }

    public String toString() {
        return nombre + " (" + puntosVida + "/" + (50 + constitucion) + ")";
    }

    public byte sumarExperiencia(int puntos) {
        experiencia += puntos;
        byte nivelesSubidos = 0;
        while (experiencia >= 1000) {
            experiencia -= 1000;
            subirNivel();
            nivelesSubidos++;
        }
        return nivelesSubidos;
    }

    public void subirNivel() {
        nivel++;
        fuerza *= 1.05;
        agilidad *= 1.05;
        constitucion *= 1.05;
        System.out.println(nombre + " ha subido al nivel " + nivel);
    }

    public void curar() {
        puntosVida = 50 + constitucion;
    }

    public boolean perderVida(int puntos) {
        puntosVida -= puntos;
        return puntosVida <= 0;
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public int atacar(Personaje enemigo) {
        int ataque = fuerza + rand.nextInt(100) + 1;
        int defensa = enemigo.agilidad + rand.nextInt(100) + 1;
        int dano = Math.max(0, ataque - defensa);

        if (dano > 0) {
            enemigo.perderVida(dano);
            sumarExperiencia(dano);
            enemigo.sumarExperiencia(dano);
        }
        return dano;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public int getMaxPuntosVida() {
        return maxPuntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public String getNombre() {
        return nombre;
    }
}
