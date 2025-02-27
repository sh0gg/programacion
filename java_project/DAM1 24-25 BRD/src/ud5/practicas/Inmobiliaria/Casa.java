package ud5.practicas.Inmobiliaria;

public class Casa extends Inmueble {

    private int metrosCuadradosFinca;

    public Casa(String direccion, int metrosCuadrados, int habitaciones, int aseos, int metrosCuadradosFinca) {
        super();
        this.metrosCuadradosFinca = metrosCuadradosFinca;
    }

    // GETTERS Y SETTERS

    public int getMetrosCuadradosFinca() {
        return metrosCuadradosFinca;
    }

    public void setMetrosCuadradosFinca(int metrosCuadradosFinca) {
        this.metrosCuadradosFinca = metrosCuadradosFinca;
    }

    @Override
    public String detalle() {
        String detalle = "Piso en " + getDireccion() +".\n" + getMetrosCuadrados() +" m2, " + getHabitaciones() + " hab, " + getAseos() + " baños, con terreno de " + getMetrosCuadradosFinca() + " m2.\n";
        if (getPrecioAlquiler() != 0) {
            detalle = detalle + "Precio de alquiler: " + getPrecioAlquiler() + "\n";
        }
        if (getPrecioVenta() != 0) {
            detalle = detalle + "Precio de venta: " + getPrecioVenta() + "\n";
        }
        return detalle;
    }
}
