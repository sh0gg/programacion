package ud5.apuntesinterfaces.quedeque;

public class Moto extends Vehiculo {
    private int cilindrada;
    private int numeroCilindros;
    private int peso;
    private String tipoMoto;

    public Moto(int id, String marca, String modelo, String color, int cilindrada, int numeroCilindros, int peso, String tipoMoto) {
        super(id, marca, modelo, color);
        this.cilindrada = cilindrada;
        this.numeroCilindros = numeroCilindros;
        this.peso = peso;
        this.tipoMoto = tipoMoto;
    }

    @Override
    public int aceleracion() {
        return (cilindrada / 10) * numeroCilindros - (peso / 10);
    }

    @Override
    public void acelerar() {
        int aceleracionActual = aceleracion();
        int distanciaRecorrida = aceleracionActual * (1 + (int)(Math.random() * 7));
        System.out.println("La moto " + marca + " " + modelo + " ha acelerado y recorrido " + distanciaRecorrida + " metros.");
    }

    @Override
    public void decelerar() {
        int distanciaReducida = (aceleracion() / 2) * (1 + (int)(Math.random() * 5));
        System.out.println("La moto " + marca + " " + modelo + " ha desacelerado y redujo su velocidad en " + distanciaReducida + " metros.");
    }

    @Override
    public void girarDerecha() {
        System.out.println("La moto " + marca + " " + modelo + " ha girado a la derecha.");
    }

    @Override
    public void girarIzquierda() {
        System.out.println("La moto " + marca + " " + modelo + " ha girado a la izquierda.");
    }


    // Getters y setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getNumeroCilindros() {
        return numeroCilindros;
    }

    public void setNumeroCilindros(int numeroCilindros) {
        this.numeroCilindros = numeroCilindros;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }
}
