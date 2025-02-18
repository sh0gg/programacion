package ud5.ejemplo.models;

public class Estudiante extends Persona {
    private String matricula;

    // Constructor
    public Estudiante(String nombre, int edad, String matricula) {
        super(nombre, edad);  // Llamando al constructor de Persona
        this.matricula = matricula;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Sobrescribiendo el método mostrarInfo()
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Matrícula: " + matricula);
    }
}
