package ud5.apuntesinterfaces.quedeque;

public class Camion extends Vehiculo {
    private int pesoVehiculo;
    private int pesoCarga;
    private int cv;
    private int numeroEjes;
    private boolean tieneRemolque;

    public Camion(int id, String marca, String modelo, String color, int pesoVehiculo, int pesoCarga, int cv, int numeroEjes, boolean tieneRemolque) {
        super(id, marca, modelo, color);
        this.pesoVehiculo = pesoVehiculo;
        this.pesoCarga = pesoCarga;
        this.cv = cv;
        this.numeroEjes = numeroEjes;
        this.tieneRemolque = tieneRemolque;
    }

    @Override
    public int aceleracion() {
        int factorRemolque = tieneRemolque ? 2 : 1;
        int aceleracionBase = (cv / numeroEjes) - ((pesoVehiculo + pesoCarga) / 800) * factorRemolque;
        return Math.max(aceleracionBase, 3); // Mínimo 3 para evitar valores muy bajos
    }

    @Override
    public void decelerar() {
        int distanciaReducida = (aceleracion() / 3) * (2 + (int)(Math.random() * 3)); // Reduce más lentamente
        System.out.println("El camión " + marca + " " + modelo + " ha desacelerado y redujo su velocidad en " + distanciaReducida + " metros.");
    }


    @Override
    public void acelerar() {
        int aceleracionActual = aceleracion();
        int distanciaRecorrida = aceleracionActual * (1 + (int)(Math.random() * 4));
        System.out.println("El camión " + marca + " " + modelo + " ha acelerado y recorrido " + distanciaRecorrida + " metros.");
    }

    @Override
    public void girarDerecha() {
        System.out.println("El camión " + marca + " " + modelo + " ha girado a la derecha con precaución.");
    }

    @Override
    public void girarIzquierda() {
        System.out.println("El camión " + marca + " " + modelo + " ha girado a la izquierda con precaución.");
    }


    // Getters y setters
    public int getPesoVehiculo() {
        return pesoVehiculo;
    }

    public void setPesoVehiculo(int pesoVehiculo) {
        this.pesoVehiculo = pesoVehiculo;
    }

    public int getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(int pesoCarga) {
        this.pesoCarga = pesoCarga;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public boolean isTieneRemolque() {
        return tieneRemolque;
    }

    public void setTieneRemolque(boolean tieneRemolque) {
        this.tieneRemolque = tieneRemolque;
    }
}
