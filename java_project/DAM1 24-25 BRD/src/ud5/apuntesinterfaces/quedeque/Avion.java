package ud5.apuntesinterfaces.quedeque;

public class Avion extends Vehiculo {
    private int pesoVacio;
    private int pesoCarga;
    private int numeroMotores;
    private String tipoMotor;
    private String modoVuelo;

    public Avion(int id, String marca, String modelo, String color, int pesoVacio, int pesoCarga, int numeroMotores, String tipoMotor, String modoVuelo) {
        super(id, marca, modelo, color);
        this.pesoVacio = pesoVacio;
        this.pesoCarga = pesoCarga;
        this.numeroMotores = numeroMotores;
        this.tipoMotor = tipoMotor;
        this.modoVuelo = modoVuelo;
    }

    @Override
    public int aceleracion() {
        int factorModo = modoVuelo.equalsIgnoreCase("despegando") ? 3 : 1;
        int aceleracionBase = ((numeroMotores * 600) - ((pesoVacio + pesoCarga) / 1200) * factorModo) / 8;
        return Math.max(aceleracionBase, 10); // Mínimo 10 para que tenga sentido
    }

    @Override
    public void decelerar() {
        int distanciaReducida = (aceleracion() / 4) * (2 + (int)(Math.random() * 5)); // Más realista
        System.out.println("El avión " + marca + " " + modelo + " ha desacelerado y redujo su velocidad en " + distanciaReducida + " metros.");
    }


    @Override
    public void acelerar() {
        int aceleracionActual = aceleracion();
        int distanciaRecorrida = aceleracionActual * (1 + (int)(Math.random() * 15));
        System.out.println("El avión " + marca + " " + modelo + " ha acelerado y recorrido " + distanciaRecorrida + " metros.");
    }


    @Override
    public void girarDerecha() {
        System.out.println("El avión " + marca + " " + modelo + " ha inclinado sus alas y girado a la derecha.");
    }

    @Override
    public void girarIzquierda() {
        System.out.println("El avión " + marca + " " + modelo + " ha inclinado sus alas y girado a la izquierda.");
    }

    public void ascender() {
        int alturaGanada = (aceleracion() / 5) * (1 + (int)(Math.random() * 10));
        System.out.println("El avión " + marca + " " + modelo + " ha ascendido " + alturaGanada + " metros.");
    }

    public void descender() {
        int alturaPerdida = (aceleracion() / 5) * (1 + (int)(Math.random() * 10));
        System.out.println("El avión " + marca + " " + modelo + " ha descendido " + alturaPerdida + " metros.");
    }



    // Getters y setters
    public int getPesoVacio() {
        return pesoVacio;
    }

    public void setPesoVacio(int pesoVacio) {
        this.pesoVacio = pesoVacio;
    }

    public int getPesoCarga() {
        return pesoCarga;
    }

    public void setPesoCarga(int pesoCarga) {
        this.pesoCarga = pesoCarga;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getModoVuelo() {
        return modoVuelo;
    }

    public void setModoVuelo(String modoVuelo) {
        this.modoVuelo = modoVuelo;
    }
}
