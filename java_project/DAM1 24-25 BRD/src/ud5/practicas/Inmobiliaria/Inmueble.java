package ud5.practicas.Inmobiliaria;

public abstract class Inmueble {
    private String direccion;
    private int metrosCuadrados;
    private int habitaciones;
    private int aseos;
    private int precioAlquiler;
    private int precioVenta;


    public Inmueble() {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.aseos = aseos;
    }

    @Override
    public String toString() {
        return "Inmueble en " + getDireccion() + "(" + getMetrosCuadrados() + "m2," + getHabitaciones() + " hab)";
    }

   public abstract String detalle();

    // GETTERS Y SETTERS

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(int metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getAseos() {
        return aseos;
    }

    public void setAseos(int aseos) {
        this.aseos = aseos;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }
}
