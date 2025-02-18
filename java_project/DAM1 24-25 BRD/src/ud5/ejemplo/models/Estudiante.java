package ud5.ejemplo.models;

/**
 * Clase que representa a un estudiante.
 */
public class Estudiante extends Persona {
    private String matricula;

    /**
     * Constructor de la clase Estudiante.
     * 
     * @param nombre    Nombre del estudiante.
     * @param edad      Edad del estudiante.
     * @param matricula Matrícula del estudiante.
     */
    public Estudiante(String nombre, int edad, String matricula) {
        super(nombre, edad);  // Llamando al constructor de Persona
        setMatricula(matricula);
    }

    /**
     * Obtiene la matrícula del estudiante.
     * 
     * @return Matrícula del estudiante.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del estudiante.
     * 
     * @param matricula Matrícula del estudiante.
     * @throws IllegalArgumentException Si la matrícula es nula o vacía.
     */
    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("La matrícula no puede ser nula o vacía");
        }
        this.matricula = matricula;
    }

    /**
     * Muestra la información del estudiante.
     */
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Matrícula: " + matricula);
    }

    /**
     * Devuelve una representación en cadena del objeto Estudiante.
     * 
     * @return Representación en cadena del objeto Estudiante.
     */
    @Override
    public String toString() {
        return super.toString() + ", Matrícula: " + matricula;
    }
}
