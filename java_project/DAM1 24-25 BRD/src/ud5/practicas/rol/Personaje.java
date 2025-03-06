package ud5.practicas.rol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Personaje {
    private String nombre;
    private String raza;
    private int fuerza, agilidad, constitucion, inteligencia, intuicion, presencia;
    private int nivel = 1, experiencia = 0, puntosVida, maxPuntosVida;

    private static final String[] RAZAS_VALIDAS = { "HUMANO", "ELFO", "ENANO", "HOBBIT", "ORCO", "TROLL" };
    private static final Random rand = new Random();

    // Constructor 1: Nombre y raza, con atributos aleatorios
    public Personaje(String nombre, String raza) throws Exception {
        validarRaza(raza);
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = rand.nextInt(100) + 1;
        this.agilidad = rand.nextInt(100) + 1;
        this.constitucion = rand.nextInt(100) + 1;
        this.inteligencia = rand.nextInt(100) + 1;
        this.intuicion = rand.nextInt(100) + 1;
        this.presencia = rand.nextInt(100) + 1;
        this.maxPuntosVida = 50 + this.constitucion;
        this.puntosVida = maxPuntosVida;
    }

    // Constructor 2: Para monstruos (nombre, ataque, defensa, velocidad)
    public Personaje(String nombre, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.raza = "MONSTRUO";
        this.fuerza = ataque;
        this.agilidad = defensa;
        this.constitucion = velocidad;
        this.inteligencia = 0;
        this.intuicion = 0;
        this.presencia = 0;
        this.maxPuntosVida = 50 + this.constitucion;
        this.puntosVida = maxPuntosVida;
    }

    // Constructor 3: Todos los atributos definidos
    public Personaje(String nombre, String raza, int fuerza, int agilidad, int constitucion,
            int inteligencia, int intuicion, int presencia) throws Exception {
        validarRaza(raza);
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.intuicion = intuicion;
        this.presencia = presencia;
        this.maxPuntosVida = 50 + this.constitucion;
        this.puntosVida = maxPuntosVida;
    }

    // Constructor 4: Solo nombre, se asigna como humano con atributos aleatorios
    public Personaje(String nombre) throws Exception {
        this(nombre, "HUMANO");
    }

    private void validarRaza(String raza) throws Exception {
        for (String r : RAZAS_VALIDAS) {
            if (r.equalsIgnoreCase(raza))
                return;
        }
        throw new Exception("Raza no válida: " + raza);
    }

    public int atacar(Personaje enemigo) {
        int ataque = fuerza + rand.nextInt(100) + 1;
        int defensa = enemigo.agilidad + rand.nextInt(100) + 1;

        int dano = Math.max(0, ataque - defensa);
        if (dano > enemigo.puntosVida)
            dano = enemigo.puntosVida;
        enemigo.puntosVida -= dano;

        if (dano > 0) {
            sumarExperiencia(dano);
            enemigo.sumarExperiencia(dano);
        }
        return dano;
    }

    // Método para atacar a un monstruo
    public int atacar(Monstruo enemigo) {
        int ataqueTotal = fuerza + rand.nextInt(100) + 1;
        int defensaTotal = enemigo.getDefensa() + rand.nextInt(100) + 1;

        int dano = Math.max(0, ataqueTotal - defensaTotal);
        if (dano > enemigo.getPuntosVida())
            dano = enemigo.getPuntosVida();
        enemigo.perderVida(dano);

        return dano;
    }

    public void sumarExperiencia(int puntos) {
        experiencia += puntos;
        while (experiencia >= nivel * 1000) {
            experiencia -= nivel * 1000;
            subirNivel();
        }
    }

    private void subirNivel() {
        nivel++;
        fuerza *= 1.05;
        agilidad *= 1.05;
        constitucion *= 1.05;
        maxPuntosVida = 50 + constitucion;
        puntosVida = maxPuntosVida;
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public void mostrar() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" + maxPuntosVida + ") - " + raza + " - Nivel " + nivel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; // Si es la misma instancia, es igual
        if (obj == null || getClass() != obj.getClass())
            return false; // Si es null o no es la misma clase, es diferente

        Personaje otro = (Personaje) obj;
        return this.nombre.equals(otro.nombre) && this.raza.equals(otro.raza);
    }

    public static Personaje[] sortAgilidadDesc(Personaje[] personajes) {
    Arrays.sort(personajes, Comparator.comparingInt(Personaje::getAgilidad).reversed());
    return personajes;
}

    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getIntuicion() {
        return intuicion;
    }

    public void setIntuicion(int intuicion) {
        this.intuicion = intuicion;
    }

    public int getPresencia() {
        return presencia;
    }

    public void setPresencia(int presencia) {
        this.presencia = presencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getMaxPuntosVida() {
        return maxPuntosVida;
    }

    public void setMaxPuntosVida(int maxPuntosVida) {
        this.maxPuntosVida = maxPuntosVida;
    }

    protected void perderVida(int dano) {
        this.puntosVida -= dano;
        if (this.puntosVida < 0) {
            this.puntosVida = 0; // Evita valores negativos
        }
    }

}
