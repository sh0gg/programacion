package ud5.practicas.rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Personaje {
    private String nombre;
    private String raza;
    private int fuerza, agilidad, constitucion, inteligencia, intuicion, presencia;
    private int nivel = 1, experiencia = 0, puntosVida, maxPuntosVida;
    private List<String> inventario; // 🔥 Ahora almacena solo los IDs de los objetos

    private static final String[] RAZAS_VALIDAS = {"HUMANO", "ELFO", "ENANO", "HOBBIT", "ORCO", "TROLL", "MONSTRUO"};
    private static final Random rand = new Random();

    public Personaje(String nombre, String raza) throws Exception {
        validarRaza(raza);
        this.nombre = nombre;
        this.raza = raza;
        this.fuerza = rand.nextInt(80) + 20;
        this.agilidad = rand.nextInt(80) + 20;
        this.constitucion = rand.nextInt(80) + 20;
        this.inteligencia = rand.nextInt(80) + 20;
        this.intuicion = rand.nextInt(80) + 20;
        this.presencia = rand.nextInt(80) + 20;
        this.maxPuntosVida = 50 + this.constitucion;
        this.puntosVida = maxPuntosVida;
        this.inventario = new ArrayList<>(); // 🔥 Inicializa la lista de IDs de ítems vacía
    }

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
        this.inventario = new ArrayList<>(); // 🔥 Lista vacía de IDs de objetos
    }


    // 🔹 Validar que la raza sea una de las permitidas
    private void validarRaza(String raza) throws Exception {
        for (String r : RAZAS_VALIDAS) {
            if (r.equalsIgnoreCase(raza)) return;
        }
        throw new Exception("❌ Raza no válida: " + raza);
    }

    // 🔹 Método para subir de nivel
    public void subirNivel() {
        nivel++;
        fuerza *= 1.05;
        agilidad *= 1.05;
        constitucion *= 1.05;
        maxPuntosVida = 50 + constitucion;
        puntosVida = maxPuntosVida; // Curarse al subir de nivel
        System.out.println("🎉 " + nombre + " ha subido al nivel " + nivel + " y ha recuperado su vida.");
    }

    // 🔹 Agregar un objeto al inventario por su ID
    public void agregarItem(String itemId) {
        if (!inventario.contains(itemId)) {
            inventario.add(itemId);
            System.out.println("🎒 " + nombre + " ha obtenido un nuevo objeto: " + itemId);
        } else {
            System.out.println("⚠️ " + nombre + " ya tiene este objeto.");
        }
    }

    // 🔹 Eliminar un objeto del inventario
    public void eliminarItem(String itemId) {
        if (inventario.remove(itemId)) {
            System.out.println("🗑 " + nombre + " ha eliminado el objeto: " + itemId);
        } else {
            System.out.println("⚠️ " + nombre + " no tenía ese objeto.");
        }
    }

    // 🔹 Mostrar los IDs de los objetos en el inventario
    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("📭 " + nombre + " no tiene objetos en su inventario.");
        } else {
            System.out.println("🎒 Inventario de " + nombre + ":");
            for (String itemId : inventario) {
                System.out.println("- ID: " + itemId);
            }
        }
    }

    // 🔹 Calcular bonificaciones de los objetos equipados (basado en el archivo `items.json`)
    public int calcularBono(String atributo, List<Item> itemsDisponibles) {
        int bonoTotal = 0;
        for (String itemId : inventario) {
            for (Item item : itemsDisponibles) {
                if (item.getId().equals(itemId)) {
                    switch (atributo.toLowerCase()) {
                        case "fuerza":
                            bonoTotal += item.getBonoFuerza();
                            break;
                        case "agilidad":
                            bonoTotal += item.getBonoAgilidad();
                            break;
                        case "constitucion":
                            bonoTotal += item.getBonoConstitucion();
                            break;
                    }
                }
            }
        }
        return bonoTotal;
    }

    // 🔹 Determinar daño en un ataque
    public int atacar(Personaje enemigo, List<Item> itemsDisponibles) {
        int bonoFuerza = calcularBono("fuerza", itemsDisponibles);
        int bonoAgilidad = calcularBono("agilidad", itemsDisponibles);

        int ataque = (fuerza + bonoFuerza) + rand.nextInt(100) + 1;
        int defensa = (enemigo.getAgilidad() + enemigo.calcularBono("agilidad", itemsDisponibles)) + rand.nextInt(100) + 1;

        int dano = Math.max(1, ataque - defensa);
        if (dano > 0) {
            enemigo.perderVida(dano);
            this.sumarExperiencia(dano);
            enemigo.sumarExperiencia(dano);
        }

        return dano;
    }


    // 🔹 Manejar la pérdida de vida
    public boolean perderVida(int puntos) {
        puntosVida -= puntos;
        return puntosVida <= 0;
    }

    // 🔹 Obtener estadísticas de combate
    public int getNivel() {
        return nivel;
    }

    public int getMaxPuntosVida() {
        return maxPuntosVida;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getAgilidad() {
        return agilidad;
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

    public List<String> getInventario() {
        return inventario;
    }

    public void setInventario(List<String> inventario) {
        this.inventario = inventario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + puntosVida + "/" + maxPuntosVida + ") - Raza: " + raza + " - Nivel: " + nivel;
    }

    public void sumarExperiencia(int puntos) {
        experiencia += puntos;
        while (experiencia >= experienciaNecesariaParaNivel(nivel + 1)) {
            experiencia -= experienciaNecesariaParaNivel(nivel + 1);
            subirNivel();
        }
    }

    private int experienciaNecesariaParaNivel(int nivel) {
        return (int) (1000 * Math.pow(nivel, 1.5));
    }

    public void mostrar() {
        System.out.println(this);
    }

    public boolean estaVivo() {
        return puntosVida > 0;
    }

    public void curar() {
        this.puntosVida = maxPuntosVida;
        System.out.println("💖 " + nombre + " ha sido completamente curado.");
    }

    public void agregarItem(Item item) {
        if (item != null) {
            inventario.add(item.getId()); // 🔥 Ahora guardamos el ID, no el objeto completo
            System.out.println("🎒 " + nombre + " ha recibido: " + item.getNombre());
        } else {
            System.out.println("⚠️ No se puede agregar un objeto nulo.");
        }
    }

}
