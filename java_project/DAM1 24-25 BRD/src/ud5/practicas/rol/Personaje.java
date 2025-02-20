package ud5.practicas.rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personaje {
    private String nombre;
    private String raza;
    private int fuerza;
    private int agilidad;
    private int constitucion;
    private int inteligencia;
    private int intuicion;
    private int presencia;
    private int nivel = 1;
    private int experiencia = 0;
    private int puntosVida;
    private int maxPuntosVida;
    private List<Item> inventario; // Inventario del personaje
    private List<String> nombresItems; // Nombres de los objetos en lugar de objetos completos


    private static final String[] RAZAS_VALIDAS = {"HUMANO", "ELFO", "ENANO", "HOBBIT", "ORCO", "TROLL", "MONSTRUO"};
    private static final Random rand = new Random();

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
        this.maxPuntosVida = 50 + this.constitucion;
        this.puntosVida = this.maxPuntosVida;
        this.inventario = new ArrayList<>(); // 🔹 Inicializa un inventario vacío siempre

        aplicarBonificacionesRaza();
    }


    // Constructor con nombre y raza, atributos aleatorios
    public Personaje(String nombre, String raza) throws Exception {
        this(nombre, raza, rand.nextInt(80) + 20, rand.nextInt(80) + 20, rand.nextInt(80) + 20,
                rand.nextInt(80) + 20, rand.nextInt(80) + 20, rand.nextInt(80) + 20);
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

    // Aplicar bonificaciones raciales
    private void aplicarBonificacionesRaza() {
        switch (raza.toUpperCase()) {
            case "HUMANO":
                // Bonificación equilibrada
                fuerza += 5;
                agilidad += 5;
                constitucion += 5;
                inteligencia += 5;
                intuicion += 5;
                presencia += 5;
                break;
            case "ELFO":
                // Más ágil e inteligente, menos constitución
                agilidad += 10;
                inteligencia += 10;
                constitucion -= 5;
                break;
            case "ENANO":
                // Más fuerte y resistente, menos ágil
                fuerza += 10;
                constitucion += 10;
                agilidad -= 5;
                break;
            case "HOBBIT":
                // Más ágil y con buena intuición, menos fuerza
                agilidad += 10;
                intuicion += 10;
                fuerza -= 5;
                break;
            case "ORCO":
                // Más fuerte, pero menos inteligente
                fuerza += 15;
                inteligencia -= 5;
                intuicion -= 5;
                break;
            case "TROLL":
                // Mucha fuerza y constitución, pero torpe
                fuerza += 20;
                constitucion += 15;
                agilidad -= 10;
                inteligencia -= 10;
                break;
            case "MONSTRUO":
                // Valores más aleatorios
                fuerza += rand.nextInt(10);
                agilidad += rand.nextInt(10);
                constitucion += rand.nextInt(10);
                inteligencia += rand.nextInt(10);
                intuicion += rand.nextInt(10);
                presencia += rand.nextInt(10);
                break;
        }
    }

    // Métodos de la clase
    public void mostrar() {
        System.out.println(this);
    }

    public String toString() {
        return nombre + " (" + puntosVida + "/" + maxPuntosVida + ") - Raza: " + raza + " - Nivel: " + nivel;
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
        maxPuntosVida = 50 + constitucion;
        puntosVida = maxPuntosVida; // Curarse al subir de nivel
        System.out.println(nombre + " ha subido al nivel " + nivel + " y ha recuperado su vida.");
    }

    public void curar() {
        puntosVida = maxPuntosVida;
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

    // Getters
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

    // Métodos para el inventario
    public void agregarItem(Item item) {
        inventario.add(item);
        System.out.println(nombre + " ha recibido el objeto: " + item.getNombre());
    }

    public void eliminarItem(String nombreItem) {
        for (Item item : inventario) {
            if (item.getNombre().equalsIgnoreCase(nombreItem)) {
                inventario.remove(item);
                System.out.println(nombre + " ha eliminado el objeto: " + item.getNombre());
                return;
            }
        }
        System.out.println(nombre + " no tiene ese objeto en su inventario.");
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println(nombre + " no tiene objetos en su inventario.");
        } else {
            System.out.println("🎒 Inventario de " + nombre + ":");
            for (Item item : inventario) {
                System.out.println("- " + item);
            }
        }
    }

    public List<Item> getInventario() {
        if (inventario == null) {
            inventario = new ArrayList<>();
        }
        return inventario;
    }
    


    public void setInventario(List<Item> inventario) {
        this.inventario = inventario;
    }

    public void recuperarInventarioDesdeLista(List<Item> itemsDisponibles) {
        this.inventario = new ArrayList<>();
        for (String nombreItem : nombresItems) {
            for (Item i : itemsDisponibles) {
                if (i.getNombre().equals(nombreItem)) {
                    this.inventario.add(i);
                    break;
                }
            }
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getIntuicion() {
        return intuicion;
    }

    public int getPresencia() {
        return presencia;
    }

    public void setNombresItems(List<String> nombresItems) {
        this.nombresItems = nombresItems;
    }
}
