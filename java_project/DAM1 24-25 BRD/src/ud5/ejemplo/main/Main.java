package ud5.ejemplo.main;

import ud5.ejemplo.models.Estudiante;
import ud5.ejemplo.models.Profesor;

public class Main {
    public static void main(String[] args) {
        // Creando un Estudiante
        Estudiante estudiante = new Estudiante("Juan Pérez", 20, "A12345");
        estudiante.mostrarInfo();

        System.out.println("----------------");

        // Creando un Profesor
        Profesor profesor = new Profesor("Dra. María López", 45, "Matemáticas");
        profesor.mostrarInfo();
    }
}
