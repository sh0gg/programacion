package ud5.apuntesinterfaces.quedeque;

public abstract class Vehiculo {
    protected int id;
    protected String marca;
    protected String modelo;
    protected String color;

    public abstract void acelerar();
    public abstract void decelerar();
    public abstract void girarDerecha();
    public abstract void girarIzquierda();
    public abstract int aceleracion();

    public Vehiculo(int id, String marca, String modelo, String color) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
