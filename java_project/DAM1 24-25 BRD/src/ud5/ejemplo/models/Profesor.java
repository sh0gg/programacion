package ud5.ejemplo.models;

/**
 * Clase que representa a un profesor.
 */
public class Profesor extends Persona {
    private String asignatura;

    /**
     * Constructor de la clase Profesor.
     * 
     * @param nombre     Nombre del profesor.
     * @param edad       Edad del profesor.
     * @param asignatura Asignatura que imparte el profesor.
     */
    public Profesor(String nombre, int edad, String asignatura) {
        super(nombre, edad);  // Llamando al constructor de Persona
        setAsignatura(asignatura);
    }

    /**
     * Obtiene la asignatura que imparte el profesor.
     * 
     * @return Asignatura que imparte el profesor.
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * Establece la asignatura que imparte el profesor.
     * 
     * @param asignatura Asignatura que imparte el profesor.
     * @throws IllegalArgumentException Si la asignatura es nula o vacía.
     */
    public void setAsignatura(String asignatura) {
        if (asignatura == null || asignatura.isEmpty()) {
            throw new IllegalArgumentException("La asignatura no puede ser nula o vacía");
        }
        this.asignatura = asignatura;
    }

    /**
     * Muestra la información del profesor.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Asignatura: " + asignatura);
    }

    /**
     * Devuelve una representación en cadena del objeto Profesor.
     * 
     * @return Representación en cadena del objeto Profesor.
     */
    @Override
    public String toString() {
        return super.toString() + ", Asignatura: " + asignatura;
    }
}
