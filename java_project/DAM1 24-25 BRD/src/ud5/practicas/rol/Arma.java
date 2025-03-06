package ud5.practicas.rol;

public class Arma extends Item {
    private int ataque;
    private boolean dosManos;

    public Arma(String nombre, double peso, int precioBase, int ataque, boolean dosManos) {
        super(nombre, peso, precioBase);
        this.ataque = ataque;
        this.dosManos = dosManos;
    }

    public int getAtaque() { return ataque; }
    public boolean esDosManos() { return dosManos; }

    @Override
    public String toString() {
        return super.toString() + ", Ataque: " + ataque + (dosManos ? " (requiere dos manos)" : "");
    }
}
