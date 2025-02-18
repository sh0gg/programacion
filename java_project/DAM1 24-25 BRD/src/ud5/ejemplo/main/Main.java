package ud5.ejemplo;

import ud5.ejemplo.models.Estudiante;
import ud5.ejemplo.models.Profesor;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Estudiante y Profesor
        Estudiante estudiante = new Estudiante("Juan Pérez", 20, "2025A123");
        Profesor profesor = new Profesor("María García", 45, "Matemáticas");

        // Mostrar información del estudiante
        System.out.println("Información del Estudiante:");
        estudiante.mostrarInfo();

        // Mostrar información del profesor
        System.out.println("\nInformación del Profesor:");
        profesor.mostrarInfo();
    }
}
