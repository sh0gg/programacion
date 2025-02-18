package ud5.ejemplo.models;

/**
 * Clase que representa a una persona.
 */
public class Persona {
    // Atributos privados (Encapsulación)
    private String nombre;
    private int edad;

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombre Nombre de la persona.
     * @param edad   Edad de la persona.
     */
    public Persona(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre Nombre de la persona.
     * @throws IllegalArgumentException Si el nombre es nulo o vacío.
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la persona.
     * 
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     * 
     * @param edad Edad de la persona.
     * @throws IllegalArgumentException Si la edad no es positiva.
     */
    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser positiva");
        }
        this.edad = edad;
    }

    /**
     * Muestra la información de la persona.
     */
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }

    /**
     * Devuelve una representación en cadena del objeto Persona.
     * 
     * @return Representación en cadena del objeto Persona.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}

