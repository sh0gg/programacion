package ud5.practicas.Inmobiliaria;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Inmueble {
    private String direccion;
    private int metrosCuadrados;
    private int habitaciones;
    private int aseos;
    private int precioAlquiler;
    private int precioVenta;


    public Inmueble(String direccion, int metrosCuadrados, int habitaciones, int aseos) {
        this.direccion = direccion;
        this.metrosCuadrados = metrosCuadrados;
        this.habitaciones = habitaciones;
        this.aseos = aseos;
    }

    @Override
    public String toString() {
        return "Inmueble en " + getDireccion() + " (" + getMetrosCuadrados() + "m2, " + getHabitaciones() + " hab, " + getAseos() + " baños).";
    }

    public abstract String detalle();

    static void mostrarInmuebles(Inmueble[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i].toString());
        }
    }

    static void sortMetrosDesc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int metros1 = ((Inmueble) o1).getMetrosCuadrados();
                int metros2 = ((Inmueble) o2).getMetrosCuadrados();

                return -(metros1 - metros2);
            }
        };
        Arrays.sort(t, c);
    }

    static void sortHabMetrosDesc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int hab1 = ((Inmueble) o1).getHabitaciones();
                int hab2 = ((Inmueble) o2).getHabitaciones();
                int res = -(hab1 - hab2);
                if (res == 0) {
                    int metros1 = ((Inmueble) o1).getMetrosCuadrados();
                    int metros2 = ((Inmueble) o2).getMetrosCuadrados();
                    res = -(metros1 - metros2);
                }
                return res;
            }
        };
        Arrays.sort(t, c);
    }

    static void sortPrecioAlquilerAsc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int precio1 = ((Inmueble) o1).getPrecioAlquiler();
                int precio2 = ((Inmueble) o2).getPrecioAlquiler();
                return precio1 - precio2;
            }
        };
        Arrays.sort(t, c);
    }

    static void sortPrecioVentaAsc(Inmueble[] t) {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int precio1 = ((Inmueble) o1).getPrecioVenta();
                int precio2 = ((Inmueble) o2).getPrecioVenta();
                return precio1 - precio2;
            }
        };

    }

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
