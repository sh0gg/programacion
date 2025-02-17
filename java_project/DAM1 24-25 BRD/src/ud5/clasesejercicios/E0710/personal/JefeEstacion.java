package ud5.clasesejercicios.E0710.personal;

import java.time.LocalDate;
import java.time.Period;

public class JefeEstacion {
    String nombre;
    String dni;
    LocalDate fechaNombramiento;

    public JefeEstacion(String nombre, String dni, LocalDate fechaNombramiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNombramiento = fechaNombramiento;
    }

    public int getAntiguedad() {
        Period p = Period.between(fechaNombramiento, LocalDate.now());
        return p.getYears();
    }

    @Override
    public String toString() {
        return "JefeEstacion: " + nombre +
                ", dni: " + dni +
                ", años de servicio: " + getAntiguedad() + '.';
    }
}
