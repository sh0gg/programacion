public class Cafetera {
    private int capacidad;
    private int cantidadActual;
    private final int MAX_CAPACIDAD = 1000;
    private final int MIN_CAPACIDAD = 50;

    // Constructor predeterminado
    public Cafetera() {
        this.capacidad = MAX_CAPACIDAD;
        this.cantidadActual = 0;
    }

    // Constructor con un solo parámetro
    public Cafetera(int capacidad) {
        if (capacidad < MIN_CAPACIDAD) {
            this.capacidad = MIN_CAPACIDAD;
        } else if (capacidad > MAX_CAPACIDAD) {
            this.capacidad = MAX_CAPACIDAD;
        } else {
            this.capacidad = capacidad;
        }
        this.cantidadActual = this.capacidad;
    }

    // Constructor con capacidad máxima y cantidad actual
    public Cafetera(int capacidad, int cantidadActual) {
        if (capacidad < MIN_CAPACIDAD) {
            this.capacidad = MIN_CAPACIDAD;
        } else if (capacidad > MAX_CAPACIDAD) {
            this.capacidad = MAX_CAPACIDAD;
        } else {
            this.capacidad = capacidad;
        }

        if (cantidadActual < 0) {
            this.cantidadActual = 0;
        } else if (cantidadActual > this.capacidad) {
            this.cantidadActual = this.capacidad;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    // Getter y Setter
    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        if (cantidadActual < 0) {
            this.cantidadActual = 0;
        } else if (cantidadActual > capacidad) {
            this.cantidadActual = capacidad;
        } else {
            this.cantidadActual = cantidadActual;
        }
    }

    // Llenar cafetera
    public void llenarCafetera() {
        cantidadActual = capacidad;
    }

    // Servir taza
    public boolean servirTaza(int capacidadTaza) {
        if (capacidadTaza < 0) {
            return false;
        }
        
        if (cantidadActual >= capacidadTaza) {
            cantidadActual -= capacidadTaza;
            return true;
        } else {
            cantidadActual = 0;
            return false;
        }
    }

    // Vaciar cafetera
    private void vaciarCafetera() {
        cantidadActual = 0;
    }

    // Agregar café
    public int agregarCafe(int cantidadCafe) {
        if (cantidadCafe < 0) {
            return 0;
        }
        
        int cantidadFaltante = capacidad - cantidadActual;
        
        if (cantidadCafe <= cantidadFaltante) {
            cantidadActual += cantidadCafe;
            return 0;
        } else {
            cantidadActual = capacidad;
            return cantidadCafe - cantidadFaltante;
        }
    }

    // Mostrar
    public void mostrar() {
        System.out.println(this.toString());
    }

    // toString
    @Override
    public String toString() {
        return "Capacidad máxima: " + capacidad + ", Cantidad actual: " + cantidadActual;
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        Cafetera cafeteraBasica = new Cafetera();
        Cafetera cafeteraPequenna = new Cafetera(500);
        Cafetera cafeteraGrande = new Cafetera(2000, 1500);

        cafeteraBasica.mostrar();
        cafeteraBasica.llenarCafetera();
        cafeteraBasica.servirTaza(150);
        cafeteraBasica.mostrar();

        cafeteraPequenna.mostrar();
        for(int i = 0; i < 4; i++)
            cafeteraPequenna.servirTaza(150);
        cafeteraPequenna.mostrar();

        cafeteraGrande.mostrar();
        cafeteraGrande.vaciarCafetera();
        cafeteraGrande.agregarCafe(200);
        cafeteraGrande.mostrar();
    }
}
