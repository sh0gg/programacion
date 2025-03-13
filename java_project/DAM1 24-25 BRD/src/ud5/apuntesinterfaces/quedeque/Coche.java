package ud5.apuntesinterfaces.quedeque;

public class Coche extends Vehiculo {

    private int numeroRuedas;
    private int numeroPuertas;
    private String tipoCoche;
    private int ccMotor;
    private int numeroCilindros;
    private int cv;
    private int peso;
    private String traccion;

    public Coche(int id, String marca, String modelo, String color, int numeroRuedas, int numeroPuertas, String tipoCoche, int ccMotor, int numeroCilindros, int cv, int peso, String traccion) {
        super(id, marca, modelo, color);
        this.numeroRuedas = numeroRuedas;
        this.numeroPuertas = numeroPuertas;
        this.tipoCoche = tipoCoche;
        this.ccMotor = ccMotor;
        this.numeroCilindros = numeroCilindros;
        this.cv = cv;
        this.peso = peso;
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return "Coche: " + getId() + ". " + getMarca() + " " + getModelo() + "\n"
                + "Color: " + getColor() + ", tipo: " + tipoCoche + "\n"
                + "Motor: " + String.format("%.1f", (double) ccMotor / 1000) +
                "L de " + cv + " caballos \n";
    }

    // Métodos abstractos

    @Override
    public void acelerar() {
        int aceleracionActual = aceleracion();
        int distanciaRecorrida = aceleracionActual * (2 + (int) (Math.random() * 5)); // Ajuste de valores
        System.out.println("El coche " + marca + " " + modelo + " ha acelerado y recorrido " + distanciaRecorrida + " metros.");
    }

    @Override
    public void decelerar() {
        int distanciaReducida = (aceleracion() / 2) * (1 + (int)(Math.random() * 3));
        distanciaReducida = Math.max(distanciaReducida, 1); // Evitar 0
        System.out.println("El coche " + marca + " " + modelo + " ha desacelerado y redujo su velocidad en " + distanciaReducida + " metros.");
    }

    @Override
    public void girarDerecha() {
        System.out.println("El coche " + marca + " " + modelo + " ha girado a la derecha.");
    }

    @Override
    public void girarIzquierda() {
        System.out.println("El coche " + marca + " " + modelo + " ha girado a la izquierda.");
    }

    @Override
    public int aceleracion() {
        if (traccion == null || traccion.isEmpty()) {
            throw new IllegalArgumentException("Este coche no tiene tracción");
        }

        int factorTraccion;
        if (traccion.equalsIgnoreCase("delantera") || traccion.equalsIgnoreCase("trasera")) {
            factorTraccion = numeroRuedas / 2;
        } else if (traccion.equalsIgnoreCase("awd") || traccion.equalsIgnoreCase("a las cuatro ruedas") || traccion.equalsIgnoreCase("4x4")) {
            factorTraccion = numeroRuedas;
        } else {
            throw new IllegalArgumentException("Tipo de tracción no reconocido: " + traccion);
        }

        int aceleracionBase = ((cv * numeroCilindros * factorTraccion) / 400) - (peso / 150);
        return Math.max(aceleracionBase, 5); // Evita valores negativos o bajos
    }

    // Setters y getters

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoCoche() {
        return tipoCoche;
    }

    public void setTipoCoche(String tipoCoche) {
        this.tipoCoche = tipoCoche;
    }

    public int getCcMotor() {
        return ccMotor;
    }

    public void setCcMotor(int ccMotor) {
        this.ccMotor = ccMotor;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(int numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
}
