package ud5.practicas.Inmobiliaria;

public class Piso extends Inmueble {

    private int planta;

    public Piso(String direccion, int metrosCuadrados, int habitaciones, int aseos, int planta) {
        super();
        this.planta = planta;
    }

    // GETTERS Y SETTERS

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    @Override
    public String detalle() {
        String detalle = "Casa en " + getDireccion() +".\n" + getMetrosCuadrados() +" m2, " + getHabitaciones() + " hab, " + getAseos() + " baños, " + getPlanta() + "ª planta.\n";
        if (getPrecioAlquiler() != 0) {
            detalle = detalle + "Precio de alquiler: " + getPrecioAlquiler() + "\n";
        }
        if (getPrecioVenta() != 0) {
            detalle = detalle + "Precio de venta: " + getPrecioVenta() + "\n";
        }
        return detalle;
    }
}
